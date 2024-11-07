import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListeSimpleTest {

    ListeSimple listeATester;

    @BeforeEach
    void init() {
        listeATester = new ListeSimple();
    }

    // Test de l'ajout
    @Test
    void ajoutAugmenteSize() {
        listeATester.ajout(1);
        assertEquals(1, listeATester.getSize());
    }

    // Test modifiePremier avec un élément existant
    @Test
    void modifiePremierExist() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.modifiePremier(1, 5);
        assertEquals("ListeSimple(Noeud(2), Noeud(5))", listeATester.toString());
    }

    // Test de modifieTous
    @Test
    void modifieTousTest() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.modifieTous(1, 3);
        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(3))", listeATester.toString());
    }

    // Test de supprimePremier
    @Test
    void supprimePremierEnTete() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(3);
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
    }

    @Test
    void supprimePremierEnMilieu() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(2);
        assertEquals("ListeSimple(Noeud(3), Noeud(1))", listeATester.toString());
    }

    @Test
    void supprimePremierElementAbsent() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.supprimePremier(3);  // Element absent
        assertEquals("ListeSimple(Noeud(2), Noeud(1))", listeATester.toString());
    }

    // Test de supprimeTousRecurs
    @Test
    void supprimeTousTestRecurs() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.supprimeTous(1);
        assertEquals("ListeSimple(Noeud(2))", listeATester.toString());
    }

    // Test d'inverser
    @Test
    void inverserListe() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.inverser();
        assertEquals("ListeSimple(Noeud(1), Noeud(2))", listeATester.toString());
    }

    // Test d'échanger deux noeuds
    @Test
    void echangerDeuxNoeuds() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        Noeud r1 = listeATester.tete;  // Noeud(3)
        Noeud r2 = listeATester.tete.getSuivant(); // Noeud(2)
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(2), Noeud(3), Noeud(1))", listeATester.toString());
    }

    @Test
    void echangerTeteEtAutreNoeud() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        Noeud r1 = listeATester.tete; // Noeud(3)
        Noeud r2 = listeATester.tete.getSuivant(); // Noeud(2)
        listeATester.echanger(r1, r2);
        assertEquals("ListeSimple(Noeud(2), Noeud(3), Noeud(1))", listeATester.toString());
    }

    // Test de getPrecedent
    @Test
    void testGetPrecedent() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        Noeud precedent = listeATester.getPrecedent(listeATester.tete.getSuivant()); // Noeud(2)
        assertEquals(1, precedent.getElement());  // Précédent de Noeud(2) doit être Noeud(1)
    }

    // Test de toString avec plusieurs éléments
    @Test
    void toStringDonneTousLesNoeuds() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        assertEquals("ListeSimple(Noeud(3), Noeud(2), Noeud(1))", listeATester.toString());
    }

    // Test d'une liste vide
    @Test
    void listeVide() {
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }
}
