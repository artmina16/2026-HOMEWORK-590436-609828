package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

class ComandoVaiTest {
	private ComandoVai vai = new ComandoVai();
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
	void testEseguiDirezioneNulla() {
		Stanza iniziale = this.prova.getStanzaCorrente();
		this.vai.setParametro(null);
		this.vai.esegui(prova, io);
		assertEquals(this.prova.getStanzaCorrente(),iniziale);
	}
	
	@Test
	void testEseguiDirezioneGiusta() {
		this.vai.setParametro("nord");
		this.vai.esegui(prova, io);
		assertEquals(this.prova.getStanzaCorrente().getNome(),"Biblioteca");
	}
	
	@Test
	void testDirezioneInesistente() {
		Stanza iniziale = this.prova.getStanzaCorrente();
		this.vai.setParametro("ciao");
		this.vai.esegui(prova, io);
		assertEquals(this.prova.getStanzaCorrente(),iniziale);
	}

}
