package championpicker.uncertainty;

import championpicker.champ.ChampionParam;

public class UncertainValue {

    private double value;
    private int confidence;

    public UncertainValue(double value, int confidence) {
        this.value = value;
        this.confidence = confidence;
    }

    public static UncertainValue parseUncertainValue(String str) {
        double value = Double.parseDouble(str.substring(0, str.indexOf("+") - 1).trim());
        int confidence = Integer.parseInt(str.substring(str.indexOf("+c") + 3).trim());
        return new UncertainValue(value, confidence);
    }

    public double getValue() {
        return value;
    }

    public int getConfidence() {
        return confidence;
    }

    public String toString() {
        return value + " +c " + confidence;
    }
}
