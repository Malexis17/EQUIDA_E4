<%-- 
    Document   : chevalModifier
    Created on : 12 nov. 2020, 13:13:32
    Author     : Thibault
--%>

<%@page import="modele.Cheval"%>
<%@page import="modele.TypeCheval"%>
<%@page import="modele.Client"%>
<%@page import="formulaires.ChevalForm"%>
<%@page import="modele.CategVente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modele.Pays"%>
<%@page import="formulaires.ClientForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cheval Modifier</title>
    </head>
    <body>
        <center>
        <h1>MODIFIER CHEVAL</h1>
        </center>
            <%
                ChevalForm form = (ChevalForm)request.getAttribute("form");
                Cheval leCheval = (Cheval)request.getAttribute("pLeCheval");
            %>

            <form class="form-inline" action="modifierCheval" method="POST">
                    <label for="id">ID  </label>
                    <input id="id" type="text" name="id"  size="15" maxlength="15" value ="<%out.println(leCheval.getId());%>">
                    </br>
                    
                    <label for="sire">SIRE  </label>
                    <input id="sire" type="text" name="sire"  size="15" maxlength="15" value ="<%out.println(leCheval.getSire());%>">
                    </br>

                    <label for="nom">NOM  </label>
                    <input id="nom"  type="text"  name="nom" size="20" maxlength="20" value="<%out.println(leCheval.getNom());%>">      
                    </br>
                     
                    <label for="sexe">SEXE : </label>
                    <select name="sexe" size="2">
                        <%
                        if(leCheval.getSexe().equals("M")){
                            out.println("<option value ='M' selected='selected'>M</option>");
                            out.println("<option value ='F'>F</option>");
                        }else{
                            out.println("<option value ='M'>M</option>");
                            out.println("<option value ='F' selected='selected'>F</option>");
                        }
                        %>
                    </select>
                        
                    <label for="typeCheval">TYPE DE CHEVAL : </label>
                <select name="typeCheval" size="5">
                <%
                        ArrayList<TypeCheval> lesTypesChevaux = (ArrayList)request.getAttribute("pLesTypesChevaux");
                        for (int i=0; i<lesTypesChevaux.size();i++){
                            TypeCheval tc = lesTypesChevaux.get(i);
                            if(leCheval.getUnTypeCheval().getId()==tc.getId()){
                                out.println("<option value ='" + tc.getId() + "' selected='selected'>" + tc.getLibelle() + "</option>");
                            }else{
                            out.println("<option value ='" + tc.getId() + "'>" + tc.getLibelle() + "</option>"); 
                            }
                        }
                    %>
                </select></br>
               
                
                <label for="client">CLIENT : </label>
                <select name="client" size="5">
                <%
                        ArrayList<Client> lesClients = (ArrayList)request.getAttribute("pLesClients");
                        for (int i=0; i<lesClients.size();i++){
                            Client cl = lesClients.get(i);
                            if(leCheval.getUnClient().getId()==cl.getId()){
                                out.println("<option value ='" + cl.getId() + "' selected='selected'>" + cl.getNom() + "</option>");
                            }else{
                            out.println("<option value ='" + cl.getId() + "'>" + cl.getNom() + "</option>"); 
                            }
                        }
                    %>
                </select></br>
                
                <label for="pere">PERE DU CHEVAL : </label>
                <select name="pere" size="5">
                <%
                        ArrayList<Cheval> lesChevauxPeres = (ArrayList)request.getAttribute("pLesChevauxMales");
                        for (int i=0; i<lesChevauxPeres.size();i++){
                            Cheval c = lesChevauxPeres.get(i);
                            if(leCheval.getUnPere().getId()==c.getId()){
                                out.println("<option value ='" + c.getId() + "' selected='selected'>" + c.getNom() + "</option>");
                            }else{
                            out.println("<option value ='" + c.getId() + "'>" + c.getNom() + "</option>"); 
                            }
                        }
                    %>
                </select></br>
                
                <label for="mere">MERE DU CHEVAL : </label>
                <select name="mere" size="5">
                <%
                        ArrayList<Cheval> lesChevauxMeres = (ArrayList)request.getAttribute("pLesChevauxFemelles");
                        for (int i=0; i<lesChevauxMeres.size();i++){
                            Cheval c = lesChevauxMeres.get(i);
                            if(leCheval.getUneMere().getId()==c.getId()){
                                out.println("<option value ='" + c.getId() + "' selected='selected'>" + c.getNom() + "</option>");
                            }else{
                            out.println("<option value ='" + c.getId() + "'>" + c.getNom() + "</option>"); 
                            }
                        }
                    %>
                </select>
                </br>
                        

                    <input type="submit" name="valider" id="valider" value="Valider"/>
                </form>
                     <footer class="footer-distributed">

                            <div class="footer-right">

                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                    <a href="#"><i class="fa fa-linkedin"></i></a>
                                    <a href="#"><i class="fa fa-github"></i></a>

                            </div>

                            <div class="footer-left">

                                    <p class="footer-links">
                                            <a class="link-1" href="../index.html">Home</a>

                                            <a href="../ServletVentes/listerLesVentes">Ventes</a>

                                            <a href="#">Pricing</a>

                                            <a href="#">About</a>

                                            <a href="#">Faq</a>

                                            <a href="#">Contact</a>
                                    </p>

                                    <p>Equida GANG &copy; 2020</p>
                            </div>

                    </footer>
    </body>
</html>
