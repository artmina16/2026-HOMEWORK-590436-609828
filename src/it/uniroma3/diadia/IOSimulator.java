package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {

    private List<String> righeDaLeggere;
    private List<String> messaggiMostrati;

    private int indiceLettura;

    public IOSimulator(List<String> righeDaLeggere) {
        this.righeDaLeggere = righeDaLeggere;
        this.messaggiMostrati = new ArrayList<>();

        this.indiceLettura = 0;
    }

    @Override
    public String leggiRiga() {
        if (this.indiceLettura < this.righeDaLeggere.size()) {
            String riga = this.righeDaLeggere.get(indiceLettura);
            this.indiceLettura++;
            return riga;
        }
        return null;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        this.messaggiMostrati.add(messaggio);
        
    }

    public List<String> getMessaggiMostrati() {
        return this.messaggiMostrati;
    }

    public String getMessaggioMostrato(int indice) {
        return this.messaggiMostrati.get(indice);
    }

    public int getNumeroMessaggiMostrati() {
        return this.messaggiMostrati.size();
    }
}