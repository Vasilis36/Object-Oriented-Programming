package hw4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Describes a similarity test between the correct answers of multiple choice synonym questions
 * and the answers the programs gives.
 * 
 * Calculates the success rate of the program.
 * 
 * @author Vasilis Ilia
 * @author -
 * @version 1.0
 * @since 21/04/2023
 */
public class SimilarityTest implements Exportable {
	private SemanticDescriptors semDes;
	private int numberOfQuestions;
	private ArrayList<String> questionWords;
	private ArrayList<String> correctAnswers;
	private ArrayList<ArrayList<String>> choices;
	private ArrayList<String> programAnswers;	
	private double successRate;

	/**
	 * Class constructor specifying the name of the file to get the questions from
	 * and the {@link SemanticDescriptors} to use to calculate the results.
	 * 
	 * @param questionsFilename  the name of the file to use to get the questions from
	 * @param semDes  			 the SemanticDescriptors to use to calculate the results
	 */
	public SimilarityTest(String questionsFilename, SemanticDescriptors semDes) {
		this.semDes = semDes;
		ArrayList<String> questions = getData(questionsFilename);

		numberOfQuestions = questions.size();
		questionWords = findQuestionWords(questions);		
		correctAnswers = findCorrectAnswers(questions);
		choices = findChoices(questions);
		programAnswers = calculateProgramAnswers();		
		successRate = calculateSuccessRate();		
	}

	/*
	 * Private method that extracts the questions from a file and returns it.
	 */
	private ArrayList<String> getData(String questionsFilename) {
		ArrayList<String> questions = new ArrayList<String>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(questionsFilename));
			String line = "";

			while((line = reader.readLine()) != null)
				questions.add(line);

			reader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File " + questionsFilename + " not found");
			e.printStackTrace();
		}
		catch (IOException e) {			
			e.printStackTrace();
		}
		return questions;
	}

	/*
	 * Private method that finds all the question words from a string and returns
	 * them as a string list.
	 */
	private ArrayList<String> findQuestionWords(ArrayList<String> questions) {	
		ArrayList<String> questionWords = new ArrayList<String>();

		for (String question : questions) {
			String[] words = getArrayOfWords(question); 
			questionWords.add(words[0]);
		}	
		return questionWords;	
	}

	/*
	 * Private method that finds all the correct answers for each question from a string and returns
	 * them as a string list.
	 */
	private ArrayList<String> findCorrectAnswers(ArrayList<String> questions) {
		ArrayList<String> correctAnswers = new ArrayList<String>();

		for (String question : questions) {
			String[] words = getArrayOfWords(question); 
			correctAnswers.add(words[1]);
		}	
		return correctAnswers;
	}	

	/*
	 * Private method that finds all the choices for each question from a string and returns
	 * them as a list of string list.
	 */
	private ArrayList<ArrayList<String>> findChoices(ArrayList<String> questions) {
		ArrayList<ArrayList<String>> choices = new ArrayList<ArrayList<String>>();

		for (String question : questions) {
			String[] words = getArrayOfWords(question); 
			
			// Choices for a single question.
			ArrayList<String> questionChoices = new ArrayList<String>();

			for (int i = 2; i < words.length; i++)
				questionChoices.add(words[i]);

			choices.add(questionChoices);				
		}
		return choices;
	}	

	/*
	 * Private method that finds the program answers for all the questions and returns them
	 * as a string list.
	 */
	private ArrayList<String> calculateProgramAnswers() {		
		ArrayList<String> programAnswers = new ArrayList<String>();

		for (int i = 0; i < numberOfQuestions; i++) {
			MostSimilarWord mostSimilarWord = new MostSimilarWord(questionWords.get(i), choices.get(i), semDes);

			programAnswers.add(mostSimilarWord.getWord());
		}
		return programAnswers;
	}

	/*
	 * Private method that returns an array of string containing the words of a sentence.
	 */
	private String[] getArrayOfWords(String sentence){		
		return sentence.split(" ");
	}

	/*
	 * Private method for calculating the success rate of the program answers.
	 */
	private double calculateSuccessRate() {
		double numberOfCorectAnswers = 0;

		for (int i = 0; i < numberOfQuestions; i++)
			if (correctAnswers.get(i).equals(programAnswers.get(i)))
				numberOfCorectAnswers++;

		return numberOfCorectAnswers / numberOfQuestions * 100;
	}

	/**
	 * Returns a string representation of the results.
	 * 
	 * Includes success rate, correct answers and answers the program gave.
	 * 
	 * @return  a string representation of the results
	 */
	public String toString() {
		String str = String.format("%1$-1s %2$.2f", "Successs Rate:", successRate) + "%";
		str += String.format("%1$-25s %2$-25s %3$-1s", "\n\nQuestion Word", "Correct Answer", "Program Answer\n\n");

		for (int i = 0; i < questionWords.size(); i++) 
			str += String.format("%1$-23s %2$-25s %3$-1s", questionWords.get(i), correctAnswers.get(i), programAnswers.get(i) + "\n");

		return str;
	}

	public void exportResults() {
		try {     
			FileWriter writer = new FileWriter("Results.txt");
			writer.write(toString());
			writer.close();
			System.out.println("Successfully exported the results to 'Results.txt'.");
		} 
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}	
}