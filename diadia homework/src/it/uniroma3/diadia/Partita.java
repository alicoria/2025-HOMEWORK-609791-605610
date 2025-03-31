package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class Partita {
    private Stanza stanzaCorrente;
    private Labirinto labirinto;
    private Giocatore giocatore;

    public Partita() {
        this.labirinto = new Labirinto();
        this.stanzaCorrente = this.labirinto.getStanzaIniziale();
        this.giocatore = new Giocatore();
    }

    public boolean isFinita() {
        return this.vinta() || this.giocatore.getCfu() <= 0;
    }

    public boolean vinta() {
        return this.stanzaCorrente.getNome().trim().equalsIgnoreCase("Biblioteca");
    }

    public Stanza getStanzaCorrente() {
        return this.stanzaCorrente;
    }

    public void setStanzaCorrente(Stanza stanzaCorrente) {
        this.stanzaCorrente = stanzaCorrente;
    }

    public int getCfu() {
        return this.giocatore.getCfu();
    }

    public void setCfu(int cfu) {
        this.giocatore.setCfu(cfu);
    }

    public Giocatore getGiocatore() {
        return this.giocatore;
    }

    public Labirinto getLabirinto() {
        return this.labirinto;
    }
}