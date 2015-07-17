package championpicker.champ;

import championpicker.uncertainty.Uncertain;
import championpicker.uncertainty.Relational;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import championpicker.io.JSONAble;

import org.json.JSONObject;

public class Champ {

    private String name;
    private int index;

    private double pickRate;
    private double banRate;
    private Uncertain winRate;
    private Relational goodWith;
    private Relational goodAgainst;

    public Champ(String name, ChampSet owner) {
        this.name = name;
        index = owner.add(this);
    }

    public Champ(String name, JSONObject json) {
        this.name = name;
        index = json.getInt("id");
    }

    // public JSONObject summary() {
    //     return new JSONObject(
    // }

    // public JSONObject toJSON() {
    //     return new JSONObject()
    //         .put("id", id);
    // }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public String toString() {
        return name;
    }

    // public int hashCode() {
    //     return name.hashCode();
    // }
}
