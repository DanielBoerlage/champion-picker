package championpicker.uncertainty;

import java.util.HashMap;
import championpicker.champ.Champ;
import championpicker.champ.ChampSet;
import championpicker.io.JSONAble;
import org.json.JSONObject;

// Map<Champ, Uncertain>
public class Relational implements JSONAble {

    Uncertain[] values;

    public Relational(ChampSet champs) {
        values = new Uncertain[champs.size()];
    }

    public Uncertain getValue(Champ champ) {
        return values[champ.getIndex()];
    }

    // public Relational(ChampSet champs) {
    //     super();
    //     for(Champ champ : champs) {
    //         put(champ, new T());
    //     }
    // }

    // public Relational(JSONObject json, ChampSet champs) {
    //     super();
    //     Iterator<String> iter = json.keys();
    //     while(iter.hasNext()) {
    //         String name = iter.next();
    //         put(champs.)
    //     }
    // }

    // public UncertainMap(JSONObject json) {
    //     super();
    //     Iterator<String> iter = json.keys();
    //     while(iter.hasNext()) {
    //         String name = iter.next();
    //         put(ChampList.master.byName(name), new UncertainValue(json.getString(name)));
    //     }
    // }

    public JSONObject toJSON() {
        JSONObject out = new JSONObject();
        // for(Map.Entry<Champ, UncertainValue> entry : entrySet())
        //     out.put(entry.getKey().getName(), entry.getValue().toString());
        return out;
    }
}
