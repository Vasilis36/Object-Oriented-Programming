package vilia002.hw3.polynomial;

/**
 * Describes a term of a polynomial.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 02/04/2023
 */
public class PolynomialTerm {
	private int coefficient;
	private int exponent;
	
	/**
	 * Class constructor specifying the coefficient and the exponent of the term.
	 * 
	 * @param coefficient  the coefficient of the term
	 * @param exponent	   the exponent of the term
	 */
	public PolynomialTerm(int coefficient, int exponent) {
		this.coefficient = coefficient;
		this.exponent = exponent;
	}
	
	/**
	 * Gets the coefficient of the term.
	 *
	 * @return  the coefficient of the term
	 */
	public int getCoefficient() {
		return coefficient;
	}
	
	/**
	 * Gets the exponent of the term.
	 * 
	 * @return  the exponent of the term
	 */
	public int getExponent() {
		return exponent;
	}
	
	/**
	 * Adds the specified coefficient to the current one.
	 * 
	 * @param coefficient  the coefficient to add
	 */
	public void addCoefficient(int coefficient) {
		this.coefficient += coefficient;
	}
}
