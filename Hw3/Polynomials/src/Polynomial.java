package vilia002.hw3.polynomial;

/**
 * Contains methods related to polynomials.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 02/04/2023
 */
public interface Polynomial {
	/**
	 * Adds a term with specified coefficient and exponent to the polynomial.
	 * 
	 * @param coefficient  the coefficient of the term
	 * @param exponent	   the exponent of the term
	 */
	void addTerm(int coefficient, int exponent);
	
	/**
	 * Removes all terms of specified exponent from the polynomial.
	 * 
	 * @param exponent  the exponent of the terms to remove
	 */
	void removeTerm(int exponent);
	
	/**
	 * Gets the degree of the polynomial.
	 * 
	 * @return  the degree of the polynomial
	 */
	int getDegree();
	
	/**
	 * Gets the coefficient of the term with the specified exponent.
	 * 
	 * @param exponent  the exponent used to specify the term
	 * @return			the coefficient of specified term
	 */
	int getCoefficient(int exponent);
	
	/**
	 * Evaluates the polynomial using specified number.
	 * 
	 * @param number  the number to use to evaluate the polynomial
	 * @return		  the value of the polynomial using specified number
	 */
	double evaluate(double number);
	
	/**
	 * Returns the polynomial that results from adding this polynomial with another.
	 * 
	 * @param other  the polynomial to add to this one
	 * @return	     the resulting polynomial
	 */
	Polynomial add(Polynomial other);
	
	
	/**
	 * Returns the polynomial in string form.
	 * 
	 * @return  the polynomial in string form
	 */
	public String toString();
}
