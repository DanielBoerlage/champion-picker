package championpicker.champ;

import java.util.HashMap;
import java.util.Iterator;
import championpicker.io.JSONAble;
import org.json.JSONObject;

public class ChampSet extends HashMap<String, Champ> implements Iterable<Champ> {

    public ChampSet() {
        super();
    }

    public ChampSet(JSONObject json) {
    	super();
    	Iterator<String> iter = json.keys();
        while(iter.hasNext()) {
            String name = iter.next();
            add(new Champ(name, json.getJSONObject(name)));
        }
    }

    public void add(Champ champ) {
    	put(champ.getName(), champ);
    }

    public JSONObject toJSON() {
    	JSONObject out = new JSONObject();
    	for (Champ champ : this)
    		out.put(champ.getName(), champ.toJSON());
    	return out;
    }

    public Iterator<Champ> iterator() {
    	return values().iterator();
    }
}
