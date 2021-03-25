/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.CategVente;
import modele.Courriel;
import modele.Lieu;
import modele.PieceJointe;
import modele.Vente;

/**
 *
 * @author sio2
 */
public class CourrielTest {
    
    public static void main(String[] args) {
    
        Courriel unCourriel1 = new Courriel();
        
        Lieu unLieu1 = new Lieu(1, "", 8, "");
        
        CategVente uneCategVente1 = new CategVente("","");
        
        Vente uneVente1 = new Vente(1, "", "", unLieu1, uneCategVente1);
        
        unCourriel1.setId(542);
        unCourriel1.setDate("09/09/2020");
        unCourriel1.setObjet("TestObjet");
        unCourriel1.setCorps("TestCorps");
        unCourriel1.setUneVente(uneVente1);
        
 
        PieceJointe unePieceJointe1 = new PieceJointe(12, "chemintest", "desctest");
        
        unCourriel1.addUnePieceJointe(unePieceJointe1);
        
        System.out.println ("Le courriel à pour id " + unCourriel1.getId() + ", il date du " + unCourriel1.getDate() + " , à pour objet " + unCourriel1.getObjet() + "et pour corps "  + unCourriel1.getCorps() + " . Il informe de la vente " + unCourriel1.getUneVente());
    
        System.out.println("Le courriels à " + unCourriel1.getNbPiecesJointes() + " pieces jointes");
    
        for(int i = 0; i < unCourriel1.getLesPiecesJointes().size(); i++){
    System.out.println("Il y a la piece jointes numero " + unCourriel1.getLesPiecesJointes().get(i).getId());
        }
    }
    
}