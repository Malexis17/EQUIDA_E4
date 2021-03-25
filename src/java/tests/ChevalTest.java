/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.Cheval;
import modele.TypeCheval;

/**
 *
 * @author sio2
 */
public class ChevalTest {
       public static void main(String[] args) {
       
       
          Cheval unCheval = new Cheval();
          unCheval.setId(1);
          unCheval.setNom("petit canasson");
          unCheval.setSire("4508.000.020Z");
          
          TypeCheval unTypCheval = new TypeCheval(455,"pure sang","Parent anglais");
          
          unCheval.setUnTypeCheval(unTypCheval);
          
         
          
          System.out.println(unCheval.getId() + " " + unCheval.getNom() + " " + unCheval.getSire() + " est un " + unCheval.getUnTypeCheval().getLibelle());
       
       
       
       }
    
}
