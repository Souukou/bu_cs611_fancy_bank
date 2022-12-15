package fancybank.gui;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import fancybank.account.Account;
import fancybank.stock.Stock;
import fancybank.stock.StockHolding;
import fancybank.stock.StockMarket;
import fancybank.user.Customer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author xiekangxian
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
	Customer customer;
    public LoginPage() {
        initComponents();
        Customer customer = new Customer(1,"username","firstname","middle","lastname","888 Commonwealth","boston","MA","02446","US","gmail.com","123456");
        customer.createCheckAccount(0, "USD");
        customer.createCheckAccount(0, "EUR");
        customer.createSavingAccount(0, "USD");
        customer.createSecurityAccount(100000);
        Stock apple = StockMarket.getInstance().getStock("AAPL");
        Stock google = StockMarket.getInstance().getStock("GOOG");
        //customer.getOneSecurityAccount().buyStock(apple, 100);
        //customer.getOneSecurityAccount().buyStock(apple, 100);
        //customer.getOneSecurityAccount().buyStock(google, 100);
        //customer.getOneSecurityAccount().buyStock(google, 100);
        this.customer = customer;
        // connect the database
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel nickname_noti = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        account_text = new javax.swing.JTextField();
        login_button = new javax.swing.JButton();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        password_text = new javax.swing.JPasswordField();
        new_user_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        nickname_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        nickname_noti.setText("NickName :");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        jLabel2.setText("Password :");

        account_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                account_textActionPerformed(evt);
            }
        });

        login_button.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        login_button.setText("Log in");
        login_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_buttonMouseClicked(evt);
            }
        });
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bank ATM");
        jLabel3.setToolTipText("");

        password_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_textActionPerformed(evt);
            }
        });

        new_user_button.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        new_user_button.setText("Create Account");
        new_user_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_user_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(nickname_noti))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(account_text, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
                                                Short.MAX_VALUE)
                                        .addComponent(password_text, javax.swing.GroupLayout.DEFAULT_SIZE, 150,
                                                Short.MAX_VALUE))
                                .addGap(75, 75, 75))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(106, 106, 106)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(new_user_button)
                                                .addGap(18, 18, 18)
                                                .addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(73, Short.MAX_VALUE)));

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] { jLabel2, nickname_noti });

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
                new java.awt.Component[] { login_button, new_user_button });

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nickname_noti)
                                        .addComponent(account_text, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(password_text, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(new_user_button)
                                        .addComponent(login_button))
                                .addContainerGap(50, Short.MAX_VALUE)));

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { jLabel2, nickname_noti });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void account_textActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_account_textActionPerformed
        // TODO add your handling code here:

    }// GEN-LAST:event_account_textActionPerformed

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_login_buttonActionPerformed
        // TODO add your handling code here:
    	Customer c = this.customer;
        String acc = this.account_text.getText();
        String password = this.password_text.toString();
        System.out.print(acc + password);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerMainPage(c).setVisible(true);
                // new ManagerMainPage().setVisible(true);
            }
        });
    }// GEN-LAST:event_login_buttonActionPerformed

    private void new_user_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_new_user_buttonActionPerformed
        // TODO add your handling code here:
        String[] new_info = new String[4];
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewCustomerPage().setVisible(true);
            }
        });

    }// GEN-LAST:event_new_user_buttonActionPerformed

    private void password_textActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_password_textActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_password_textActionPerformed

    private void login_buttonMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_login_buttonMouseClicked
        // TODO add your handling code here:
        // String acc = "";
        // String password = "";
        // boolean flag = true;
        // Statement state = connect.createStatement();
        //
        // while(){
        // acc = ;
        // password = ;
        // if(password.equals(this.account_text.getText()) &&
        // acc.equals(this.account_next.getText()) ){
        // this.dispose();
        // flag = false;
        // break;
        // }
        // }
        // if(flag){
        // JOptionPane.showMessageDialog(this, "Enter the incorrect account number or
        // password!");
        // }

    }// GEN-LAST:event_login_buttonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField account_text;
    private javax.swing.JButton login_button;
    private javax.swing.JButton new_user_button;
    private javax.swing.JPasswordField password_text;
    // End of variables declaration//GEN-END:variables
}
