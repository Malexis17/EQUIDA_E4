/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaires;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import modele.Pays;

/**
 *
 * @author Thibault
 */
public class PaysForm {
    private String resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(Map<String, String> erreurs) {
        this.erreurs = erreurs;
    }
    
    //méthode de validation du champ de saisie nom
    private void validationCode( String code ) throws Exception {
        if ( code != null && code.length() != 3 ) {
        throw new Exception( "Le code d'un pays doit contenir 3 caractères." );
        }
    }

    private void setErreur( String champ, String message ) {
    erreurs.put(champ, message );
    }    
    
    private static String getDataForm( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }   
    }
    
    public Pays ajouterPays( HttpServletRequest request ) {
      
        Pays unPays  = new Pays();
         
        String code = getDataForm( request, "code" );
        String nom = getDataForm( request, "nom");
             
 
       
        try {
             validationCode( code );
        } catch ( Exception e ) {
            setErreur( "code", e.getMessage() );
        }
        unPays.setCode(code);

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
         
      
        unPays.setNom(nom);
        
               
       
        return unPays ;
    }
}
