package championpicker;

import java.io.IOException;
import jcurses.widgets.*;
import jcurses.system.Toolkit;
import jcurses.system.CharColor;

class Main{

	public static void main(String[] args) throws Exception {
		Window w = new Window(40, 20, true, "Hello World Window");
    DefaultLayoutManager mgr = new DefaultLayoutManager();
    mgr.bindToContainer(w.getRootPanel());
    mgr.addWidget(
		  new Label("Hello World!",
			    new CharColor(CharColor.WHITE, CharColor.GREEN)),
		  0, 0, 40, 20,
		  WidgetsConstants.ALIGNMENT_CENTER,
		  WidgetsConstants.ALIGNMENT_CENTER);
    w.show();
    Thread.currentThread().sleep(5000);	// sleep for 5 seconds, then exit
    w.close(); // reset the native console
	}
}
