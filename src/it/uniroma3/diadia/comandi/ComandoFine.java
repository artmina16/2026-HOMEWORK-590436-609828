package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {

	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
	}

	

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "fine";		
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;		
	}

}
