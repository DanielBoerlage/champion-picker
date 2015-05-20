package championpicker.champ;

import championpicker.Uncertainty.UncertainValue;

import java.util.Map;

public class Champion {

    private String name;

    double pickRate;
    double banRate;

    //UncertainValue pickRate;
    //UncertainValue banRate;
    Map<Champion, UncertainValue> goodWith;
    Map<Champion, UncertainValue> goodAiganst;

    public Champion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        String out = name;
        return out;
    }
}
