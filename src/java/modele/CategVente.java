package modele;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zakina
 */
public class CategVente {
    private String code;
    private String libelle ;
    private ArrayList<Client> lesClients ;
    private ArrayList<Vente> lesVentes ;

    public CategVente() {
    }

    public CategVente(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<Client> getLesClients() {
        return lesClients;
    }

    public void setLesClients(ArrayList<Client> lesClients) {
        this.lesClients = lesClients;
    }

    public ArrayList<Vente> getLesVentes() {
        return lesVentes;
    }

    public void setLesVentes(ArrayList<Vente> lesVentes) {
        this.lesVentes = lesVentes;
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
    
    public void addVente(Vente pUneVente){
        
        if (this.lesVentes == null){
            this.lesVentes = new ArrayList<Vente>();                  
        }
         lesVentes.add(pUneVente);
    }
    
    public int getNbVente(){
        return lesVentes.size();
    }
    
    
    
}
