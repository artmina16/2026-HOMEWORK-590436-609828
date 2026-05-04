package it.uniroma3.diadia.comandi;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	@Override
	public void esegui(Partita partita, IO io) {
		if(this.nomeAttrezzo==null) {
			io.mostraMessaggio("Quale attrezzo vuoi posare ?");
			return;
		}
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(this.nomeAttrezzo)) {
			io.mostraMessaggio("Attrezzo non trovato");
			return;
		}else {
		Attrezzo attrezzoDaPosare = partita.getGiocatore().getBorsa().getAttrezzo(this.nomeAttrezzo);
		partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);	
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		io.mostraMessaggio("Attrezzo posato nella stanza");
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getNome() {
		return "posa";		
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;		
	}
}
