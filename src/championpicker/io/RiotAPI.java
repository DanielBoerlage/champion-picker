package championpicker.io;

import org.json.JSONObject;

import championpicker.champ.Champ;
import championpicker.champ.ChampList;

import java.util.Iterator;

public class RiotAPI {

    private final String apiKey;

    public static void recordApiKey(String apiKey) {
        IO.writeToFile(apiKey, "api_key.txt");
    }

    public RiotAPI() {
        apiKey = IO.readFromFile("api_key.txt");
    }

    private String createURL(String extension) {
            return "https://na.api.pvp.net/" + extension + "?api_key=" + apiKey;
    }

    public ChampList getChampList() {
        ChampList champs = new ChampList();
        JSONObject json = new JSONObject(IO.readFromWebpage(createURL("api/lol/static-data/na/v1.2/champion"))).getJSONObject("data");
        Iterator<String> iter = json.keys();
        while(iter.hasNext()) {
            JSONObject champ = json.getJSONObject(iter.next());
            champs.add(new Champ(champ.getString("name"), champ.getInt("id")));
        }
        return champs;
    }
}
