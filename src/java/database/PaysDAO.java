/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static database.VenteDAO.requete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.CategVente;
import modele.Pays;
import modele.Vente;

/**
 *
 * @author Zakina
 */
public class PaysDAO {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     public static ArrayList<Pays>  getLesPays(Connection connection){      
        ArrayList<Pays> lesPays = new  ArrayList<Pays>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from pays where pays.archive IS NULL OR pays.archive=0");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Pays unPays = new Pays();
                unPays.setCode(rs.getString("code"));
                unPays.setNom(rs.getString("nom"));
                lesPays.add(unPays);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesPays ;    
    }
     public static Pays getLePays(Connection connection, String code){      
        Pays lePays = new Pays();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from pays where code=? AND( pays.archive IS NULL OR pays.archive=0)");
            requete.setString(1, code);
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                lePays.setCode(rs.getString("code"));
                lePays.setNom(rs.getString("nom"));
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lePays ;    
    }
     
     // Méthode permettant d'insérer un pays en base à partir de l'objet pays passé en paramètre
    // Cette méthode renvoie l'objet pays
    public static Pays ajouterPays(Connection connection, Pays unPays){      
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("INSERT INTO pays ( code, nom) VALUES (?,?)");
            requete.setString(1, unPays.getCode());
            requete.setString(2, unPays.getNom());
            

           /* Exécution de la requête */
            requete.executeUpdate();
            
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unPays ;    
    }
    
    public static Pays modifierPays(Connection connection, Pays unPays){      
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("UPDATE pays SET nom=? WHERE code=?");
            requete.setString(2, unPays.getCode());
            requete.setString(1, unPays.getNom());
            

           /* Exécution de la requête */
            requete.executeUpdate();
            
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unPays ;    
    }
    
}
