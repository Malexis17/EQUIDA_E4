/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.CategVenteDAO;
import database.ClientDAO;

import database.LieuDAO;


import formulaires.LieuForm;

import database.PaysDAO;
import database.VenteDAO;
import formulaires.CategVenteForm;
import formulaires.PaysForm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.CategVente;
import modele.Client;

import modele.Lieu;

import modele.Pays;

import modele.Vente;

/**
 *
 * @author Morel Alexis
 */
public class ServletAdmin extends HttpServlet {

    Connection connection ;
    
    @Override
    public void init()
    {     
        ServletContext servletContext=getServletContext();
        connection=(Connection)servletContext.getAttribute("connection");
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             /*TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAdmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getRequestURI();
       
       if(url.equals("/ERROR500/ServletAdmin/ajouterCategVente"))
        {     
          this.getServletContext().getRequestDispatcher("/vues/categVente/categVenteAjouter.jsp" ).forward( request, response );
        }

       
       if(url.equals("/ERROR500/ServletAdmin/AjouterLieu"))
       {
      this.getServletContext().getRequestDispatcher("/vues/Lieu/AjouterLieu.jsp" ).forward( request, response );
       
       }

       if(url.equals("/ERROR500/ServletAdmin/ajouterPays"))
        {     
          this.getServletContext().getRequestDispatcher("/vues/pays/paysAjouter.jsp" ).forward( request, response );
        }
       
       if(url.equals("/ERROR500/ServletAdmin/modifierPays"))
        {
          String code = (String)request.getParameter("code");
          Pays unPays = PaysDAO.getLePays(connection,code);
          request.setAttribute("pLePays", unPays);
          this.getServletContext().getRequestDispatcher("/vues/pays/paysModifier.jsp" ).forward( request, response );
        }
       
       if(url.equals("/ERROR500/ServletAdmin/listerLesPays"))
        {  
            ArrayList<Pays> lesPays = PaysDAO.getLesPays(connection);
            request.setAttribute("pLesPays", lesPays);
            getServletContext().getRequestDispatcher("/vues/pays/listerLesPays.jsp").forward(request, response);
        }
       
        if(url.equals("/ERROR500/ServletAdmin/listerLesLieux"))
       {
          ArrayList<Lieu> lesLieux = LieuDAO.getLesLieux(connection);
          request.setAttribute("pLesLieux", lesLieux);
           getServletContext().getRequestDispatcher("/vues/Lieu/listerLesLieux.jsp").forward(request, response);
       }
       
         if(url.equals("/ERROR500/ServletAdmin/lieuModifier")){
           String id = (String)request.getParameter("idLieu");
           Lieu unLieu= LieuDAO.getleLieu(connection, id);
           request.setAttribute("pLeLieu", unLieu);
           System.out.println("LIEU= "+ unLieu.getVille());
           this.getServletContext().getRequestDispatcher("/vues/Lieu/lieuModifier.jsp").forward(request, response);
       }
          
         if(url.equals("/ERROR500/ServletAdmin/supprimerLieu"))
        {
          String id = (String)request.getParameter("idLieu");
          Lieu unLieu = LieuDAO.getleLieu(connection,id);
          request.setAttribute("pLeLieu", unLieu);
          this.getServletContext().getRequestDispatcher("/vues/Lieu/supprimerLieu.jsp" ).forward( request, response );
        }
         
         if(url.equals("/ERROR500/ServletAdmin/listerLesCategVente")){
             ArrayList<CategVente> lesCategVente = CategVenteDAO.getLesCategVentes(connection);
             request.setAttribute("pLesCategVente", lesCategVente);
             getServletContext().getRequestDispatcher("/vues/categVente/listerLesCategVente.jsp").forward(request, response);
         }

         if(url.equals("/ERROR500/ServletAdmin/categVenteModifier")){
             String id = (String)request.getParameter("codeCategVente");
             CategVente uneCategVente = CategVenteDAO.getuneCategVente(connection, id);
             request.setAttribute("plaCategVente", uneCategVente);
                  System.out.println("CategVente= "+ uneCategVente.getLibelle());
             this.getServletContext().getRequestDispatcher("/vues/categVente/categVenteModifier.jsp").forward(request, response);
         }
       
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
         String url = request.getRequestURI();
        
         if(url.equals("/ERROR500/ServletAdmin/AjouterLieu")){
            LieuForm form = new LieuForm();

         Lieu unLieu = form.AjouterLieu(request);

          request.setAttribute("form", form);
          request.setAttribute("pLieu", unLieu);


          if(form.getErreurs().isEmpty()){

                 LieuDAO.AjouterLieu(connection, unLieu);
              this.getServletContext().getRequestDispatcher("/vues/Lieu/LieuConsulter.jsp" ).forward( request, response );
          }
          else
          {

          }
        
         }
        if(url.equals("/ERROR500/ServletAdmin/ajouterCategVente")){

            /* Préparation de l'objet formulaire */
           CategVenteForm form = new CategVenteForm();

           /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
           CategVente uneCategVente = form.ajouterCategVente(request);

           /* Stockage du formulaire et de l'objet dans l'objet request */
           request.setAttribute( "form", form );
           request.setAttribute( "pCategVente", uneCategVente );

           if (form.getErreurs().isEmpty()){
               // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du client 
               CategVenteDAO.ajouterCategVente(connection, uneCategVente);
               this.getServletContext().getRequestDispatcher("/vues/categVente/categVenteConsulter.jsp" ).forward( request, response );
           }
           else
           { 
                   // il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs


           }
        }

        


