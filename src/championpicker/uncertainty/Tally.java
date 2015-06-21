package championpicker.uncertainty;

public class Tally extends UncertainValue {

    private int count;

    public Tally() {
        count = 0;
    }

    public void count(boolean truth) {
        if (truth) count++;
        experiance++;
    }

    @Override
    public double getValue() {
        return (double)count / experiance;
    }
}
