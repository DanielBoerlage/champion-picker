package championpicker.champ;

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

    public int append(Champ champ) {
    	int ret = size();
        super.add(champ);
        return ret;
    }

    // maybe add table instead.. but need as many elemnts as champ id (may be too large)
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


    // public Iterator<Champ> iterator() {
    // 	return new Iterator<Champ>(){
    //         boolean hasNext() {

    //         }


    //     };
    // }
}
