package fancybank.gui;

import fancybank.account.SavingAccount;
import fancybank.user.Customer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author xiekangxian Di Wang
 */
public class SavingAccountPage extends javax.swing.JFrame {

    /**
     * Creates new form SavingAccountPage
     */
	Customer c;
	SavingAccount account;
    public SavingAccountPage(Customer c) {
        initComponents();
        this.c = c;
        this.account = this.c.getOneSavingAccount();
        this.acc_num_text.setText(String.valueOf(this.account.getAccountNumber()));
        this.balance_text.setText(String.valueOf(this.account.getBalance().get()));
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

        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        acc_num_text = new javax.swing.JTextField();
        deposit_button = new javax.swing.JButton();
        withdraw_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        javax.swing.JLabel ballabel = new javax.swing.JLabel();
        balance_text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Saving Account");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(710, 503));
        setSize(new java.awt.Dimension(800, 450));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
        jLabel2.setText("Account Number:");

        acc_num_text.setEditable(false);
        acc_num_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        acc_num_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_num_textActionPerformed(evt);
            }
        });

        deposit_button.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        deposit_button.setText("Deposit");
        deposit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deposit_buttonActionPerformed(evt);
            }
        });

        withdraw_button.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        withdraw_button.setText("Withdraw");
        withdraw_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdraw_buttonActionPerformed(evt);
            }
        });

        back_button.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        ballabel.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
        ballabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ballabel.setText("Account Balance:");

        balance_text.setEditable(false);
        balance_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(deposit_button, javax.swing.GroupLayout.DEFAULT_SIZE, 160,
                                                        Short.MAX_VALUE)
                                                .addGap(77, 77, 77)
                                                .addComponent(withdraw_button, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        160, Short.MAX_VALUE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, Short.MAX_VALUE)
                                                                .addComponent(acc_num_text,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 278,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(ballabel,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addGap(40, 40, 40)
                                                                .addComponent(balance_text,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 278,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(112, 112, 112))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(241, Short.MAX_VALUE)
                                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 228,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(241, 241, 241)));

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
                new java.awt.Component[] { deposit_button, withdraw_button });

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(acc_num_text, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ballabel)
                                        .addComponent(balance_text, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(withdraw_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deposit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(46, 46, 46)
                                .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 52,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(73, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acc_num_textActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_acc_num_textActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_acc_num_textActionPerformed

    private void deposit_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deposit_buttonActionPerformed
        // TODO add your handling code here:
    	SavingAccount a = this.account;
    	Customer c = this.c;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MoneyOperationPage(c,a, 1, 0,0).setVisible(true);
            }
        });
        this.setVisible(false);
        dispose();
    }// GEN-LAST:event_deposit_buttonActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_back_buttonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Customer c = this.c;
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerMainPage(c).setVisible(true);
            }
        });
        
    }// GEN-LAST:event_back_buttonActionPerformed

    private void withdraw_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_withdraw_buttonActionPerformed
        // TODO add your handling code here:
    	SavingAccount a = this.account;
    	Customer c = this.c;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MoneyOperationPage(c,a, 1, 1,0).setVisible(true);
            }
        });
        this.setVisible(false);
        dispose();
    }// GEN-LAST:event_withdraw_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(SavingAccountPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SavingAccountPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SavingAccountPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SavingAccountPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SavingAccountPage().setVisible(true);
            }
        });
        */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acc_num_text;
    private javax.swing.JButton back_button;
    private javax.swing.JTextField balance_text;
    private javax.swing.JButton deposit_button;
    private javax.swing.JButton withdraw_button;
    // End of variables declaration//GEN-END:variables
}
