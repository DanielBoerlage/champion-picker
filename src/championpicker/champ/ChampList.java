package championpicker.champ;

import java.util.ArrayList;

import championpicker.uncertainty.UncertainValue;
import championpicker.uncertainty.Tally;
import championpicker.game.GameList;
import championpicker.game.Game;
import championpicker.io.JSONAble;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;

public class ChampList extends ArrayList<Champ> implements JSONAble {

    public static ChampList master;

    public ChampList() {
        super();
    }

    public ChampList(JSONObject json) {
        super();
        Iterator<String> iter = json.keys();
        while(iter.hasNext()) {
            String name = iter.next();
            add(new Champ(name, json.getJSONObject(name)));
        }
    }

    public JSONObject toJSON() {
        JSONObject out = new JSONObject();
        for(Champ champ : this)
            out.put(champ.getName(), champ.toJSON());
        return out;
    }

    public Champ byId(int id) {
        for(Champ champ : this)
            if(champ.getId() == id)
                return champ;
        return null;
    }

    public void compileStats(GameList corpus) {
        HashMap<Champ, Tally> picks = new HashMap<Champ, Tally>();
        HashMap<Champ, Tally> bans = new HashMap<Champ, Tally>();
        HashMap<Champ, Tally> wins = new HashMap<Champ, Tally>();
        for(Champ champ : this) {
            picks.put(champ, new Tally());
            bans.put(champ, new Tally());
            wins.put(champ, new Tally());
        }

        for(Game game : corpus) {
            Set<Champ> gamePicks = game.allPicks();
            Set<Champ> gameBans = game.allBans();
            for(Champ champ : this) {
                picks.get(champ).count(gamePicks.contains(champ));
                if(gamePicks.contains(champ))
                    wins.get(champ).count(game.champWon(champ));
                bans.get(champ).count(gameBans.contains(champ));
            }
        }

        for (Champ champ : this) {
            champ.setPickRate(picks.get(champ).toDouble());
            champ.setBanRate(bans.get(champ).toDouble());
            champ.setWinRate(wins.get(champ).toUncertainValue());
        }
    }
}
