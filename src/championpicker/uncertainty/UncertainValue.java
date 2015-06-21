package championpicker.uncertainty;

import static java.lang.Math.tanh;

public class UncertainValue {

    private static final String delim = "?";

    private double value;
    protected int experiance;

    public UncertainValue() {
        this(.5, 0);
    }

    public UncertainValue(double value, int experiance) {
        this.value = value;
        this.experiance = experiance;
    }

    public UncertainValue(String str) {
        value = Double.parseDouble(str.substring(0, str.indexOf(delim)));
        experiance = Integer.parseInt(str.substring(str.indexOf(delim) + delim.length()));
        assert toString().equals(str);
    }

    public double getBelief(double learningWeight, double average) {
        return (getValue() - average) * tanh(learningWeight * experiance));
    }

    public double getValue() {
        return value;
    }

    public int getExperiance() {
        return experiance;
    }

    public String toString() {
        return getValue() + delim + experiance;
    }
}
