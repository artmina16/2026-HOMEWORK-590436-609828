package it.uniroma3.ambienti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class CaricatoreLabirinto {

    private BufferedReader reader;
    private LabirintoBuilder builder;

    public CaricatoreLabirinto(Reader reader) {
        this.reader = new BufferedReader(reader);
        this.builder = new LabirintoBuilder();
    }

    public Labirinto carica() throws IOException {
        String linea;

        while ((linea = this.reader.readLine()) != null) {
            if (linea.equals("Stanze:")) {
                leggiStanze();
            } else if (linea.equals("Estremi:")) {
                leggiEstremi();
            } else if (linea.equals("Attrezzi:")) {
                leggiAttrezzi();
            } else if (linea.equals("Uscite:")) {
                leggiUscite();
            }
        }

        return this.builder.getLabirinto();
    }

    private void leggiStanze() throws IOException {
        String linea;

        while ((linea = reader.readLine()) != null && !linea.endsWith(":")) {
            builder.addStanza(linea);
        }
    }

    private void leggiEstremi() throws IOException {
        String iniziale = reader.readLine();
        String vincente = reader.readLine();

        builder.addStanzaIniziale(iniziale);
        builder.addStanzaVincente(vincente);
    }

    private void leggiAttrezzi() throws IOException {
        String linea;

        while ((linea = reader.readLine()) != null && !linea.endsWith(":")) {
            String[] pezzi = linea.split(" ");
            String nome = pezzi[0];
            int peso = Integer.parseInt(pezzi[1]);
            String nomeStanza = pezzi[2];

            builder.addStanza(nomeStanza);
            builder.addAttrezzo(nome, peso);
        }
    }

    private void leggiUscite() throws IOException {
        String linea;

        while ((linea = reader.readLine()) != null && !linea.endsWith(":")) {
            String[] pezzi = linea.split(" ");
            String partenza = pezzi[0];
            String direzione = pezzi[1];
            String arrivo = pezzi[2];

            builder.addAdiacenza(partenza, arrivo, direzione);
        }
    }
}