package it.uniroma3.ambienti;

public class StanzaBloccata extends Stanza {
	private String stanzaBloccata;
	private String attrezzoSbloccante;
	public StanzaBloccata(String nome, String attrezzoSbloccante, String stanzaBloccata) {
		super(nome);
		this.attrezzoSbloccante = attrezzoSbloccante;
		this.stanzaBloccata = stanzaBloccata;
		
	}
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(this.stanzaBloccata) && !this.hasAttrezzo(attrezzoSbloccante)) {
			return this;
		}else {
			return super.getStanzaAdiacente(direzione);
		}
	}

}
