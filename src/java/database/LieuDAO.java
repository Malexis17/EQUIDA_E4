/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Lieu;


/**
 *
 * @author sio2
 */
public class LieuDAO {
    
      Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    
    public static Lieu AjouterLieu(Connection connection, Lieu unLieu){
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("INSERT INTO lieu ( id, ville,nbBoxes,commentaire)\n" +
                    "VALUES (?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setInt(1, unLieu.getId());
            requete.setString(2, unLieu.getVille());
           requete.setInt(3, unLieu.getNbBoxes());
            requete.setString(4,unLieu.getCommentaires());
            
            
  /* Exécution de la requête */
           
   requete.executeUpdate();
            
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unLieu ;    
    }
    
    public static ArrayList<Lieu> getLesLieux(Connection connection){
        ArrayList<Lieu> lesLieux = new ArrayList<Lieu>();
        
          //On hydrate l'objet métier Client avec les résultats de la requête
        try
          
        {
            //preparation de la requete  
            requete=connection.prepareStatement("select * from lieu where lieu.archive IS NULL OR lieu.archive=0");
            
            rs=requete.executeQuery();
            //On hydrate l'objet métier Client avec les résultats de la requête
            while (rs.next() ){
                Lieu unLieu = new Lieu();
                unLieu.setId(rs.getInt("id"));
                unLieu.setVille(rs.getString("ville"));
                unLieu.setNbBoxes(rs.getInt("nbBoxes"));
                unLieu.setCommentaires(rs.getString("commentaire"));
                lesLieux.add(unLieu);
                
                
            }
            
        }
         catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        
        return lesLieux;
            
    }
    
    public static Lieu getleLieu(Connection connection, String id){  
        Lieu leLieu = new Lieu();
        try
        {
            //preparation de la requete
        
            requete=connection.prepareStatement("select * from lieu where id=?");
         requete.setString(1, id);
         System.out.println("REQUETE " + requete);
         //executer la requete
         rs=requete.executeQuery();
         
       
          while ( rs.next() ) {  
               leLieu.setId(rs.getInt("id"));
                leLieu.setVille(rs.getString("ville"));
                leLieu.setNbBoxes(rs.getInt("nbBoxes"));
                leLieu.setCommentaires(rs.getString("commentaire"));
            }
         
         
      
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leLieu;   
        
  }
    
     public static Lieu modifierLieu(Connection connection, Lieu unLieu){      
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("UPDATE lieu SET ville=?, nbBoxes=?, commentaire=? WHERE id=?");
            System.out.println("LIEUDAO requete="+requete);
            
            requete.setString(1, unLieu.getVille());
            requete.setInt(2, unLieu.getNbBoxes());
            requete.setString(3, unLieu.getCommentaires());
            requete.setInt(4,unLieu.getId());
            

          
            requete.executeUpdate();
            
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unLieu ;    
    }
     
      public static Lieu supprimerLieu(Connection connection, Lieu unLieu){      
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("UPDATE lieu SET archive=1 WHERE id=?");
            requete.setInt(1, unLieu.getId());
            
         
            

           /* Exécution de la requête */
            requete.executeUpdate();
            
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unLieu ;    
    }
    
      
     
     
    
}
