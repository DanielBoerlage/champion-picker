package championpicker.game;

import championpicker.champ.ChampList;
import championpicker.champ.Champ;

import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Date;

import java.util.Set;
import java.util.HashSet;

public class Game {

	private long id;
	private long date;
	// Team0 is the blue team and always has first ban and first pick
	private Team team0, team1;
	// true if team0 won
	private boolean winner;

	// public Game(int id, double weight) {
	// 	this.id = id;
	// }

	public Game(JSONObject json) throws Exception {
		id = json.getLong("matchId");
		date = json.getLong("matchCreation");
		JSONArray participants = json.getJSONArray("participants");
		int teamSize = participants.length() / 2;
		team0 = new Team();
		team1 = new Team();
		for(int i = 0; i < teamSize; i++) {
			JSONObject player = participants.getJSONObject(i);
			team0.addPick(ChampList.master.byId(player.getInt("championId")));

			player = participants.getJSONObject(i + teamSize);
			team1.addPick(ChampList.master.byId(player.getInt("championId")));
		}
		JSONArray teams = json.getJSONArray("teams");
		JSONObject team = teams.getJSONObject(0);
		winner = team.getBoolean("winner");
		JSONArray bans = team.getJSONArray("bans");
		team0.addBan(ChampList.master.byId(bans.getJSONObject(0).getInt("championId")));
		team0.addBan(ChampList.master.byId(bans.getJSONObject(1).getInt("championId")));
		team0.addBan(ChampList.master.byId(bans.getJSONObject(2).getInt("championId")));
		team = teams.getJSONObject(1);
		bans = team.getJSONArray("bans");
		team1.addBan(ChampList.master.byId(bans.getJSONObject(0).getInt("championId")));
		team1.addBan(ChampList.master.byId(bans.getJSONObject(1).getInt("championId")));
		team1.addBan(ChampList.master.byId(bans.getJSONObject(2).getInt("championId")));
	}

	public Set<Champ> allPicks() {
		Set<Champ> out = new HashSet<Champ>();
		out.addAll(team0.getPicks());
		out.addAll(team1.getPicks());
		return out;
	}

	public Set<Champ> friendlies(Champ champ) {
		Set<Champ> out = new HashSet<Champ>();
		out.addAll(team0.getPicks().contains(champ) ? team0.getPicks() : team1.getPicks());
		out.remove(champ);
		return out;
	}

	public Set<Champ> enemies(Champ champ) {
		return team0.getPicks().contains(champ) ? team1.getPicks() : team0.getPicks();
	}

	public boolean champWon(Champ champ) {
		return winner ^ team0.getPicks().contains(champ);
	}

	public Set<Champ> allBans() {
		Set<Champ> out = new HashSet<Champ>();
		out.addAll(team0.getBans());
		out.addAll(team1.getBans());
		return out;
	}

	public long getId() {
		return id;
	}

	public String toString() {
		return team0 + " vs " + team1;
		//return String.valueOf(ge)
	}

	public long getDateDiff(long date) {
		return date - this.date;
	}
}
