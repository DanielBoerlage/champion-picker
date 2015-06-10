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
//
// public class UncertainValue implements Serializable {
//
//     private static final String delim = "?";
//
//     private double value;
//     private int experiance;
//
//     public UncertainValue(double value, int experiance) {
//         this.value = value;
//         this.experiance = experiance;
//     }
//
//     public UncertainValue(String str) {
//         value = Double.parseDouble(str.substring(0, str.indexOf(delim)));
//         experiance = Integer.parseInt(str.substring(str.indexOf(delim) + delim.length()));
//         assert toString().equals(str);
//     }
//
//     public double getBelief(double learningWeight) {
//         return value * tanh(learningWeight * experiance);
//     }
//
//     public double getRateBelief(double learningWeight) {
//         return (2 * value - 1) * tanh(learningWeight * experiance);
//     }
//
//     public double getValue() {
//         return value;
//     }
//
//     public int getExperiance() {
//         return experiance;
//     }
//
//     public String toString() {
//         return value + delim + experiance;
//     }
// }
