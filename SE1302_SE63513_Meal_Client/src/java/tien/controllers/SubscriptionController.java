/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import tien.utils.ConstantsWebServiceWareHouse;

/**
 *
 * @author Admin
 */
public class SubscriptionController extends HttpServlet {

    private static final String SUCCESS = "about.jsp";
    private static final String ERROR = "error.jsp";
    private static final ConstantsWebServiceWareHouse CONSTANT = new ConstantsWebServiceWareHouse();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String result = "Your subscription is successful, please enjoy our service";
        try {
            String txtName = request.getParameter("txtName");
            String txtEmail = request.getParameter("txtEmail");
            String txtTitle = request.getParameter("txtTitle");
            String txtDate = request.getParameter("txtDate");
            String txtMessage = request.getParameter("txtMessage");
            System.out.println(txtName + "\n"
                    + txtEmail + "\n"
                    + txtTitle + "\n"
                    + new Date(txtDate) + "\n"
                    + txtMessage + "\n");
            

            Form form = new Form();
            form.param("txtName", txtName);
            form.param("txtEmail", txtEmail);
            form.param("txtDate", txtDate);
            form.param("txtMessage", txtTitle + ":\n" + txtMessage);

            Client client = ClientBuilder.newClient();
            WebTarget wt = client.target(CONSTANT.WEB_SERVICE_BASE_URI).path(CONSTANT.SUBSCRIPTION);
            Response res = wt.request().post(Entity.form(form));

            String responseFromWC = res.readEntity(new GenericType<String>(){});
            if(res.getStatus() == 200){
                if(responseFromWC.equalsIgnoreCase("Email exist")){
                    result = "But your email has existed, please choose another email";
                }
            }
            request.setAttribute("SUBSCRIPTION", result);
            url = SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
