package championpicker.console;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.terminal.Terminal;

import com.googlecode.lanterna.terminal.TerminalSize;


public class Output {

	public static void creatTerm(){
		Terminal terminal = TerminalFacade.createTerminal();
		TerminalSize screenSize = terminal.getTerminalSize();
	}
	
	
		
	public static void err(String errmsg) {
		System.err.println(errmsg);
	}
}