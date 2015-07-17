package championpicker.learn;

import java.util.Map;
import java.util.HashMap;

import championpicker.game.Context;
import championpicker.champ.Champ;
//import championpicker.champ.ChampScore;

public class Weights {

    public double pickRate, banRate, winRate, goodWith, goodAiganst, learningWeight;

    public Weights(double pickRate, double banRate, double winRate, double goodWith, double goodAiganst, double learningWeight) {
        this.pickRate = pickRate;
        this.banRate = banRate;
        this.winRate = winRate;
        this.goodWith = goodWith;
        this.goodAiganst = goodAiganst;
        this.learningWeight = learningWeight;
    }

    // public void compileChampList(ChampList champs) {
    //     // for(Champ champ : champs)
    //     //     champ.compile(pickRate, banRate, winRate, learningWeight);
    // }

    public double calcScore(Champ champ, Context context) {
        double sum = 0;
        // sum += champ.getCompiledStaticSum();
        double localSum = 0;
        // for(Champ friendly : context.getFriendlyTeam().getPicks())
            // localSum += champ.getCompiledGoodWith().get(friendly);
        // sum += localSum * goodWith;
        return sum;
    }

    // public Map<Champ, Double> calcScores(ChampList champs, Context context) {
    //     Map<Champ, Double> out = new HashMap<Champ, Double>();
    //     for(Champ champ : champs)
    //         out.put(champ, calcScore(champ, context));
    //     return out;
    // }
}
