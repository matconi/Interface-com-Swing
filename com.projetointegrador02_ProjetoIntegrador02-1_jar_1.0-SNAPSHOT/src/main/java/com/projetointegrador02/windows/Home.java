/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.projetointegrador02.windows;

import com.projetointegrador02.Env;
import com.projetointegrador02.database.ContactDao;
import com.projetointegrador02.database.DatabaseConnection;
import com.projetointegrador02.database.UserDao;
import com.projetointegrador02.entities.User;
import com.projetointegrador02.windows.contacts.FormContAdd;
import com.projetointegrador02.windows.users.FormLogin;
import com.projetointegrador02.entities.Contact;
import com.projetointegrador02.validators.TreatmentException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Usuario
 */
public class Home extends javax.swing.JFrame {
    private static User currentUser;

    /** Creates new form Home
     * @param currentUser */
 
    public Home(User currentUser) {
        initComponents();
        Home.currentUser = currentUser;
        scrollUserTable.setVisible(false);
        deleteBtn.setVisible(false);
        deselectBtn.setVisible(false);
    }
    public Home() {
        initComponents();
    }
    
    private void loadUserTable() throws SQLException {
        scrollUserTable.setVisible(true);
    
        DatabaseConnection databaseConnection = new DatabaseConnection(
            "root", Env.getPass(), "manager_messages", "localhost", 3306);
        
        UserDao userDao = new UserDao(databaseConnection);
        Vector<User> users = userDao.findAll();
        DefaultTableModel userModel = (DefaultTableModel) userTable.getModel();
        for (User user : users) {
            String userName = user.getUserName();
            if (user.getId() == currentUser.getId()) {
                userName = currentUser.getUserName().concat("[você]"); 
            }
            userModel.addRow(new Object[]{
            user.getId(), userName 
            });             
        }
        deleteBtn.setVisible(true);
        loadBtn.setEnabled(false); 
        deselectBtn.setVisible(true);
    }
    
    private void deleteCurrentUser() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection(
            "root", Env.getPass(), "manager_messages", "localhost", 3306);
        
        UserDao userDao = new UserDao(databaseConnection);
        userDao.delete(currentUser);

        scrollUserTable.setVisible(false);
        deleteBtn.setVisible(false);
        addContBtn.setEnabled(false);
        JOptionPane.showMessageDialog(rootPane,
            "Usuário excluido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean validateNotYou(Contact idContact) throws TreatmentException {
        if (currentUser.getId() == idContact.getContactId().getId()) {
            throw new TreatmentException("Não pode adicionar a si mesmo!");
        }
        return true;
    }
    
    public static boolean validateFirstCont(Contact idCurrent, Contact idContact) throws TreatmentException {
        try {           
            DatabaseConnection databaseConnection = new DatabaseConnection(
            "root", Env.getPass(), "manager_messages", "localhost", 3306);
            
            ContactDao contactDao = new ContactDao(databaseConnection);
            ResultSet rs = contactDao.first(idCurrent, idContact);
            if (rs.next()) {
                throw new TreatmentException(String.format(
                    "Contato já adicionado como '%s'", rs.getString("contactname").toUpperCase()));
            }         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                "Erro inesperado aconteceu! " + ex.getErrorCode() + ex.getMessage(),
                "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
        return true;
    }
    private void loadContTable() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection(
            "root", Env.getPass(), "manager_messages", "localhost", 3306);
        ContactDao contactDao = new ContactDao(databaseConnection);    
  
        Vector<Contact> contacts = contactDao.findAll(currentUser);
        DefaultTableModel contModel = (DefaultTableModel) contTable.getModel();
        for (Contact contact : contacts) {
            contModel.addRow(new Object[]{
                contact.getContactName(), contact.getContactId().getId(), contact.getId()
            });
            //contact.setId(contact.getId());                      
        }   
    }
    
    public static Contact getContactInitForUpdate() {
        int rowSelected = contTable.getSelectedRow();        
        //using setters
        //contact.setContactName((String) contTable.getValueAt(rowSelected, 0));
        //contact.setContactId(new User((int) contTable.getValueAt(rowSelected, 1)));
        //using constructor
        return new Contact(
            (String) contTable.getValueAt(rowSelected, 0),
            new User((int) contTable.getValueAt(rowSelected, 1))
        );
    }
    public static int getIdForUpdate() {
        return (int) contTable.getValueAt(contTable.getSelectedRow(), 2);
    }
    
    private void deleteContact() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection(
            "root", Env.getPass(), "manager_messages", "localhost", 3306);
        ContactDao contactDao = new ContactDao(databaseConnection);
       
        Contact contact = new Contact(getIdForUpdate());
        contactDao.delete(contact);

