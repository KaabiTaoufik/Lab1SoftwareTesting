package junit.monprojet.test;

import junit.monprojet.PorteMonnaie;
import junit.monprojet.SommeArgent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PorteMonnaieTest {
    SommeArgent m12CHF;
    SommeArgent m14CHF;
    SommeArgent m14USD;
    @BeforeEach
    void setUp() {
        m12CHF= new SommeArgent(12, "CHF");
        m14CHF= new SommeArgent(14, "CHF");
        m14USD= new SommeArgent(14, "USD");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void TestAddingMoney(){
        PorteMonnaie porteMonnaie = new PorteMonnaie();
        PorteMonnaie porteMonnaie2 = new PorteMonnaie();
        porteMonnaie.ajouteSomme(m14CHF);
        porteMonnaie2.ajouteSomme(m14CHF);
        System.out.println(porteMonnaie.toString());
        porteMonnaie.ajouteSomme(m14CHF);
        porteMonnaie2.ajouteSomme(m14CHF);
        System.out.println(porteMonnaie.toString());
        porteMonnaie.ajouteSomme(m14USD);
        porteMonnaie2.ajouteSomme(m14USD);
        System.out.println(porteMonnaie.toString());
        assertTrue(porteMonnaie.equals(porteMonnaie2));
    }
}