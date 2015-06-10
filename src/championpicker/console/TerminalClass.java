package championpicker.console; 

import com.googlecode.lanterna.TerminalFacade;

import com.googlecode.lanterna.terminal.Terminal;

import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.gui.GUIScreen;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;

import com.googlecode.lanterna.terminal.swing.SwingTerminal;
import com.googlecode.lanterna.screen.Screen;

import com.googlecode.lanterna.gui.dialog.DialogButtons;
import championpicker.Main;

//import com.googlecode.lanterna.gui.listener.WindowAdapter;

import javax.swing.JFrame;

public class TerminalClass{

	public static void createTerm(){
		
		Terminal term = TerminalFacade.createSwingTerminal();
		
		Screen screen = new Screen(term);
		screen.startScreen();
		
		GUIScreen testGUI = new GUIScreen(screen);

		//term.enterPrivateMode();

		Message helloWorld = new Message(testGUI, Main.title, Main.message, DialogButtons.OK_CANCEL);

		JFrame frame = ((SwingTerminal)term).getJFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Champion Picker");
		
		Thread t = new Thread(helloWorld);
		//t.start();

		/*try {
			Thread.sleep(10000);
		} catch(Exception e) { }
		*/

		//screen.stopScreen();
	}
}