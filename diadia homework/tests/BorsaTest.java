import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import java.util.List;

class BorsaTest {
    private Borsa borsa;
    private Attrezzo martello;
    private Attrezzo chiave;
   

    @BeforeEach
    void setUp() {
        borsa = new Borsa();
        martello = new Attrezzo("Martello", 2);
        chiave = new Attrezzo("Chiave", 1);
    }

    @Test
    void testAggiuntaAttrezzo() {
        borsa.aggiungiAttrezzo(martello);
        assertTrue(borsa.contenuto().contains(martello), "La borsa dovrebbe contenere il Martello");
    }

    @Test
    void testRimozioneAttrezzo() {
        borsa.aggiungiAttrezzo(chiave);
        assertTrue(borsa.rimuoviAttrezzo(chiave), "La rimozione della Chiave dovrebbe avere successo");
        assertFalse(borsa.contenuto().contains(chiave), "La borsa non dovrebbe più contenere la Chiave");
    }

    @Test
    void testContieneAttrezzo() {
        borsa.aggiungiAttrezzo(martello);
        assertTrue(borsa.contieneAttrezzo("Martello"), "La borsa dovrebbe contenere il Martello");
        assertFalse(borsa.contieneAttrezzo("Spada"), "La borsa non dovrebbe contenere la Spada");
    }

    
    @Test
    void testContenutoDellaBorsa() {
        borsa.aggiungiAttrezzo(martello);
        borsa.aggiungiAttrezzo(chiave);
        List<Attrezzo> attrezzi = borsa.contenuto();
        assertEquals(2, attrezzi.size(), "La borsa dovrebbe contenere esattamente 2 attrezzi");
    }
}