package championpicker.game;

import championpicker.champ.Champ;

import java.util.ArrayList;
import java.util.List;

public class Team {

    boolean firstPick;
    private List<Champ> picks, bans;

    public Team(boolean firstPick) {
        this.firstPick = firstPick;
        picks = new ArrayList<Champ>();
        bans = new ArrayList<Champ>();
    }

    public void addPick(Champ champ) {
        picks.add(champ);
    }

    public void addBan(Champ champ) {
        bans.add(champ);
    }

    public List<Champ> getPicks() {
        return picks;
    }

    public List<Champ> getBans() {
        return bans;
    }

    public boolean isFirstPick() {
        return firstPick;
    }

    public String toString() {
        return "picks: " + picks + "  bans: " + bans;
    }
}
