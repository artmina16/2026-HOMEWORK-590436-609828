package it.uniroma3.diadia;

public class IOSimulator implements IO {

    private String[] righeDaLeggere;
    private String[] messaggiMostrati;

    private int indiceLettura;
    private int indiceMessaggi;

    public IOSimulator(String[] righeDaLeggere) {
        this.righeDaLeggere = righeDaLeggere;
        this.messaggiMostrati = new String[100];

        this.indiceLettura = 0;
        this.indiceMessaggi = 0;
    }

    @Override
    public String leggiRiga() {
        if (this.indiceLettura < this.righeDaLeggere.length) {
            String riga = this.righeDaLeggere[this.indiceLettura];
            this.indiceLettura++;
            return riga;
        }
        return null;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        if (this.indiceMessaggi < this.messaggiMostrati.length) {
            this.messaggiMostrati[this.indiceMessaggi] = messaggio;
            this.indiceMessaggi++;
        }
    }

    public String[] getMessaggiMostrati() {
        return this.messaggiMostrati;
    }

    public String getMessaggioMostrato(int indice) {
        return this.messaggiMostrati[indice];
    }

    public int getNumeroMessaggiMostrati() {
        return this.indiceMessaggi;
    }
}