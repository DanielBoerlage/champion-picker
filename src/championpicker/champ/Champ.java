package championpicker.champ;

import championpicker.uncertainty.UncertainValue;
//import championpicker.io.JSONable;

import org.json.JSONObject;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;

public class Champ implements Serializable {

    private String name;

    private Map<String, Object> stats;

    public Champ(String name) {
        this.name = name;
        stats = new HashMap<String, Object>();
    }

    public void addStat(String key, Object stat) {
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
        for(Map.Entry<String, Object> stat : stats.entrySet())
            json.put(stat.getKey(), ((ChampStat)stat.getValue()).statValue());
        return json;
    }

    public String toString() {
        return name;
    }
}
