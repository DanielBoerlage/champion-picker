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
    private double         pickRate;
    private double         banRate;
    private UncertainValue winRate;

    private UncertainMap goodWith;
    private UncertainMap goodAiganst;

    private double compiledStaticSum;
    private Map<Champ, Double> compiledGoodWith;
    private Map<Champ, Double> compiledGoodAiganst;

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
        banRate = json.getDouble("banRate");
        winRate = new UncertainValue(json.getString("winRate"));
    }

    public JSONObject toJSON() {
        return new JSONObject()
            .put("id", id)
            .put("pickRate", pickRate)
            .put("banRate", banRate)
            .put("winRate", winRate.toString())
            .put("goodWith", goodWith.toJSON())
            .put("goodAiganst", goodAiganst.toJSON());
    }

    public void initRelationals(ChampList champs) {
        // goodWith = new UncertainMap(champs);
        // goodAiganst = new UncertainMap(champs);
    }

    public void setRelationals(JSONObject json) {
        goodWith = new UncertainMap(json.getJSONObject("goodWith"));
        goodAiganst = new UncertainMap(json.getJSONObject("goodAiganst"));
    }

    public void compile(double pickRateWeight, double banRateWeight, double winRateWeight, double learningWeight) {
        // compiledStaticSum = 0;
        // compiledStaticSum += pickRateWeight * pickRate;
        // compiledStaticSum += banRateWeight * banRate;
        // compiledStaticSum += winRateWeight * winRate.getRateBelief(learningWeight);
        //
        // compiledGoodWith = new HashMap<Champ, Double>();
        // for(Map.Entry<Champ, UncertainValue> entry : goodWith.entrySet())
        //     compiledGoodWith.put(entry.getKey(), entry.getValue().getRateBelief(learningWeight));
        // compiledGoodAiganst = new HashMap<Champ, Double>();
        // for(Map.Entry<Champ, UncertainValue> entry : goodAiganst.entrySet())
        //     compiledGoodAiganst.put(entry.getKey(), entry.getValue().getRateBelief(learningWeight));
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

    public void setGoodWith(UncertainMap goodWith) {
        this.goodWith = goodWith;
    }

    public void setGoodAiganst(UncertainMap goodAiganst) {
        this.goodAiganst = goodAiganst;
    }

    public double getPickRate() {
        return pickRate;
    }

    public double getBanRate() {
        return banRate;
    }

    public UncertainValue getWinRate() {
        return winRate;
    }

    public double getCompiledStaticSum() {
        return compiledStaticSum;
    }

    public Map<Champ, Double> getCompiledGoodWith() {
        return compiledGoodWith;
    }

    public Map<Champ, Double> getCompiledGoodAiganst() {
        return compiledGoodAiganst;
    }

    //public abstract void compile();

    //contstructor for ChampStats class
    // public abstract void compileStats(GameList corpus) {
    //     Tally pickTally = new Tally();
    //     Tally banTally  = new Tally();
    //     Tally winTally  = new Tally();
    //     Map<Champ, Tally> goodWithTally    = new HashMap<Champ, Tally>();
    //     Map<Champ, Tally> goodAgainstTally = new HashMap<Champ, Tally>();
    //     for (Champ champ : ChampList.master) {
    //         goodWithTally.put(new Tally());
    //         goodAgainstTally.put(new Tally());
    //     }
    //
    //     for(Game game : corpus) {
    //         boolean wasPicked = game.allPicks().contains(this);  // simplify to game.containsPick(this)
    //         boolean wasBanned = game.allBans().contains(this);
    //         pickTally.count(wasPicked);
    //         banTally.count(wasBanned);
    //         if(wasPicked) {
    //             boolean wonGame = game.champWon(this);
    //             winTally.count(wonGame);
    //             for(Champ friendly : game.friendlies(this))
    //                 goodWithTally.get(friendly).count(wonGame);
    //             for(Champ enemy : game.enemies(this))
    //                 goodAgainstTally.get(enemy).count(wonGame);
    //         }
    //     }
    //
    //     pickRate = pickTally.toDouble();
    //     banRate = banTally.toDouble();
    //     winRate = winTally.toUncertainValue();
    //     goodWith    = new HashMap<Champ, UncertainValue>();
    //     goodAgainst = new HashMap<Champ, UncertainValue>();
    //     for (Champ champ : ChampList.master) {
    //         goodWith.put(champ, goodWithTally.get(champ).toUncertainValue());
    //         goodAgainst.put(champ, goodAgainstTally.get(champ).toUncertainValue());
    //     }
    // }

    // public void compileStats(GameList corpus) {
    //     HashMap<Champ, Tally> picks = new HashMap<Champ, Tally>();
    //     HashMap<Champ, Tally> bans = new HashMap<Champ, Tally>();
    //     HashMap<Champ, Tally> wins = new HashMap<Champ, Tally>();
    //     HashMap<Champ, HashMap<Champ, Tally>> goodWith = new HashMap<Champ, HashMap<Champ, Tally>>();
    //     HashMap<Champ, HashMap<Champ, Tally>> goodAiganst = new HashMap<Champ, HashMap<Champ, Tally>>();
    //     for(Champ champ : this) {
    //         picks.put(champ, new Tally());
    //         bans.put(champ, new Tally());
    //         wins.put(champ, new Tally());
    //         HashMap<Champ, Tally> champGoodWith = new HashMap<Champ, Tally>();
    //         HashMap<Champ, Tally> champGoodAiganst = new HashMap<Champ, Tally>();
    //         for(Champ otherChamp : this) {
    //             champGoodWith.put(otherChamp, new Tally());
    //             champGoodAiganst.put(otherChamp, new Tally());
    //         }
    //         goodWith.put(champ, champGoodWith);
    //         goodAiganst.put(champ, champGoodAiganst);
    //     }
    //
    //     for(Game game : corpus) {
    //         Set<Champ> gamePicks = game.allPicks();
    //         Set<Champ> gameBans = game.allBans();
    //         for(Champ champ : this) {
    //             boolean inGame = gamePicks.contains(champ);
    //             picks.get(champ).count(inGame);
    //             if(inGame) {
    //                 boolean won = game.champWon(champ);
    //                 wins.get(champ).count(won);
    //                 for(Champ friendly : game.friendlies(champ))
    //                     goodWith.get(champ).get(friendly).count(won);
    //                 for(Champ enemy : game.enemies(champ))
    //                     goodAiganst.get(champ).get(enemy).count(won);
    //             }
    //             bans.get(champ).count(gameBans.contains(champ));
    //         }
    //
    //     }
    //
    //     for (Champ champ : this) {
    //         champ.setPickRate(picks.get(champ).toDouble());
    //         champ.setBanRate(bans.get(champ).toDouble());
    //         champ.setWinRate(wins.get(champ).toUncertainValue());
    //         champ.setGoodWith(new UncertainMap(goodWith.get(champ)));
    //         champ.setGoodAiganst(new UncertainMap(goodAiganst.get(champ)));
    //     }
    // }
}
