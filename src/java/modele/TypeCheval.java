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
public class TypeCheval {
    private int id;
    private String libelle;
    private String description;
    private ArrayList<Vente> lesVentes;
    private ArrayList<Cheval> lesChevaux;

    public TypeCheval() {
    }

    public TypeCheval(int id) {
        this.id = id;
    }
    
    

    public TypeCheval(int id, String libelle, String description) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Vente> getLesVentes() {
        return lesVentes;
    }

    public ArrayList<Cheval> getLesChevaux() {
        return lesChevaux;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLesVentes(ArrayList<Vente> lesVentes) {
        this.lesVentes = lesVentes;
    }

    public void setLesChevaux(ArrayList<Cheval> lesChevaux) {
        this.lesChevaux = lesChevaux;
    }
    
    public void addUneVente(Vente uneVente){
        if (lesVentes == null){
            lesVentes = new ArrayList<Vente>();
        }
        lesVentes.add(uneVente);
    }
    
    public int getNbVentes(){
        return lesVentes.size();
    }
    
    public void addUnCheval(Cheval unCheval){
        if (lesChevaux == null){
            lesChevaux = new ArrayList<Cheval>();
        }
        lesChevaux.add(unCheval);
    }
    
    public int getNbChevaux(){
        return lesChevaux.size();
    }
    
}
