package championpicker.uncertainty;

public class Tally {

    private int count, total;

    public Tally() {
        count = 0;
        total = 0;
    }

    public void addTrue() {
        count++;
        total++;
    }

    public void addFalse() {
        count++;
    }

    public UncertainValue toUncertainValue() {
        return new UncertainValue(((double)count) / total, total);
    }
}
