package championpicker.uncertainty;

import static java.lang.Math.tanh;

public class UncertainValue {

    private static final String delim = "?";

    private double value, belief;
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

    public void compileBelief(double learningWeight) {
        belief = getValue() * getConfidence(learningWeight);
    }

    public void compileRateBelief(double learningWeight) {
        belief = (2 * getValue() - 1) * getConfidence(learningWeight);
    }

    public double getConfidence(double learningWeight) {
        return tanh(learningWeight * experiance);
    }

    public double getBelief() {
        return belief;
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
