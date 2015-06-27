package championpicker.champ;

import java.util.ArrayList;

import championpicker.uncertainty.UncertainValue;
import championpicker.uncertainty.UncertainMap;
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

    public void initRelationals() {
        // for(Champ champ : this)
        //     champ.initRelationals(this);
    }

    public void setRelationals(JSONObject json) {
        // for(Champ champ : this)
        //     champ.setRelationals(json.getJSONObject(champ.getName()));
    }

    public Champ byId(int id) {
        for(Champ champ : this)
            if(champ.getId() == id)
                return champ;
        return null;
    }

    public Champ byName(String name) {
        for(Champ champ : this)
            if(champ.getName().equals(name))
                return champ;
        return null;
    }

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

    //     }

    //     // for (Champ champ : this) {
    //     //     champ.setPickRate(picks.get(champ).toDouble());
    //     //     champ.setBanRate(bans.get(champ).toDouble());
    //     //     champ.setWinRate(wins.get(champ).toUncertainValue());
    //     //     champ.setGoodWith(new UncertainMap(goodWith.get(champ)));
    //     //     champ.setGoodAiganst(new UncertainMap(goodAiganst.get(champ)));
    //     // }
    // }
}
