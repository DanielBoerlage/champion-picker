package championpicker.champ;

import java.util.ArrayList;

import championpicker.io.JSONAble;
import org.json.JSONObject;
import org.json.JSONArray;

public class ChampList extends ArrayList<Champ> implements JSONAble {

    public static ChampList master;

    public ChampList() {
        super();
    }

    public ChampList(JSONObject json) {
        super();
        JSONArray champs = json.getJSONArray("champs");
        for(int i = 0; i < champs.length(); i++)
            add(new Champ(champs.getJSONObject(i)));
    }

    public Champ byId(int id) {
        for(Champ champ : this)
            if(champ.getId() == id)
                return champ;
        return null;
    }

    public JSONObject toJSON() {
        return new JSONObject()
            .put("champs", this);
    }
}
