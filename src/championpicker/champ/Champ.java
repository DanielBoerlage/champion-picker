package championpicker.champ;

import championpicker.uncertainty.UncertainValue;
import championpicker.io.JSONable;

import org.json.JSONObject;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Champ {// implements JSONable {

    private String name;

    //private List<ChampionStat> stats;

    private Map<String, ChampStat> stats;

    public Champ(String name) {
        this.name = name;
        stats = new HashMap<String, ChampStat>();
    }

    //public Champion(String name) {
        //this.name = name;
        //stat = new HashMap<String, ChampionStat
    //}

    //public void addStat(ChampionStat stat) {
    //    stats.add(stat);
    //}

    public void addStat(String key, ChampStat stat) {
        stats.put(key, stat);
    }

    public String getName() {
        return name;
    }

    // public String getSummary() {
    //     String out = name;
    //     for(ChampionParam param : params)
    //         out += "\n\t." + param.key() + ": " + param.value();
    //     return out;
    // }

    // public boolean equals(Object obj) {
    //     return ((Champion)obj).getName().equals(name);
    // }

     public JSONObject statsJSON() {
        JSONObject json = new JSONObject();
        for(Map.Entry<String, ChampStat> stat : stats.entrySet())
            json.put(stat.getKey(), stat.getValue().statValue());
        return json;
        //return new JSONObject(stats); <-- treats stat as a bean object
    }

    public String getSummary() {
        return null;
    }

    public String toString() {
        // String out = name;
        // for(ChampionParam param : params)
        //     out += "\n\t." + param.key() + ": " + param.value();
        // return out;
        return name;
    }
}
