/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import tien.utils.SQLUtils;

/**
 *
 * @author Admin
 */
public class FoodMaterialDAO implements Serializable {

    public boolean insertFoodMaterial(int foodID, int materialID) throws Exception {
        boolean result = false;
        if (materialID == 0) {
            String query = "Insert into FoodMaterial (foodID) values (?, ?)";
            try (Connection conn = SQLUtils.getConnection();
                    PreparedStatement pstm = conn.prepareStatement(query)) {
                pstm.setInt(1, foodID);
                result = pstm.executeUpdate() > 0;
            }
        } else {
            String query = "Insert into FoodMaterial (foodID, materialID) values (?, ?)";
            try (Connection conn = SQLUtils.getConnection();
                    PreparedStatement pstm = conn.prepareStatement(query)) {
                pstm.setInt(1, foodID);
                pstm.setInt(2, materialID);
                result = pstm.executeUpdate() > 0;
            }
        }

        System.out.println("insertFoodMaterial successfully");
        return result;
    }
}
