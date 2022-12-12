/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.projetointegrador02.windows.messages;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class FormMenAdd extends javax.swing.JFrame {

    /**
     * Creates new form FormContAdd
     */
    public FormMenAdd() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNome = new javax.swing.JLabel();
        labelTel = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        btnSalEnv = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        btnSal = new javax.swing.JButton();
        btnExc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar mensagem");

        labelNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNome.setLabelFor(fieldNome);
        labelNome.setText("Contato Destino:");

        labelTel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelTel.setLabelFor(textArea);
        labelTel.setText("Mensagem:");

        fieldNome.setColumns(15);
        fieldNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNomeActionPerformed(evt);
            }
        });

        btnSalEnv.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalEnv.setText("Enviar");
        btnSalEnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalEnvActionPerformed(evt);
            }
        });

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textArea.setLineWrap(true);
        textArea.setRows(10);
        textArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textArea.setMaximumSize(new java.awt.Dimension(800, 800));
        jScrollPane1.setViewportView(textArea);

        btnSal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSal.setText("Salvar ");
        btnSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalActionPerformed(evt);
            }
        });

        btnExc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnExc.setText("Excluir");
        btnExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(labelNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelTel))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalEnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSal, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(btnExc, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTel)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalEnv)
                        .addGap(30, 30, 30)
                        .addComponent(btnSal)
                        .addGap(30, 30, 30)
                        .addComponent(btnExc)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNomeActionPerformed

    private void btnSalEnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalEnvActionPerformed
        // TODO add your handling code here:
        String noneData = "";
        JOptionPane jo = new JOptionPane();
        if ((this.fieldNome.getText().equals(noneData)) || (this.textArea.getText().equals(noneData))) {           
            jo.showMessageDialog(rootPane, "Preencha todos os campos corretamente!",
                "Campos inválidos", JOptionPane.ERROR_MESSAGE);
        } else {      
            jo.showMessageDialog(rootPane, "Mensagem enviada com sucesso!",
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnSalEnvActionPerformed

    private void btnSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalActionPerformed
        // TODO add your handling code here:
        String noneData = "";
        JOptionPane jo = new JOptionPane();
        if ((this.fieldNome.getText().equals(noneData)) || (this.textArea.getText().equals(noneData))) {           
            jo.showMessageDialog(rootPane, "Preencha todos os campos corretamente!",
                "Campos inválidos", JOptionPane.ERROR_MESSAGE);
        } else {      
            jo.showMessageDialog(rootPane, "Mensagem salva com sucesso!",
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSalActionPerformed

    private void btnExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcActionPerformed
        int end = JOptionPane.showConfirmDialog(
                this, "Tem certeza que deseja excluir a mensagem?",
                "Excluir Mensagem", WIDTH, JOptionPane.WARNING_MESSAGE
        );
        if (end == 0) {
            this.setVisible(false);
        } else {
            this.setVisible(true);
        }
    }//GEN-LAST:event_btnExcActionPerformed

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
            java.util.logging.Logger.getLogger(FormMenAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormMenAdd().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExc;
    private javax.swing.JButton btnSal;
    private javax.swing.JButton btnSalEnv;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTel;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}