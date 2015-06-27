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
        Champ ezreal = new Champ("Ezreal", 2);

        Champ alistar = new Champ("Alistar", 0);
        Champ ahri = new Champ("Ahri", 1);

        ChampSet master = new ChampSet();
        master.add(ezreal);
        master.add(alistar);
        master.add(ahri);

        Relational<Double> ezGW = new Relational<Double>();
        ezGW.put(ahri, .1);
        ezGW.put(alistar, .5);

        System.out.println(ezGW);
    }
}
