/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.w3c.dom.Document;
import tien.utils.ConstantsWebServiceWareHouse;
import tien.utils.DOMUtils;

/**
 *
 * @author Admin
 */
public class LoadMaterialController extends HttpServlet {

    private static final String SUCCESS = "dataindex.jsp";
    private static final String ERROR = "error.jsp";
    private static final ConstantsWebServiceWareHouse CONSTANT = new ConstantsWebServiceWareHouse();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
//            URL url2 = new URL(constant.WEB_SERVICE_BASE_URI + constant.GET_ALL_MATERIAL);
//            URLConnection urlConnection = url2.openConnection();
//            String line = "";
//            String res = "";
//            try (InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8);
//                    BufferedReader br = new BufferedReader(isr)) {
//                while ((line = br.readLine()) != null) {
//                    line = line.trim();
//                    line = line.replace(" standalone=\"yes\"", "").replace("><", ">\n<");
//                    res += line + "\n";
//                    System.out.println(line + "\n");
//                }
//            }

            Client client = ClientBuilder.newClient();
            WebTarget wt = client.target(CONSTANT.WEB_SERVICE_BASE_URI).path(CONSTANT.GET_ALL_MATERIAL);
            String res = wt.request().get(String.class);
            
            res = res.replace("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>", "");
//            res = res.replace("><", ">\n<");
//            System.out.println(res);
            HttpSession session = request.getSession();
            Document doc = DOMUtils.parseXMLStringIntoDOM(res);
            
            session.setAttribute("DOMMATERIAL", doc);
            session.setAttribute("MATERIALSTRING", res);
            System.out.println("LoadMaterialController successfully");
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
