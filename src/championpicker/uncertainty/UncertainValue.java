package championpicker.uncertainty;

import java.io.Serializable;

import static java.lang.Math.tanh;

public class UncertainValue implements Serializable {

    private static final String delim = "?";

    private double value;
    private int experiance;

    public UncertainValue(double value, int experiance) {
        this.value = value;
        this.experiance = experiance;
    }

    // public UncertainValue(String str) {
    //     value = Double.parseDouble(str.substring(0, str.indexOf(delim)));
    //     experiance = Integer.parseInt(str.substring(str.indexOf(delim) + delim.length()));
    //     assert toString().equals(str);
    // }

    public static UncertainValue parse(String str) {
        if()
    }

    // rename
    public void translateValueToGoodBadFactorForm() {
        value = value * 2 - 1;
    }

    // rename
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
        return value + delim + experiance;
    }
}
