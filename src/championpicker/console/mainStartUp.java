package championpicker.console;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.dialog.DialogButtons;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.Screen;

import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Label;

import championpicker.Main;
import championpicker.console.mainMenu;

import javax.swing.JFrame;

public class mainStartUp{

	public static Terminal term;
	public static Screen screen;
	public static GUIScreen gui;
	
	public static void mainStartUp(){
	
		term = TerminalFacade.createSwingTerminal();
		
		screen = new Screen(term);
		screen.startScreen();
		
		gui = new GUIScreen(screen);
		
		JFrame frame = ((SwingTerminal)term).getJFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Champion Picker");
		
		Message helloWorld = new Message(gui, "Welcome!", "Welcome to Champion Picker!", DialogButtons.OK);
		
		Thread t = new Thread(helloWorld);
		t.start();
	}
}