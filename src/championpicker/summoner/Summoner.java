package championpicker.summoner;

public class Summoner {

    private String name;
    private long id;

    public Summoner(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }
}
