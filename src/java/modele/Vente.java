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
public class Vente {
    private int id;
    private String nom;
    private String dateDebutVente;
    private Lieu unLieu ;
    private CategVente uneCategVente;
    private ArrayList<Courriel> lesCourriels ;

    public Vente() {
    }

    public Vente(int id, String nom, String dateDebutVente, Lieu unLieu, CategVente uneCategVente) {
        this.id = id;
        this.nom = nom;
        this.dateDebutVente = dateDebutVente;
        this.unLieu = unLieu;
        this.uneCategVente = uneCategVente;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDateDebutVente() {
        return dateDebutVente;
    }

    public Lieu getUnLieu() {
        return unLieu;
    }

    public CategVente getUneCategVente() {
        return uneCategVente;
    }

    public ArrayList<Courriel> getLesCourriels() {
        return lesCourriels;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateDebutVente(String dateDebutVente) {
        this.dateDebutVente = dateDebutVente;
    }

    public void setUnLieu(Lieu unLieu) {
        this.unLieu = unLieu;
    }

    public void setUneCategVente(CategVente uneCategVente) {
        this.uneCategVente = uneCategVente;
    }

    public void setLesCourriels(ArrayList<Courriel> lesCourriels) {
        this.lesCourriels = lesCourriels;
    }

    public void addUnCourriel(Courriel unCourriel){
        if (lesCourriels == null){
            lesCourriels = new ArrayList<Courriel>();
        }
        lesCourriels.add(unCourriel);
    }
    
    public int getNbCourriel(){
        return lesCourriels.size();
    }
    
    
    
}
