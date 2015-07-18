package championpicker.game;

import championpicker.champ.Champ;
import championpicker.champ.ChampSet;

import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Date;

import java.util.Set;
import java.util.HashSet;

public class Game {

	private long id;
	private long date;
	private boolean winner;
	private Team team0, team1;

	public Game(JSONObject json) throws Exception {
		id = json.getLong("matchId");
		date = json.getLong("matchCreation");
		JSONArray participants = json.getJSONArray("participants");
		int teamSize = participants.length() / 2;
		team0 = new Team(true);
		team1 = new Team(false);
		for (int i = 0; i < teamSize; i++) {
			JSONObject player = participants.getJSONObject(i);
			team0.addPick(ChampSet.master.byId(player.getInt("championId")));

			player = participants.getJSONObject(i + teamSize);
			team1.addPick(ChampSet.master.byId(player.getInt("championId")));
		}
		JSONArray teams = json.getJSONArray("teams");
		JSONObject team = teams.getJSONObject(0);
		winner = team.getBoolean("winner");
		JSONArray bans = team.getJSONArray("bans");
		team0.addBan(ChampSet.master.byId(bans.getJSONObject(0).getInt("championId")));
		team0.addBan(ChampSet.master.byId(bans.getJSONObject(1).getInt("championId")));
		team0.addBan(ChampSet.master.byId(bans.getJSONObject(2).getInt("championId")));
		team = teams.getJSONObject(1);
		bans = team.getJSONArray("bans");
		team1.addBan(ChampSet.master.byId(bans.getJSONObject(0).getInt("championId")));
		team1.addBan(ChampSet.master.byId(bans.getJSONObject(1).getInt("championId")));
		team1.addBan(ChampSet.master.byId(bans.getJSONObject(2).getInt("championId")));
	}

	public boolean containsPick(Champ champ) {
		return team0.getPicks().contains(champ) || team1.getPicks().contains(champ);
	}

	public boolean containsBan(Champ champ) {
		return team0.getBans().contains(champ) || team1.getBans().contains(champ);
	}

	public Set<Champ> friendlies(Champ champ) {
		Set<Champ> out = new HashSet<Champ>(); //just make list
		out.addAll(team0.getPicks().contains(champ) ? team0.getPicks() : team1.getPicks());
		out.remove(champ);
		return out;
	}

	public Set<Champ> enemies(Champ champ) {
		Set<Champ> out = new HashSet<Champ>(); //just make list
		out.addAll(team0.getPicks().contains(champ) ? team1.getPicks() : team0.getPicks());
		return out;
	}

	public boolean champWon(Champ champ) {
		return winner ^ team0.getPicks().contains(champ);
	}

	// public Set<Champ> allBans() {
	// 	Set<Champ> out = new HashSet<Champ>();
	// 	out.addAll(team0.getBans());
	// 	out.addAll(team1.getBans());
	// 	return out;
	// }

	// public long getId() {
	// 	return id;
	// }

	public String toString() {
		return team0 + " vs " + team1;
	}

	// public long getDateDiff(long date) {
	// 	return date - this.date;
	// }

	public Team getTeam0() {
		return team0;
	}

	public Team getTeam1() {
		return team1;
	}
}
