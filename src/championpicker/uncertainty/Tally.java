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
        total++;
    }

    public void count(boolean truth) {
        if (truth) count++;
        total++;
    }

    public UncertainValue toUncertainValue() {
        return new UncertainValue(((double)count) / total, total);
    }

    public double toDouble() {
        return ((double)count) / total;
    }
}
