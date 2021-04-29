<%-- 
    Document   : ClientAjouter
    Created on : 22/06, 16:35:27
    Author     : Zakina
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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/stylesheet.css">
        <!-- JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <title>Cheval Ajouter</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">
               <img src="../vues/images/logo.jpg" width="50" height="40" style="display: inline-block;">
            </a>
  <a class="navbar-brand" href="#">Equida</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="../index.html">Accueil <span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Listes
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="../ServletVentes/listerLesVentes">Lister Les Ventes</a>
          <a class="dropdown-item" href="../ServletAdmin/listerLesLieux">Lister Les Lieux</a>
          <a class="dropdown-item" href="../ServletAdmin/listerLesPays">Lister Les Pays</a>
          <a class="dropdown-item" href="../ServletAdmin/listerLesCategVente">Lister Les CategVentes</a>
        </div>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Ajouter
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="../ServletClient/ajouterClient">Ajouter Client</a>
          <a class="dropdown-item" href="../ServletCheval/ajouterCheval">Ajouter Cheval</a>
          <a class="dropdown-item" href="../ServletAdmin/ajouterCategVente">Ajouter Catégorie</a>
          <a class="dropdown-item" href="../ServletAdmin/AjouterLieu">Ajouter Lieu</a>
          <a class="dropdown-item" href="../ServletAdmin/ajouterPays">Ajouter Pays</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
    <center>
        <h1>NOUVEAU CHEVAL</h1>
    </center>
        
        
         <%
                ChevalForm form = (ChevalForm)request.getAttribute("form");
            %>
        
        <form class="form-inline" action="ajouterCheval" method="POST">
            <center>
                <label for="nom">NOM </label>
                <input id="nom" type="text" name="nom"  size="30" maxlength="40" required="required">
                </br>
                
                <label for="sire">SIRE </label>
                <input id="sire"  type="text"  name="sire" size="30" maxlength="13" required="required">
                 </br>
                 
                <label for="sexe">SEXE </label>
                <select name="sexe" size="2" required="required">
                    <option value ="M">M</option>
                    <option value ="F">F</option>
                </select>     
                
                
                <label for="typeCheval">TYPE DE CHEVAL </label>
                <select name="typeCheval" size="5" required="required">
                <%
                        ArrayList<TypeCheval> lesTypesChevaux = (ArrayList)request.getAttribute("pLesTypesChevaux");
                        for (int i=0; i<lesTypesChevaux.size();i++){
                            TypeCheval tc = lesTypesChevaux.get(i);
                            System.out.println("tc.id = " + tc.getId());
                            out.println("<option value ='" + tc.getId() + "'>" + tc.getLibelle() + "</option>"); 
                           
                        }
                    %>
                </select>
               
                
                <label for="client">CLIENT </label>
                <select name="client" size="5" required="required">
                <%
                        ArrayList<Client> lesClients = (ArrayList)request.getAttribute("pLesClients");
                        for (int i=0; i<lesClients.size();i++){
                            Client cl = lesClients.get(i);
                            out.println("<option value ='" + cl.getId() + "'>" + cl.getNom() + "</option>"); 
                           
                        }
                    %>
                </select>
                
                <label for="pere">PERE DU CHEVAL </label>
                <select name="pere" size="5" required="required">
                <%
                        ArrayList<Cheval> lesChevauxPeres = (ArrayList)request.getAttribute("pLesChevauxMales");
                        for (int i=0; i<lesChevauxPeres.size();i++){
                            Cheval c = lesChevauxPeres.get(i);
                            out.println("<option value ='" + c.getId() + "'>" + c.getNom() + "</option>"); 
                           
                        }
                    %>
                </select>
                
                <label for="mere">MERE DU CHEVAL </label>
                <select name="mere" size="5" required="required">
                <%
                        ArrayList<Cheval> lesChevauxMeres = (ArrayList)request.getAttribute("pLesChevauxFemelles");
                        for (int i=0; i<lesChevauxMeres.size();i++){
                            Cheval c = lesChevauxMeres.get(i);
                            out.println("<option value ='" + c.getId() + "'>" + c.getNom() + "</option>"); 
                           
                        }
                    %>
                </select></br>
                <input type="submit" name="valider" id="valider" value="Valider"/>
                </center>
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

				<p>Equida &copy; 2020</p>
			</div>

		</footer> 
    </body>
</html>
