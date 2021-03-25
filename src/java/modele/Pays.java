/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author Zakina
 */
public class Pays {
    
    private String code ;
    private String nom;
    private ArrayList<Client> lesClients ;

    public Pays() {
    }

    public Pays(String code) {
        this.code = code;
    }

    public Pays(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Client> getLesClients() {
        return lesClients;
    }

    public void setLesClients(ArrayList<Client> lesClients) {
        this.lesClients = lesClients;
    }
    
    public void addClient(Client pUnClient){
        
        if (this.lesClients == null){
            this.lesClients = new ArrayList<Client>();                  
        }
         lesClients.add(pUnClient);
    }
    
    public int getNbClient(){
        return lesClients.size();
    }
}
    
   
