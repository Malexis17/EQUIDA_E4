/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.Client;
import modele.Pays;

/**
 *
 * @author sio2
 */
public class PaysTest {
    public static void main(String[] args) {
        Pays unPays1 = new Pays();

        unPays1.setCode("FR");
        unPays1.setNom("FRANCE");
        
        Client unClient1 = new Client(1, "titre", "luc", "", "", "", "","", unPays1);
        Client unClient2 = new Client(2, "titre", "luc", "", "", "", "","", unPays1);
        Client unClient3 = new Client(3, "titre", "luc", "", "", "", "","", unPays1);
        
        unPays1.addClient(unClient1);
        unPays1.addClient(unClient2);
        unPays1.addClient(unClient3);
        
        System.out.println ("Le Pays à pour code " + unPays1.getCode() + ", son nom complet est " + unPays1.getNom());

        System.out.println("Dans le Pays il y a " + unPays1.getNbClient() + " Clients");
        
        for(int i = 0; i < unPays1.getLesClients().size(); i++){
    System.out.println("Il y a " + unPays1.getLesClients().get(i).getNom());
        } 

    }
        
}
