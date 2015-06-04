package championpicker.console;

import javax.swing.JFrame;
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

import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Label;

public class mainStartUp{

	public Terminal term;
	public Screen screen;
	
	public void mainStartUp(){
	
		Terminal term = TerminalFacade.createSwingTerminal();
		
		Screen screen = new Screen(term);
		screen.startScreen();
		
		GUIScreen testGUI = new GUIScreen(screen);
		
		JFrame frame = ((SwingTerminal)term).getJFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Champion Picker");
	}
}