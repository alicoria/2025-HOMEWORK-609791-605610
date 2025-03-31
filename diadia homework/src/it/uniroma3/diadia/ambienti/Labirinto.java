package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
    private Stanza stanzaIniziale;
    private Stanza stanzaFinale;

    public Labirinto() {
        creaStanze();
    }

    // Metodo che crea le stanze e le collega
    private void creaStanze() {
        /* Crea gli attrezzi */
        Attrezzo lanterna = new Attrezzo("lanterna", 3);
        Attrezzo osso = new Attrezzo("osso", 1);
        Attrezzo chiave = new Attrezzo("chiave", 2);

        /* Crea le stanze del labirinto */
        Stanza atrio = new Stanza("Atrio");
        Stanza aulaN11 = new Stanza("Aula N11");
        Stanza aulaN10 = new Stanza("Aula N10");
        Stanza laboratorio = new Stanza("Laboratorio Campus");
        Stanza biblioteca = new Stanza("Biblioteca");

        /* Collega le stanze tra loro */
        atrio.impostaStanzaAdiacente("nord", biblioteca);
        atrio.impostaStanzaAdiacente("est", aulaN11);
        atrio.impostaStanzaAdiacente("sud", aulaN10);
        aulaN11.impostaStanzaAdiacente("est", laboratorio);
        aulaN11.impostaStanzaAdiacente("ovest", atrio);
        aulaN10.impostaStanzaAdiacente("nord", atrio);
        aulaN10.impostaStanzaAdiacente("est", aulaN11);
        aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
        laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
        biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* Posiziona gli attrezzi nelle stanze */
        aulaN10.addAttrezzo(lanterna);
        atrio.addAttrezzo(osso);
        biblioteca.addAttrezzo(chiave);

        /* Imposta la stanza iniziale e finale */
        this.stanzaIniziale = atrio;
        this.stanzaFinale = biblioteca;
    }

    // Metodo per ottenere la stanza iniziale
    public Stanza getStanzaIniziale() {
        return this.stanzaIniziale;
    }

    // Metodo per ottenere la stanza finale
    public Stanza getStanzaFinale() {
        return this.stanzaFinale;
    }
}