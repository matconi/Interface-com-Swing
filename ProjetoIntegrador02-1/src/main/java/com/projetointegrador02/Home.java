/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.projetointegrador02;

/**
 *
 * @author Usuario
 */
public class Home extends javax.swing.JFrame {

    /** Creates new form Home */
    public Home() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        itemContAdicionar = new javax.swing.JMenuItem();
        itemContVer = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        itemMenAdd = new javax.swing.JMenuItem();
        itemMenShare = new javax.swing.JMenuItem();
        itemMenShare1 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        jMenu1.setText("jMenu1");

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Início");

        jMenu7.setText("Contatos");

        itemContAdicionar.setText("Adicionar");
        itemContAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemContAdicionarActionPerformed(evt);
            }
        });
        jMenu7.add(itemContAdicionar);

        itemContVer.setText("Ver contatos");
        itemContVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemContVerActionPerformed(evt);
            }
        });
        jMenu7.add(itemContVer);

        jMenuBar3.add(jMenu7);

        jMenu8.setText("Mensagens");

        itemMenAdd.setText("Enviar mensagem");
        itemMenAdd.setToolTipText("");
        itemMenAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenAddActionPerformed(evt);
            }
        });
        jMenu8.add(itemMenAdd);

        itemMenShare.setText("Enviados");
        itemMenShare.setToolTipText("");
        itemMenShare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenShareActionPerformed(evt);
            }
        });
        jMenu8.add(itemMenShare);

        itemMenShare1.setText("Caixa de Entrada");
        itemMenShare1.setToolTipText("");
        itemMenShare1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenShare1ActionPerformed(evt);
            }
        });
        jMenu8.add(itemMenShare1);

        jMenuBar3.add(jMenu8);

        jMenu9.setText("Usuário");
        jMenuBar3.add(jMenu9);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemContAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemContAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemContAdicionarActionPerformed

    private void itemMenAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemMenAddActionPerformed

    private void itemContVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemContVerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemContVerActionPerformed

    private void itemMenShareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenShareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemMenShareActionPerformed

    private void itemMenShare1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenShare1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemMenShare1ActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemContAdicionar;
    private javax.swing.JMenuItem itemContVer;
    private javax.swing.JMenuItem itemMenAdd;
    private javax.swing.JMenuItem itemMenShare;
    private javax.swing.JMenuItem itemMenShare1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    // End of variables declaration//GEN-END:variables

}
