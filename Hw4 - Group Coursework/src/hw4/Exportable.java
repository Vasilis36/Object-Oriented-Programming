package hw4;

/**
 * Interface for exporting results.
 * 
 * @author Vasilis Ilia
 * @author -
 * @version 1.0
 * @since 22/04/2023
 */

public interface Exportable {

	/**
	 * Exports the results of the program in a file.
	 * 
	 * Overwrites an already existing file of the same name and sends a message when it's done.	 	
	 */
	public void exportResults();
}
