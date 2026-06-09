package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IO;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda","regala"};
	@Override
	public void esegui(Partita partita, IO io) {
		// TODO Auto-generated method stub
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");

	}

	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "aiuto";
		
	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
		
	}

}
