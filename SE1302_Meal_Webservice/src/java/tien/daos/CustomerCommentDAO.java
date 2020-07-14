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
import java.sql.Date;
import tien.utils.SQLUtils;

/**
 *
 * @author Admin
 */
public class CustomerCommentDAO implements Serializable {

    public boolean insert(int id,
            String comment) throws ClassNotFoundException, SQLException {
        boolean result = false;
        String query = "INSERT INTO CustomerComment ( customerID, comment, createDate) VALUES ( ?, ?, ?)";
        try (Connection conn = SQLUtils.getConnection();
                PreparedStatement pstm = conn.prepareStatement(query)) {
            pstm.setInt(1, id);
            pstm.setString(2, comment);
            pstm.setDate(3, new Date(System.currentTimeMillis()));

            result = pstm.executeUpdate() > 0;
        }
        System.out.println("insertCustomerCommentDAO successfully");
        return result;
    }
}
