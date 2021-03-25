/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaires;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import modele.CategVente;


/**
 *
 * @author sio2
 */
public class CategVenteForm {
    
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
        if ( code != null && code.length() < 2 ) {
        throw new Exception( "Le code doit contenir au moins 2 caractères." );
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
    
    
    public CategVente ajouterCategVente( HttpServletRequest request ) {
      
        CategVente uneCategVente  = new CategVente();
         
        String code = getDataForm( request, "code" );
        String libelle = getDataForm( request, "libelle");
        
       
        try {
             validationCode( libelle );
        } catch ( Exception e ) {
            setErreur( "code", e.getMessage() );
        }
        uneCategVente.setCode(code);

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
         
      
        uneCategVente.setCode(code);
        uneCategVente.setLibelle(libelle);
        
               
       
        return uneCategVente;
    }
    
}

