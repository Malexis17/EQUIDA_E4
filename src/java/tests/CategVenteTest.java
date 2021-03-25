/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.CategVente;
import modele.Client;
import modele.Lieu;
import modele.Pays;
import modele.Vente;

/**
 *
 * @author sio2
 */
public class CategVenteTest {
    
    public static void main(String[] args) {
        CategVente uneCategVente1 = new CategVente("E12", "Vente d'été");
    
        System.out.println ("La catégorie de vente à pour code " + uneCategVente1.getCode() + ", son nom complet est " + uneCategVente1.getLibelle());
        
        Pays unPays1 = new Pays();
        unPays1.setCode("FR");
        unPays1.setNom("FRANCE");
        
        Client unClient1 = new Client(1, "titre", "Chien", "Théodule", "17 rue de la place", "14000", "Caen","théodule.chien@gmail.com", unPays1);
        Client unClient2 = new Client(2, "titre", "Chien", "Théodule", "17 rue de la place", "14000", "Caen","théodule.chien@gmail.com", unPays1);
        Client unClient3 = new Client(3, "titre", "Chien", "Théodule", "17 rue de la place", "14000", "Caen","théodule.chien@gmail.com", unPays1);

        uneCategVente1.addClient(unClient1);
        uneCategVente1.addClient(unClient1);
        uneCategVente1.addClient(unClient1);
        
        System.out.println("Il y a " + uneCategVente1.getNbClient() + " personne intéressés.");
        
        for(int i = 0; i < uneCategVente1.getLesClients().size(); i++){
    System.out.println("Il y a " + uneCategVente1.getLesClients().get(i).getNom());
        }
        
        Lieu UnLieu1 = new Lieu(1, "", 7, "");
                
        Vente uneVente1 = new Vente(1, "Jelly Bay", "", UnLieu1, uneCategVente1);
        Vente uneVente2 = new Vente(2, "Mixing Brain", "", UnLieu1, uneCategVente1);
        Vente uneVente3 = new Vente(3, "Rapsberry Sailing", "", UnLieu1, uneCategVente1);
        
        uneCategVente1.addVente(uneVente1);
        uneCategVente1.addVente(uneVente2);
        uneCategVente1.addVente(uneVente3);
        
        System.out.println("Il y a " + uneCategVente1.getNbVente() + " ventes prévues.");
        
        for(int i = 0; i < uneCategVente1.getLesVentes().size(); i++){
    System.out.println("Il y a " + uneCategVente1.getLesVentes().get(i).getNom());
        }
    
    }
    
}
