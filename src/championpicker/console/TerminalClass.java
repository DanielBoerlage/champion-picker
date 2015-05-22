package championpicker.console;

import com.googlecode.lanterna.TerminalFacade;

import com.googlecode.lanterna.terminal.Terminal;

import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.gui.GUIScreen;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;

public class TerminalClass{

	public static void createTerm(){
		
		Terminal term = TerminalFacade.createSwingTerminal();

		GUIScreen testGUI = new GUIScreen(new Screen(term));

		//term.enterPrivateMode();

		DialogWindow helloWorld = new DialogWindow(testGUI);

		Thread t = new Thread(helloWorld);
		t.start();

		try {
			Thread.sleep(3000);
		} catch(Exception e) { }

		helloWorld.stop();

		//term.exitPrivateMode();
	}


	/*GUIScreen textGUI = TerminalFacade.createGUIScreen();
    	if(textGUI == null) {
        	System.err.println("Couldn't allocate a terminal!");
        	return;
    	}
    textGUI.getScreen().startScreen();
    textGUI.setTitle("GUI Test");

	//TerminalFacade.createSwingTerminal();



    textGUI.getScreen().stopScreen();*/
}