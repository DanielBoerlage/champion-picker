package championpicker.learn;

import java.util.Map;
import java.util.HashMap;

import championpicker.champ.Champ;
import championpicker.champ.ChampList;
//import championpicker.champ.ChampScore;

public class Weights {

    public double pickRate, banRate, winRate, learningWeight;

    public Weights(double pickRate, double banRate, double winRate, double learningWeight) {
        this.pickRate = pickRate;
        this.banRate = banRate;
        this.winRate = winRate;
        this.learningWeight = learningWeight;
    }

    public void compileChampList(ChampList champs) {
        for(Champ champ : champs)
            champ.compile(learningWeight);
    }

    public double calcScore(Champ champ) {
        double sum = 0;
        sum += pickRate * champ.getPickRate();
        sum += banRate * champ.getBanRate();
        sum += winRate * champ.getCompiledWinRate();
        return sum;
    }

    public Map<Champ, Double> calcScores(ChampList champs) {
        Map<Champ, Double> out = new HashMap<Champ, Double>();
        for(Champ champ : champs)
            out.put(champ, calcScore(champ));
        return out;
    }
}
