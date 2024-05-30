package vilia002.hw1;

/**
* A binary tree for the conversation of two {@link Agent Agents}.
* 
* @author Vasilis Ilia
* @version 1.0
* @since 2/09/2023
*/
public class BinaryTree {	
	private Node root;	
	
	/**
	 * Class constructor.
	 */
	public BinaryTree() {		
	}
	
	//  Each node of the tree is an object.
	private class Node {
		private Node left; 		//  the left node of this node
		private Node right;     //  the right node of this node
		private String data;    //  the data saved in this node
		private double leftProbability;  //  the probability to traverse to the left node
										 //  of this node.
		
		//  Constructor of the Node Class.
		private Node(String data, double leftProbability) {
			this.data = data;
			this.leftProbability = leftProbability;				
		}		
		
		/*
		 * Prints out this node's data and then traverses to the next node by 
		 * selecting a random number from 0 to 1, and using the probability 
		 * of this node to traverse to the left one of this.
		 */
		private void goToNextNode() {
			System.out.println(data);	
			
			//  If both left and right node of this node are null, then this node
			//  is the last one and the program terminates.
			if (left == null && right == null)
				System.exit(0);
			
			if (Math.random() <= leftProbability)
				left.goToNextNode();
			else
				right.goToNextNode();
		}
	}
	
	/**
	 * Starts traversing through the binary tree.	 
	 */
	public void startTraversing() {
		root.goToNextNode();
	}
	
	/**
	 * Builds the binary tree using two {@link Agent Agents} specified.
	 * 
	 * Each node is a sentence an Agent says. Nodes are linked together 
	 * according to the conversation graph.
	 * 
	 * @param A first Agent
	 * @param B second Agent
	 */
	public void createBinaryTree(Agent A, Agent B) {
		Node node1 = new Node(A.sayHello(), 0.5);
		Node node2 = new Node(B.agentSays("Hello " + A.getName() + ", I am " + B.getName() + 
				" and I am not feeling so good.") , 0.8);
		Node node3 = new Node(B.agentSays("How are you " + A.getName() + "?"), 1);
		Node node4 = new Node(A.agentSays(B.getName() + " why are you not feeling so"
				+ " good?"), 1);
		Node node5 = new Node(A.agentSays("Well " + B.getName() + " I do not care, because" +
				" I am from " + A.getCityBorn()), 0.1);
		Node node6 = new Node(A.agentSays("Fine. Where are you from?"), 1);
		Node node7 = new Node(B.agentSays("I just left my home town " + B.getCityBorn()
				+ "."), 1);
		Node node8 = new Node(B.agentSays("Well I am sorry, I am Canadian."), 1);
		Node node9 = new Node(B.agentSays("No one in my major " + B.getMajor() + 
				" is this rude."), 1);
		Node node10 = new Node(B.sayCityBorn(), 1);
		Node node11 = new Node(A.agentSays("Well me too, was from " + A.getCityBorn()
				+ " and now I am in " + A.getCityNow() + "."), 0.3);
		Node node12 = new Node(A.agentSays("Sorry I have to go."), 0);
		Node node13 = new Node(A.agentSays("I do not like people from " + B.getCityBorn()
				+ ", because I am from " + A.getCityBorn() + "."), 0.3);
		Node node14 = new Node(B.agentSays("Sorry I cannot speak with people from " +
				A.getCityBorn() + "."), 0);
		Node node15 = new Node(B.agentSays("This is so fascinating!"), 0);
		Node node16 = new Node(B.agentSays("I love your groove."), 1);
		Node node17 = new Node(A.agentSays("Well thank you, but I do not know your name."), 1);
		Node node18 = new Node(B.agentSays("Hello " + A.getName() + ", my name is " +
				B.getName() + "."), 1);
		Node node19 = new Node(A.agentSays("Sorry " + B.getName() + ", I have to go."), 0);	
			
		root = node1;
			
		root.left = node2;
		root.right = node3;	
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node4.left = node7;
		node5.left = node8;
		node5.right = node9;
		node6.left = node10;
		node7.left = node11;
		node8.left = node12;
		node9.left = node12;
		node10.left = node13;
		node11.left = node14;
		node11.right = node15;
		node13.left = node15;
		node13.right = node16;
		node16.left = node17;
		node17.left = node18;
		node18.left = node19;		
	}			
}

