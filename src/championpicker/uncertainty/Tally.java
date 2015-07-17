package championpicker.uncertainty;

public class Tally {

    private int count, experiance;

    public Tally() {
        count = experiance = 0;
    }

    public void count(boolean truth) {
        if (truth) count++;
        experiance++;
    }

    public Uncertain compile() {
        return new Uncertain(getValue(), experiance);
    }

    public double getValue() {
        return (double)count / experiance;
    }
}
