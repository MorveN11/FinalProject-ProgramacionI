package User;

import NetWork.DataBase;
import java.util.Objects;
import javax.swing.JOptionPane;


public class Register extends javax.swing.JFrame {
    
    public Register() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCellPhone = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        txtGender = new javax.swing.JComboBox<>();
        txtPassword = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 140, 0, 390);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo1.1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 518, 140);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo1.2.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 625, 520, 230);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo1.3.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 140, 44, 396);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo1.3.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 230, 44, 396);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo1.4.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(480, 130, 40, 270);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fondo1.4.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(480, 390, 40, 240);

        jPanel1.setBackground(new java.awt.Color(0, 65, 100));

        jLabel7.setBackground(new java.awt.Color(244, 244, 244));
        jLabel7.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(244, 244, 244));
        jLabel7.setText("Name:");

        jLabel9.setBackground(new java.awt.Color(244, 244, 244));
        jLabel9.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(244, 244, 244));
        jLabel9.setText("CellPhone:");

        jLabel10.setBackground(new java.awt.Color(244, 244, 244));
        jLabel10.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(244, 244, 244));
        jLabel10.setText("Gender:");

        jLabel11.setBackground(new java.awt.Color(244, 244, 244));
        jLabel11.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(244, 244, 244));
        jLabel11.setText("LastName:");

        jLabel12.setBackground(new java.awt.Color(244, 244, 244));
        jLabel12.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(244, 244, 244));
        jLabel12.setText("Email:");

        jLabel13.setBackground(new java.awt.Color(244, 244, 244));
        jLabel13.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(244, 244, 244));
        jLabel13.setText("UserName:");

        jLabel14.setBackground(new java.awt.Color(244, 244, 244));
        jLabel14.setFont(new java.awt.Font("Eras Demi ITC", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(244, 244, 244));
        jLabel14.setText("Password:");

        jLabel15.setBackground(new java.awt.Color(244, 244, 244));
        jLabel15.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(244, 244, 244));
        jLabel15.setText("Register");

        btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnRegister.setText("Registrar");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnExit.setText("Cerrar");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnBack.setText("Regresar");

        txtName.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        txtLastName.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        txtCellPhone.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        txtUserName.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        txtGender.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        txtGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "No Asignado" }));

        txtPassword.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegister)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail)
                            .addComponent(txtLastName)
                            .addComponent(txtName)
                            .addComponent(txtUserName)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(txtCellPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtGender, 0, 206, Short.MAX_VALUE)))
                            .addComponent(txtPassword)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCellPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnRegister))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExit)
                            .addComponent(btnBack))))
                .addContainerGap(220, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 30, 470, 810);

        setSize(new java.awt.Dimension(517, 888));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        int exito =  DataBase.saveData(txtName.getText(), txtLastName.getText(), txtEmail.getText(), txtCellPhone.getText(),
            Objects.requireNonNull(txtGender.getSelectedItem()).toString(),
            txtUserName.getText(), String.valueOf(txtPassword.getPassword()));

        if(exito>0){

            JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente",
                "Éxito en la operación", JOptionPane.INFORMATION_MESSAGE);
        }else{

            JOptionPane.showMessageDialog(null, "Los datos no se pudieron guardar\n"
                + "Inténtelo nuevamente", "Error en la operación", JOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }//GEN-LAST:event_btnRegisterActionPerformed

    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new Register().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCellPhone;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JComboBox<String> txtGender;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
