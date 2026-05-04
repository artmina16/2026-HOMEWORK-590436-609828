package it.uniroma3.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.attrezzi.Attrezzo;

class StanzaBloccataTest {
	private Stanza soggiorno = new Stanza("soggiorno");
	private StanzaBloccata cantina = new StanzaBloccata("cantina", "chiave", "nord");
	private Attrezzo chiave = new Attrezzo("chiave", 0);
	
	@Test
	void testGetStanzaAdiacenteBloccata() {
		this.cantina.impostaStanzaAdiacente("nord", soggiorno);
		assertEquals(this.cantina.getStanzaAdiacente("nord"), cantina);
	}
	
	@Test
	void testGetStanzaAdiacenteSbloccata() {
		this.cantina.impostaStanzaAdiacente("nord", soggiorno);
		this.cantina.addAttrezzo(chiave);
		assertEquals(this.cantina.getStanzaAdiacente("nord"), soggiorno);
	}
	//eventualmente, da rivedere
}
