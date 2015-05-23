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

    // public Champion getChampion(String name) {
    //     for(Champion champion : this)
    //         if(champion.getName().equals(name))
    //             return champion;
    //     return null;
    // }
    
    //public JSONObject toJSON() {
        // JSONArray arr = new JSONArray((Collection)1this);
        // return new JSONObject(arr);
        //JSONStringer
    //    return null;
    //}

    /*public JSONArray toJSONArray() {
        JSONStringer json = new JSONStringer();
        json.array();
        for (Champ champ : this)
            json.value(champ);
        json.endArray();
        return new JSONArray(json.toString());
    }*/

    // public JSONObject toJSON() {
    //     // JSONStringer json = new JSONStringer();
    //     // json.object();
    //     // for (Champ champ : this) {
    //     //     json.key(champ.getName());
    //     //     json.value(
    //     // }
    //     // json.endObject();

    //     JSONObject json = new JSONObject();
    //     for (Champ champ : this) {
    //         json.put(champ.getName(), champ.getStats());
    //     }
    //     return json;
    // }

    // public JSONObject champListJSON() {
    //     JSONObject json = new JSONObject();
    //     for (Champ champ : this)
    //         json
    // }

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
