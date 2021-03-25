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
public class PieceJointeTest {
    
    public static void main(String[] args) {
    
        PieceJointe unePieceJointe1 = new PieceJointe();
        
       
        
        unePieceJointe1.setId(542);
        unePieceJointe1.setChemin("chemintest");
        unePieceJointe1.setDescription("descriptiontest");
        
        Lieu unLieu1 = new Lieu(1, "", 9, "");
        
        CategVente uneCategVente1 = new CategVente("","");
        
        Vente uneVente1 = new Vente(1, "", "", unLieu1, uneCategVente1);
 
        Courriel unCourriel1 = new Courriel(12, "date", "objet", "corps", uneVente1);
        
        unePieceJointe1.addUnCourriel(unCourriel1);
        
        System.out.println ("La piece jointe à pour id " + unePieceJointe1.getId() + ", son chemin est " + unePieceJointe1.getChemin() + " et sa description est " + unePieceJointe1.getDescription());
    
        System.out.println("La piece jointes est présente dans " + unePieceJointe1.getNbCourriels() + " courriels");
    
        for(int i = 0; i < unePieceJointe1.getLesCourriels().size(); i++){
    System.out.println("Elle est présente dans le courriel numéro " + unePieceJointe1.getLesCourriels().get(i).getId());
        }
    }
    
}
