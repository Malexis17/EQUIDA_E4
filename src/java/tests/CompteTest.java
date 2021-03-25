/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.Compte;
import modele.Role;

/**
 *
 * @author Thibault
 */
public class CompteTest {
    public static void main(String[] args) {
        Role unRole = new Role("ADM","Administrateur");
        Compte unCompte = new Compte(1,"admin","mpadmin");
        unCompte.setUnRole(unRole);
        System.out.println("Le compte " + unCompte.getLogin() + " a pour role " + unCompte.getUnRole().getNom());
        

    }
}
