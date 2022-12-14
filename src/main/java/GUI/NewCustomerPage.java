/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import javax.swing.JOptionPane;


import javax.swing.JOptionPane;
/**
 *
 * @author xiekangxian Di Wang
 */
public class NewCustomerPage extends javax.swing.JFrame {

    /**
     * Creates new form NewCustomerPage
     */
    private String[] info;
    public NewCustomerPage() {
        
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

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel email_noti = new javax.swing.JLabel();
        javax.swing.JLabel first_name_noti = new javax.swing.JLabel();
        javax.swing.JLabel password = new javax.swing.JLabel();
        javax.swing.JLabel DOB = new javax.swing.JLabel();
        javax.swing.JLabel street_noti = new javax.swing.JLabel();
        email_text = new javax.swing.JTextField();
        firstname_text = new javax.swing.JTextField();
        password_text = new javax.swing.JTextField();
        DOB_text = new javax.swing.JTextField();
        street_text = new javax.swing.JTextField();
        create_button = new javax.swing.JButton();
        cancel_button = new javax.swing.JButton();
        javax.swing.JLabel city_noti = new javax.swing.JLabel();
        javax.swing.JLabel zip_noti = new javax.swing.JLabel();
        javax.swing.JLabel country_noti = new javax.swing.JLabel();
        javax.swing.JLabel state_noit = new javax.swing.JLabel();
        city_text = new javax.swing.JTextField();
        zip_text = new javax.swing.JTextField();
        state_text = new javax.swing.JTextField();
        country_text = new javax.swing.JTextField();
        javax.swing.JLabel middle_name_noti = new javax.swing.JLabel();
        middlename_text = new javax.swing.JTextField();
        javax.swing.JLabel last_name_noti = new javax.swing.JLabel();
        lastname_text = new javax.swing.JTextField();
        javax.swing.JLabel nickname_noti = new javax.swing.JLabel();
        nickname_text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Signup");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Customer Account");

        email_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        email_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        email_noti.setText(" Email :");

        first_name_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        first_name_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        first_name_noti.setText("First Name :");

        password.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        password.setText("Password :");

        DOB.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        DOB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOB.setText("DOB(MM/DD/Year) :");

        street_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        street_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        street_noti.setText("Street :");

        email_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_textActionPerformed(evt);
            }
        });
        email_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                email_textKeyTyped(evt);
            }
        });

        firstname_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstname_textActionPerformed(evt);
            }
        });

        password_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_textActionPerformed(evt);
            }
        });

        create_button.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        create_button.setText("Create");
        create_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_buttonMouseClicked(evt);
            }
        });
        create_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_buttonActionPerformed(evt);
            }
        });

        cancel_button.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cancel_button.setText("Cancel");
        cancel_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancel_buttonMouseClicked(evt);
            }
        });
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        city_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        city_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        city_noti.setText("City :");

        zip_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        zip_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        zip_noti.setText("Zip Code :");

        country_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        country_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        country_noti.setText("Country :");

        state_noit.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        state_noit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        state_noit.setText("State :");

        city_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                city_textActionPerformed(evt);
            }
        });

        zip_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zip_textActionPerformed(evt);
            }
        });

        middle_name_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        middle_name_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        middle_name_noti.setText("Middle Name :");

        middlename_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middlename_textActionPerformed(evt);
            }
        });

        last_name_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        last_name_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        last_name_noti.setText("Last Name :");

        lastname_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastname_textActionPerformed(evt);
            }
        });

        nickname_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        nickname_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nickname_noti.setText("NickName :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(create_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(street_noti)
                            .addComponent(DOB)
                            .addComponent(password)
                            .addComponent(city_noti)
                            .addComponent(zip_noti)
                            .addComponent(country_noti)
                            .addComponent(state_noit)
                            .addComponent(middle_name_noti)
                            .addComponent(first_name_noti)
                            .addComponent(last_name_noti)
                            .addComponent(email_noti)
                            .addComponent(nickname_noti, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email_text, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DOB_text, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nickname_text, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstname_text)
                            .addComponent(middlename_text)
                            .addComponent(lastname_text, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(password_text, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(street_text, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(city_text)
                            .addComponent(zip_text)
                            .addComponent(state_text)
                            .addComponent(country_text)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 120, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DOB, city_noti, country_noti, email_noti, first_name_noti, last_name_noti, middle_name_noti, nickname_noti, password, state_noit, street_noti, zip_noti});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DOB_text, city_text, country_text, email_text, firstname_text, lastname_text, middlename_text, nickname_text, password_text, state_text, street_text, zip_text});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nickname_noti)
                    .addComponent(nickname_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_noti))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(first_name_noti)
                    .addComponent(firstname_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(middle_name_noti)
                    .addComponent(middlename_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(last_name_noti)
                    .addComponent(lastname_text, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(password_text))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DOB)
                    .addComponent(DOB_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(street_noti)
                    .addComponent(street_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(city_noti)
                    .addComponent(city_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zip_noti)
                    .addComponent(zip_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(state_noit)
                    .addComponent(state_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(country_noti)
                    .addComponent(country_text))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DOB, city_noti, country_noti, email_noti, first_name_noti, last_name_noti, middle_name_noti, nickname_noti, password, state_noit, street_noti, zip_noti});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DOB_text, city_text, country_text, email_text, firstname_text, lastname_text, middlename_text, nickname_text, password_text, state_text, street_text, zip_text});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void email_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_textActionPerformed

    private void password_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_textActionPerformed

    private void create_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_buttonActionPerformed
        // TODO add your handling code here:
        String acc_num = this.email_text.getText();
        String password = this.firstname_text.getText();
        String address = this.street_text.getText();
        String dob = this.DOB_text.getText();
        String name = this.password_text.getText();
        if(acc_num.length()==0||password.length()==0||address.length()==0||dob.length()==0||name.length()==0){
            JOptionPane.showMessageDialog(null, "Can't have empty input.", "Empty Input Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            //do create new customer
            setVisible(false); //you can't see me!
            dispose(); //Destroy the JFrame object
        }
        
    }//GEN-LAST:event_create_buttonActionPerformed

    private void email_textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_email_textKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_email_textKeyTyped

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_cancel_buttonActionPerformed

    private void create_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_buttonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_create_buttonMouseClicked

    private void cancel_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancel_buttonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel_buttonMouseClicked

    private void firstname_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstname_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname_textActionPerformed

    private void city_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_city_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_city_textActionPerformed

    private void zip_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zip_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zip_textActionPerformed

    private void lastname_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastname_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastname_textActionPerformed

    private void middlename_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middlename_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middlename_textActionPerformed

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
            java.util.logging.Logger.getLogger(NewCustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewCustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewCustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewCustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewCustomerPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DOB_text;
    private javax.swing.JButton cancel_button;
    private javax.swing.JTextField city_text;
    private javax.swing.JTextField country_text;
    private javax.swing.JButton create_button;
    private javax.swing.JTextField email_text;
    private javax.swing.JTextField firstname_text;
    private javax.swing.JTextField lastname_text;
    private javax.swing.JTextField middlename_text;
    private javax.swing.JTextField nickname_text;
    private javax.swing.JTextField password_text;
    private javax.swing.JTextField state_text;
    private javax.swing.JTextField street_text;
    private javax.swing.JTextField zip_text;
    // End of variables declaration//GEN-END:variables
}
