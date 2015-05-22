package championpicker.console;

import championpicker.Main;

import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Interactable;

import com.googlecode.lanterna.gui.listener.WindowListener;
import com.googlecode.lanterna.gui.Interactable;

import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.input.Key;

public class DialogWindow extends Window implements Runnable{//, WindowListener {

	GUIScreen parent;
	
	public DialogWindow(GUIScreen parent){
		super(Main.NAME);
		this.parent = parent;
	}

	public void run(){
		parent.showWindow(this);
		//addWindowListener(this);
	}

	/*public void onWindowClosed(Window window){
		System.out.println("To close");
		//parent.getScreen().getTerminal().exitPrivateMode();
	}
	
	public void onWindowInvalidated(Window window){}
	
	public void onWindowShown(Window window){}
	
	public void onUnhandledKeyboardInteraction(Window window, Key key){}
	
	public void onFocusChanged(Window window, Interactable fromComponent, Interactable toComponent){}*/
}