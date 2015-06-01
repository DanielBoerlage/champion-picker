package championpicker.learn;

import java.util.Map;
import java.util.HashMap;

import championpicker.champ.Champ;
import championpicker.champ.ChampList;
//import championpicker.champ.ChampScore;

public class Weights {

    public double pickRate, banRate, winRate, learningWeight;

    public Weights(double pickRate, double banRate) {
        this.pickRate = pickRate;
        this.banRate = banRate;
    }

    public double calcScore(Champ champ) {
        double sum = 0;
        sum += pickRate * champ.getPickRate();
        sum += banRate * champ.getBanRate();
        return sum;
    }

    public Map<Champ, Double> calcScores(ChampList champs) {
        Map<Champ, Double> out = new HashMap<Champ, Double>();
        for(Champ champ : champs)
            out.put(champ, calcScore(champ));
        return out;
    }
    //
    // public List<ChampScore> calcScores(ChampList champs) {
    //     List<ChampScore> out = new List<ChampScore>();
    //     for(Champ champ : champs)
    //         out.add(new ChampScore(champ, calcScore(champ)));
    //     return
    //
    //     Map<Champ, Double>
    // }
}
