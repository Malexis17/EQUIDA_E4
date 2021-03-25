/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.Lieu;

/**
 *
 * @author sio2
 */
public class lieuTest {
    
    public static void main(String[] args) {
    
   Lieu unLieu = new Lieu(501,"Caen", 15,"Ville sympatique");
   System.out.println(unLieu.getId() + " " + unLieu.getVille() + " " + unLieu.getNbBoxes() + " " + unLieu.getCommentaires());
   
   
    }
   
   
}
