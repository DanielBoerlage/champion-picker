package championpicker.champ;

import java.util.ArrayList;

import championpicker.io.JSONAble;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Iterator;

public class ChampList extends ArrayList<Champ> implements JSONAble {

    public static ChampList master;

    public ChampList() {
        super();
    }

    public ChampList(JSONObject json) {
        super();
        Iterator<String> iter = json.keys();
        while(iter.hasNext()) {
            String name = iter.next();
            add(new Champ(name, json.getJSONObject(name)));
        }
    }

    public JSONObject toJSON() {
        JSONObject out = new JSONObject();
        for(Champ champ : this)
            out.put(champ.getName(), champ.toJSON());
        return out;
    }

    public Champ byId(int id) {
        for(Champ champ : this)
            if(champ.getId() == id)
                return champ;
        return null;
    }
}
