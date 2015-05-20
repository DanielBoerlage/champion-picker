package championpicker.champ;

import java.util.ArrayList;

public class ChampionList extends ArrayList<Champion> {

    public ChampionList() {
        super();
    }

    public Champion getChampion(String name) {
        for(Champion champion : this)
            if(champion.getName().equals(name))
                return champion;
        return null;
    }
}
