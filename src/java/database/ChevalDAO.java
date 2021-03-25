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
import modele.Cheval;
import modele.Client;
import modele.Pays;
import modele.TypeCheval;
import modele.Client;
/**
 *
 * @author sio2
 */
public class ChevalDAO {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    /* @author sio2 - 13/10/2020
    /* Méthode permettant de lister toutes les ventes enregistrées en base, triées par date décroissante.
    /* Pour chaque vente, on récupère aussi sa catégorie.
    /* La liste des vente est stockée dans une ArrayList
    */
    public static Cheval getInfoCheval(Connection connection, String idCheval){  
        Cheval unCheval = new Cheval();
        try
        {
            //preparation de la requete     
            //codeCateg="ETE";
            requete=connection.prepareStatement("SELECT c.*, c.photo, tc.libelle, cl.nom as nom_client, cpere.nom as nom_pere, cpere.idType as type_pere, cmere.nom as nom_mere, cmere.idType as type_mere\n" +
"FROM cheval c, cheval cmere, cheval cpere, typecheval tc, client cl\n" +
"WHERE c.idType=tc.id\n" +
"AND cmere.id=c.Mère\n" +
"AND cpere.id=c.Père\n" +
"AND c.idClient=cl.id\n" +
"AND c.id = ?\n" +
"AND (c.archive IS NULL OR c.archive=0);");

            requete.setString(1, idCheval);
            //executer la requete
            rs=requete.executeQuery();
             
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                
              
                unCheval.setId(rs.getInt("c.id"));
                
                unCheval.setNom(rs.getString("c.nom"));
                
                unCheval.setSire(rs.getString("c.sire"));
                
                unCheval.setSexe(rs.getString("c.sexe"));
                
                unCheval.setCheminPhoto(rs.getString("c.photo"));
                
                TypeCheval unTypeCheval = new TypeCheval();
                unTypeCheval.setLibelle(rs.getString("tc.libelle"));
                
                
                Cheval unChevalPere = new Cheval();
                unChevalPere.setId(rs.getInt("c.Père"));
                unChevalPere.setNom(rs.getString("nom_pere"));
                
                Cheval unChevalMere = new Cheval();
                unChevalMere.setId(rs.getInt("c.Mère"));
                unChevalMere.setNom(rs.getString("nom_mere"));
                
                Client unClient = new Client();
                unClient.setNom(rs.getString("nom_client"));
                
                unCheval.setUnPere(unChevalPere);
                unCheval.setUneMere(unChevalMere);
                unCheval.setUnClient(unClient);
                unCheval.setUnTypeCheval(unTypeCheval);
                /*CategVente uneCateg = new CategVente();
                uneCateg.setCode(rs.getString("code"));  // on aurait aussi pu prendre CodeCateg
                uneCateg.setLibelle(rs.getString("libelle"));*/
              
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval;    
    }
    
    public static Cheval ajouterCheval(Connection connection, Cheval unCheval){
        System.out.println("DANS CHEVAL DAO");
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // id (clé primaire de la table client) est en auto_increment,donc on ne renseigne pas cette valeur
            // la paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            
            requete=connection.prepareStatement("INSERT INTO cheval ( sire, nom, sexe, idType, Père, Mère, idClient)\n" +
                    "VALUES (?,?,?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unCheval.getSire());
            requete.setString(2, unCheval.getNom());
            requete.setString(3, unCheval.getSexe());
            requete.setInt(4, unCheval.getUnTypeCheval().getId());
            requete.setInt(5, unCheval.getUnPere().getId());
            requete.setInt(6, unCheval.getUneMere().getId());
            requete.setInt(7, unCheval.getUnClient().getId());
            
            System.out.println(unCheval.getSire());
            System.out.println(unCheval.getNom());
            System.out.println(unCheval.getUnTypeCheval().getId());
            System.out.println(unCheval.getSexe());
            System.out.println(unCheval.getUnPere().getId());
            System.out.println(unCheval.getUneMere().getId());
            System.out.println(unCheval.getUnClient().getId());
            
           /* Exécution de la requête */
            requete.executeUpdate();
            
            System.out.println("APRES INSERTION");
            
             // Récupération de id auto-généré par la bdd dans la table client
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unCheval.setId(idGenere);
            }
            
          
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval ;    
    }
    
    public static Cheval modifierCheval(Connection connection, Cheval unCheval){

        try
        {
           
            requete=connection.prepareStatement("UPDATE cheval SET sire=?,nom=?,sexe=?, idType=?,Père=?,Mère=?,idClient=? WHERE id=?");
            requete.setInt(8, unCheval.getId());
            requete.setString(1, unCheval.getSire());
            requete.setString(2, unCheval.getNom());
            requete.setString(3, unCheval.getSexe());
            requete.setInt(4, unCheval.getUnTypeCheval().getId());
            requete.setInt(5, unCheval.getUnPere().getId());
            requete.setInt(6, unCheval.getUneMere().getId());
            requete.setInt(7, unCheval.getUnClient().getId());
            
            
            System.out.println("requete " + requete);
            
           /* Exécution de la requête */
            requete.executeUpdate();
 
            
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval ;    
    }
    
    public static ArrayList<Cheval>  getLesChevaux(Connection connection){      
        ArrayList<Cheval> lesChevaux = new  ArrayList<Cheval>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from cheval ORDER BY nom ");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Cheval unCheval = new Cheval();
                unCheval.setId(rs.getInt("id"));
                unCheval.setSire(rs.getString("sire"));
                unCheval.setNom(rs.getString("nom"));
                unCheval.setSexe(rs.getString("sexe"));
                
                
                lesChevaux.add(unCheval);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesChevaux ;    
    }
    
    public static Cheval getLeCheval(Connection connection, String id){      
        Cheval unCheval = new Cheval();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select cheval.*, tc.id, ch2.id, ch3.id, cl.id from cheval, typecheval tc, cheval ch2, cheval ch3, client cl where cheval.id=? AND cheval.idType = tc.id AND cheval.père = ch2.id AND cheval.mère = ch3.id AND cheval.idClient = cl.id AND( cheval.archive IS NULL OR cheval.archive=0)");
            requete.setString(1, id);
            //executer la requete
            rs=requete.executeQuery();
            
            while ( rs.next() ) {  
                unCheval.setId(rs.getInt("id"));
                unCheval.setSire(rs.getString("sire"));
                unCheval.setNom(rs.getString("nom"));
                unCheval.setSexe(rs.getString("sexe"));
                
                TypeCheval unTypeCheval = new TypeCheval();
                unTypeCheval.setId(rs.getInt("tc.id"));
                unCheval.setUnTypeCheval(unTypeCheval);
                
                Cheval unChevalPere = new Cheval();
                unChevalPere.setId(rs.getInt("ch2.id"));
                unCheval.setUnPere(unChevalPere);
                
                Cheval unChevalMere = new Cheval();
                unChevalMere.setId(rs.getInt("ch3.id"));
                unCheval.setUneMere(unChevalMere);
                
                Client unClient = new Client();
                unClient.setId(rs.getInt("cl.id"));
                unCheval.setUnClient(unClient);
                
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return unCheval;    
    }
    
    public static ArrayList<Cheval>  getLesChevauxMales(Connection connection){      
        ArrayList<Cheval> lesChevauxMales = new  ArrayList<Cheval>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from cheval WHERE sexe = 'M' ORDER BY nom ");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Cheval unCheval = new Cheval();
                unCheval.setId(rs.getInt("id"));
                unCheval.setSire(rs.getString("sire"));
                unCheval.setNom(rs.getString("nom"));
                unCheval.setSexe(rs.getString("sexe"));
                
                
                lesChevauxMales.add(unCheval);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesChevauxMales ;    
    } 
    
    public static ArrayList<Cheval>  getLesChevauxFemelles(Connection connection){      
        ArrayList<Cheval> lesChevauxFemelles = new  ArrayList<Cheval>();
        try
        {
            //preparation de la requete     
            requete=connection.prepareStatement("select * from cheval WHERE sexe = 'F' ORDER BY nom ");
            
            //executer la requete
            rs=requete.executeQuery();
            
            //On hydrate l'objet métier Client avec les résultats de la requête
            while ( rs.next() ) {  
                Cheval unCheval = new Cheval();
                unCheval.setId(rs.getInt("id"));
                unCheval.setSire(rs.getString("sire"));
                unCheval.setNom(rs.getString("nom"));
                unCheval.setSexe(rs.getString("sexe"));
                
                
                lesChevauxFemelles.add(unCheval);
            }
        }   
        catch (SQLException e) 
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesChevauxFemelles ;    
    } 
}
