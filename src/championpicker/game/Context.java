package championpicker.game;

import championpicker.champ.Champ;

public class Context {

    private Team friendlyTeam, enemyTeam;

    public Context() {
        friendlyTeam = new Team();
        enemyTeam = new Team();
    }

    public void addFriendlyPick(Champ champ) {
        friendlyTeam.addPick(champ);
    }

    public void addEnemyPick(Champ champ) {
        enemyTeam.addPick(champ);
    }

    public void addFriendlyBan(Champ champ) {
        friendlyTeam.addBan(champ);
    }

    public void addEnemeyBan(Champ champ) {
        enemyTeam.addBan(champ);
    }

    public Team getFriendlyTeam() {
        return friendlyTeam;
    }

    public Team getEnemyTeam() {
        return enemyTeam;
    }
}
