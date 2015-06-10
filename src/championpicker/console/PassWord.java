package championpicker.console;

import com.googlecode.lanterna.gui.*;

import com.googlecode.lanterna.gui.component.PasswordBox;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.dialog.DialogButtons;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.Screen;

import championpicker.Main;

import javax.swing.JFrame;
//import com.googlecode.lanterna.gui.Component;

public class PassWord extends PasswordBox implements Runnable{
	
	GUIScreen parent;
	
	//eexpects window gets component
	
	
	public PassWord(GUIScreen parent, String initial, int width){
		super(initial, width);
		this.parent = parent;
	}
	
	public void run(){
		Label label = new Label();
		parent.showWindow(label.addComponent(PassWord, GUIScreen.Position_CENTER));
	}
} 