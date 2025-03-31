package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
    private int cfu;
    private Borsa borsa;

    // Costruttore del Giocatore, inizializza CFU e la borsa
    public Giocatore() {
        this.cfu = 20; // Imposta i CFU iniziali a 20
        this.borsa = new Borsa(); // Inizializza la borsa
    }

    // Metodo per ottenere i CFU
    public int getCfu() {
        return cfu;
    }

    // Metodo per diminuire i CFU
    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    // Aggiungi un attrezzo alla borsa
    public void aggiungiAttrezzo(Attrezzo attrezzo) {
        borsa.aggiungiAttrezzo(attrezzo);
    }

    // Rimuovi un attrezzo dalla borsa
    public boolean rimuoviAttrezzo(Attrezzo attrezzo) {
        return borsa.rimuoviAttrezzo(attrezzo);
    }

    // Restituisci la borsa del giocatore
    public Borsa getBorsa() {
        return borsa;
    }

    // Metodo per usare un attrezzo (in questo caso, ridurre i CFU)
    public void usaAttrezzo(Attrezzo attrezzo) {
        if (borsa.contenuto().contains(attrezzo)) {
            this.cfu -= attrezzo.getPeso();
            rimuoviAttrezzo(attrezzo);
        }
    }
}
