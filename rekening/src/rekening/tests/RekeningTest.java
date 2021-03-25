package rekening.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import rekening.Spaarrekening;
import rekening.Zichtrekening;

class RekeningTest {

	@Test
	void test() {
		Zichtrekening zichtrekening = new Zichtrekening(500.67);
		zichtrekening.storten(500);
		Zichtrekening zichtrekening2 = new Zichtrekening(500.67);
		zichtrekening2.storten(500);
		Zichtrekening zichtrekening3 = new Zichtrekening(500);
		zichtrekening3.storten(500);
		
		Spaarrekening spaarrekening = new Spaarrekening();
		
		assertEquals("balans: 500.0, kredietlimiet: 500.67", zichtrekening.toString());
		assertTrue(zichtrekening.equals(zichtrekening2));
		assertFalse(zichtrekening.equals(zichtrekening3));
		assertFalse(zichtrekening.equals(spaarrekening));
		assertFalse(spaarrekening.equals(zichtrekening));
		assertEquals("balans: 0.0", spaarrekening.toString());
		
		assertEquals(500, zichtrekening.getBalans());
		assertEquals(200, zichtrekening.afhalen(200));
		assertEquals(300, zichtrekening.getBalans());
		assertEquals(800.67, (zichtrekening.afhalen(1000)*100)/100);

	}

}
