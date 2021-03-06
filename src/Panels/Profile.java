/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Panels;

import User.Customer;

/**
 *
 * @author Diego
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    public Profile() {
        initComponents();
        initilizated();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtDailyTasks = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtWeeklyTasks = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        txtUserName = new javax.swing.JLabel();
        txtLastNames = new javax.swing.JLabel();
        txtPopCoins = new javax.swing.JLabel();
        txtChalaCoins = new javax.swing.JLabel();
        txtNameUser = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtDailyTasks, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 260, 30));

        jButton1.setFont(new java.awt.Font("Cascadia Code", 0, 18)); // NOI18N
        jButton1.setText("Canjear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 130, 30));
        getContentPane().add(txtWeeklyTasks, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 240, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setText("Tareas Diarias:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 150, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setText("Tareas Semanales:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 170, 30));

        btnBack.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 160, 30));

        txtUserName.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 30)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(0, 0, 153));
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 200, 50));

        txtLastNames.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        getContentPane().add(txtLastNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 290, 40));

        txtPopCoins.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        getContentPane().add(txtPopCoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 140, 40));

        txtChalaCoins.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        getContentPane().add(txtChalaCoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 70, 40));

        txtNameUser.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 24)); // NOI18N
        getContentPane().add(txtNameUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 270, 40));
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 6, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/UserProfile.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 400));

        setSize(new java.awt.Dimension(580, 406));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtChalaCoins;
    private javax.swing.JLabel txtDailyTasks;
    private javax.swing.JLabel txtLastNames;
    private javax.swing.JLabel txtNameUser;
    private javax.swing.JLabel txtPopCoins;
    private javax.swing.JLabel txtUserName;
    private javax.swing.JLabel txtWeeklyTasks;
    // End of variables declaration//GEN-END:variables
    
    private void initilizated() {
        
        txtNameUser.setText(Customer.name);
        txtLastNames.setText(Customer.lastName);
        txtPopCoins.setText(Customer.popCoins);
        txtChalaCoins.setText(Customer.chalaCoins);
        txtUserName.setText(Customer.userName);
        txtDailyTasks.setText(Customer.dailyChallenges);
        txtWeeklyTasks.setText(Customer.weeklyTasks);
        
        
    }


}
