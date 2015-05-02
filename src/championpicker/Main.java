import java.io.IOException;
import jcurses.widgets.*;
import jcurses.system.Toolkit;
import jcurses.system.CharColor;


class InputTest{

	public static void main(String[] args){
		Window w = new Window(40, 20, true, "Numbers");
            DefaultLayoutManager mgr = new DefaultLayoutManager();
            mgr.bindToContainer(w.getRootPanel());

            CharColor color = new CharColor(CharColor.WHITE, CharColor.GREEN);

            w.show();

            while ( ! w.isClosed() ) {
                Toolkit.printString( "Hello World!", 45, 17, color);
            }
	}
}