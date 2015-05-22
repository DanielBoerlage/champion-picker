package championpicker.console; 

import com.googlecode.lanterna.TerminalFacade;

import com.googlecode.lanterna.terminal.Terminal;

import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.gui.GUIScreen;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;

import com.googlecode.lanterna.terminal.swing.SwingTerminal;

//import com.googlecode.lanterna.gui.listener.WindowAdapter;

import javax.swing.JFrame;

public class TerminalClass{

	public static void createTerm(){
		
		Terminal term = TerminalFacade.createSwingTerminal();

		GUIScreen testGUI = new GUIScreen(new Screen(term));

		term.enterPrivateMode();

		DialogWindow helloWorld = new DialogWindow(testGUI);

		//helloWorld.addWindowListener(new WindowAdapter
		
		((SwingTerminal)term).getJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Thread t = new Thread(helloWorld);
		t.start();

		try {
			Thread.sleep(10000);
		} catch(Exception e) { }

<<<<<<< HEAD
=======
		helloWorld.stop();

>>>>>>> 9e944ee08e1bfd9d18847f33ef26837172942585
		term.exitPrivateMode();
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