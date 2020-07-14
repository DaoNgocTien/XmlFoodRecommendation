/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tien.daos.FoodDAO;
import tien.daos.MaterialDAO;
//import tien.jaxb.obj.Materials;
import tien.service.WriteIntoFile;
import tien.service.kitchenart.PreProcessDetailHtmlIntoXML;
import tien.service.kitchenart.PreProcessHrefHtmlIntoXML;
import tien.stax.ConvertXMLIntoObjectByStAX;
import tien.webservice.Food;
import tien.webservice.Material;
import tien.webservice.service.FoodFacadeREST;

/**
 *
 * @author Admin
 */
public class CrawlFoodController extends HttpServlet {

    private static FoodFacadeREST foodFacadeREST = null;
    private static EntityManager em = null;
    private static final String SCHEMA_FILE = "/WEB-INF/material.xsd";
    private static final String RAW_FOOD = "/WEB-INF/rawFood.xml";
    private static final String XSL_FILE = "/WEB-INF/material.xsl";
    private static final String VALIDATED_XML = "/WEB-INF/validatedXML.xml";
    private static String REAL = "D:\\DaoNgocTien\\SE1302_Meal_Webservice\\web";

    public static void main(String[] args) {
        try {
//            String content = "";
//
//            //  Pre process html content into line
//            content = PreProcessHrefHtmlIntoXML.preProcessHrefHtmlIntoXML();
//
//            //  Write content into xml file to check
//            File rawFoodXML = new File(REAL + RAW_FOOD);
//            WriteIntoFile.writeIntoFile(rawFoodXML, content);
//
//            //  Convert xml file into object by StAX
//            ConvertXMLIntoObjectByStAX StAX = new ConvertXMLIntoObjectByStAX();
//            List<Food> list = StAX.convertXMLFoodIntoObjectByStAX(rawFoodXML);

            //  Insert food into database
            FoodDAO dao = new FoodDAO();
//            for (Food food : list) {
//                dao.insertFood(food);
//            }

            //  Select all food with id
          List<Food>  list = dao.selectFood();
            for (Food food : list) {
                food.setCalories(Math.round(food.getCalories()) * 1.0);
                food.setCarbonhydrate(Math.round(food.getCarbonhydrate()) * 1.0);
                food.setFiber(Math.round(food.getFiber()) * 1.0);
                food.setFat(Math.round(food.getFat()) * 1.0);
                food.setProtein(Math.round(food.getProtein()) * 1.0);
                dao.updateFood(food);
            }

//            //  for each food, get the cooking method and material and energy, then update food
//            MaterialDAO materialDao = new MaterialDAO();
//            List<Material> listMaterial = materialDao.selectMaterial();
//            for (int i = 335; i < list.size(); i++) {
////                Food food = list.get(i);
////                list.remove(i);
//                PreProcessDetailHtmlIntoXML.preProcessDetailHtmlIntoXML( listMaterial, list.get(i));
////                dao.updateFood(food);
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrawlFoodController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrawlFoodController at " + request.getContextPath() + "</h1>");
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
