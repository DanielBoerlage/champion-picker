package championpicker.Uncertainty;

public class UncertainValue {

    private double value, uncertainty;

    public UncertainValue(double value, double uncertainty) {
        this.value = value;
        this.uncertainty = uncertainty;
    }

    public double getValue() {
        return value;
    }

    public double getUncertainty() {
        return uncertainty;
    }
}
