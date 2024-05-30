package hw4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Describes semantic descriptors.
 * 
 * A semantic descriptor is a vector used for finding the semantic similarity 
 * between words.
 * 
 * @author Vasilis Ilia
 * @author -
 * @version 1.0
 * @since 19/04/2023
 */
public class SemanticDescriptors {
	// A HashMap whose keys are each a unique word, and its values are HashMaps that
	// correspond to the amount of times the key word has been in a sentence
	// with a different word.
	private HashMap<String, HashMap<String, Integer>> vector;

	/**
	 * Class constructor specifying {@link SentenceLists} for creating the 
	 * SemanticDescriptor.
	 * 
	 * @param lists  the SentenceLists used to create the SemanticDescriptors
	 */
	public SemanticDescriptors(SentenceLists lists) {		
		vector = new HashMap<String, HashMap<String, Integer>>();

		buildVector(lists.getList());
	}

	/*
	 * Private method that builds the vector using specified list of sentences. 
	 */
	private void buildVector(ArrayList<ArrayList<String>> list) {

		// Loop that goes through each sentence in the list.
		for (int i = 0; i < list.size(); i++) {			
			// Elements of list need to be downcasted to ArrayList<String> from Object.
			ArrayList<String> sentence = (ArrayList<String>)list.get(i);		

			// Loop that goes through each word in a sentence.			
			for (int j = 0; j < sentence.size(); j++) {
				String word = sentence.get(j);

				// If key word is not already added in the vector HashMap then adds it.
				if (!vector.containsKey(word))
					vector.put(word, null);				
			}

			// Updates each word key for the words of the current sentence. 
			// Only needs to be done once a sentence in a sequential order, since
			// any possible new key words were not present in previous sentences.
			updateWordKeys(sentence);
			clearNullKeys(sentence);
		}
	}

	/*
	 * Private method for updating the HashMaps for each key word in the 
	 * vector for the specified sentence.
	 */
	private void updateWordKeys(ArrayList<String> sentence) {
		for (String wordKey : sentence) {
			// So we only count the occurrence of two words being in the same 
			// sentence. Duplicates in one sentence should not count twice.
			ArrayList<String> wordsAlreadyChecked = new ArrayList<String>();

			for (String wordValue : sentence) {
				if (wordKey == wordValue)
					continue;

				boolean wordChecked = false;

				for (String word : wordsAlreadyChecked)
					if (wordValue == word)
						wordChecked = true;

				if (wordChecked == false) {
					wordsAlreadyChecked.add(wordValue);
					countWordValue(wordKey, wordValue);					
				}				
			}
		}
	}

	/* 
	 * Private method for counting an occurrence of a key word being in the
	 * sentence with another word.
	 */
	private void countWordValue(String wordKey, String wordValue) {

		// If the wordKey is null then we need to add a new HashMap as its element.
		if (vector.get(wordKey) == null) {
			HashMap<String, Integer> newValueHashMap = new HashMap<String, Integer>();
			newValueHashMap.put(wordValue, 1);
			vector.put(wordKey, newValueHashMap);
		}

		// If the wordKey has not been in the same sentence as the wordValue yet,
		// but has a HashMap as an element, add it with an occurrence of 1.
		else if (!vector.get(wordKey).containsKey(wordValue))
			vector.get(wordKey).put(wordValue, 1);	

		// If the wordKey has been before in the same sentence as the wordValue,
		// then gets the previous occurrences and adds 1 to them.		
		else {			
			int currentValue = vector.get(wordKey).get(wordValue);
			int newValue = currentValue + 1;

			vector.get(wordKey).replace(wordValue, newValue);			
		}	
	}

	/*
	 *  Private method for removing any keys that hold no values
	 *  (words that were never in a sentence with another word).
	 */
	private void clearNullKeys(ArrayList<String> sentence) {
		for (String word : sentence) 
			if (vector.get(word) == null)
				vector.remove(word);
	}

	/**
	 * Gets the HashMap of the SemanticDescriptors.
	 * 
	 * @return  the HashMap of the SemanticDescriptors
	 */
	public HashMap<String, HashMap<String, Integer>> getHashMap(){
		return vector;
	}
}
