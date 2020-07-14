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
import tien.jaxb.obj.Attributes;
import tien.utils.SQLUtils;
import tien.webservice.Material;

/**
 *
 * @author Admin
 */
public class MaterialDAO implements Serializable {

    public boolean insertMaterial(List<Attributes> list) throws ClassNotFoundException, SQLException {
        boolean result = false;
        String query = "Insert into Material (foodname, carbonhydrate, fiber, fat, protein, calories) values (?, ?, ?, ?, ?, ?)";
        try (Connection conn = SQLUtils.getConnection();
                PreparedStatement pstm = conn.prepareStatement(query)) {
            for (Attributes item : list) {
                pstm.setString(1, item.getFoodname());
                pstm.setFloat(2, Math.round((item.getCarbonhydrate().floatValue() * 100.0) / 100.0));
                pstm.setFloat(3, Math.round((item.getFiber().floatValue() * 100.0) / 100.0));
                pstm.setFloat(4, Math.round((item.getFat().floatValue() * 100.0) / 100.0));
                pstm.setFloat(5, Math.round((item.getProtein().floatValue() * 100.0) / 100.0));
                pstm.setFloat(6, Math.round((item.getCalories().floatValue() * 100.0) / 100.0));
                try {
                    result = pstm.executeUpdate() > 0;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(item.getFoodname() + " ============ " + item.getCarbonhydrate());
                }
            }
        }
        return result;
    }

    public List<Material> selectMaterial() throws ClassNotFoundException, SQLException {
        List<Material> list = new ArrayList<>();

        String query = "Select * from Material";
        try (Connection conn = SQLUtils.getConnection();
                PreparedStatement pstm = conn.prepareStatement(query)) {
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String foodname = rs.getString("foodname");
                    Double carbonhydrate = rs.getFloat("carbonhydrate") * 1.0;
                    Double fiber = rs.getFloat("fiber") * 1.0;
                    Double fat = rs.getFloat("fat") * 1.0;
                    Double protein = rs.getFloat("protein") * 1.0;
                    Double calories = rs.getFloat("calories") * 1.0;

                    Material material = new Material();
                    material.setId(id);
                    material.setFoodname(foodname);
                    material.setCalories(calories);
                    material.setCarbonhydrate(carbonhydrate);
                    material.setFat(fat);
                    material.setFiber(fiber);
                    material.setProtein(protein);

                    list.add(material);
                }
            }
        }
        System.out.println("selectMaterial successfully");
//        for (Food item : list) {
//            System.out.println(item.getTitle() + " =========== " + item.getId());
//        }
        return list;
    }
}
