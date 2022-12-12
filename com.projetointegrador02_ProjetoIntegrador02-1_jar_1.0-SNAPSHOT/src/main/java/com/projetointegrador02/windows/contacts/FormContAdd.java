/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.projetointegrador02.windows.contacts;

import com.projetointegrador02.Env;
import com.projetointegrador02.database.ContactDao;
import com.projetointegrador02.database.DatabaseConnection;
import com.projetointegrador02.entities.Contact;
import com.projetointegrador02.entities.User;
import com.projetointegrador02.validators.TreatmentException;
import com.projetointegrador02.windows.Home;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class FormContAdd extends javax.swing.JFrame {
    private Contact current;
    private Contact contact;   
    /**
     * Creates new form FormContAdd
     * @param contact
     * @param current
     */
    // seleção da tabela
    public FormContAdd(Contact current, Contact contact) {
        initComponents();
        this.current = current;
        this.contact = contact;   
        initFromTable();
    }
    //runable
    public FormContAdd() {
        initComponents();         
    }
    //sem tabela
    public FormContAdd(Contact current) {
        initComponents(); 
        this.current = current;
    }
        
    private void initFromTable() {
        idField.setText(String.valueOf(contact.getContactId().getId()));
        idField.setEditable(false);
    } 
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbID = new javax.swing.JLabel();
        lbCont = new javax.swing.JLabel();
        contactNameField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar contato");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lbID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbID.setLabelFor(idField);
        lbID.setText("ID do Usuário:");

        lbCont.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbCont.setLabelFor(contactNameField);
        lbCont.setText("Nome do Contato:");

        contactNameField.setColumns(11);
        contactNameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        contactNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNameFieldActionPerformed(evt);
            }
        });

        idField.setColumns(15);
        idField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSave.setText("Salvar Contato");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbCont)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(contactNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbID)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCont)
                    .addComponent(contactNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contactNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNameFieldActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        try {      
             
            validateRequiredFields();
            DatabaseConnection databaseConnection = new DatabaseConnection(
                "root", Env.getPass(), "manager_messages", "localhost", 3306);
            ContactDao contactDao = new ContactDao(databaseConnection);  
            
            if (this.getTitle().startsWith("E")) { //update              
                Contact contactFU = new Contact(Home.getIdForUpdate());                             
                contactFU.setContactName(contactNameField.getText());
                contactDao.update(contactFU);
                JOptionPane.showMessageDialog(rootPane, "Contato atualizado com sucesso!", 
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
            } else { //save
                Contact contactSave = new Contact();
                contactSave.setContactName(contactNameField.getText());
                contactSave.setCurrentId(new User(current.getCurrentId().getId()));
                //NullPointer Treatment
                if (contact != null) { //initFromTable
                    contactSave.setContactId(contact.getContactId());
                } else { //initNoTable
                    Contact contactId = new Contact();              
                    contactId.setContactId(new User(Integer.parseInt(idField.getText())));
                    contactSave.setContactId(contactId.getContactId());
                }
                
                if (Home.validateNotYou(contactSave) && Home.validateFirstCont(current, contactSave)) {
                    contactDao.save(contactSave); 
                    JOptionPane.showMessageDialog(rootPane, "Contato adicionado com sucesso!", 
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                }  
            }    
        } catch (TreatmentException treatmentException) {
        JOptionPane.showMessageDialog(rootPane, treatmentException.getMessage(),
            "Campos inválidos", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            switch (ex.getErrorCode()) {
                case 1452 -> JOptionPane.showMessageDialog(rootPane, 
                            "ID do usuário foi excluido ou não existe",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                case 1062 -> JOptionPane.showMessageDialog(rootPane, String.format(
                            "Usuário já adicionado como '%s'",
                            contact
                            ), "Erro", JOptionPane.ERROR_MESSAGE);
                default -> JOptionPane.showMessageDialog(rootPane,           
                        "Erro inesperado aconteceu! " + ex.getErrorCode() + ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }    
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (this.getTitle().startsWith("E")) {
            Contact contactFU = Home.getContactInitForUpdate(); 
            idField.setText(String.valueOf(contactFU.getContactId().getId()));
            idField.setEditable(false);
            contactNameField.setText(contactFU.getContactName());
        }    
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormContAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormContAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormContAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormContAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormContAdd().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField contactNameField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel lbCont;
    private javax.swing.JLabel lbID;
    // End of variables declaration//GEN-END:variables
    private void validateRequiredFields() throws TreatmentException {
        if ((idField.getText().isBlank())||(contactNameField.getText().isBlank())) {           
            throw new TreatmentException("Todos os campos são obrigatórios!");
        }    
    }   
}