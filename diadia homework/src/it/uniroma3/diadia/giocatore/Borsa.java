package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
    private List<Attrezzo> attrezzi;

    public Borsa() {
        this.attrezzi = new ArrayList<>();
    }
    private int capacita=10;

    public boolean aggiungiAttrezzo(Attrezzo attrezzo) {
        if (this.attrezzi.size() < this.capacita) { // Supponendo che ci sia un limite di capacità
            this.attrezzi.add(attrezzo);
            return true;  // Indica che l'aggiunta è andata a buon fine
        }
        return false;  // Indica che la borsa è piena
    }

    public boolean rimuoviAttrezzo(Attrezzo attrezzo) {
        return this.attrezzi.remove(attrezzo);
    }

    public boolean contieneAttrezzo(String nomeAttrezzo) {
        for (Attrezzo attrezzo : attrezzi) {
            if (attrezzo.getNome().equalsIgnoreCase(nomeAttrezzo)) {
                return true;
            }
        }
        return false;
    }

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        for (Attrezzo attrezzo : attrezzi) {
            if (attrezzo.getNome().equalsIgnoreCase(nomeAttrezzo)) {
                return attrezzo;
            }
        }
        return null;
    }

    public List<Attrezzo> contenuto() {
        return new ArrayList<>(this.attrezzi);
    }
}