// package championpicker.champ;
//
// import java.util.Comparator;
// import java.util.Map;
//
// // WARNING!! this code was adapted from
// // stackoverflow.com/questions/109383/how-to-sort-a-mapkey-value-on-the-values-in-java
// // and it fails in a lot of cases
// // see comments on first answer
// public class ChampComparator implements Comparator<Champ> {
//
//     private Map<Champ, Double> base;
//
//     public ChampComparator(Map<Champ, Double> base) {
//         this.base = base;
//     }
//
//     public int compare(Champ a, Champ b) {
//         //if(base.get(a) == base.get(b))
//         //    System.out.println("equal - " + base.get(a) + " " + a + " + " + b);
//         return base.get(b).compareTo(base.get(a));
//     }
// }
