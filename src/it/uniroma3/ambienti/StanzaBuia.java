package it.uniroma3.ambienti;

public class StanzaBuia extends Stanza {
	private String attrezzoCheIllumina;
	
	public StanzaBuia(String nome, String attrezzoCheIllumina) {
	    super(nome);
	    this.attrezzoCheIllumina = attrezzoCheIllumina;
	}
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoCheIllumina)) {
			return super.getDescrizione();
		}else {
			return "Qui c'è buio pesto";
		}
	}

}
