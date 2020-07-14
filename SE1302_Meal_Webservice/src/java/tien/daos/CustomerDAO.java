/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tien.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tien.utils.SQLUtils;

/**
 *
 * @author Admin
 */
public class CustomerDAO implements Serializable {

    public boolean insert(String txtName,
            String txtEmail,
            String txtMessage) throws ClassNotFoundException, SQLException {
        boolean result = false;
        String query = "INSERT INTO Customer ( email, subscription, fullname) VALUES ( ?, ?, ?)";
        try (Connection conn = SQLUtils.getConnection();
                PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setString(1, txtEmail);
            pstm.setInt(2, 1);
            pstm.setString(3, txtName);
            
            result = pstm.executeUpdate() > 0;
        }
        System.out.println("insertCustomer successfully");
        return result;
    }
}
