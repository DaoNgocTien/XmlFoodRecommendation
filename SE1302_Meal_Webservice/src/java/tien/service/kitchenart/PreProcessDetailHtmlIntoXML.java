/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.service.kitchenart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tien.controllers.CalculateFoodController;
import tien.daos.FoodDAO;
import tien.webservice.Food;
import tien.webservice.Material;

/**
 *
 * @author Admin
 */
public class PreProcessDetailHtmlIntoXML implements Serializable {

    public static Food preProcessDetailHtmlIntoXML(List<Material> list,Food food) throws MalformedURLException, IOException, ClassNotFoundException, SQLException {
        List<String> listMaterial = new ArrayList<>();

        URL url = new URL(food.getHref());
//        URL url = new URL("http://cook.kitchenart.vn/cong-thuc-nau-an/banh-meringue-kem-va-dau/");
        URLConnection urlConnection = url.openConnection();

        String materialCooking = "";
        String begin = "<div class=\"nguyen_lieu\">";
        String beginTool = "<div class=\"nguyen_lieu dung_cu\">";
        String beginCookingMethod = "cach_che_bien";
        String end = "<div style=\"margin: 20px 0; padding: 10px; border: 1px ";
        boolean start = false;
        boolean startTool = false;
        String line = "";
        String cookingMethod = "";
        String materials = "";

        try (InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr)) {
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.contains(begin) || line.contains(beginCookingMethod)) {
                    start = true;
                } else if (line.contains(beginTool)) {
                    start = false;
                    startTool = true;
                } else if (line.contains(end)) {
                    break;
                }

                if (start) {
                    if (startTool) {
                        cookingMethod += line + "\n";
                    } else {
                        if (line.contains("<span class=\"btn_muahang\">")) {

                            line = line.replace("<li><span class=\"btn_muahang\"><i class=\"fa fa-circle\" aria-hidden=\"true\"></i>", "");
                            line = line.replace("<a", "");
                            listMaterial.add(line);

                            materialCooking += "<span><i class=\"fa fa-circle\" aria-hidden=\"true\"></i>" + line + "</span>" + "\n";
                        }
                    }
                }

            }
        }
//        System.out.println(cookingMethod);
//        System.out.println(materialCooking);

        //  Add cooking method and material list
        food.setCookingMethod(cookingMethod);
        food.setMaterialDescription(materialCooking);
        
        //  Calculate energy then update food
        CalculateFoodController.calculateFoodEnergy(list, listMaterial, food);
//        
        return food;
    }
}
