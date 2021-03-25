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
public class Lot {
    private int id;
    private String prixdepart;
    private Cheval unCheval;
    private Vente uneVente;
    private ArrayList<Enchere> lesEncheres;

    public Lot() {
    }

    public Lot(int id, String prixdepart, Cheval unCheval, Vente uneVente) {
        this.id = id;
        this.prixdepart = prixdepart;
        this.unCheval = unCheval;
        this.uneVente = uneVente;
    }

    public int getId() {
        return id;
    }

    public String getPrixdepart() {
        return prixdepart;
    }

    public Cheval getUnCheval() {
        return unCheval;
    }

    public Vente getUneVente() {
        return uneVente;
    }

    public ArrayList<Enchere> getLesEncheres() {
        return lesEncheres;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrixdepart(String prixdepart) {
        this.prixdepart = prixdepart;
    }

    public void setUnCheval(Cheval unCheval) {
        this.unCheval = unCheval;
    }

    public void setUneVente(Vente uneVente) {
        this.uneVente = uneVente;
    }

    public void setLesEncheres(ArrayList<Enchere> lesEncheres) {
        this.lesEncheres = lesEncheres;
    }
    
    public void addUneEnchere(Enchere uneEnchere){
        if (lesEncheres == null){
            lesEncheres = new ArrayList<Enchere>();
        }
        lesEncheres.add(uneEnchere);
    }
    
    public int getNbEncheres(){
        return lesEncheres.size();
    }
}