        JOptionPane.showMessageDialog(rootPane,
            "Contato excluido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMsgTab = new javax.swing.JTabbedPane();
        userPanel = new javax.swing.JPanel();
        scrollUserTable = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        loadBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        addContBtn = new javax.swing.JButton();
        addUserBtn = new javax.swing.JButton();
        deselectBtn = new javax.swing.JButton();
        contPanel = new javax.swing.JPanel();
        scrollContTable = new javax.swing.JScrollPane();
        contTable = new javax.swing.JTable();
        excContBtn = new javax.swing.JButton();
        editContBtn = new javax.swing.JButton();
        sendBtn = new javax.swing.JButton();
        messagePanel = new javax.swing.JPanel();
        addDirectPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager Messages");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        addMsgTab.setBackground(new java.awt.Color(0, 51, 153));
        addMsgTab.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addMsgTab.setForeground(new java.awt.Color(255, 255, 255));
        addMsgTab.setToolTipText("");
        addMsgTab.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        userPanel.setBackground(new java.awt.Color(0, 51, 153));
        userPanel.setPreferredSize(new java.awt.Dimension(600, 350));

        userTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userTable.setAlignmentX(0.0F);
        userTable.setAlignmentY(0.0F);
        userTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        userTable.setGridColor(new java.awt.Color(0, 51, 153));
        userTable.setRowHeight(25);
        userTable.setSelectionBackground(new java.awt.Color(0, 102, 204));
        userTable.setShowVerticalLines(true);
        scrollUserTable.setViewportView(userTable);
        if (userTable.getColumnModel().getColumnCount() > 0) {
            userTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            userTable.getColumnModel().getColumn(1).setPreferredWidth(115);
        }

        loadBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        loadBtn.setText("Carregar Usuários");
        loadBtn.setToolTipText("Carrega a lista com todos os usuários. Só pode ser feito uma vez.");
        loadBtn.setBorder(null);
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setActionCommand("Excluir o Seu Usuário");
        deleteBtn.setLabel("Excluir o Seu Usuário");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        addContBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addContBtn.setText("Adicionar Contato");
        addContBtn.setToolTipText("Adiciona um usuário  na sua lista de contatos.");
        addContBtn.setBorder(null);
        addContBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContBtnActionPerformed(evt);
            }
        });

        addUserBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        addUserBtn.setText("Nova Sessão ");
        addUserBtn.setToolTipText("Abre uma nova janela de login. Atenção: ao fechar \nqualquer menu principal todas as sessões serão encerradas!");
        addUserBtn.setBorder(null);
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        deselectBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deselectBtn.setText("Retirar Seleção");
        deselectBtn.setToolTipText("Retira a seleção da tabela");
        deselectBtn.setBorder(null);
        deselectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deselectBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollUserTable, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addContBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addUserBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(loadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deselectBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(scrollUserTable, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(loadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addContBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deselectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        addUserBtn.getAccessibleContext().setAccessibleDescription("Abre uma nova janela de login. ");

        addMsgTab.addTab("   Usuários   ", userPanel);

        contPanel.setBackground(new java.awt.Color(0, 51, 153));

        contTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        contTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "ID do Usuário", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        contTable.setAlignmentX(1.0F);
        contTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        contTable.setGridColor(new java.awt.Color(102, 153, 255));
        contTable.setRowHeight(25);
        contTable.setSelectionBackground(new java.awt.Color(0, 102, 204));
        scrollContTable.setViewportView(contTable);
        if (contTable.getColumnModel().getColumnCount() > 0) {
            contTable.getColumnModel().getColumn(0).setPreferredWidth(400);
            contTable.getColumnModel().getColumn(1).setPreferredWidth(325);
            contTable.getColumnModel().getColumn(2).setMinWidth(0);
            contTable.getColumnModel().getColumn(2).setPreferredWidth(0);
            contTable.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        excContBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        excContBtn.setText("Excluir");
        excContBtn.setToolTipText("");
        excContBtn.setBorder(null);
        excContBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excContBtnActionPerformed(evt);
            }
        });

        editContBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        editContBtn.setText("Editar");
        editContBtn.setToolTipText("");
        editContBtn.setBorder(null);
        editContBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editContBtnActionPerformed(evt);
            }
        });

        sendBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        sendBtn.setText("Enviar Mensagem");
        sendBtn.setToolTipText("");
        sendBtn.setBorder(null);
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contPanelLayout = new javax.swing.GroupLayout(contPanel);
        contPanel.setLayout(contPanelLayout);
        contPanelLayout.setHorizontalGroup(
            contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollContTable, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contPanelLayout.createSequentialGroup()
                        .addComponent(editContBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(excContBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208)
                        .addComponent(sendBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        contPanelLayout.setVerticalGroup(
            contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(scrollContTable, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(excContBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editContBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        addMsgTab.addTab("   Contatos   ", contPanel);

        messagePanel.setBackground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout messagePanelLayout = new javax.swing.GroupLayout(messagePanel);
        messagePanel.setLayout(messagePanelLayout);
        messagePanelLayout.setHorizontalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );
        messagePanelLayout.setVerticalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        addMsgTab.addTab("   Mensagens   ", messagePanel);

        addDirectPanel.setBackground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout addDirectPanelLayout = new javax.swing.GroupLayout(addDirectPanel);
        addDirectPanel.setLayout(addDirectPanelLayout);
        addDirectPanelLayout.setHorizontalGroup(
            addDirectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );
        addDirectPanelLayout.setVerticalGroup(
            addDirectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        addMsgTab.addTab("   +   ", addDirectPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addMsgTab, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addMsgTab)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
        int end = JOptionPane.showConfirmDialog(rootPane,
                "Fechar o menu principal encerrará as sessões e a aplicação.\nTem certeza que deseja fazer isso?",
                "Encerrar Programa", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
        );
        if (end == 0) {
            this.setVisible(false);
            System.exit(0);
        } else {
            this.getDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {               
            loadContTable();                                 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, 
                "Erro inesperado aconteceu! " + ex.getErrorCode() + ex.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void excContBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excContBtnActionPerformed
        int end = JOptionPane.showConfirmDialog(rootPane, String.format(
            "Tem certeza que deseja excluir o contato '%s'?",
            contTable.getValueAt(contTable.getSelectedRow(), 0)).toUpperCase(),
            "Excluir Contato", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (end == 0) {
            try {
                deleteContact();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane,
                    "Erro inesperado aconteceu! " + ex.getErrorCode() + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_excContBtnActionPerformed

    private void editContBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editContBtnActionPerformed
        if (contTable.getSelectedRow() != -1) {
            FormContAdd formContAdd = new FormContAdd();            
            formContAdd.setTitle("Editar contato");
            formContAdd.setVisible(true);
        }     
    }//GEN-LAST:event_editContBtnActionPerformed

    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBtnActionPerformed
        try {
            loadUserTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,
                "Erro na consulta aconteceu! " + ex.getErrorCode() + ex.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loadBtnActionPerformed

    private void addContBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addContBtnActionPerformed
        FormContAdd formContAdd = null; 
        int rowSelected = userTable.getSelectedRow();
        //User u = new User(currentUser.getId());
        Contact currentId = new Contact(new User(currentUser.getId()));
       // try {
            if (rowSelected != -1) { //table

                Contact contactId = new Contact();
                contactId.setContactId(new User((int) userTable.getValueAt(rowSelected, 0))); 

                   // if (validateNotYou(contactId) && validateFirstCont(currentId, contactId)) {
                        formContAdd = new FormContAdd(currentId, contactId);
                   // }
                    
            } else { //no table
                formContAdd = new FormContAdd(currentId);
            }      
        formContAdd.setVisible(true);
       // } catch (TreatmentException treatmentException) {
       //     JOptionPane.showMessageDialog(rootPane, treatmentException.getMessage(),
       //     "Ação inválida", JOptionPane.ERROR_MESSAGE);
       // }
        
    }//GEN-LAST:event_addContBtnActionPerformed

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        FormLogin formLogin = new FormLogin();
        formLogin.setVisible(true);
    }//GEN-LAST:event_addUserBtnActionPerformed

    private void deselectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deselectBtnActionPerformed
        if (userTable.getSelectedRow() != -1) {
            userTable.clearSelection();
        }
    }//GEN-LAST:event_deselectBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int end = JOptionPane.showConfirmDialog(rootPane, String.format(
            "O usuário '%s' será excluido de todas as listas de contatos.\n Tem certeza que deseja fazer isso?",
            currentUser.getUserName().toUpperCase()),
        "Excluir Usuário", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (end == 0) {
            try {
                deleteCurrentUser();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane,
                    "Erro inesperado aconteceu! " + ex.getErrorCode() + ex.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addContBtn;
    private javax.swing.JPanel addDirectPanel;
    private javax.swing.JTabbedPane addMsgTab;
    private javax.swing.JButton addUserBtn;
    private javax.swing.JPanel contPanel;
    private static javax.swing.JTable contTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deselectBtn;
    private javax.swing.JButton editContBtn;
    private javax.swing.JButton excContBtn;
    private javax.swing.JButton loadBtn;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JScrollPane scrollContTable;
    private javax.swing.JScrollPane scrollUserTable;
    private javax.swing.JButton sendBtn;
    private javax.swing.JPanel userPanel;
    public javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables

    private void getDefaultCloseOperation(int DO_NOTHING_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
