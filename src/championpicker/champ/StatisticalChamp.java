package championpicker.champ;

import java.util.Map;
import java.util.HashMap;

public class StatisticalChamp extends Champ {

	private Map<String, ChampStat> stats;

	public StatisticalChamp(String name) {
		super(name);
		this.stats = new HashMap<String, ChampStat>();
	}

	public void addStat(String name, ChampStat stat) {
		stats.put(name, stat);
	}
}