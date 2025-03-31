package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import IOConsole.IOConsole;

public class DiaDia {
    static final private String MESSAGGIO_BENVENUTO = "" +
            "Ti trovi nell'Università, ma oggi è diversa dal solito...\n" +
            "Meglio andare al più presto in biblioteca a studiare. Ma dov'è?\n" +
            "Ci sono attrezzi che potrebbero servirti nell'impresa.\n" +
            "Puoi raccoglierli, usarli o posarli.\n\n" +
            "Per conoscere i comandi usa 'aiuto'.";

    static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
    private Partita partita;
    private IOConsole io;

    public DiaDia(IOConsole io) {
        this.partita = new Partita();
        this.io = io;
    }

    public void gioca() {
        io.mostraMessaggio(MESSAGGIO_BENVENUTO);

        String istruzione;
        do {
            io.mostraMessaggio("> ");
            istruzione = io.leggiRiga();
        } while (!processaIstruzione(istruzione));
    }

    private boolean processaIstruzione(String istruzione) {
        Comando comandoDaEseguire = new Comando(istruzione);

        switch (comandoDaEseguire.getNome()) {
            case "fine":
                this.fine();
                return true;
            case "vai":
                this.vai(comandoDaEseguire.getParametro());
                break;
            case "aiuto":
                this.aiuto();
                break;
            case "prendi":
                this.prendi(comandoDaEseguire.getParametro());
                break;
            case "posa":
                this.posa(comandoDaEseguire.getParametro());
                break;
            default:
                io.mostraMessaggio("Comando sconosciuto.");
        }

        if (this.partita.isFinita()) {
            if (this.partita.vinta()) {
                io.mostraMessaggio("HAI VINTO!");
            } else {
                io.mostraMessaggio("Hai perso. CFU esauriti.");
            }
            return true;
        }

        return false;
    }

    private void aiuto() {
        io.mostraMessaggio("Comandi disponibili:");
        for (String comando : elencoComandi) {
            io.mostraMessaggio(comando + " ");
        }
    }

    private void vai(String direzione) {
        if (direzione == null) {
            io.mostraMessaggio("Dove vuoi andare?");
            return;
        }
        Stanza prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
        if (prossimaStanza == null) {
            io.mostraMessaggio("Direzione inesistente.");
        } else {
            this.partita.setStanzaCorrente(prossimaStanza);
            this.partita.setCfu(this.partita.getCfu() - 1);
        }
        io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
    }

    private void prendi(String nomeAttrezzo) {
        if (nomeAttrezzo == null) {
            io.mostraMessaggio("Quale attrezzo vuoi prendere?");
            return;
        }
        Stanza stanzaCorrente = this.partita.getStanzaCorrente();
        Borsa borsa = this.partita.getGiocatore().getBorsa();

        if (stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
            Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
            if (borsa.aggiungiAttrezzo(attrezzo)) {
                stanzaCorrente.removeAttrezzo(attrezzo);
                io.mostraMessaggio("Hai preso: " + nomeAttrezzo);
            } else {
                io.mostraMessaggio("Borsa piena!");
            }
        } else {
            io.mostraMessaggio("Attrezzo non presente nella stanza.");
        }
    }

    private void posa(String nomeAttrezzo) {
        if (nomeAttrezzo == null) {
            io.mostraMessaggio("Quale attrezzo vuoi posare?");
            return;
        }
        Borsa borsa = this.partita.getGiocatore().getBorsa();
        Stanza stanzaCorrente = this.partita.getStanzaCorrente();

        if (borsa.contieneAttrezzo(nomeAttrezzo)) {
            Attrezzo attrezzo = borsa.getAttrezzo(nomeAttrezzo);
            stanzaCorrente.addAttrezzo(attrezzo);
            borsa.rimuoviAttrezzo(attrezzo);
            io.mostraMessaggio("Hai posato: " + nomeAttrezzo);
        } else {
            io.mostraMessaggio("Non hai questo attrezzo nella borsa.");
        }
    }

    private void fine() {
        io.mostraMessaggio("Grazie per aver giocato!");
    }

    public static void main(String[] args) {
        IOConsole io = new IOConsole();
        DiaDia gioco = new DiaDia(io);
        gioco.gioca();
    }
}