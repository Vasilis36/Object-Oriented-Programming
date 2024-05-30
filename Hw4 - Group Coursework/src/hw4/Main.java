package hw4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class that runs the {@link SimilarityTest} and exports the data.
 * 
 * The user is asked to enter (through the console) the name of the file
 * containing synonym test questions, as well as the names of the training files,
 * where each line should be a separate input of a file name. By typing “stop” user
 * input is terminated and the program starts creating lists in an attempt to find 
 * synonyms (for the words in the synonym questions file). The location of the test 
 * questions and the training files, as well as the results file “Results.txt” is in 
 * the project’s directory.
 * 
 * @author Vasilis Ilia
 * @author -
 * @version 1.0
 * @since 22/04/2023
 */
public class Main {

	/**
	 * Class constructor.
	 */
	public Main() {	
	}

	/**
	 * Reads the filenames of the user's questions and training files and runs the program.
	 * 
	 * Instantiates a {@link SimilarityTest} and exports the data using {@link SimilarityTest#exportResults()}.
	 * Outputs messages for each procedure the program goes through.
	 */
	public void run() {
		Scanner reader = new Scanner(System.in);
		String questionsFilename = readQuestionsFilename(reader);
		ArrayList<String> trainingFilenames = readTrainingFilenames(reader);	
		reader.close();

		System.out.println("Please wait...");
		
		System.out.println("Reading Files...");
		SentenceLists sentenceLists = new SentenceListsFromFiles(trainingFilenames);
		
		System.out.println("Building data structure...");
		SemanticDescriptors semDes = new SemanticDescriptors(sentenceLists);
		
		System.out.println("Calculating Results...");
		SimilarityTest similarityTest = new SimilarityTest(questionsFilename, semDes);
		
		similarityTest.exportResults();
	}

	/*
	 * Private method for reading the filename of the user's questions file.
	 */
	private String readQuestionsFilename(Scanner reader) {
		System.out.println("Please give the name of the file containing the test questions:");		
		String filename = reader.nextLine();			
		return filename;
	}

	/*
	 * Private method for reading the filenames of the user's training files.
	 */
	private ArrayList<String> readTrainingFilenames(Scanner reader) {
		ArrayList<String> filenames = new ArrayList<>();

		System.out.println("Please give the names of the training files. Type 'stop' to proceed to the results.");
		String input = reader.nextLine();		

		while (!input.equals("stop")) {
			filenames.add(input);
			input = reader.nextLine();			
		}		
		return filenames;
	}

	/**
	 * Main method.
	 * 
	 * Runs the program.
	 * 
	 * @param args  the command line arguments
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}