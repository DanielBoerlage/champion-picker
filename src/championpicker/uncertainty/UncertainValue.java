package championpicker.uncertainty;

import championpicker.champ.ChampStat;

import static java.lang.Math.tanh;

public class UncertainValue {

    private double value;
    private int experiance;

    public UncertainValue(double value, int experiance) {
        this.value = value;
        this.experiance = experiance;
    }

    public UncertainValue(String str) {
        value = Double.parseDouble(str.substring(0, str.indexOf(":")));
        experiance = Integer.parseInt(str.substring(str.indexOf(":") + 1));
        assert toString().equals(str);
    }

    // public static UncertainValue parseUncertainValue(String str) {
    //     double value = Double.parseDouble(str.substring(0, str.indexOf("+") - 1).trim());
    //     int confidence = Integer.parseInt(str.substring(str.indexOf("+c") + 3).trim());
    //     return new UncertainValue(value, confidence);
    // }

    public void translateValueToFactorizedForm() {
        value = value * 2 - 1;
    }

    public double getBelief(double learningWeight) {
        return value * tanh(learningWeight * experiance);
    }

    public double getValue() {
        return value;
    }

    public int getExperiance() {
        return experiance;
    }

    public String toString() {         
        return value + ":" + experiance;
    }
}
