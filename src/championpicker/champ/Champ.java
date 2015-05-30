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
    private double         pickRate;
    private double         banRate;
    private UncertainValue winRate;

    public Champ(String name, int id) {
        this.name = name;
        this.id = id;
        pickRate = .5;
        banRate = .5;
        winRate = new UncertainValue(.5, 0);
    }

    public Champ(String name, JSONObject json) {
        this.name = name;
        id = json.getInt("id");
        pickRate = json.getDouble("pickRate");
        banRate = json.getDouble("bickRate");
        winRate = new UncertainValue(json.getString("winRate"));
    }

    public JSONObject toJSON() {
        return new JSONObject()
            .put("id", id)
            .put("pickRate", pickRate)
            .put("banRate", banRate)
            .put("winRate", winRate.toString());
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

    public void setPickRate(double pickRate) {
        this.pickRate = pickRate;
    }

    public void setBanRate(double banRate) {
        this.banRate = banRate;
    }

    public void setWinRate(UncertainValue winRate) {
        this.winRate = winRate;
    }
}
