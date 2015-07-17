package championpicker.champ;

import championpicker.uncertainty.Uncertain;
import championpicker.uncertainty.Relational;
import championpicker.uncertainty.Tally;

import championpicker.game.Game;
import championpicker.game.GameSet;
import championpicker.learn.Weights;


import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import championpicker.io.JSONAble;

import org.json.JSONObject;

public class Champ {

    private String name;
    private int id;
    private int index;

    private double pickRate;
    private double banRate;
    //private Uncertain winRate;

    private double compiledScore;

    public Champ(String name, int id, ChampSet owner) {
        this.name = name;
        this.id = id;
        index = owner.append(this);
    }

    public Champ(String name, int id, int index) {
        this.name = name;
        this.id = id;
        this.index = index;
    }

    public JSONObject statsJSON() {
        JSONObject json = new JSONObject();
        json.put("pickRate", pickRate);
        json.put("banRate", banRate);
        return json;
    }

    public void compileStats(GameSet games) {
        Tally pickRateTally = new Tally();
        Tally banRateTally = new Tally();
        for(Game game : games) {
            pickRateTally.count(game.containsPick(this));
            banRateTally.count(game.containsBan(this));
        }
        pickRate = pickRateTally.getValue();
        banRate = banRateTally.getValue();
    }

    public void compilePartialScore(Weights weights) {
        compiledScore = pickRate * weights.getPickRate();
        compiledScore += banRate * weights.getBanRate();
        //compiledSum += winRate
    }

    public double calculateScore(Weights weights) { //, Context context
        return compiledScore;
    }

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
