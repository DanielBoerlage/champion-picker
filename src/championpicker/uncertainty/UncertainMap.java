package championpicker.uncertainty;

import championpicker.champ.Champ;
import championpicker.champ.ChampList;
import championpicker.io.JSONAble;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import java.util.Iterator;

public class UncertainMap extends HashMap<Champ, UncertainValue> implements JSONAble {

    public UncertainMap() {
        super();
    }

    public UncertainMap(Map<Champ, Tally> tallies) {
        super();
        for(Map.Entry<Champ, Tally> entry : tallies.entrySet())
            put(entry.getKey(), entry.getValue().toUncertainValue());
    }

    public UncertainMap(ChampList champs) {
        super();
        for(Champ champ : champs)
            put(champ, new UncertainValue(.5, 0));
    }

    public UncertainMap(JSONObject json) {
        super();
        Iterator<String> iter = json.keys();
        while(iter.hasNext()) {
            String name = iter.next();
            put(ChampList.master.byName(name), new UncertainValue(json.getString(name)));
        }
    }

    public JSONObject toJSON() {
        JSONObject out = new JSONObject();
        for(Map.Entry<Champ, UncertainValue> entry : entrySet())
            out.put(entry.getKey().getName(), entry.getValue().toString());
        return out;
    }
}
