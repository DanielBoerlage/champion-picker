package championpicker.champ;

import java.util.ArrayList;

public class ChampList extends ArrayList<Champ> {

    public ChampList() {
        super();
    }

    public Champ byId(int id) {
        for(Champ champ : this)
            if(champ.getId() == id)
                return champ;
        return null;
    }
}
