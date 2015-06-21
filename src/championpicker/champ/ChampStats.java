package championpicker.champ;

import org.json.JSONObject;

public class ChampStats extends Champ {

    private double         pickRate;
    private double         banRate;
    private UncertainValue winRate;
    private UncertainMap   goodWith;
    private UncertainMap   goodAgainst;

    public ChampStats(double pickRate, double banRate, UncertainValue winRate) {
        this.pickRate = pickRate;
        this.banRate = banRate;
        this.winRate = winRate;
    }

    public ChampStats(String name, JSONObject json) {
        this.name = name;
        id = json.getInt("id");
        pickRate = json.getDouble("pickRate");
        banRate = json.getDouble("banRate");
        winRate = new UncertainValue(json.getString("winRate"));
    }

    public ChampStats(GameList gameList) {
        Tally pickTally = new Tally();
        Tally banTally  = new Tally();
        winRate = new Tally();
        
    }

    @Override
    public JSONObject toJSON() {
        return new JSONObject()
            .put("id", id)
            .put("pickRate", pickRate)
            .put("banRate", banRate)
            .put("winRate", winRate.toString());
    }


    public void setPickRate(double pickRate) {
        this.pickRate = pickRate;
    }

    public void setBanRate(double banRate) {
        this.banRate = banRate;
    }

    public void setWinRate(UncertainValue winRate) {
        this.winRate = winRate;
    }

    public void compileStats(GameList gameList) {
        Tally pickTally = new Tally();
        Tally banTally  = new Tally();
        Tally winTally  = new Tally();
        Map<Champ, Tally> goodWithTally    = new HashMap<Champ, Tally>();
        Map<Champ, Tally> goodAgainstTally = new HashMap<Champ, Tally>();
        for (Champ champ : ChampList.master) {
            goodWithTally.put(new Tally());
            goodAgainstTally.put(new Tally());
        }

        for(Game game : gameList) {
            boolean wasPicked = game.containsPick(this);  // simplify to game.containsPick(this)
            boolean wasBanned = game.allBans().contains(this);
            pickTally.count(wasPicked);
            banTally.count(wasBanned);
            if(wasPicked) {
                boolean wonGame = game.champWon(this);
                winTally.count(wonGame);
                for(Champ friendly : game.friendlies(this))
                    goodWithTally.get(friendly).count(wonGame);
                for(Champ enemy : game.enemies(this))
                    goodAgainstTally.get(enemy).count(wonGame);
            }
        }

        pickRate = pickTally.toDouble();
        banRate = banTally.toDouble();
        winRate = winTally.toUncertainValue();
        goodWith    = new HashMap<Champ, UncertainValue>();
        goodAgainst = new HashMap<Champ, UncertainValue>();
        for (Champ champ : ChampList.master) {
            goodWith.put(champ, goodWithTally.get(champ).toUncertainValue());
            goodAgainst.put(champ, goodAgainstTally.get(champ).toUncertainValue());
        }
    }
}
