package championpicker.champ;

import championpicker.uncertainty.UncertainValue;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Champion {

    private String name;

    private List<ChampionParam> params;

    double pickRate;
    double banRate;

    //UncertainValue pickRate;
    //UncertainValue banRate;
    Map<Champion, UncertainValue> goodWith;
    Map<Champion, UncertainValue> goodAiganst;

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

    public String toString() {
        String out = name;
        for(ChampionParam param : params)
            out += "\n\t." + param.key() + ": " + param.value();
        return out;
    }
}
