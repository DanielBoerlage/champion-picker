package championpicker.champ;

import championpicker.io.JSONable;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONStringer;

public class ChampList extends ArrayList<Champ> {

    public ChampList() {
        super();
    }

    public JSONObject champStatsJSON() {
        JSONObject json = new JSONObject();
        for (Champ champ : this)
            json.put(champ.getName(), champ.statsJSON());
        return json;
    }

    /*public JSONObject statsInJSON() {
        JSONObject obj = new JSONObject();
        for()
    }*/
}
