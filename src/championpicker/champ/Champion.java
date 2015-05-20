package championpicker.champ;

import championpicker.Uncertainty.UncertainValue;

import java.util.Map;

public class Champion {

    private String name;

    double pickRate;
    double banRate;
    Map<Champion, UncertainValue> goodWith;
    Map<Champion, UncertainValue> goodAiganst;

    public Champion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
