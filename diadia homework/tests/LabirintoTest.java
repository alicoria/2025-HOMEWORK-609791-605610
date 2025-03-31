
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {
    private Labirinto labirinto;

    @BeforeEach
    void setUp() {
        labirinto = new Labirinto();
    }

    @Test
    void testStanzaIniziale() {
        assertNotNull(labirinto.getStanzaIniziale(), "La stanza iniziale non dovrebbe essere null");
        assertEquals("Atrio", labirinto.getStanzaIniziale().getNome(), "La stanza iniziale dovrebbe essere 'Atrio'");
    }

    @Test
    void testStanzaFinale() {
        assertNotNull(labirinto.getStanzaFinale(), "La stanza finale non dovrebbe essere null");
        assertEquals("Biblioteca", labirinto.getStanzaFinale().getNome(), "La stanza finale dovrebbe essere 'Biblioteca'");
    }

    @Test
    void testConnessioniStanze() {
        Stanza atrio = labirinto.getStanzaIniziale();
        Stanza biblioteca = labirinto.getStanzaFinale();
        
        assertEquals("Biblioteca", atrio.getStanzaAdiacente("nord").getNome(), "A nord dell'Atrio dovrebbe esserci la Biblioteca");
        assertEquals("Atrio", biblioteca.getStanzaAdiacente("sud").getNome(), "A sud della Biblioteca dovrebbe esserci l'Atrio");
    }
}
