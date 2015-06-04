package championpicker.console;

import com.googlecode.lanterna.gui.component.PasswordBox;
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

public class PassWord{

	public static void createPasswordBox(String credentialRequest){
		Panel password = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
		password.setTitle("");
		password.addComponent(new Label("Password: "));
		password.addComponent(new PasswordBox(null, 15));
		addComponent(password);
	}
} 