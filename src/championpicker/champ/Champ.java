package championpicker.champ;

import java.util.Map;
import java.util.HashMap;
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

    public String toString() {
        return name;
    }
}
