package it.uniroma3.diadia.personaggi;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.Partita;

public class Mago extends AbstractPersonaggio {
	

	public Mago(String nome, String presentaz) {
		super(nome, presentaz);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		Attrezzo modificato = new Attrezzo(attrezzo.getNome(),attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(modificato);
		
		return "ti ho ridato l'attrezzo dimezzato di peso";
		
	}

	@Override
	public String agisci(Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

}
