/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

//import modele.Lot;

import modele.Cheval;
import modele.Lot;


/**
 *
 * @author sio2
 */
public class lotTest {
    
           public static void main(String[] args) {
             
        Lot unLot= new Lot();
        unLot.setId(1001);
        unLot.setPrixdepart("45000€");    
             
        
        Cheval unCheval = new Cheval();
          unCheval.setId(1);
          unCheval.setNom("petit canasson");
          unCheval.setSire("4508.000.020Z");
          
          unLot.setUnCheval(unCheval);
          
          System.out.println("Le lot " + unLot.getId() + " a pour prix " + unLot.getPrixdepart() + " est correspond à " + unLot.getUnCheval().getNom());
          
          
         
          
       
          
       
       
       
       }
    
    
}
