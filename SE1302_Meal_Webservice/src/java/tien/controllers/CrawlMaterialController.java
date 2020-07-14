/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;
//import tien.jaxb.obj.Materials;
import tien.daos.MaterialDAO;
import tien.jaxb.JAXBUnmarshalling;
import tien.jaxb.XJCGenerateJavaObject;
import tien.jaxb.obj.Attributes;
import tien.jaxb.obj.Materials;
import tien.service.WriteIntoFile;
import tien.service.XMLIntoValidatedXML;
import tien.service.thehinh365.PreProcessHtmlIntoXML;

/**
 *
 * @author Admin
 */
public class CrawlMaterialController extends HttpServlet {

    private static final String SCHEMA_FILE = "/WEB-INF/material.xsd";
    private static final String RAW_MATERIAL = "/WEB-INF/rawMaterial.xml";
    private static final String XSL_FILE = "/WEB-INF/material.xsl";
    private static final String VALIDATED_XML = "/WEB-INF/validatedXML.xml";
    private static String REAL = "D:\\DaoNgocTien\\SE1302_Meal_Webservice\\web";

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String content = "";

            //  Pre process html content into line
            content = PreProcessHtmlIntoXML.preProcessHtmlIntoXML();
//            System.out.println(content);
            //  Write content into xml file to check
            File rawMaterialXMLFile = new File(REAL + RAW_MATERIAL);
            WriteIntoFile.writeIntoFile(rawMaterialXMLFile, content);

            //  Transform raw xml file into validated xml file
            File validatedXML = new File(REAL + VALIDATED_XML);
            XMLIntoValidatedXML.transformXMLIntoValidatedXML(REAL + XSL_FILE, validatedXML, content);

            //  Generate Java Pojo Obj by JAXB and Schema
            File schemaFile = new File(REAL + SCHEMA_FILE);
            XJCGenerateJavaObject.generateJavaObject(schemaFile);

            //  Generate Object from JAXB unmarshalling and validated xml
            Materials material = JAXBUnmarshalling.JAXBUnmarshalling(validatedXML);
            for (Attributes attributes : material.getMaterial()) {
                System.out.println(attributes.getFoodname() + " ============ " + attributes.getCarbonhydrate());
            }

            //  Insert into database
            MaterialDAO dao = new MaterialDAO();
            dao.insertMaterial(material.getMaterial());
        } catch (IOException | ClassNotFoundException | SQLException | JAXBException | TransformerException e) {
            e.printStackTrace();
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String realPath = getServletContext().getRealPath("/");

            String content = "";

            //  Pre process html content into line
            content = PreProcessHtmlIntoXML.preProcessHtmlIntoXML();

            //  Write content into xml file to check
            File rawMaterialXMLFile = new File(realPath + RAW_MATERIAL);
            WriteIntoFile.writeIntoFile(rawMaterialXMLFile, content);

            //  Generate Java Pojo Obj by JAXB and Schema
            File schemaFile = new File(realPath + SCHEMA_FILE);
            XJCGenerateJavaObject.generateJavaObject(schemaFile);
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
