package junit.monprojet.test;

import junit.monprojet.SommeArgent;
import junit.monprojet.UniteDistincteException;

import static org.junit.jupiter.api.Assertions.*;

class SommeArgentTest {
    SommeArgent m12CHF;
    SommeArgent m14CHF;
    SommeArgent m14USD;
    int counter;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        m12CHF= new SommeArgent(12, "CHF");
        m14CHF= new SommeArgent(14, "CHF");
        m14USD= new SommeArgent(14, "USD");
        String passageAvantText = "éme passage avant execution d'une methode de test";
        System.out.println(++counter +passageAvantText);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        String passageAprestText = "éme passage APRES execution d'une methode de test";
        System.out.println(++counter +passageAprestText);
    }

    @org.junit.jupiter.api.Test
    void FirstTestCase() throws UniteDistincteException {
        SommeArgent expected = new SommeArgent(26, "CHF");
        SommeArgent result = m12CHF.add(m14CHF); // (2)
        assertTrue(expected.equals(result));
    }

    @org.junit.jupiter.api.Test
    void SecondTestCase() {
        assertTrue(!m12CHF.equals(null));
        assertEquals(m12CHF, new SommeArgent(12, "CHF"));
        assertTrue(!m12CHF.equals(m14CHF));
        assertEquals(m12CHF, m12CHF);
        assertTrue(!m14USD.equals(m14CHF));
    }

    @org.junit.jupiter.api.Test
    void CheckExceptionIsCaughtTest() throws UniteDistincteException {
        assertThrowsExactly(UniteDistincteException.class,() -> m12CHF.add(m14USD));
    }
}