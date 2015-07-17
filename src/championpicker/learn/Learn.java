package championpicker.learn;

import championpicker.game.GameList;
import championpicker.game.Game;

public class Learn {

    public GameList corpus;

    public Learn(GameList corpus) {
        this.corpus = corpus;
    }

    // prediction is closest to reality
    public double fitness(Weights weights, Game game) {
        return 0;
    }
}
