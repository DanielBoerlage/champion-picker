// package championpicker.champ;
//
// import org.json.JSONObject;
//
// public class ChampStats extends Champ {
//
//     private double         pickRate;
//     private double         banRate;
//     private UncertainValue winRate;
//     private UncertainMap   goodWith;
//     private UncertainMap   goodAgainst;
//
//     public ChampStats(double pickRate, double banRate, UncertainValue winRate) {
//         this.pickRate = pickRate;
//         this.banRate = banRate;
//         this.winRate = winRate;
//     }
//
//     public ChampStats(String name, JSONObject json) {
//         this.name = name;
//         id = json.getInt("id");
//         pickRate = json.getDouble("pickRate");
//         banRate = json.getDouble("banRate");
//         winRate = new UncertainValue(json.getString("winRate"));
//     }
//
//     @Override
//     public JSONObject toJSON() {
//         return new JSONObject()
//             .put("id", id)
//             .put("pickRate", pickRate)
//             .put("banRate", banRate)
//             .put("winRate", winRate.toString());
//     }
//
//
//     public void setPickRate(double pickRate) {
//         this.pickRate = pickRate;
//     }
//
//     public void setBanRate(double banRate) {
//         this.banRate = banRate;
//     }
//
//     public void setWinRate(UncertainValue winRate) {
//         this.winRate = winRate;
//     }
// }
