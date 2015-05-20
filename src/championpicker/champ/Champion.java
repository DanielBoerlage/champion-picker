package championpicker.champ;

import championpicker.uncertainty.UncertainValue;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Champion {

    private String name;

    private List<ChampionParam> params;

    public Champion(String name) {
        this.name = name;
        params = new ArrayList<ChampionParam>();
    }

    public void addParam(ChampionParam param) {
        params.add(param);
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        String out = name;
        for(ChampionParam param : params)
            out += "\n\t." + param.key() + ": " + param.value();
        return out;
    }

    public boolean equals(Object obj) {
        return ((Champion)obj).getName().equals(name);
    }

    public String toString() {
        return getName();
    }
}
