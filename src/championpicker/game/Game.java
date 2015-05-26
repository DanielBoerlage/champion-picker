package championpicker.game;

import championpicker.champ.ChampList;

import org.json.JSONObject;
import org.json.JSONArray;


public class Game {

	private long id;
	// Team0 is the blue team and always has first ban and first pick
	private Team team0, team1;
	private String winner;

	// public Game(int id, double weight) {
	// 	this.id = id;
	// }

	public Game(JSONObject json) {
		id = json.getLong("matchId");
		JSONArray participants = json.getJSONArray("participants");
		int teamSize = participants.length() / 2;
		team0 = new Team();
		team1 = new Team();
		for(int i = 0; i < teamSize; i++) {
			JSONObject player = participants.getJSONObject(i);
			team0.add(ChampList.master.byId(player.getInt("championId")));

			player = participants.getJSONObject(i + teamSize);
			team1.add(ChampList.master.byId(player.getInt("championId")));
		}
	}

	public long getId() {
		return id;
	}

	public String toString() {
		return team0 + " vs " + team1;
	}
}
