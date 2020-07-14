/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tien.utils.SQLUtils;
import tien.webservice.Food;

/**
 *
 * @author Admin
 */
public class FoodDAO implements Serializable{

    public boolean insertFood(Food food) throws ClassNotFoundException, SQLException {
        boolean result = false;
        String query = "Insert into Food (href, src, image, title, cookingMethod, materialDescription, carbonhydrate, fiber, fat, protein, calories) values (?, ?, ?, ?, ?, ?, ? ,? ,? ,? ,?)";
        try (Connection conn = SQLUtils.getConnection();
                PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setString(1, food.getHref());
            pstm.setString(2, "");
            pstm.setString(3, food.getImage());
            pstm.setString(4, food.getTitle());

            pstm.setString(5, "");
            pstm.setString(6, "");

            pstm.setFloat(7, 0);
            pstm.setFloat(8, 0);
            pstm.setFloat(9, 0);
            pstm.setFloat(10, 0);
            pstm.setFloat(11, 0);
            result = pstm.executeUpdate() > 0;
        }
        System.out.println("insertFood successfully");
        return result;
    }

    public List<Food> selectFood() throws ClassNotFoundException, SQLException {
        List<Food> list = new ArrayList<>();

        String query = "Select * from Food";
        try (Connection conn = SQLUtils.getConnection();
                PreparedStatement pstm = conn.prepareStatement(query)) {
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");

                    String href = rs.getString("href") == null ? "" : rs.getString("href");
                    String src = rs.getString("src") == null ? "" : rs.getString("src");
                    String image = rs.getString("image") == null ? "" : rs.getString("image");
                    String title = rs.getString("title") == null ? "" : rs.getString("title");
                    String cookingMethod = rs.getString("cookingMethod") == null ? "" : rs.getString("cookingMethod");
                    String materialDescription = rs.getString("materialDescription") == null ? "" : rs.getString("materialDescription");

                    Double carbonhydrate = rs.getFloat("carbonhydrate") * 1.0;
                    Double fiber = rs.getFloat("fiber") * 1.0;
                    Double fat = rs.getFloat("fat") * 1.0;
                    Double protein = rs.getFloat("protein") * 1.0;
                    Double calories = rs.getFloat("calories") * 1.0;

                    Food food = new Food();
                    food.setId(id);

                    food.setHref(href);
                    food.setSrc(src);
                    food.setImage(image);
                    food.setTitle(title);
                    food.setMaterialDescription(materialDescription);
                    food.setCookingMethod(cookingMethod);

                    food.setCalories(calories);
                    food.setCarbonhydrate(carbonhydrate);
                    food.setProtein(protein);
                    food.setFat(fat);
                    food.setFiber(fiber);

                    list.add(food);
                }
            }
        }
        System.out.println("selectFood successfully");
//        for (Food item : list) {
//            System.out.println(item.getTitle() + " =========== " + item.getId());
//        }
        return list;
    }

    public boolean updateFood(Food food) throws ClassNotFoundException, SQLException {
        boolean result = false;

        String query = "Update Food Set cookingMethod=?, materialDescription=?, carbonhydrate=?, fiber=?, fat=?, protein=?, calories=? Where id = ?";
        try (Connection conn = SQLUtils.getConnection();
                PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setString(1, food.getCookingMethod() == null ? "" : food.getCookingMethod());
            pstm.setString(2, food.getMaterialDescription() == null ? "" : food.getMaterialDescription());
            pstm.setFloat(3, food.getCarbonhydrate().floatValue());
            pstm.setFloat(4, food.getFiber().floatValue());
            pstm.setFloat(5, food.getFat().floatValue());
            pstm.setFloat(6, food.getProtein().floatValue());
            pstm.setFloat(7, food.getCalories().floatValue());
            pstm.setInt(8, food.getId());
            result = pstm.executeUpdate() > 0;
        }
        System.out.println("updateFood successfully");
        return result;
    }
}
