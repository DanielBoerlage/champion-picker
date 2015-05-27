package championpicker.game;

import championpicker.champ.Champ;

import java.util.List;
import java.util.ArrayList;

public class Team {

    private List<Champ> picks, bans;

    public Team() {
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
}
