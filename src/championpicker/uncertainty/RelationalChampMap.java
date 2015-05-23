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

    // public static UncertainMap parseUncertainMap(String str) {
    //     //System.out.println(str);
    //     String name = str.substring(str.indexOf(".") + 1, str.indexOf(":"));
    //     UncertainMap um = new UncertainMap(name);
    //     for(int i = str.indexOf("{"); i > 0; i = str.indexOf(",", i+1)) { // !!HORRIBLKE CODE@@
    //         //System.out.println(i);
    //         int j = str.indexOf(",", i+1);
    //         j = (j < 0) ? str.indexOf("}") : j;
    //         //System.out.println(j);
    //         um.put(str.substring(i+1, str.indexOf("=", i)).trim(),
    //                UncertainValue.parseUncertainValue(str.substring(str.indexOf("=", i) + 1, j)));
    //     }
    //     return um;
    // }

    // public static UncertainMap parseUncertainMap(String str) {
    //     return null;
    // }

    // public String getName() {
    //     return name;
    // }

    public Object statValue() {
        JSONObject json = new JSONObject();
        for(Map.Entry<Champ, UncertainValue> champ : entrySet())
            json.put(champ.getKey().getName(), champ.getValue().toString());
        return json;
    }

    // public Object value() {
    //     return toString();
    // }
}