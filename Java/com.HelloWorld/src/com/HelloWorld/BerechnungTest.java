package com.HelloWorld;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BerechnungTest {
	private Berechnung berObjekt;

	@BeforeEach
	public void init() {
		berObjekt = new Berechnung();
	}

	@Test
	void testZahl_01() {
		int result = berObjekt.zahl(1, 1);
		assertEquals(0, result);

	}

	@Test
	void testZahl_02() {
		int result = berObjekt.zahl(2, 1);
		assertEquals(1, result);
	}

	Berechnung b = new Berechnung();

	@Test
	void testXGroesserY() {
		// x=5, y=3 -> e=2 -> z=1+2=3
		assertEquals(3, berObjekt.zahl(5, 3));
	}

	@Test
	void testXGleichY() {
		// x=4, y=4 -> e=0 -> return 0
		assertEquals(0, berObjekt.zahl(4, 4));
	}
	
}
