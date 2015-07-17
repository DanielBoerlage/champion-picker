package championpicker.champ;

import java.util.HashMap;
import java.util.Iterator;
import championpicker.io.JSONAble;
import org.json.JSONObject;
import org.json.JSONArray;

public class ChampSet {

    private Champ[] champs;
    private int index;

    public ChampSet(int size) {
        champs = new Champ[size];
    }

    public ChampSet(JSONObject json) {
    	super();
    	Iterator<String> iter = json.keys();
        while(iter.hasNext()) {
            String name = iter.next();
            add(new Champ(name, json.getJSONObject(name)));
        }
    }

    public int add(Champ champ) {
    	champs[index] = champ;
        return index++;
    }

    public int size() {
        return champs.length;
    }

    public JSONObject summary() {
        JSONArray champArray = new JSONArray();
        for(Champ champ : champs)
            champArray.put(champ);
        return new JSONObject()
            .put("champs", champArray);
    }

    public JSONObject toJSON() {
    	JSONObject out = new JSONObject();
    	// for (Champ champ : this)
    	// 	out.put(champ.getName(), champ.toJSON());
    	return out;
    }

    // public Iterator<Champ> iterator() {
    // 	return new Iterator<Champ>(){
    //         boolean hasNext() {

    //         }


    //     };
    // }
}
