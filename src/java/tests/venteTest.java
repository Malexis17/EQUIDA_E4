/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.Lieu;
import modele.Vente;

/**
 *
 * @author sio2
 */
public class venteTest {
    
    public static void main(String[] args) {
        
        Vente uneVente = new Vente();
        uneVente.setId(425);
        uneVente.setNom("Vente hiver");
        uneVente.setDateDebutVente("2020-07-17");
        
        Lieu unLieu = new Lieu(501,"Caen",15,"Ville sympathique");
        uneVente.setUnLieu(unLieu);
        
        System.out.println("La " + uneVente.getNom() + " se déroule à " + uneVente.getUnLieu().getVille());
       
    
    }
    
}
