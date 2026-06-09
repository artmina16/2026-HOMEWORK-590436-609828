package it.uniroma3.diadia.comandi;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPrendi extends AbstractComando {
	private String nomeAttrezzo;
	@Override
	public void esegui(Partita partita, IO io) {
		// TODO Auto-generated method stub
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("Quale attrezzo vuoi prendere ?");
			return;
		}
		if(!partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			io.mostraMessaggio("Attrezzo non trovato");
			return;
		}else {	
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
			io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		}

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "prendi";
		
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
		
	}

}
