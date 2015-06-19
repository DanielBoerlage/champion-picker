package championpicker.console;

import com.googlecode.lanterna.gui.*;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.dialog.DialogButtons;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.Window;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.Screen;

import championpicker.Main;
import championpicker.console.mainStartUp;

import javax.swing.JFrame;

public class queueWindow extends Window{
	
	public queueWindow(){
		super("GLHF");
		
		createButtons(1);
	}
	
	public void createButtons(int roundNum){

		addComponent(new Button("Us", new Action(){

		public void doAction(){
			System.out.println("Woohoo!");
			//firstPick();
		}}));
		
		addComponent(new Button("Them", new Action(){

		public void doAction(){
			System.out.println("SWAAAAAAGGGGGGG!");
			//secondPick();
		}}));
	}
}