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
import java.io.Serializable;

public class RiotAPI implements Serializable {

    private final String region, apiKey;
    private final long rateLimit;
    private transient long lastFetch;


    public RiotAPI(String region, String apiKey) {
        this.region = region;
        this.apiKey = apiKey;
        rateLimit = 1210;
        lastFetch = 0;
    }

    // public RiotAPI(JSONObject json) {
    //     region = json.getString("region");
    //     apiKey = json.getString("apiKey");
    // }

    private String createURL(String extension) {
            return "https://" + region + ".api.pvp.net/" + extension + "?api_key=" + apiKey;
    }

    private JSONObject fetchJSON(String extension) {
        long current = System.currentTimeMillis();
        if(current - lastFetch < rateLimit) {
            try {
                Thread.sleep(rateLimit - (current - lastFetch));
                current = System.currentTimeMillis();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lastFetch = current;
        return new JSONObject(IO.readFromWebpage(createURL(extension)));
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
        queue.add(root);
        while(games.size() < n && !queue.isEmpty()) {
            Summoner current = queue.remove();
            JSONObject json = fetchJSON("api/lol/" + region + "/v1.3/game/by-summoner/" + current.getId() + "/recent");
            JSONArray gameArr = json.getJSONArray("games");
            for(int i = 0; i < gameArr.length(); i++) {
                JSONObject game = gameArr.getJSONObject(i);
                if(!game.getString("subType").equals(type)) continue;
                long gameId = game.getLong("gameId");
                if(!games.containsId(gameId))
                    games.add(fetchGame(gameId));
                JSONArray fellowPlayers = game.getJSONArray("fellowPlayers");
                for(int j = 0; j < fellowPlayers.length(); j++) {
                    Summoner newSummoner = new Summoner(fellowPlayers.getJSONObject(j).getLong("summonerId"));
                    if(!queue.contains(newSummoner))
                        queue.add(newSummoner);
                }
            }
        }
        return games;
    }

    public GameList fetchRecentGames(Summoner summoner, String type) {
        GameList games = new GameList();
        JSONObject json = fetchJSON("api/lol/" + region + "/v1.3/game/by-summoner/" + summoner.getId() + "/recent");
        JSONArray gameArr = json.getJSONArray("games");
        for(int i = 0; i < gameArr.length(); i++) {
            JSONObject game = gameArr.getJSONObject(i);
            if(game.getString("subType").equals(type))
                games.add(fetchGame(game.getLong("gameId")));
        }
        return games;
    }

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
