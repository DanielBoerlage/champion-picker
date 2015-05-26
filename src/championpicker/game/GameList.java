package championpicker.game;

import java.util.ArrayList;
import java.io.File;
import org.json.JSONObject;
import championpicker.io.IO;

public class GameList extends ArrayList<Game> {

	public GameList() {
		super();
	}

	// create Game list from a directory of games in JSON format
	public GameList(String dir) {
		super();
		String[] files = new File(dir).list();
		for(String file : files)
			add(new Game(IO.readJSONFromFile(file)));
	}

	public boolean containsId(long gameId) {
		for(Game game : this)
			if(game.getId() == gameId)
				return true;
		return false;
	}
}
