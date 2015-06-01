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
        if(total == 0)
            return new UncertainValue(.5, 0);
        return new UncertainValue(((double)count) / total, total);
    }

    public double toDouble() {
        if(total == 0)
            return .5;
        return ((double)count) / total;
    }
}
