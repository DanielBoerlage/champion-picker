package championpicker.champ;

import java.util.Map;
import java.util.HashMap;

public class StatisticalChamp extends Champ {

	private Map<String, Object> stats;

	public StatisticalChamp(String name) {
		super(name);
		this.stats = new HashMap<String, Object>();
	}

	public void addStat(String name, Object stat) {
		stats.put(name, stat);
	}

	// public String toString() {

	// }
}