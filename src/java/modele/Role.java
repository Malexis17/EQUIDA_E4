/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author Thibault
 */
public class Role {
    private String code ;
    private String nom;
    private ArrayList<Permission> lesPermissions ;
    private ArrayList<Compte> lesComptes ;
    
    public Role(){
  
    }

    public Role(String code, String nom) {
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

    public ArrayList<Permission> getLesPermissions() {
        return lesPermissions;
    }

    public void setLesPermissions(ArrayList<Permission> lesPermissions) {
        this.lesPermissions = lesPermissions;
    }
    
    public void addPermission(Permission UnePermission){
        
        if (this.lesPermissions == null){
            this.lesPermissions = new ArrayList<Permission>();                  
        }
         lesPermissions.add(UnePermission);
    }

    public ArrayList<Compte> getLesComptes() {
        return lesComptes;
    }

    public void setLesComptes(ArrayList<Compte> lesComptes) {
        this.lesComptes = lesComptes;
    }
    
    public void addCompte(Compte UnCompte){
        
        if (this.lesComptes == null){
            this.lesComptes = new ArrayList<Compte>();                  
        }
         lesComptes.add(UnCompte);
    }
}