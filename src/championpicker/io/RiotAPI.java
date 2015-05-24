package championpicker.io;

import org.json.JSONObject;

import championpicker.champ.Champ;
import championpicker.champ.ChampList;
import championpicker.summoner.Summoner;

import java.util.Iterator;
import java.io.Serializable;

public class RiotAPI implements Serializable {

    private final String region, apiKey;

    public RiotAPI(String region, String apiKey) {
        this.region = region;
        this.apiKey = apiKey;
    }

    // public RiotAPI(JSONObject json) {
    //     region = json.getString("region");
    //     apiKey = json.getString("apiKey");
    // }

    private String createURL(String extension) {
            return "https://" + region + ".api.pvp.net/" + extension + "?api_key=" + apiKey;
    }

    public ChampList fetchChampList() {
        ChampList champs = new ChampList();
        JSONObject json = new JSONObject(IO.readFromWebpage(createURL("api/lol/static-data/" + region + "/v1.2/champion")));
        json = json.getJSONObject("data");
        Iterator<String> iter = json.keys();
        while(iter.hasNext()) {
            JSONObject champ = json.getJSONObject(iter.next());
            champs.add(new Champ(champ.getString("name"), champ.getInt("id")));
        }
        return champs;
    }

    // public GameList getRecentGames(Summoner summoner) {
    //     GameList games = new GameList();
    //
    // }

    public Summoner fetchSummoner(String name) {
        JSONObject json = new JSONObject(IO.readFromWebpage(createURL("api/lol/" + region + "/v1.4/summoner/by-name/" + name)));
        JSONObject summ = json.getJSONObject(name);
        return new Summoner(name, summ.getLong("id"));
    }

    public String getRegion() {
        return region;
    }

    public String getApiKey() {
        return apiKey;
    }
}
