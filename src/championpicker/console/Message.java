package championpicker.console;

import championpicker.Main;
import championpicker.console.mainMenu;

import com.googlecode.lanterna.gui.layout.LayoutParameter;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Interactable;
import com.googlecode.lanterna.gui.listener.WindowListener;
import com.googlecode.lanterna.gui.Interactable;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Panel.Orientation;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.dialog.DialogButtons;

import com.googlecode.lanterna.input.Key;

import com.googlecode.lanterna.screen.Screen;

import com.googlecode.lanterna.terminal.Terminal;

public class Message extends MessageBox implements Runnable{//, WindowListener {

	GUIScreen parent;
	
	public Message(GUIScreen parent, String name, String message, DialogButtons buttons){
	
		super(name, message, buttons);
		this.parent = parent;
	}
	
	/*public void onClose(){
		parent.update();
	}*/

	public void run(){
		parent.showWindow(this, GUIScreen.Position.CENTER);
		System.out.println("Message run");
	}

	/*public void onWindowClosed(Window window){
		System.out.println("Close");
		parent.getScreen().getTerminal().exitPrivateMode();
	}*/
	
	//public void testPrint(){
	
		/*System.out.println("testPrint");
		
		Panel horizontalPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);

        horizontalPanel.addComponent(horizontalPanel);
		
		MessageBox message = new MessageBox("Welcome!", "Welcome!", DialogButtons.OK);
		super(String title, String message, DialogButtons buttons);
		
		horizontalPanel.addComponent(message);
		
		
		/*horizontalPanel.addComponent( new Button("OK", new Action(){
			public void doAction() {
				System.out.println("Do Action");
				close();
				System.out.println("Action Done");
				System.out.println("Refreshed");
			}
		}));
		
		//parent.getScreen().refresh();
		
		addComponent(horizontalPanel);
		*/
	//}
	
	public void onWindowInvalidated(Window window){}	
	public void onWindowShown(Window window){}	
	public void onUnhandledKeyboardInteraction(Window window, Key key){}
	public void onFocusChanged(Window window, Interactable fromComponent, Interactable toComponent){}
}