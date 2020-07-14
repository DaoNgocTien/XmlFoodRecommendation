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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import tien.daos.FoodMaterialDAO;
import tien.daos.MaterialDAO;
import tien.webservice.Food;
import tien.webservice.Material;

/**
 *
 * @author Admin
 */
public class MaterialComparation implements Serializable {

    public static Food compareMaterial( List<Material> listMaterial, String materialCooking, Food food) throws MalformedURLException, IOException, ClassNotFoundException, SQLException, Exception {

        int materialID = 0;
        Collections.shuffle(listMaterial);
        for (Material material : listMaterial) {
            try {
                materialID = material.getId();
                URL url = new URL("https://www.tools4noobs.com/?action=ajax_string_similarity&text=" + material.getFoodname().replace(" ", "").trim() + "&text2=" + materialCooking.replace(" ", "").trim() + "&limit=0.4");
                URLConnection urlConnection = url.openConnection();
                urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
                try (InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8);
                        BufferedReader br = new BufferedReader(isr)) {
                    String line = br.readLine().replace("<div class=\"well\">Strings match around: ", "").replace("%.</div>", "").trim();

                    if (Double.parseDouble(line) > 35) {
                        food.setCalories(food.getCalories() + material.getCalories()/3);
                        food.setCarbonhydrate(food.getCarbonhydrate() + material.getCarbonhydrate()/3);
                        food.setFat(food.getFat() + material.getFat()/3);
                        food.setFiber(food.getFiber() + material.getFiber()/3);
                        food.setProtein(food.getProtein() + material.getProtein()/3);
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //  Insert material mapping for food
        FoodMaterialDAO dao = new FoodMaterialDAO();
        dao.insertFoodMaterial(food.getId(), materialID);

        return food;
    }
}
