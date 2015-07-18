package championpicker.learn;

import championpicker.game.GameList;
import championpicker.game.Game;
import championpicker.game.Team;
import championpicker.champ.ChampSet;
import championpicker.champ.Champ;

import java.util.List;
import java.util.ArrayList;

import championpicker.game.GameSet;

public class Learn {

    public GameSet corpus;

    public Learn(GameSet corpus) {
        this.corpus = corpus;
    }

    // prediction is closest to reality
    public double predictionFitness(Weights weights, Team friendly, Team enemy) {
        double cummFitness = 0;
        ChampSet champs = ChampSet.master;
        List<Champ> friendlyPicks = friendly.getPicks();
        List<Champ> friendlyBans = friendly.getBans();
        List<Champ> enemyPicks = enemy.getPicks();
        List<Champ> enemyBans = enemy.getBans();

		for(int i = 0; i < friendlyBans.length()) {
			Champ banned = friendlyBans.get(i);
			Context contex = null;
        	banned.compileScore(weights, context);
        	cummFitness += banned.getScore();
        }

        for(int i = 0; i < friendlyPicks.length()) {
        	Champ picked = friendlyPicks.get(i);
        	Context context = null;
        	picked.compileScore(weights, context);
        	cummFitness += picked.getScore();
        }

        return cummFitness;
    }
}
