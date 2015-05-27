package championpicker.io;

import org.json.JSONObject;
import org.json.JSONArray;

import championpicker.champ.Champ;
import championpicker.champ.ChampList;
import championpicker.summoner.Summoner;
import championpicker.game.Game;
import championpicker.game.GameList;

import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.Serializable;

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

    private String createURL(String extension, String... params) {
        // if(extension.contains("?"))  //make better
        //     return "https://" + region + ".api.pvp.net/" + extension + "&api_key=" + apiKey;
        // return "https://" + region + ".api.pvp.net/" + extension + "?api_key=" + apiKey;
        if(params.length == 0)
            return "https://" + region + ".api.pvp.net/api/lol/" + extension + "?api_key=" + apiKey;
        String url = "https://" + region + ".api.pvp.net/api/lol/" + extension + "?";
        for(String param : params)
            url += param + "&";
        return url + apiKey;
    }

    private JSONObject apiCall(String extension, String... params) {
        long current = System.currentTimeMillis();
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
        return new JSONObject(IO.readFromWebpage(createURL(extension, params)));
    }

    public ChampList fetchChampList() {
        ChampList champs = new ChampList();
        JSONObject json = fetchJSON("api/lol/static-data/" + region + "/v1.2/champion").getJSONObject("data");
        Iterator<String> iter = json.keys();
        while(iter.hasNext()) {
            JSONObject champ = json.getJSONObject(iter.next());
            champs.add(new Champ(champ.getString("name"), champ.getInt("id")));
        }
        return champs;
    }

    public GameList fetchGamesBFS(int n, Summoner root, String type) {
        GameList games = new GameList();
        Queue<Summoner> queue = new LinkedList<Summoner>();
        ArrayList<Summoner> visited = new ArrayList<Summoner>();
        queue.add(root);
        visited.add(root);
        while(games.size() < n && !queue.isEmpty()) {
            System.out.println("queue size: " + queue.size());
            System.out.println("games size: " + games.size());
            Summoner current = queue.remove();
            JSONObject json = fetchJSON("api/lol/" + region + "/v2.2/matchhistory/" + current.getId() + "?rankedQueues=" + type);
            JSONArray gameArr = json.getJSONArray("matches");
            for(int i = 0; i < gameArr.length(); i++) {
                JSONObject game = gameArr.getJSONObject(i);
                long gameId = game.getLong("matchId");
                if(!games.containsId(gameId)) {
                    JSONObject gameData = fetchJSON("api/lol/" + region + "/v2.2/match/" + gameId);
                    games.add(new Game(gameData));
                    System.out.println("Added new game");
                    JSONArray participants = gameData.getJSONArray("participantIdentities");
                    for(int j = 0; j < participants.length(); j++) {
                        JSONObject player = participants.getJSONObject(j).getJSONObject("player");
                        Summoner branch = new Summoner(player.getString("summonerName"), player.getLong("summonerId"));
                        if(!visited.contains(branch)) {
                            queue.add(branch);
                            visited.add(branch);
                            System.out.println("Found summoner (new): " + branch.getName());
                        } else {
                            System.out.println("Found summoner (alread exists): " + branch.getName());
                        }
                    }
                } else {
                    System.out.println("Game already exists");
                }
            }
        }
        return games;
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

    public Game fetchGame(long gameId) {
        return new Game(fetchJSON("api/lol/" + region + "/v2.2/match/" + gameId));
    }

    public Summoner fetchSummoner(String name) {
        JSONObject summoner = fetchJSON("api/lol/" + region + "/v1.4/summoner/by-name/" + name).getJSONObject(name);
        return new Summoner(name, summoner.getLong("id"));
    }

    public String getRegion() {
        return region;
    }

    public String getApiKey() {
        return apiKey;
    }
}
