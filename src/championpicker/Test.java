package championpicker;

import championpicker.champ.*;
import championpicker.uncertainty.*;
import championpicker.console.*;
import championpicker.io.*;
import championpicker.game.*;
import championpicker.learn.*;
import championpicker.util.*;

import championpicker.console.mainStartUp;

import java.io.File;
import java.nio.file.*;

import org.json.*;

import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.TerminalFacade;

import java.util.*;

public class Test {

    public static void test(String[] args) {
        RiotAPI api = new RiotAPI(IO.readJSONFromFile("api.json"));
        long quikhead = 33051878;
        long sam      = 22059070;
        ChampSet.master = new ChampSet(IO.readJSONFromFile("champs.json"));
        //api.fetchGamesBFS(100, 90, 30, sam, "RANKED_TEAM_3x3", "sams_games");
        GameSet games = new GameSet("sams_games");
        // for(Champ champ : ChampSet.master)
        //     champ.compileStats(games);
        // IO.writeToFile(ChampSet.master.statisticalSummary(), "stats.json");
        ChampSet.master.readStats(IO.readJSONFromFile("stats.json"));
        Weights weights = new Weights(0, 1);
        ChampSet.master.compilePartialScores(weights);
        //ChampSet.master.compileScores(weights);
        Learn learn = new Learn(games);
        Game game = games.get(0);
        System.out.println(game);
        System.out.println(learn.fitness(weights, game.getTeam0(), game.getTeam1()));
    }
}
