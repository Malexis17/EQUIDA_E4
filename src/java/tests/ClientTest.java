/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modele.CategVente;
import modele.Client;
import modele.Pays;

/**
 *
 * @author Zakina
 */
public class ClientTest {
    
    public static void main(String[] args) {
        
        Pays unPays1 = new Pays();
        unPays1.setCode("FR");
        unPays1.setNom("FRANCE");
        
        Client unClient1 = new Client(1, "titre", "Chien", "Théodule", "17 rue de la place", "14000", "Caen","théodule.chien@gmail.com", unPays1);
          
        System.out.println ("Le client à pour nom " + unClient1.getNom() + ", son prénom est " + unClient1.getPrenom() + ". Son code postal est le " + unClient1.getCopos() + " et sa ville est "  + unClient1.getVille() + ". Il habite au " + unClient1.getRue() + " et son adresse mail est " +unClient1.getMail());

        System.out.println ("Le client habite en " + unClient1.getUnPays().getNom());
        
        CategVente uneCategVente1 = new CategVente("A32","Vente Mixte Février");
        CategVente uneCategVente2 = new CategVente("A45","Vente Mixte Mars");
        CategVente uneCategVente3 = new CategVente("E12","Vente d'été");
        
        unClient1.addUneCategVente(uneCategVente1);
        unClient1.addUneCategVente(uneCategVente2);
        unClient1.addUneCategVente(uneCategVente3);
        
        System.out.println("Le client est intéressé par " + unClient1.getNbCategVente() + " Catégories de ventes");
        
        for(int i = 0; i < unClient1.getLesCategVentes().size(); i++){
    System.out.println("Il est intéressé par " + unClient1.getLesCategVentes().get(i).getLibelle());
        }
    }
    
}
