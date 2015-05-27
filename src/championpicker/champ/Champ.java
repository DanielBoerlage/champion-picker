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
    private UncertainValue pickRate;
    private UncertainValue banRate;

    public Champ(String name, int id) {
        this.name = name;
        this.id = id;
        pickRate = new UncertainValue(.5, 0);
        banRate = new UncertainValue(.5, 0);
    }

    public Champ(String name, JSONObject json) {
        this.name = name;
        id = json.getInt("id");
        pickRate = new UncertainValue(json.getString("pickRate"));
        banRate = new UncertainValue(json.getString("banRate"));
    }

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

    public String toString() {
        return name;
    }
}
