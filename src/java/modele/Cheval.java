/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author sio2
 */
public class Cheval {
    private int id;
    private String sire;
    private String nom;
    private String sexe;
    private String prixDepart;
    private String CheminPhoto;
    private TypeCheval unTypeCheval;
    private Cheval unPere;
    private Cheval uneMere;
    private Client unClient;
    private ArrayList<Lot> lesLots;
    
    

    public Cheval() {
    }

    public Cheval(int id) {
        this.id = id;
    }
    
    

    public Cheval(int id, String sire, String nom, String sexe, String prixDepart, String CheminPhoto, TypeCheval unTypeCheval, Cheval unPere, Cheval uneMere, Client unClient) {
        this.id = id;
        this.sire = sire;
        this.nom = nom;
        this.sexe = sexe;
        this.prixDepart = prixDepart;
        this.CheminPhoto = CheminPhoto;
        this.unTypeCheval = unTypeCheval;
        this.unPere = unPere;
        this.uneMere = uneMere;
        this.unClient = unClient;
    }

    public int getId() {
        return id;
    }

    public String getSire() {
        return sire;
    }

    public String getNom() {
        return nom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getPrixDepart() {
        return prixDepart;
    }

    public String getCheminPhoto() {
        return CheminPhoto;
    }

    public TypeCheval getUnTypeCheval() {
        return unTypeCheval;
    }

    public Cheval getUnPere() {
        return unPere;
    }

    public Cheval getUneMere() {
        return uneMere;
    }

    public Client getUnClient() {
        return unClient;
    }

    public ArrayList<Lot> getLesLots() {
        return lesLots;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSire(String sire) {
        this.sire = sire;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setPrixDepart(String prixDepart) {
        this.prixDepart = prixDepart;
    }

    public void setCheminPhoto(String CheminPhoto) {
        this.CheminPhoto = CheminPhoto;
    }

    public void setUnTypeCheval(TypeCheval unTypeCheval) {
        this.unTypeCheval = unTypeCheval;
    }

    public void setUnPere(Cheval unPere) {
        this.unPere = unPere;
    }

    public void setUneMere(Cheval uneMere) {
        this.uneMere = uneMere;
    }

    public void setUnClient(Client unClient) {
        this.unClient = unClient;
    }

    public void setLesLots(ArrayList<Lot> lesLots) {
        this.lesLots = lesLots;
    }

    
    
    

    
    
    public void addUnLot(Lot unLot){
        if (lesLots == null){
            lesLots = new ArrayList<Lot>();
        }
        lesLots.add(unLot);
    }
    
    public int getNbLots(){
        return lesLots.size();
    }
    
    
  
}
