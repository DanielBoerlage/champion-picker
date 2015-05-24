package championpicker.io;

import org.json.JSONObject;
import org.json.JSONArray;

import championpicker.champ.Champ;
import championpicker.champ.ChampList;
import championpicker.summoner.Summoner;
import championpicker.game.Game;
import championpicker.game.GameList;

import java.util.Iterator;
import java.io.Serializable;

public class RiotAPI implements Serializable {

    private final String region, apiKey;
    private final long rateLimit;
    private transient long lastFetch;


    public RiotAPI(String region, String apiKey) {
        this.region = region;
        this.apiKey = apiKey;
        rateLimit = 1201;
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

    public GameList fetchRecentGames(Summoner summoner, ChampList champs) {
        GameList games = new GameList();
        JSONObject json = fetchJSON("api/lol/" + region + "/v1.3/game/by-summoner/" + summoner.getId() + "/recent");
        JSONArray gameArr = json.getJSONArray("games");
        for(int i = 0; i < gameArr.length(); i++)
            games.add(fetchGame(gameArr.getJSONObject(i).getLong("gameId"), champs));
        return games;
    }

    public Game fetchGame(long gameId, ChampList champs) {
        return new Game(fetchJSON("api/lol/" + region + "/v2.2/match/" + gameId), champs);
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
