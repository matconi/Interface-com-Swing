/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetointegrador02.database;

import com.projetointegrador02.entities.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class UserCrud {
    private DatabaseConnection databaseConnection;

    public UserCrud(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public int save(User user) throws SQLException {
        String sql = "INSERT INTO user (username,password) VALUES (?,?)";
        PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        return preparedStatement.executeUpdate();
    }
    
}
