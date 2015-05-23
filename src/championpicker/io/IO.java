package championpicker.io;

import championpicker.console.Output;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;

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

	public static Object readObjectFromFile(String path) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
			return in.readObject();
		} catch (FileNotFoundException e) {
			Output.err("Error creating/accessing file " + path + ". " + e.getMessage());
		} catch (IOException e) {
			Output.err("IO Error reading from file " + path + ". " + e.getMessage());
		} catch (ClassNotFoundException e) {
			Output.err("Class not found error while reading from " + path + ". " + e.getMessage());
		}
		return null;
	}

	public static void writeObjectToFile(Object obj, String path) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
			out.writeObject(obj);
		} catch (FileNotFoundException e) {
			Output.err("Error accesing file " + path + ". " + e.getMessage());
		} catch (IOException e) {
			Output.err("IO Error writing to file " + path + ". " + e.getMessage());
		}
	}
}
