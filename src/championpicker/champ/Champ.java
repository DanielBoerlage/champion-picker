package championpicker.champ;

import championpicker.uncertainty.Uncertain;
import championpicker.uncertainty.Relational;
import championpicker.uncertainty.Tally;

import championpicker.game.Game;
import championpicker.game.GameSet;
import championpicker.game.Context;
import championpicker.learn.Weights;


import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import championpicker.io.JSONAble;

import org.json.JSONObject;

public class Champ implements Comparable {

    private String name;
    private int id;
    private int index;

    private double pickRate;
    private double banRate;
    //private Uncertain winRate;

    private double partialScore;
    private double score;

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
        return new JSONObject()
            .put("pickRate", pickRate)
            .put("banRate",  banRate);
    }

    public void readStats(JSONObject json) {
        pickRate = json.getDouble("pickRate");
        banRate = json.getDouble("banRate");
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
        partialScore = pickRate * weights.getPickRate();
        partialScore += banRate * weights.getBanRate();
        //compiledSum += winRate
    }

    public void compileScore(Weights weights, Context context) {
        score = partialScore;
    }

    public int compareTo(Object other) {
        double otherScore = ((Champ)other).getScore();
        if (score > otherScore) return 1;
        else if(score == otherScore) return 0;
        else return -1;
    }

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

    public double getPickRate() {
        return pickRate;
    }

    public double getBanRate() {
        return banRate;
    }

    public double getScore() {
        return score;
    }
}
