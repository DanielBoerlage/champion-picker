package championpicker;

import championpicker.champ.*;
import championpicker.uncertainty.*;
import championpicker.console.*;
import championpicker.io.*;

import java.io.File;
import java.nio.file.*;

import org.json.*;

import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.TerminalFacade;

import java.util.*;

public class Main{

	/*public static void main(String[] args){
		TerminalClass.createTerm();
	}*/

	public static void main(String[] args) {
		ChampList champs = new ChampList();
		Champ aatrox = new Champ("Aatrox");
		Champ ahri = new Champ("Ahri");
		champs.add(aatrox);
		champs.add(ahri);
		aatrox.addStat("PickRate", new UncertainValue(.5, 0));
		aatrox.addStat("BanRate", new UncertainValue(.3, 6));
		ahri.addStat("PickRate", new UncertainValue(.2, 10));
		ahri.addStat("BanRate", new UncertainValue(0, 0));
		//HashMap<Champ, UncertainValue> ga = new HashMap<Champ, UncertainValue>();
		RelationalChampMap aatroxGA = new RelationalChampMap();
		aatrox.addStat("GoodWith", aatroxGA);
		aatroxGA.put(aatrox, new UncertainValue(.5, 32));
		aatroxGA.put(ahri, new UncertainValue(.7, 1));
		System.out.println(champs + "  " + champs.champStatsJSON());
		IO.writeObjectToFile(champs, "champ_stats.ser");
		ChampList read = (ChampList)IO.readObjectFromFile("champ_stats.ser");
		System.out.println(read + "  " + read.champStatsJSON());
	}

	/*public static void main(String[] args) {


		//System.out.println(new JSONObject("{\"hi\":\"bye\"}").getString("hi"));

		// Path path = Paths.get("a_file.txt");
		// String content = "hello world!";
		// IO.writeToFile(content, path);
		//
		// System.out.println(IO.readFromFile(path));
		// Map<String, String> map = new HashMap<String, String>();
		// map.put("hi", "bysde");
		// map.put("bye", "hiasd");
		// JSONObject json = new JSONObject((Map)map);
		// System.out.println(json);

		// Path path = Paths.get("a_file.txt");
		// String content = "hello worlf!";
		// IO.writeToFile(content, path);

		// System.out.println(IO.readFromFile(path));

		// ChampList champs = new ChampList();
		// champs.add(new StatisticalChamp("Aatrox"));
		// champs.add(new StatisticalChamp("Ahri"));
		// System.out.println(champs);
		// System.out.println(champs.toJSONArray());
		// JSONObject obj = new JSONObject();
		// obj.put("champs", champs.toJSONArray());
		// System.out.println(obj.toString(4));

		ChampList champs = new ChampList();
		Champ aatrox = new Champ("Aatrox");
		Champ ahri = new Champ("Ahri");
		champs.add(aatrox);
		champs.add(ahri);
		aatrox.addStat("PickRate", new UncertainValue(.5, 0));
		aatrox.addStat("BanRate", new UncertainValue(.3, 6));
		RelationalChampMap aatroxGA = new RelationalChampMap();
		aatroxGA.put(aatrox, new UncertainValue(.5, 32));
		aatroxGA.put(ahri, new UncertainValue(.7, 1));
		aatrox.addStat("GoodWith", aatroxGA);
		ahri.addStat("PickRate", new UncertainValue(.2, 10));
		ahri.addStat("BanRate", new UncertainValue(0, 0));
		JSONObject obj = champs.champStatsJSON();
		System.out.println(obj.toString(4));

		// JSONStringer json = new JSONStringer();
		// json
		// 	.array()
		// 		.value("hallo welt")
		// 		.value("salut le monde")
		// 	.endArray();

		// System.out.println(json);

		// JSONArray arr = new JSONArray(json.toString());
		// JSONObject obj = new JSONObject();
		// obj.put("greetings", arr);

		// System.out.println(arr);
		// System.out.println(obj);

		//String[] arr = {"a", "b", "c"};
		//Collection c = Arrays.asList(arr);
		//System.out.println(new JSONArray((Collection)c));




		// UncertainValue uv = new UncertainValue(.3, 20);
		// System.out.println(uv);
		// UncertainValue uv2 = new UncertainValue(uv.toString());
		// System.out.println(uv2);
		// System.out.println(uv2.getValue() + " " + uv2.getExperiance());
		// uv2.translateValueToGoodBadFactorForm();
		// System.out.println(uv2.getValue() + " " + uv2.getExperiance());
		// System.out.println(uv2.getBelief(.2));
	}*/

	/*public static void main(String[] args) throws Exception {
		GUIScreen textGUI = TerminalFacade.createGUIScreen();
	    if(textGUI == null) {
	        System.err.println("Couldn't allocate a terminal!");
	        return;
	    }
	    textGUI.getScreen().startScreen();
	    textGUI.setTitle("GUI Test");

	    //Do GUI logic here

	    Thread.sleep(3000);

	    textGUI.getScreen().stopScreen();
	}*/

	/*public static void main(String[] args) throws Exception {
		ChampionList champList = new ChampionList();
		Champion aatrox = new Champion("Aatrox");
		aatrox.addParam(new UncertainParam("PickRate", .5, 0));
		Champion ahri = new Champion("Ahri");
		ahri.addParam(new UncertainParam("PickRate", .6, 2));
		UncertainMap ahriGA = new UncertainMap("GoodAiganst");
		ahriGA.put("aatrox", new UncertainValue(.8, 2));
		ahriGA.put("ahri", new UncertainValue(.2, 1));
		ahri.addParam(ahriGA);
		champList.add(aatrox);
		champList.add(ahri);
		File file = new File("./champion-data.txt");
		ChampionIO.writeChampionListToFile(champList, file);
		System.out.println(ChampionIO.readChampionListFromFile(file));
		ChampionList newList = ChampionIO.readChampionListFromFile(file);
		System.out.println(newList.get(0).getSummary());
		System.out.println(newList.get(1).getSummary());
	}*/

	/*public static void main(String[] args) throws Exception {
		String str = "ssadssassadfs";
		System.out.println(Arrays.toString(str.split("(a)(?=[^s])")));
	}*/

	/*public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("hi", "there");
		hm.put("bye", "already");
		System.out.println(hm);
	}*/
}
