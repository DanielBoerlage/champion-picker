package championpicker.uncertainty;

import java.util.Map;
import java.util.HashMap;
import championpicker.champ.Champ;
import championpicker.champ.ChampStat;

import org.json.JSONObject;

public class RelationalChampMap extends HashMap<Champ, UncertainValue> implements ChampStat {

    public RelationalChampMap() {
        super();
    }

    public Object statValue() {
        JSONObject json = new JSONObject();
        for(Map.Entry<Champ, UncertainValue> champ : entrySet())
            json.put(champ.getKey().getName(), champ.getValue().toString());
        return json;
    }
}