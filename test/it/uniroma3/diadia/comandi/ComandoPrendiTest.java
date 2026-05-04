package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

class ComandoPrendiTest {
	private ComandoPrendi prendi = new ComandoPrendi();
	private Partita prova = new Partita();
	private IO io = new IO() {
        @Override
        public void mostraMessaggio(String messaggio) {
            // non fa nulla
        }

        @Override
        public String leggiRiga() {
            return null;
        }
    };
	
	@Test
	void testPrendiOsso() {
		prendi.setParametro("osso");
		prendi.esegui(prova, io);
		assertTrue(prova.getGiocatore().getBorsa().hasAttrezzo("osso"));
		assertFalse(prova.getStanzaCorrente().hasAttrezzo("osso"));
	}
	
	@Test 
	void testPrendiNulla() {
		prendi.setParametro(null);
		prendi.esegui(prova, io);
		assertTrue(prova.getGiocatore().getBorsa().isEmpty());
	}
	
	@Test 
	void testPrendiCiao() {
		prendi.setParametro("ciao");
		prendi.esegui(prova, io);
		assertTrue(prova.getGiocatore().getBorsa().isEmpty());
	}

}
