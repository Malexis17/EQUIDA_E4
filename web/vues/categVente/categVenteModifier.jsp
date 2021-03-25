<%-- 
    Document   : categVenteModifier
    Created on : 5 nov. 2020, 15:26:18
    Author     : Alexis
--%>
<%@page import="formulaires.CategVenteForm"%>
<%@page import="modele.CategVente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification d'une categorie de vente</title>
    </head>
    <body>
        <h1>Modifier la catégorie de vente</h1>
        
          <%
        
        CategVenteForm form = (CategVenteForm)request.getAttribute("form");
        CategVente uneCategVente = (CategVente)request.getAttribute("plaCategVente");
        
        %>
                        
                
 <form class="form" action="categVenteModifier" method="POST">
               <label for="code">code : </label>
                <input id="code" type="text" name="code"  size="4" maxlength="10" value="<%out.println(uneCategVente.getCode());%>" readonly>
                </br>
            <label for="libelle">libelle : </label>
                <input id="libelle" type="text" name="libelle"  size="50" maxlength="50" value="<%out.println(uneCategVente.getLibelle());%>" >
                </br>

        
         <input type="submit" name="valider" id="valider" value="Valider"/>
   
    
    </form>
          
    </body>
</html>