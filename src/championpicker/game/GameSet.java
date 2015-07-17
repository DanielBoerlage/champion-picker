package championpicker.game;

import java.util.ArrayList;
import java.io.File;
import championpicker.io.IO;


public class GameSet extends ArrayList<Game> {

	public GameSet() {
		super();
	}

	public GameSet(String dir) {
		super();
		String[] files = new File(dir).list();
		for(String file : files) {
			try {
				add(new Game(IO.readJSONFromFile(dir + "/" + file)));
			} catch(Exception e) { }
		}
	}
}
