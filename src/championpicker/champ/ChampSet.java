package championpicker.champ;

import championpicker.learn.Weights;
import championpicker.game.GameSet;
import championpicker.game.Context;

import java.util.HashMap;
import java.util.Iterator;
import championpicker.io.JSONAble;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;

public class ChampSet extends ArrayList<Champ> {

    public static ChampSet master;

    public ChampSet() {
        super();
    }

    public ChampSet(JSONObject json) {
    	super();
    	Iterator<String> iter = json.keys();
        while(iter.hasNext()) {
            String name = iter.next();
            add(new Champ(name, json.getInt(name), size()));
        }
    }

    public void readStats(JSONObject json) {
        for(Champ champ : this)
            champ.readStats(json.getJSONObject(champ.getName()));
    }

    public int append(Champ champ) {
    	int ret = size();
        super.add(champ);
        return ret;
    }

    // maybe add table instead.. but need as many elemnts as champ id (may be too large) 1000max..toolazy
    public Champ byId(int id) {
        for(Champ champ : this)
            if(champ.getId() == id)
                return champ;
        return null;
    }

    public JSONObject summary() {
        JSONObject json = new JSONObject();
        for(Champ champ : this)
            json.put(champ.getName(), champ.getId());
        return json;
    }

    public JSONObject statisticalSummary() {
        JSONObject json = new JSONObject();
        for(Champ champ : this)
            json.put(champ.getName(), champ.statsJSON());
        return json;
    }

    public void compileStats(GameSet games) {
        for(Champ champ : this)
            champ.compileStats(games);
    }

    public void compilePartialScores(Weights weights) {
        for(Champ champ : this)
            champ.compilePartialScore(weights);
    }

    public void compileScores(Weights weights, Context context) {
        for(Champ champ : this)
            champ.compileScore(weights, context);
    }

    // public Iterator<Champ> iterator() {
    // 	return new Iterator<Champ>(){
    //         boolean hasNext() {

    //         }


    //     };
    // }
}
