package vilia002.hw3.polynomial;

import java.util.LinkedList;

/**
 * Describes a polynomial expression.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 02/04/2023
 */
public class PolynomialExpression implements Polynomial{
	private LinkedList<PolynomialTerm> polynomial;

	/**
	 * No argument class constructor. Creates a zero polynomial.
	 */
	public PolynomialExpression() {
		polynomial = new LinkedList<PolynomialTerm>();
	}
	
	/**
	 * Class constructor specifying polynomial polynomial as a string.
	 * 
	 * @param stringPolynomial  the polynomial as a string
	 */
	public PolynomialExpression(String stringPolynomial) {
		this();
		addTermsFromString(stringPolynomial);
	}

	// Private method to find and add the terms from a String to this polynomial.
	private void addTermsFromString(String stringPolynomial) {
		String[] terms = stringPolynomial.split(" "); // Array with all the terms as strings

		for (String term : terms) {			
			String stringCoefficient = "";
			String stringExponent = "";
			int coefficient;
			int exponent;

			int i;
			
			// Loop to find the coefficient of the term
			for (i = 0; i < term.length() && (term.charAt(i) == '+' || term.charAt(i) == '-' ||
					term.charAt(i) >= '0' && term.charAt(i) <= '9'); i++)				
				stringCoefficient += term.charAt(i);
			
			coefficient = Integer.parseInt(stringCoefficient);
			
			// Exponent = 0 when term is just a number(index = size of list after finding coefficient)
			if (i == term.length())
				exponent = 0;			
			else {
				// Loop to find the exponent of the term.
				for (int j = i; j < term.length(); j++)
					if (term.charAt(j) >= '1' && term.charAt(j) <= '9')
						stringExponent += term.charAt(j);
				
				exponent = Integer.parseInt(stringExponent);
			}
			addTerm(coefficient, exponent);				
		}
	}

	public void addTerm(int coefficient, int exponent) {
		// Exponent cannot be negative.
		if (exponent < 0)
			throw new IllegalArgumentException("Exponent cannot a negative number.");

		// Does not add terms with coefficients that equal zero.
		if (coefficient == 0) 	
			return;

		if (polynomial.isEmpty())
			polynomial.add(new PolynomialTerm(coefficient, exponent));

		// If the list is not empty, then add the element in a descending order.
		else {
			int index = getIndexOfSmallerOrEqualExponent(exponent);
			
			if (index == polynomial.size())
				polynomial.add(index, new PolynomialTerm(coefficient, exponent));	
			
			// If there is already an existing term with the same coefficient add them together.
			else if (polynomial.get(index).getExponent() == exponent) {
				polynomial.get(index).addCoefficient(coefficient);
				removeIfZero(index);
			}			
			else 
				polynomial.add(index, new PolynomialTerm(coefficient, exponent));			
		}		
	}

	/*
	 * Private method for finding the index of the term that has smaller or equal exponent to the one specified.
	 * Returns the size of the LinkedList in case no such element exists.
	 */	 
	private int getIndexOfSmallerOrEqualExponent(int exponent) {
		for (int i = 0; i < polynomial.size(); i++)
			if (polynomial.get(i).getExponent() <= exponent)
				return i;
		// If there is no element that has smaller or equal exponent,
		// then the element needs to be added at the end.
		return polynomial.size();  
	}

	/*
	 * Private method that removes the term at specified index if its coefficient equals to zero.
	 */
	private void removeIfZero(int index) {
		if (polynomial.get(index).getCoefficient() == 0)
			polynomial.remove(index);
	}

	public void removeTerm(int exponent) {
		for (int i = 0; i < polynomial.size(); i++)
			if (polynomial.get(i).getExponent() == exponent)
				polynomial.remove(i);
	}

	public int getDegree() {
		if (polynomial.isEmpty())
			throw new IllegalArgumentException("Cannot define degree of a zero polynomial.");

		return polynomial.getFirst().getExponent();
	}

	public int getCoefficient(int exponent) {
		for (int i = 0; i < polynomial.size(); i++)
			if (polynomial.get(i).getExponent() == exponent)
				return polynomial.get(i).getCoefficient();
		return -1; // Returns -1 if no term with specified exponent exists.
	}

	public double evaluate(double number) {
		if (polynomial.isEmpty())
			return 0;

		double sum = 0;

		for (PolynomialTerm term : polynomial)
			sum += term.getCoefficient() * Math.pow(number, term.getExponent());

		return sum;
	}

	public Polynomial add(Polynomial other) {
		if (other.getClass() != this.getClass())
			throw new IllegalArgumentException("Argument is not of type PolynomialExpression");

		// Creates new polynomial
		Polynomial newPolynomial = new PolynomialExpression();

		// Adds all the terms from this polynomial to the new one.
		for (PolynomialTerm term : polynomial)
			newPolynomial.addTerm(term.getCoefficient(), term.getExponent());

		PolynomialExpression newOther = (PolynomialExpression) other;

		// Adds all the terms from the other polynomial to the new one.
		for (PolynomialTerm term : newOther.polynomial) 	
			newPolynomial.addTerm(term.getCoefficient(), term.getExponent());			

		return newPolynomial;
	}
	
	public String toString() {		
		if (polynomial.isEmpty())
			return "0";
		
		String str = "";
		
		for (PolynomialTerm term : polynomial) {			
			if (term.getCoefficient() > 0 && str != "")
				str += "+";
			
			str += term.getCoefficient();
			if (term.getExponent() != 0)
				str += "x^" + term.getExponent() + " ";
		}
		return str.strip();		
	}
}
