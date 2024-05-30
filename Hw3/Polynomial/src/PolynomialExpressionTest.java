package vilia002.hw3.polynomial;

import static org.junit.Assert.*;
import org.junit.*;

public class PolynomialExpressionTest {	
	
	@Test
	public void testPolynomialExpression() {
		PolynomialExpression polynomial = new PolynomialExpression();
		assertEquals("0", polynomial.toString());
	}

	@Test
	public void testPolynomialExpressionString() {
		PolynomialExpression polynomial = new PolynomialExpression("-3x^4 -2x^5 -5 +11x^1");
		assertEquals("-2x^5 -3x^4 +11x^1 -5", polynomial.toString());
	}	
	
	@Test
	public void testAddTerm() {
		PolynomialExpression polynomial = new PolynomialExpression("3x^1 +4x^2");
		polynomial.addTerm(4, 2);
		assertEquals("8x^2 +3x^1", polynomial.toString());
	}	
	
	@Test
	public void testRemoveTerm() {
		PolynomialExpression polynomial = new PolynomialExpression("-3x^4 -2x^5 -5 +11x^1");
		polynomial.removeTerm(5);		
		assertEquals("-3x^4 +11x^1 -5", polynomial.toString());
	}
	
	@Test
	public void testGetDegree() {
		PolynomialExpression polynomial = new PolynomialExpression("-5");
		assertEquals(0, polynomial.getDegree());
		polynomial = new PolynomialExpression("2x^1 +3x^3 +5x^2");
		assertEquals(3, polynomial.getDegree());
	}	
	
	@Test
	public void testGetCoefficient() {
		PolynomialExpression polynomial = new PolynomialExpression();
		assertEquals(-1, polynomial.getCoefficient(2));
		polynomial = new PolynomialExpression("2x^1 +3x^3 +5x^2");
		assertEquals(5, polynomial.getCoefficient(2));
	}
	
	@Test
	public void testEvaluate() {
		PolynomialExpression polynomial = new PolynomialExpression();
		assertEquals(0, (int)polynomial.evaluate(-3));
		polynomial = new PolynomialExpression("2x^2 +3x^1");
		assertEquals(14, (int)polynomial.evaluate(2));
	}
	
	@Test
	public void testAdd() {
		PolynomialExpression polynomial1 = new PolynomialExpression("-3x^4 -2x^5 -5 +11x^1");
		PolynomialExpression polynomial2 = new PolynomialExpression("-1x^4 +2x^5 -5 +3x^1");
		assertEquals("-4x^4 +14x^1 -10", polynomial1.add(polynomial2).toString());
	}
	
	@Test
	public void testToString() {
		PolynomialExpression polynomial = new PolynomialExpression("-3x^4 -2x^5 -5 +11x^1");
		assertEquals("-2x^5 -3x^4 +11x^1 -5", polynomial.toString());
		polynomial = new PolynomialExpression();
		assertEquals("0", polynomial.toString());
	}
}
