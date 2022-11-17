/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.projetointegrador02.windows;

import com.projetointegrador02.Env;
import com.projetointegrador02.database.DatabaseConnection;
import com.projetointegrador02.database.UserCrud;
import com.projetointegrador02.entities.User;
import com.projetointegrador02.windows.contacts.FormContAdd;
import com.projetointegrador02.windows.users.FormLogin;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Usuario
 */
public class Home extends javax.swing.JFrame {
    private User currentUser;
    /** Creates new form Home
     * @param currentUser */
 
    public Home(User currentUser) {
        initComponents();
        this.currentUser = currentUser;
        scrollUserTable.setVisible(false);
        deleteBtn.setVisible(false);
    }
    public Home() {
        initComponents();
    }
    
    private void loadTable() throws SQLException {
        scrollUserTable.setVisible(true);
    
        DatabaseConnection databaseConnection = new DatabaseConnection(
            "root", Env.getPass(), "manager_messages", "localhost", 3306);
        UserCrud userCrud = new UserCrud(databaseConnection);
        Vector<User> users = userCrud.loadUsers();
        DefaultTableModel model = (DefaultTableModel) userTable.getModel();
        for (User user : users) {
            String userName = user.getUserName();
            if (user.getId() == currentUser.getId()) {
                userName = currentUser.getUserName().concat(" (você)"); 
            }
            model.addRow(new Object[]{
            user.getId(), userName 
            });             
        }
        deleteBtn.setVisible(true);
        loadBtn.setEnabled(false);     
    }
    
    private void deleteCurrentUser() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection(
            "root", Env.getPass(), "manager_messages", "localhost", 3306);
        UserCrud userCrud = new UserCrud(databaseConnection);
        userCrud.delete((int) currentUser.getId());

        scrollUserTable.setVisible(false);
        deleteBtn.setVisible(false);
        addContBtn.setEnabled(false);
        JOptionPane.showMessageDialog(rootPane, "Usuário excluido com sucesso!");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        userPanel = new javax.swing.JPanel();
        scrollUserTable = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        loadBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        addContBtn = new javax.swing.JButton();
        blockBtn = new javax.swing.JButton();
        addUserBtn = new javax.swing.JButton();
        contPanel = new javax.swing.JPanel();
        userPanel1 = new javax.swing.JPanel();
        messagePanel = new javax.swing.JPanel();
        userPanel2 = new javax.swing.JPanel();

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

        tabbedPane.setBackground(new java.awt.Color(0, 51, 153));
        tabbedPane.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tabbedPane.setForeground(new java.awt.Color(255, 255, 255));
        tabbedPane.setToolTipText("");
        tabbedPane.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        userPanel.setBackground(new java.awt.Color(0, 51, 153));

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
        userTable.setAlignmentX(1.0F);
        userTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        scrollUserTable.setViewportView(userTable);
        if (userTable.getColumnModel().getColumnCount() > 0) {
            userTable.getColumnModel().getColumn(0).setResizable(false);
            userTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            userTable.getColumnModel().getColumn(1).setPreferredWidth(95);
        }

        loadBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loadBtn.setText("Carregar Usuários");
        loadBtn.setToolTipText("Carrega a lista com todos os usuários. Só pode ser feito uma vez.");
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setActionCommand("Excluir o Seu Usuário");
        deleteBtn.setLabel("Excluir o Seu Usuário");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        addContBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addContBtn.setText("Adicionar Contato");
        addContBtn.setToolTipText("Adiciona um usuário pela tabela ou pelo formulário na sua lista de contatos.");
        addContBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContBtnActionPerformed(evt);
            }
        });

        blockBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        blockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockBtnActionPerformed(evt);
            }
        });

        addUserBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addUserBtn.setText("Nova Sessão ");
        addUserBtn.setToolTipText("Abre uma nova janela de login. Atenção: ao fechar \nqualquer menu principal todas as sessões serão encerradas!");
        addUserBtn.setActionCommand("Nova Sessão ");
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addComponent(scrollUserTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addContBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(blockBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addUserBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(scrollUserTable, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userPanelLayout.createSequentialGroup()
                        .addComponent(loadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addContBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(blockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        tabbedPane.addTab("   Usuários   ", userPanel);

        userPanel1.setBackground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout userPanel1Layout = new javax.swing.GroupLayout(userPanel1);
        userPanel1.setLayout(userPanel1Layout);
        userPanel1Layout.setHorizontalGroup(
            userPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );
        userPanel1Layout.setVerticalGroup(
            userPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contPanelLayout = new javax.swing.GroupLayout(contPanel);
        contPanel.setLayout(contPanelLayout);
        contPanelLayout.setHorizontalGroup(
            contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
            .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(userPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        contPanelLayout.setVerticalGroup(
            contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(contPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(contPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(userPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tabbedPane.addTab("   Contatos   ", contPanel);

        userPanel2.setBackground(new java.awt.Color(0, 51, 153));

        javax.swing.GroupLayout userPanel2Layout = new javax.swing.GroupLayout(userPanel2);
        userPanel2.setLayout(userPanel2Layout);
        userPanel2Layout.setHorizontalGroup(
            userPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );
        userPanel2Layout.setVerticalGroup(
            userPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout messagePanelLayout = new javax.swing.GroupLayout(messagePanel);
        messagePanel.setLayout(messagePanelLayout);
        messagePanelLayout.setHorizontalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
            .addGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(messagePanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(userPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        messagePanelLayout.setVerticalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(messagePanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(userPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tabbedPane.addTab("   Mensagens   ", messagePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
        
        //JOptionPane jo = new JOptionPane(this, JOptionPane.WARNING_MESSAGE);
        int end = JOptionPane.showConfirmDialog(
                rootPane, "Fechar o menu principal encerrará a sessão e a aplicação.\nTem certeza que deseja fazer isso?",
                "Encerrar Programa", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE
        );
        if (end == 0) {
            this.setVisible(false);
            System.exit(0);
        } else {
            this.getDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBtnActionPerformed
        try {   
            loadTable();        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro na consulta aconteceu!" + ex.getErrorCode() + ex.getMessage());
        }
    }//GEN-LAST:event_loadBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int end = JOptionPane.showConfirmDialog(
            rootPane, String.format(
            "O usuário '%s' será excluido de todas as listas de contatos.\n Tem certeza que deseja fazer isso?", currentUser.getUserName().toUpperCase()),
            "Excluir Usuário", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (end == 0) {
            try {
                deleteCurrentUser();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro inesperado aconteceu!" + ex.getErrorCode() + ex.getMessage());
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
    }//GEN-LAST:event_formWindowOpened

    private void addContBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addContBtnActionPerformed
        FormContAdd formContAdd = new FormContAdd();
        formContAdd.setVisible(true);
    }//GEN-LAST:event_addContBtnActionPerformed

    private void blockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blockBtnActionPerformed

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        FormLogin formLogin = new FormLogin();
        formLogin.setVisible(true);
    }//GEN-LAST:event_addUserBtnActionPerformed

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
    private javax.swing.JButton addUserBtn;
    private javax.swing.JButton blockBtn;
    private javax.swing.JPanel contPanel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton loadBtn;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JScrollPane scrollUserTable;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JPanel userPanel;
    private javax.swing.JPanel userPanel1;
    private javax.swing.JPanel userPanel2;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables

    private void getDefaultCloseOperation(int DO_NOTHING_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
