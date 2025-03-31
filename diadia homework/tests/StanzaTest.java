import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;

class StanzaTest {

    private Stanza biblioteca;
    private Stanza cucina;

    @BeforeEach
    void setUp() {
        biblioteca = new Stanza("Biblioteca");
        cucina = new Stanza("Cucina");
    }

    @Test
    void testNomeStanza() {
        assertEquals("Biblioteca", biblioteca.getNome(), "Il nome della stanza dovrebbe essere Biblioteca");
    }

    @Test
    void testAggiungiAdiacenza() {
        biblioteca.impostaStanzaAdiacente("nord", cucina);
        assertEquals(cucina, biblioteca.getStanzaAdiacente("nord"), "La stanza a nord dovrebbe essere Cucina");
    }

    @Test
    void testStanzaAdiacenteNonEsistente() {
        assertNull(biblioteca.getStanzaAdiacente("sud"), "Non dovrebbe esserci una stanza a sud");
    }
}
