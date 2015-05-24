package championpicker.champ;

import championpicker.uncertainty.UncertainValue;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

public class Champ implements Serializable {

    private String name;
    private int id;
    public UncertainValue pickRate;

    //private Map<String, Object> stats;

    public Champ(String name, int id) {
        this.name = name;
        this.id = id;
        //stats = new HashMap<String, Object>();
    }

    //public void addStat(String key, Object stat) {
    //    stats.put(key, stat);
    //}

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPickRate() {
        return pickRate.toString();
    }

    public String toString() {
        return name;
    }
}
