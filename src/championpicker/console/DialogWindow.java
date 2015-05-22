package championpicker.console;

import com.googlecode.lanterna.gui.Window;
import championpicker.Main;

import com.googlecode.lanterna.gui.GUIScreen;

public class DialogWindow extends Window implements Runnable {

	GUIScreen parent;

	public DialogWindow(GUIScreen parent){
		super(Main.NAME);
		this.parent = parent;
	}

	public void run(){
		parent.showWindow(this);
	}

	public void stop() {
		close();
	}
}