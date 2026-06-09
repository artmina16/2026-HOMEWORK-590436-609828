package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public abstract class AbstractComando {
	
	
	public abstract void esegui(Partita partita, IO io);

	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

}
