/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import tien.dtos.Food;
import tien.utils.ConstantsWebServiceWareHouse;

/**
 *
 * @author Admin
 */
public class LoadFoodController extends HttpServlet {

    private static final String SUCCESS = "RecommendMealController";
    private static final String ERROR = "error.jsp";
    private static final ConstantsWebServiceWareHouse CONSTANT = new ConstantsWebServiceWareHouse();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            Client client = ClientBuilder.newClient();
            WebTarget wt = client.target(CONSTANT.WEB_SERVICE_BASE_URI).path(CONSTANT.GET_ALL_FOOD);
            Response res = wt.request().get();
            List<Food> list = res.readEntity(new GenericType< List<Food>>() {
            });
            if (res.getStatus() == 200) {

                Collections.shuffle(list);
                List<Food> breakfast = new ArrayList<>();
                List<Food> lunch = new ArrayList<>();
                List<Food> dinner = new ArrayList<>();

                int count = 0;
                for (Food food : list) {
                    if (!food.getCookingMethod().isEmpty() && !food.getMaterialDescription().isEmpty() && food.getCookingMethod() != null && food.getMaterialDescription() != null) {
                        count++;
                        if (count <= 120) {
                            breakfast.add(food);
                        }
                        if (count <= 240 && count > 120) {
                            lunch.add(food);
                        }
                        if (count > 200) {
                            dinner.add(food);
                        }
                    }
                }

                request.setAttribute("BREAKFAST", breakfast);
                request.setAttribute("LUNCH", lunch);
                request.setAttribute("DINNER", dinner);
            }
                HttpSession session = request.getSession();
                session.setAttribute("LISTFOOD", list);
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
