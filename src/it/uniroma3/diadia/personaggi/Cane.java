package it.uniroma3.diadia.personaggi;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.Partita;

public class Cane extends AbstractPersonaggio{
	private Attrezzo ciboPreferito;
	private Attrezzo regalo;
	
	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {

	    if(attrezzo.getNome().equals(this.ciboPreferito)) {

	        if(this.regalo != null) {
	            partita.getStanzaCorrente().addAttrezzo(this.regalo);
	            this.regalo = null;
	        }

	        return "Il cane accetta il regalo e lascia cadere un attrezzo.";
	    }

	    partita.getGiocatore().setCfu(
	            partita.getGiocatore().getCfu() - 1);

	    return "Il cane ti morde!";
	}
	@Override
	public String agisci(Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

}
