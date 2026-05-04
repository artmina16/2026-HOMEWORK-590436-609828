package it.uniroma3.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.attrezzi.Attrezzo;

class StanzaBuiaTest {
	StanzaBuia cantina = new StanzaBuia("cantina", "lanterna");
	Attrezzo lanterna = new Attrezzo("lanterna", 2);
	
	@Test
	void testStanzaBuiaAncoraDaIlluminare() {
		assertEquals("Qui c'è buio pesto", cantina.getDescrizione());
	}
	
	@Test
	void testStanzaBuiaIlluminata() {
		this.cantina.addAttrezzo(lanterna);
		assertEquals(cantina.toString(), cantina.getDescrizione());
	}

}
