/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaires;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import modele.Lieu;

/**
 *
 * @author sio2
 */
public class LieuForm {
    
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
    
    
    public Lieu AjouterLieu( HttpServletRequest request ) {
      
        Lieu unLieu  = new Lieu();
         
      String id = getDataForm(request, "id");
        String ville = getDataForm( request, "ville");
   String nbBoxes = getDataForm(request,"nbBoxes");
        String Commentaire = getDataForm(request,"commentaire");
        
       
    
      
      unLieu.setId(Integer.parseInt(id));
        unLieu.setVille(ville);
         
       unLieu.setNbBoxes(Integer.parseInt(nbBoxes));
        unLieu.setCommentaires(Commentaire);
        
   
               
       
        return unLieu;
    }
    
    
    
    
    
}
