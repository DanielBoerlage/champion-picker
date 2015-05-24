package championpicker.io;

import championpicker.console.Output;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.MalformedURLException;

public class IO {

	public static String readFromFile(String path) {
		try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            Output.err("IO Error reading from file " + path + ". " + e.getMessage());
        }
        return "";
	}

	public static void writeToFile(String str, String path) {
		try {
			Files.write(Paths.get(path), str.getBytes());
		} catch (IOException e) {
			Output.err("IO Error writing to file " + path + ". " + e.getMessage());
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

	public static String readFromWebpage(String url) {
		System.out.println("querying " + url);
		String line, out = "";
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
			while((line = reader.readLine()) != null) out += line;
		} catch (MalformedURLException e) {
			Output.err("Badly formated URL Error " + url + ". " + e.getMessage());
		} catch (IOException e) {
			Output.err("IO Error reading from URL " + url + ". " + e.getMessage());
		}
		return out;

	}
}
