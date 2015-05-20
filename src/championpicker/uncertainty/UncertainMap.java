package championpicker.uncertainty;

import java.util.HashMap;
import championpicker.champ.Champion;
import championpicker.champ.ChampionParam;

public class UncertainMap extends HashMap<String, UncertainValue> implements ChampionParam {

    private String name;

    public UncertainMap(String name) {
        super();
        this.name = name;
    }

    public static UncertainMap parseUncertainMap(String str) {
        String name = str.substring(str.indexOf(".") + 1, str.indexOf(":"));
        return null;
    }

    public Object key() {
        return name;
    }

    public Object value() {
        return toString();
    }
}


/*

Aatrox
    .goodAiganst: {Ahri=0.5 +confidence 0, Alistar=0.5 +confidence 3}

    */