        if(url.equals("/ERROR500/ServletAdmin/ajouterPays")){

            /* Préparation de l'objet formulaire */
           PaysForm form = new PaysForm();

           /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
           Pays unPays = form.ajouterPays(request);

           /* Stockage du formulaire et de l'objet dans l'objet request */
           request.setAttribute( "form", form );
           request.setAttribute( "pPays", unPays );

           if (form.getErreurs().isEmpty()){
               // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du client 
               PaysDAO.ajouterPays(connection, unPays);
               this.getServletContext().getRequestDispatcher("/vues/pays/paysConsulter.jsp" ).forward( request, response );
           }
           else
           { 
                   // il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs


           }
        }
        
        if(url.equals("/ERROR500/ServletAdmin/modifierPays")){

            /* Préparation de l'objet formulaire */
           PaysForm form = new PaysForm();

           /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
           Pays unPays = form.ajouterPays(request);

           /* Stockage du formulaire et de l'objet dans l'objet request */
           request.setAttribute( "form", form );
           request.setAttribute( "pPays", unPays );

           if (form.getErreurs().isEmpty()){
               // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du client 
               PaysDAO.modifierPays(connection, unPays);
               this.getServletContext().getRequestDispatcher("/vues/pays/paysConsulter.jsp" ).forward( request, response );
           }
           else
           { 
                   // il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs


           }
        }
        
         if(url.equals("/ERROR500/ServletAdmin/lieuModifier")){
                     /* Préparation de l'objet formulaire */
                     LieuForm form = new LieuForm();
                    
                     /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
                     Lieu unLieu = form.AjouterLieu(request);
                     System.out.println("SERVLETADMIN + LIEU COPMMENTA" + unLieu.getCommentaires());
                     System.out.println("SERVLETADMIN + LIEU VILLE " + unLieu.getVille());
                       /* Stockage du formulaire et de l'objet dans l'objet request */
                      request.setAttribute( "form", form );
                      request.setAttribute( "pLieu", unLieu );
                      
                       if (form.getErreurs().isEmpty()){
               // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du client 
               LieuDAO.modifierLieu(connection, unLieu);
               this.getServletContext().getRequestDispatcher("/vues/Lieu/LieuConsulter.jsp" ).forward( request, response );
                       }
               
               else
               {
                       // il y a des erreurs. On réaffiche le formulaire avec des messages d'erreur 
                       }
          
          
          }
         
         if(url.equals("/ERROR500/ServletAdmin/supprimerLieu")){

            /* Préparation de l'objet formulaire */
           LieuForm form = new LieuForm();

           /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
           Lieu unLieu = form.AjouterLieu(request);

           /* Stockage du formulaire et de l'objet dans l'objet request */
           request.setAttribute( "form", form );
           request.setAttribute( "pPays", unLieu );

           if (form.getErreurs().isEmpty()){
               // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du client 
               LieuDAO.supprimerLieu(connection, unLieu);
             
           }
           else
           { 
                   // il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs


           }
        }
         
         if(url.equals("/ERROR500/ServletAdmin/categVenteModifier")){

            /* Préparation de l'objet formulaire */
           CategVenteForm form = new CategVenteForm();

           /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
           CategVente uneCategVente = form.ajouterCategVente(request);

           /* Stockage du formulaire et de l'objet dans l'objet request */
           request.setAttribute( "form", form );
           request.setAttribute( "pCategVente", uneCategVente );

           if (form.getErreurs().isEmpty()){
               // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du client 
               CategVenteDAO.modifierCategVente(connection, uneCategVente);
               this.getServletContext().getRequestDispatcher("/vues/categVente/categVenteConsulter.jsp" ).forward( request, response );
           }
           else
           { 
                   // il y a des erreurs. On réaffiche le formulaire avec des messages d'erreurs


           }
        }
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}