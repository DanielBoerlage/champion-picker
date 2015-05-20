package championpicker;

import championpicker.champ.*;

import java.io.File;

import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.TerminalFacade;

import java.util.Arrays;

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
		//System.out.println("sandwich?");
		ChampionList champList = new ChampionList();
		champList.add(new Champion("Aatrox"));
		champList.add(new Champion("Ahri"));
		File file = new File("./championData.txt");
		ChampionIO.writeChampionListToFile(champList, file);
		System.out.println(ChampionIO.readChampionListFromFile(file));
	}

	/*public static void main(String[] args) throws Exception {
		String str = "ssadssassadfs";
		System.out.println(Arrays.toString(str.split("(a)(?=[^s])")));
	}*/
}
