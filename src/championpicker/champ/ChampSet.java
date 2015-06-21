package championpicker.champ;

public class ChampSet extends HashMap<String, Champ> {

    public ChampSet() {
        super();
    }

    public Champ byName(String name) {
        return get(name);
    }
}
