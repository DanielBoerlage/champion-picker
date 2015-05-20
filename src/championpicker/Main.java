package championpicker;

import championpicker.champ.*;
import championpicker.uncertainty.*;

import java.io.File;

import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.TerminalFacade;

import java.util.Arrays;
import java.util.HashMap;

class Main{

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

	public static void main(String[] args) throws Exception {
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
	}

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
