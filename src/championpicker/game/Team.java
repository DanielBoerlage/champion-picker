package championpicker.game;

import championpicker.champ.Champ;

import java.util.Set;
import java.util.HashSet;

public class Team {

    private Set<Champ> picks, bans;

    public Team() {
        picks = new HashSet<Champ>();
        bans = new HashSet<Champ>();
    }

    public void addPick(Champ champ) {
        picks.add(champ);
    }

    public void addBan(Champ champ) {
        bans.add(champ);
    }

    public Set<Champ> getPicks() {
        return picks;
    }

    public Set<Champ> getBans() {
        return bans;
    }
}
