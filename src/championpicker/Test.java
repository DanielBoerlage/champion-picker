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
        ChampSet master = new ChampSet(2);
        Champ ez = new Champ("Ezreal", master);
        Champ ahri = new Champ("Ahri", master);
        System.out.println(master.summary().toString(4));
    }
}
