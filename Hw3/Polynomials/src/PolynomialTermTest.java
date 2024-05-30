package vilia002.hw3.polynomial;

import static org.junit.Assert.*;
import org.junit.*;

public class PolynomialTermTest {

	@Test
	public void testPolynomialTerm() {
		PolynomialTerm term = new PolynomialTerm(2, 3);
		assertEquals(2, term.getCoefficient());
		assertEquals(3, term.getExponent());
	}

	@Test
	public void testGetCoefficient() {
		PolynomialTerm term = new PolynomialTerm(0, 3);
		assertEquals(0, term.getCoefficient());
		term = new PolynomialTerm(-2, 4);
		assertEquals(-2, term.getCoefficient());
	}

	@Test
	public void testGetExponent() {
		PolynomialTerm term = new PolynomialTerm(2, 4);
		assertEquals(4, term.getExponent());
	}
	
	@Test
	public void testAddCoefficient() {
		PolynomialTerm term = new PolynomialTerm(1, 3);
		term.addCoefficient(-1);
		assertEquals(0, term.getCoefficient());
		term.addCoefficient(-3);
		assertEquals(-3, term.getCoefficient());		
	}
}
