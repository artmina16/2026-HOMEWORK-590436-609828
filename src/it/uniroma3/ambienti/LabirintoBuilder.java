package it.uniroma3.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.attrezzi.Attrezzo;

public class LabirintoBuilder {

    private Labirinto labirinto;
    private Map<String, Stanza> nome2stanza;
    private Stanza ultimaStanzaAggiunta;

    public LabirintoBuilder() {
        this.labirinto = new Labirinto();
        this.nome2stanza = new HashMap<>();
    }

    public LabirintoBuilder addStanza(String nomeStanza) {
        Stanza stanza = this.getStanza(nomeStanza);
        this.ultimaStanzaAggiunta = stanza;
        return this;
    }

    public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
        Stanza stanza = this.getStanza(nomeStanza);

        this.labirinto.setStanzaIniziale(stanza);
        this.ultimaStanzaAggiunta = stanza;

        return this;
    }

    public LabirintoBuilder addStanzaVincente(String nomeStanza) {
        Stanza stanza = this.getStanza(nomeStanza);

        this.labirinto.setStanzaVincente(stanza);
        this.ultimaStanzaAggiunta = stanza;

        return this;
    }

    public LabirintoBuilder addAdiacenza(String nomeStanzaPartenza, String nomeStanzaArrivo, String direzione) {
        Stanza stanzaPartenza = this.getStanza(nomeStanzaPartenza);
        Stanza stanzaArrivo = this.getStanza(nomeStanzaArrivo);

        stanzaPartenza.impostaStanzaAdiacente(direzione, stanzaArrivo);

        return this;
    }

    public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
        if (this.ultimaStanzaAggiunta != null) {
            Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
            this.ultimaStanzaAggiunta.addAttrezzo(attrezzo);
        }

        return this;
    }

    public Labirinto getLabirinto() {
        return this.labirinto;
    }

    public Map<String, Stanza> getListaStanze() {
        return this.nome2stanza;
    }

    private Stanza getStanza(String nomeStanza) {
        Stanza stanza = this.nome2stanza.get(nomeStanza);

        if (stanza == null) {
            stanza = new Stanza(nomeStanza);
            this.nome2stanza.put(nomeStanza, stanza);
        }

        return stanza;
    }
}