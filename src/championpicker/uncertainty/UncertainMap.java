package championpicker.uncertainty;

import java.util.HashMap;
import championpicker.champ.Champ;
import championpicker.champ.ChampStat;

import org.json.JSONObject;

public class UncertainMap extends HashMap<String, UncertainValue> implements ChampStat {

    private String name;

    public UncertainMap(String name) {
        super();
        this.name = name;
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

    public static UncertainMap parseUncertainMap(String str) {
        return null;
    }

    public String getName() {
        return name;
    }

    public JSONObject toJSON() {
        return new JSONObject(this);
    }

    // public Object value() {
    //     return toString();
    // }
}


/*

Aatrox
    .goodAiganst: {Ahri=0.5 +confidence 0, Alistar=0.5 +confidence 3}

    */
