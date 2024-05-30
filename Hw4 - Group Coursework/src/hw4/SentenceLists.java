package hw4;

import java.util.ArrayList;

/**
 * A template for creating a list of lists of words.
 * 
 * The abstract class SentenceLists is responsible for extracting the
 * words from each sentence included in the given text, by storing 
 * them in sentence lists and then adding them all to the text list.
 * 
 * @author Vasilis Ilia
 * @author -
 * @version 1.0
 * @since 19/04/23 
 */
public abstract class SentenceLists {

	/*
	 * The field list represents the given text's list, which stores all 
	 * the lists of words of each sentence in the text.
	 * 
	 * The field indexOfSentence is used to store the index (position) of the 
	 * end of the sentences in the text.
	 * 
	 * The field listSize is the number of sentences, which is basically the number
	 * of lists that will be added to the text list. 
	 */
	private ArrayList<ArrayList<String>> list;
	private String text;
	private ArrayList<Integer> indexOfSentence = new ArrayList<Integer>();
	private int listSize;

	/**
	 * Class constructor specifying the text to make lists of.
	 * 
	 * The constructor first refers its text field to the parameter that is
	 * passed when the SentenceLists object is created. Here the number of sentences 
	 * contained in the given text is determined by calling the method 
	 * getNumberOfSentences and the list ArrayList is then created. The method addLists
	 * is called in the end to add the sentence lists to the text list.
	 * 
	 * @param text  the given string to make lists of 
	 */
	public SentenceLists(String text){
		this.text = text;
		listSize = getNumberOfSentences(); 
		list = new ArrayList<ArrayList<String>>(listSize);
		addLists();
	}

	/*
	 * Stores the number of sentences of the text in sentenceCnt, and the index of 
	 * the end of each sentence is stored in the ArrayList indexOfArray.
	 */
	private int getNumberOfSentences() {
		int sentenceCnt = 0; // stores the number of sentences found in the text

		for(int i = 0; i < text.length(); i++)
			if ((text.charAt(i) == '.' && text.charAt(i-1) != '.') || text.charAt(i) == '?' || text.charAt(i) == '!') { // also in case of "..."
				indexOfSentence.add(i);  //  the index of one of the above characters is stored, implying the end the of a sentence
				sentenceCnt++;
			}		
		return sentenceCnt;	
	}

	/*
	 * Adds each sentence list of words to the text list. (by calling the 
	 * method getSentenceLists which returns an ArrayList of the words of 
	 * the sentence contained between the indexes passed as arguments).
	 */
	private void addLists() {
		list.add(getSentenceLists(-1, indexOfSentence.get(0))); 
		
		for (int i = 1 ; i < listSize; i++)
			list.add(getSentenceLists(indexOfSentence.get(i-1), indexOfSentence.get(i))); //  Next sentence starts at the index of the
																						  //  end of the last sentence (indexOfSentence[i-1]).
	}

	/*
	 * Creates an ArrayList (wordsOfSentence) which stores
	 * the words of the sentence between the indexes (parameters) in lower case.
	 * minIndex & maxIndex are the beginning & the end of the sentence.
	 */
	private ArrayList<String> getSentenceLists(int minIndex, int maxIndex) {
		ArrayList<String> wordsOfSentence = new ArrayList<String>(); //  the list of the sentence between the indexes
		String word = "";  //  stores each word of the sentence and consecutively adds it to wordsOfSentence.
		
		for (int i = minIndex + 1; i <= maxIndex; i++){
			char x = this.text.charAt(i);

			if ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z'))
				word += x;	

			else if (!word.isEmpty()){
				wordsOfSentence.add(word.toLowerCase());
				word = "";
			}
		}
		return wordsOfSentence;	
	}	

	/**
	 * Gets the list of sentences.
	 * 
	 * @return  the list of sentences
	 */ 
	public ArrayList<ArrayList<String>> getList(){
		return this.list;
	}
}
