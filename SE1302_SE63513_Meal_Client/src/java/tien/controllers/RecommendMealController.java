/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tien.dtos.Food;
import tien.utils.ConstantsWebServiceWareHouse;

/**
 *
 * @author Admin
 */
public class RecommendMealController extends HttpServlet {

    private static final String SUCCESS = "calculate.jsp";
    private static final String ERROR = "error.jsp";
    private static final ConstantsWebServiceWareHouse CONSTANT = new ConstantsWebServiceWareHouse();
    private static List<Food> breakfast;
    private static List<Food> lunch;
    private static List<Food> dinner;
    private static List<Food> display;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            //  calo from customer
            double calories = Double.parseDouble(request.getParameter("txtCalories").trim());
            System.out.println(request.getParameter("txtOpGender"));
            System.out.println(request.getParameter("txtAge"));
            System.out.println(request.getParameter("txtHeight"));
            System.out.println(request.getParameter("txtWeight"));
            System.out.println(request.getParameter("txtOpActivity"));
            //  list food for each meal
            breakfast = new ArrayList<>();
            lunch = new ArrayList<>();
            dinner = new ArrayList<>();

            //  calo calculate
            double calo = 0;
            //  limit calo for each set of meal
            double limit = calories / 3;

            //  list food will be displayed
            display = (List<Food>) request.getAttribute("BREAKFAST");
            System.out.println("BREAKFASTTTTTTTTTTTTTTTTTTTTTTTTTT");
            Collections.shuffle(display);
            for (Food food : display) {
                if (calo <= limit * 1.15) {
                    calo += food.getCalories();
                    breakfast.add(food);
                    System.out.println("ADD");
                } else {
                    calo = 0;
                    display.clear();
                    break;
                }
            }
            System.out.println("LUNCHHHHHHHHHHHHHHHHHHHHHHH");
            display = (List<Food>) request.getAttribute("LUNCH");
            Collections.shuffle(display);
            for (Food food : display) {

                if (calo <= limit * 1.15) {
                    calo += food.getCalories();
                    System.out.println("ADD");
                    lunch.add(food);
                } else {
                    calo = 0;
                    display.clear();
                    break;
                }

            }
            System.out.println("DINNERRRRRRRRRRRRRRRRRRRRRR");
            display = (List<Food>) request.getAttribute("DINNER");
            Collections.shuffle(display);
            for (Food food : display) {
                if (calo <= limit * 1.15) {
                    calo += food.getCalories();
                    System.out.println("ADD");
                    dinner.add(food);
                } else {
                    calo = 0;
                    display.clear();
                    break;
                }

            }

            url = SUCCESS;
            HttpSession session = request.getSession();
            session.setAttribute("BREAKFAST", breakfast);
            session.setAttribute("LUNCH", lunch);
            session.setAttribute("DINNER", dinner);
            System.out.println(((List<Food>) session.getAttribute("BREAKFAST")).size());
            System.out.println(((List<Food>) session.getAttribute("LUNCH")).size());
            System.out.println(((List<Food>) session.getAttribute("DINNER")).size());
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
