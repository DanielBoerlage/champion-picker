package championpicker.champ;

import championpicker.io.JSONable;
import java.util.ArrayList;

import org.json.JSONObject;

public class ChampList extends ArrayList<Champ> implements JSONable {

    public ChampList() {
        super();
    }

    // public Champion getChampion(String name) {
    //     for(Champion champion : this)
    //         if(champion.getName().equals(name))
    //             return champion;
    //     return null;
    // }
    
    public JSONObject toJSON() {
        return null;
    }
}
