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

    public JSONArray toJSONArray() {
        JSONStringer json = new JSONStringer();
        json.array();
        for (Champ champ : this)
            json.value(champ);
        json.endArray();
        return new JSONArray(json.toString());
    }
}
