package championpicker.champ;

import championpicker.uncertainty.UncertainValue;
//import championpicker.io.JSONable;

import org.json.JSONObject;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Champ {

    private String name;

    private Map<String, ChampStat> stats;

    public Champ(String name) {
        this.name = name;
        stats = new HashMap<String, ChampStat>();
    }

    public void addStat(String key, ChampStat stat) {
        stats.put(key, stat);
    }

    public String getName() {
        return name;
    }

    // public boolean equals(Object obj) {
    //     return ((Champion)obj).getName().equals(name);
    // }

     public JSONObject statsJSON() {
        JSONObject json = new JSONObject();
        for(Map.Entry<String, ChampStat> stat : stats.entrySet())
            json.put(stat.getKey(), stat.getValue().statValue());
        return json;
    }

    public String toString() {
        return name;
    }
}
