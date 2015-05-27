package championpicker.champ;

import championpicker.uncertainty.UncertainValue;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import championpicker.io.JSONAble;

import org.json.JSONObject;

public class Champ implements JSONAble {

    private String name;
    private int id;
    public UncertainValue pickRate;
    public UncertainValue banRate;

    //private Map<String, Object> stats;

    public Champ(String name, int id) {
        this.name = name;
        this.id = id;
        pickRate = new UncertainValue(.5, 0);
        banRate = new UncertainValue(.5, 0);
        //stats = new HashMap<String, Object>();
    }

    public Champ(String name, JSONObject json) {
        this.name = name;
        id = json.getInt("id");
        pickRate = new UncertainValue(json.getString("pickRate"));
        banRate = new UncertainValue(json.getString("banRate"));
    }

    //public void addStat(String key, Object stat) {
    //    stats.put(key, stat);
    //}

    public JSONObject toJSON() {
        return new JSONObject()
            .put("id", id)
            .put("pickRate", pickRate.toString())
            .put("banRate", banRate.toString());
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // public String getPickRate() {
    //     return pickRate.toString();
    // }

    public String toString() {
        return name;
    }
}
