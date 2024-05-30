package vilia002.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* Reads and saves the content of a file.
*
* The content of the file is saved in an array. Each line in the file counts as a
* separate element.
* 
* @author Vasilis Ilia
* @version 1.0
* @since 2/09/2023
*/
public class WordList {
	private String[] ArrayList;
	
	/**
	 * Class constructor specifying name of file to read.	
	 * 
	 * @param fileName  the name of the file to read
	 * @throws FileNotFoundException  If the file with the specified name does not exist
	 * or is inaccessible.
	 */
	public WordList(String fileName) throws FileNotFoundException {
		File fileNameObj = new File(fileName);
		saveFileContent(fileNameObj);	
	}
	
	//  Private method for opening the file, reading it, and saving its content. 
	private void saveFileContent(File fileNameObj) throws FileNotFoundException {
		Scanner reader = new Scanner(fileNameObj);
		
		String words = "";		
		
		while(reader.hasNext()) 
			words += reader.nextLine() + "\n";
		
		reader.close();		
		
		ArrayList = words.split("\n");
	}
	
	/**
	 * Gets a random word from the file. 
	 * 
	 * @return a random word from the file
	 */
	public String getRandomWord() {
		int indexOfWord = (int) (Math.random() * ArrayList.length);
		return ArrayList[indexOfWord];
	}	
}
