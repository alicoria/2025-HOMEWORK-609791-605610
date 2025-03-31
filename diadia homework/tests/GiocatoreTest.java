import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;


public class GiocatoreTest {

    private Giocatore giocatore;
    private Attrezzo lanterna;

    @BeforeEach
    void setUp() {
        giocatore = new Giocatore();
        lanterna = new Attrezzo("lanterna", 3);  // Creiamo un attrezzo
    }

    @Test
    void testCfuIniziali() {
        assertEquals(20, giocatore.getCfu(), "Il giocatore dovrebbe iniziare con 20 CFU");
    }

    @Test
    void testAggiungiAttrezzo() {
        giocatore.aggiungiAttrezzo(lanterna);
        assertTrue(giocatore.getBorsa().contieneAttrezzo("lanterna"), "La borsa dovrebbe contenere la lanterna");
    }

    @Test
    void testUsaAttrezzo() {
        giocatore.aggiungiAttrezzo(lanterna);
        giocatore.usaAttrezzo(lanterna);
        assertEquals(17, giocatore.getCfu(), "I CFU dovrebbero diminuire di 3 dopo l'uso della lanterna");
        assertFalse(giocatore.getBorsa().contieneAttrezzo("lanterna"), "La borsa non dovrebbe contenere più la lanterna");
    }
}
