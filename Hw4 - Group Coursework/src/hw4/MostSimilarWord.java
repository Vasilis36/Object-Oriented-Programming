package hw4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Describes the most similar word to a specified word from a list of choices.
 * 
 * Calculates the semantic similarities between each of the choices and the 
 * given word. The most similar word is the one with the highest
 * semantic similarity.
 * 
 * @author Vasilis Ilia
 * @author -
 * @version 1.0
 * @since 20/04/2023
 */
public class MostSimilarWord {
	private ArrayList<Double> semanticSimilarities;
	private String word;

	/**
	 * Class constructor specifying the word to each to find the most similar word,
	 * a list of choices to choose the most similar word from, and the
	 * {@link SemanticDescriptors} to use, in order to calculate the semantic 
	 * similarities between the words.
	 * 
	 * @param questionWord  the word to find the most similar word to
	 * @param choices 		the choices of words to choose the most similar word from
	 * @param semDes 	    the SemanticDescriptors used to calculate the semantic similarities
	 */
	public MostSimilarWord(String questionWord, ArrayList<String> choices, SemanticDescriptors semDes) {
		semanticSimilarities = new ArrayList<Double>();

		calculateSemanticSimilarities(questionWord, choices, semDes);
		findMostSimilarWord(choices);		
	}

	/*
	 * Private method that calculates the semantic similarities between the question word and all the choices,
	 * using the SemanticDescriptors.
	 */
	private void calculateSemanticSimilarities(String questionWord, ArrayList<String> choices, SemanticDescriptors semDes) {
		HashMap<String, Integer> semDesOfQuestionWord;

		// Only tries to calculate the semantic similarities if the semantic descriptor of 
		// the question word exists.
		if (semanticDescriptorExists(questionWord, semDes)) {
			semDesOfQuestionWord = getSemDesOfWord(questionWord, semDes);

			for (String word : choices) {
				HashMap<String, Integer> semDesOfChoiceWord;

				if (semanticDescriptorExists(word, semDes))				
					semDesOfChoiceWord = getSemDesOfWord(word, semDes);

				// If the vector for the questionWord does not exist then the semantic similarity
				// between the words cannot be calculated and gets the value of -1.
				else {
					semanticSimilarities.add(-1.0);
					continue;
				}

				semanticSimilarities.add(calculateCosineSimilarity(semDesOfQuestionWord, semDesOfChoiceWord));			
			}
		}
		// If the semantic descriptor of the choice word does not exist, puts 0 as the value for all the 
		// the semantic similarities.
		else
			for (int i = 0; i < choices.size(); i++)
				semanticSimilarities.add(0.0);
	}

	/*
	 * Private method that checks whether a semantic descriptor in the  
	 * SemanticDescriptors exists, using a specified work as a key.
	 */
	private boolean semanticDescriptorExists(String word, SemanticDescriptors semDes){
		return semDes.getHashMap().containsKey(word);
	}

	/*
	 * Private method that returns the semantic descriptor of a specified word from 
	 * the pool of SemanticDescriptors.
	 */
	private HashMap<String, Integer> getSemDesOfWord(String word, SemanticDescriptors semDes){
		return semDes.getHashMap().get(word);		
	}

	/*
	 * Calculates the dot product between two semantic descriptors divided by the square root 
	 * of the product of their magnitudes.
	 */
	private double calculateCosineSimilarity(HashMap<String, Integer> semDes1, HashMap<String, Integer> semDes2) {
		double dotProduct = 0;
		
		for (String wordOfVector1 : semDes1.keySet())
			for (String wordOfVector2 : semDes2.keySet())
				if (wordOfVector1.equals(wordOfVector2))
					dotProduct += semDes1.get(wordOfVector1) * semDes2.get(wordOfVector2);

		return dotProduct / (calculateSquareRootOfMagnitude(semDes1) * calculateSquareRootOfMagnitude(semDes2));
	}

	/*
	 * Private method that calculates the square root of the magnitude of a semantic
	 * descriptor (HashMap).
	 */
	private double calculateSquareRootOfMagnitude(HashMap<String, Integer> semDesOfWord) {
		double sumOfSquares = 0;

		for (String wordOfVector : semDesOfWord.keySet())
			sumOfSquares += semDesOfWord.get(wordOfVector) * semDesOfWord.get(wordOfVector);		

		return Math.sqrt(sumOfSquares);
	}

	/*
	 * Private method that finds the most similar word from the list of choices,
	 * by comparing the semantic similarities of the choices to the question word.
	 */
	private void findMostSimilarWord(ArrayList<String> choices) {
		int indexOfMostSimilar = 0;
		double maxSemanticSimilarity = semanticSimilarities.get(0);

		for (int i = 1; i < semanticSimilarities.size(); i++)
			if (semanticSimilarities.get(i) > maxSemanticSimilarity) {
				maxSemanticSimilarity = semanticSimilarities.get(i);	
				indexOfMostSimilar = i;
			}		
		word = choices.get(indexOfMostSimilar);
	}

	/**
	 * Gets the most similar word.
	 * 
	 * @return  the most similar word
	 */
	public String getWord() {
		return word;
	}
}
