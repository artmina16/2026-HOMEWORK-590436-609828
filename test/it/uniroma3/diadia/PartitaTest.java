package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;

public class PartitaTest {
	private Partita partita = new Partita();		
	
	@Test
	public void testIsFinitaCfuZero() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testIsFinitaStanzaVincenteTrovata() {
		Stanza biblioteca = this.partita.getLabirinto().getStanzaVincente();
		this.partita.setStanzaCorrente(biblioteca);
		assertTrue(this.partita.isFinita());
	}
	
	@Test
	public void testIsFinita() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

}
