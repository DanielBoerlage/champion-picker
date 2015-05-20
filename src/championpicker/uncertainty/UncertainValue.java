package championpicker.uncertainty;

import championpicker.champ.ChampionParam;

public class UncertainValue implements ChampionParam {

    private String name;
    private double value;
    private int confidence;

    public UncertainValue(String name, double value, int confidence) {
        this.name = name;
        this.value = value;
        this.confidence = confidence;
    }

    public static UncertainValue parseUncertainValue(String str) {
        String name = str.substring(0, str.indexOf(":"));
        double value = Double.parseDouble(str.substring(str.indexOf(":") + 1, str.indexOf("+") - 1));
        int confidence = Integer.parseInt(str.substring(str.indexOf("confidence") + 11));
        return new UncertainValue(name, value, confidence);
    }

    public double getValue() {
        return value;
    }

    public double getConfidence() {
        return confidence;
    }

    // param stuff
    public Object key() {
        return name;
    }

    public Object value() {
        return value + " +confidence " + confidence;
    }
}
