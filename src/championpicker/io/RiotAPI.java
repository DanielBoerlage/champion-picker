package championpicker.io;

import org.json.JSONObject;
import org.json.JSONArray;

import championpicker.champ.Champ;
import championpicker.summoner.Summoner;
import championpicker.game.Game;
import championpicker.game.GameList;

import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class RiotAPI implements Serializable, JSONAble {

    private final String region, apiKey;
    private final long rateLimit; //recommended value: 1205
    private long lastFetch;

    public RiotAPI(String region, String apiKey, long rateLimit) {
        this.region = region;
        this.apiKey = apiKey;
        this.rateLimit = rateLimit;
        lastFetch = 0;
    }

    public RiotAPI(JSONObject json) {
        region = json.getString("region");
        apiKey = json.getString("apiKey");
        rateLimit = json.getLong("rateLimit");
        lastFetch = 0;
    }

    public JSONObject toJSON() {
        return new JSONObject()
            .put("region", region)
            .put("apiKey", apiKey)
            .put("rateLimit", rateLimit);
    }

    private JSONObject apiCall(String extension, String... params) {
        long current = System.currentTimeMillis();//sleeptime calc here
        if(current - lastFetch < rateLimit) {
            try {
                long sleepTime = rateLimit - (current - lastFetch);
                Thread.sleep(sleepTime);
                current += sleepTime;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lastFetch = current;

        String url = "https://" + region + ".api.pvp.net/api/lol/" + extension + "?";
        for(String param : params)
            url += param + "&";
        url += "api_key=" + apiKey;
        return new JSONObject(IO.readFromWebpage(url));
    }

    //add api call for all the different riot api methods

    // public ChampList fetchChampList() {
    //     ChampList champs = new ChampList();
    //     JSONObject json = apiCall("static-data/" + region + "/v1.2/champion").getJSONObject("data");
    //     Iterator<String> iter = json.keys();
    //     while(iter.hasNext()) {
    //         JSONObject champ = json.getJSONObject(iter.next());
    //         // champs.add(new Champ(champ.getString("name"), );
    //     }
    //     champs.initRelationals();
    //     return champs;
    // }

    public void fetchGamesBFS(int n, long maxAge, int summThresh, long root, String type, String dir) {
        Set<Long> games = new HashSet<Long>();
        int recentGames = 0;
        List<Long> summoners = new ArrayList<Long>();
        summoners.add(root);
        for (int iSumm = 0; iSumm < summoners.size(); iSumm++) {
            System.out.println("queue size: " + (summoners.size() - iSumm));
            System.out.println("games size: " + recentGames);
            JSONArray matches = apiCall(region + "/v2.2/matchhistory/" + summoners.get(iSumm), "rankedQueues=" + type)
                                    .getJSONArray("matches");
            for (int iGame = 0; iGame < matches.length(); iGame++) {
                long gameId = matches.getJSONObject(iGame).getLong("matchId");
                if (games.contains(gameId)) {
                    System.out.println("Found game (stale)");
                    continue;
                }
                JSONObject gameData = apiCall(region + "/v2.2/match/" + gameId);
                games.add(gameId);
                long daysOld = (System.currentTimeMillis() - gameData.getLong("matchCreation")) / (1000 * 60 * 60 * 24);
                if(daysOld > maxAge) {
                    System.out.println("Found game ( old )");
                    if ((summoners.size() - iSumm) > summThresh) continue;
                } else {
                    System.out.println("Found game ( new )                        age: " + daysOld + " days old");
                    IO.writeToFile(gameData, dir + "/" + gameId + ".json");
                    recentGames++;
                }
                if (recentGames == n) return;
                JSONArray identities = gameData.getJSONArray("participantIdentities");
                JSONArray participants = gameData.getJSONArray("participants");
                for (int iPlayer = 0; iPlayer < participants.length(); iPlayer ++) {
                    JSONObject player = identities.getJSONObject(iPlayer).getJSONObject("player");
                    long summonerId = player.getLong("summonerId");
                    String summonerName = player.getString("summonerName");
                    String rank = participants.getJSONObject(iPlayer).getString("highestAchievedSeasonTier");
                    if (summoners.contains(summonerId)) {
                        System.out.println("Found summoner (stale): " + summonerName);
                        continue;
                    }
                    System.out.printf("Found summoner ( new ): %-16s rank: %s\n", summonerName, rank);
                    summoners.add(summonerId);
                }
            }
        }
    }

    // public GameList fetchRecentGames(Summoner summoner, String type) {
    //     GameList games = new GameList();
    //     JSONObject json = fetchJSON("api/lol/" + region + "/v1.3/game/by-summoner/" + summoner.getId() + "/recent");
    //     JSONArray gameArr = json.getJSONArray("games");
    //     for(int i = 0; i < gameArr.length(); i++) {
    //         JSONObject game = gameArr.getJSONObject(i);
    //         if(game.getString("subType").equals(type))
    //             games.add(fetchGame(game.getLong("gameId")));
    //     }
    //     return games;
    // }

    // public Game fetchGame(long gameId) {
    //     return new Game(apiCall(region + "/v2.2/match/" + gameId));
    // }

    public Summoner fetchSummoner(String name) {
        JSONObject summoner = apiCall(region + "/v1.4/summoner/by-name/" + name).getJSONObject(name.toLowerCase());
        return new Summoner(name, summoner.getLong("id"));
    }

    public String getRegion() {
        return region;
    }

    public String getApiKey() {
        return apiKey;
    }
}
