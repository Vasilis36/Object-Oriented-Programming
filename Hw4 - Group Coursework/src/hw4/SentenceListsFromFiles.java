package hw4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * SentenceListsFromFiles is a {@link SentenceLists}.
 * 
 * It takes in a list of filenames and passes the contents of these files to
 * the super constructor.
 * 
 * @author Vasilis Ilia
 * @author -
 * @version 1.0
 * @since 20/04/2023
 */
public class SentenceListsFromFiles extends SentenceLists{

	/**
	 * Class constructor specifying the list of filenames of the files to extract
	 * the string from.
	 * 
	 * @param filenames  a list that contains the names of the files to use
	 */
	public SentenceListsFromFiles(ArrayList<String> filenames) {
		super(extractFileContent(filenames));
	}

	/*
	 * Reads the contents of each file in the filenames ArrayList
	 * and stores them in a String variable.
	 */
	private static String extractFileContent(ArrayList<String> filenames) {		
		List<String> contentAsList = new ArrayList<String>();
		String content = "";

		for (int i = 0 ; i < filenames.size(); i++) {		
			Path path = Paths.get(filenames.get(i));

			try {					 
				contentAsList = Files.readAllLines(path);
				content += contentAsList.toString();
			} 				 
			catch (IOException e) {	
				System.out.println("An error occurred.");
				e.printStackTrace();
			}	
		}
		return content;
	}
}
