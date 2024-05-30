package vilia002.hw1;

import java.io.FileNotFoundException;

/**
* Initializes the conversation between two {@link Agent Agents}.
* 
* @author Vasilis Ilia
* @version 1.0
* @since 2/09/2023
*/
public class DiscussionDirector {	
	private Agent A;
	private Agent B;
	
	/**
	 * Class constructor.
	 * 
	 * Instantiates two {@link Agent Agents}.
	 * 
	 * @throws FileNotFoundException  If a file for the characteristics of the 
	 * {@link Agent} is not found or is inaccessible.
	 */
	public DiscussionDirector() throws FileNotFoundException{
		A = Agent.generateAgent();
		B = Agent.generateAgent();			
	}
	
	/**
	 * Instantiates a binary tree using two {@link Agent Agents} and starts the conversation 
	 * using {@link BinaryTree#startTraversing()}.
	 */
	public void discuss() {	
		BinaryTree binTree = new BinaryTree();
		binTree.createBinaryTree(A, B);
		binTree.startTraversing();
	}
	
	/**
	 * Main method.
	 * 
	 * Instantiates DiscussionDirector and calls {@link #discuss()}
	 * 	 
	 * @param args the command line arguments
	 * @throws FileNotFoundException  If a file for the characteristics of the 
	 * {@link Agent} is not found or is inaccessible.
	 */
	public static void main(String[] args) throws FileNotFoundException  {		
		DiscussionDirector director = new DiscussionDirector();		
		director.discuss();
	}
}
