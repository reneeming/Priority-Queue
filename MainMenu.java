
/**
@author Ming Ni
@version 1.0

COP5007 Exam 2
File Name: MainMenu.java
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu extends Menu {

	/**
	Handle user's input for this menu.
	*/
	@Override
	public boolean listenerUserInput() {
		Scanner scan = new Scanner(System.in);
		print("Please enter input file path:\n");
		String filePath = scan.nextLine();
		print("\nPlease enter delimiter for input and its priority:\n");
		String delimiter = scan.nextLine();

		Scanner in = null;
		try {
			in = new Scanner(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		PriorityQueue<String> queue = new PriorityQueue<>();
		while (in.hasNext()) {
			String line = in.nextLine().trim();
			String[] contents = line.split(delimiter);
			queue.add(contents[0], Integer.parseInt(contents[1]));
		}
		in.close();

		List<String> lines = new ArrayList<>();
		while (!queue.isEmpty()) {
			lines.add(queue.remove());
		}

		Path outputFile = Paths.get("OutputStrings.txt");
		try {
			Files.write(outputFile, lines, Charset.forName("UTF-8"));
			print("OutputStrings.txt has been saved!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
