package championpicker.game;

import java.util.ArrayList;

public class GameList extends ArrayList<Game> {

	public GameList() {
		super();
	}

	public boolean containsId(long gameId) {
		for(Game game : this)
			if(game.getId() == gameId)
				return true;
		return false;
	}
}
