package championpicker.champ;

import championpicker.console.Output;

import championpicker.uncertainty.UncertainValue;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import java.util.Arrays;

public class ChampionIO {


    public static ChampionList readChampionListFromFile(File file) {
        ChampionList champList = new ChampionList();
        String[] champInfos = readFile(file).split("\n(?=[^\t])");
        for(String champInfo : champInfos)
            champList.add(parseChampionInfo(champInfo));
        return champList;
    }

    public static Champion parseChampionInfo(String champInfo) {
        //System.out.println("'" + champInfo + "'");
        String[] lines = champInfo.split("\n");
        Champion out = new Champion(lines[0]);
        for(int i = 1; i < lines.length; i++) { // CAUTION redneck coding ahead
            out.addParam(UncertainValue.parseUncertainValue(lines[i].substring(lines[i].indexOf(".") + 1)));
        }
        return out;
    }

    // warning: this will overide the contents of file
    public static void writeChampionListToFile(ChampionList champList, File file) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            for (Champion champ : champList)
                writer.println(champ);
        } catch (IOException e) {
            Output.err("IO Error writing to file " + file);
        }
    }

    // modified from stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
    private static String readFile(File file) {
        try {
            byte[] encoded = Files.readAllBytes(file.toPath());
            return new String(encoded, Charset.defaultCharset());
        } catch (IOException e) {
            Output.err("IO Error reading from file " + file);
        }
        return "";
    }
}
