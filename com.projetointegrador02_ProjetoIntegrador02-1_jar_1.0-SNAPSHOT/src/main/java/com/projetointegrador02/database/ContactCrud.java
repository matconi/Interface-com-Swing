/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projetointegrador02.database;

import com.projetointegrador02.entities.Contact;
import com.projetointegrador02.entities.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ContactCrud {
    private DatabaseConnection databaseConnection;

    public ContactCrud(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
    //cadastro contato
    public int save(Contact contact) throws SQLException {
        String sql = "INSERT INTO contact (contactname, id_current, id_contact) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, contact.getcontactName());
        preparedStatement.setInt(2, contact.getCurrentId()); 
        preparedStatement.setInt(3, contact.getContactId());     

        return preparedStatement.executeUpdate();
    }
}
