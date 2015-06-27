package championpicker.champ;

import championpicker.uncertainty.UncertainValue;
import championpicker.uncertainty.UncertainMap;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import championpicker.io.JSONAble;

import org.json.JSONObject;

public class Champ implements JSONAble {

    private String name;
    private int id;

    public Champ(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Champ(String name, JSONObject json) {
        this.name = name;
        id = json.getInt("id");
    }

    public JSONObject toJSON() {
        return new JSONObject()
            .put("id", id);
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

    // public int hashCode() {
    //     return name.hashCode();
    // }
}
