package championpicker.champ;

import championpicker.console.Output;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ChampionIO {

    //public static ChampionList readChampionListFromFile(File file) {

    //}

    // warning: this will overide the contents of file
    public static void writeChampionListToFile(ChampionList champList, File file) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            for (Champion champ : champList) {
                writer.println(champ.getName());
                System.out.println(champ.getName());
            }
        } catch (IOException e) {
            Output.err("Error writing to file " + file);
        }
    }
}
