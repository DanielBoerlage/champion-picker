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

	public static final String NAME = "Champion Picker";

	public static void main(String[] args) {
		
		// String json = "{\"pageInfo\": {\"pageName": "abc\",\"pagePic\": \"http://example.com/content.jpg\"}\"posts\":[{\"post_id\": \"123456789012_123456789012\",\"actor_id\": \"1234567890\",\"picOfPersonWhoPosted\": \"http://example.com/photo.jpg\",\"nameOfPersonWhoPosted\": \"Jane Doe\",\"message\": \"Sounds cool. Can't wait to see it!\",\"likesCount\": \"2\",\"comments\": [],\"timeOfPost\": \"1234567890\"}]}";

		// JSONObject obj = new JSONObject(json);
		// System.out.println(obj.getJSONObject("pageInfo").getString("pageName"));

		// JSONArray arr = obj.getJSONArray("posts");
		// for (int i = 0; i < arr.length(); i++)
		// {
		//     System.out.println(post_id = arr.getJSONObject(i).getString("post_id"));
		// }

		//System.out.println(new JSONObject("{\"hi\":\"bye\"}").getString("hi"));
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
		StatisticalChamp aatrox = new StatisticalChamp("Aatrox");
		aatrox.addStat("PickRate", new UncertainValue(.5, 0));


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
	}

	/*public static void main(String[] args){
		TerminalClass.createTerm();
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
