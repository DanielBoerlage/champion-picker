package championpicker.io;

import championpicker.console.Output;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class IO {

	public static String readFromFile(Path path) {
		try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            Output.err("IO Error reading from file " + path);
        }
        return "";
	}

	public static void writeToFile(String str, Path path) {
		try {
			Files.write(path, str.getBytes());
		} catch (IOException e) {
			Output.err("IO Error writing to file " + path);
		}
	}
}