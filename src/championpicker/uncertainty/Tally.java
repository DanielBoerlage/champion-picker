package championpicker.uncertainty;

public class Tally extends Uncertain {

    private int count;

    public Tally() {
        super(Double.NaN, 0);
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
