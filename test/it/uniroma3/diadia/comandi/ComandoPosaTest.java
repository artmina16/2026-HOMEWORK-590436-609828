package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

class ComandoPosaTest {
	private ComandoVai vai = new ComandoVai();
	private ComandoPrendi prendi = new ComandoPrendi();
	private ComandoPosa posa = new ComandoPosa();
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
	void testPosaLanterna() {
		vai.setParametro("sud");
		vai.esegui(prova, io);
		prendi.setParametro("lanterna");
		prendi.esegui(prova, io);
	    vai.setParametro("ovest");
	    vai.esegui(prova, io);
		posa.setParametro("lanterna");
		posa.esegui(prova, io);
		assertTrue(prova.getStanzaCorrente().hasAttrezzo("lanterna"));
	}
	
	@Test
	void testPosaNulla() {
		posa.setParametro("ciao");
		posa.esegui(prova, io);
		assertFalse(prova.getStanzaCorrente().hasAttrezzo("ciao"));
	}

}
