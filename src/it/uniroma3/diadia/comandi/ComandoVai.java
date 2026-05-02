package it.uniroma3.diadia.comandi;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoVai implements Comando {
	private String direzione;

	/**
	* esecuzione del comando
	*/
	@Override
	public void esegui(Partita partita, IO io) {
	 Stanza stanzaCorrente = partita.getStanzaCorrente();
	 Stanza prossimaStanza = null;
	 if(this.direzione==null) {
		 io.mostraMessaggio("Dove vuoi andare?");
		 io.mostraMessaggio("Devi specificare una direzione");
		 return;
	 }
	 prossimaStanza= stanzaCorrente.getStanzaAdiacente(this.direzione);
	 if(prossimaStanza==null) {
		 io.mostraMessaggio("Direzione inesistente");
		 return;
	 }
	 partita.setStanzaCorrente(prossimaStanza);
	 io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	 partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;		
	}

	@Override
	public String getNome() {
		return "vai";		
	}

	@Override
	public String getParametro() {
		return this.direzione;	
	}
}