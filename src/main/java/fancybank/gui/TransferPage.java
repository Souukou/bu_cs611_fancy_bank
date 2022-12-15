package fancybank.gui;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.util.ArrayList;

import javax.swing.JOptionPane;

import fancybank.account.Account;
import fancybank.account.CheckAccount;
import fancybank.account.Money;
import fancybank.account.SecurityAccount;
import fancybank.account.Transferable;
import fancybank.currency.Currency;
import fancybank.data.Data;
import fancybank.transaction.CashTransaction;
import fancybank.transaction.Transaction;
import fancybank.user.Customer;

/**
 *
 * @author Di Wang
 */
public class TransferPage extends javax.swing.JFrame {

        /**
         * Creates new form NewJFrame
         */
		private Customer c;
		private ArrayList<Account> display_account;
        public TransferPage(Customer c) {
        		this.c = c;
                initComponents();
                ArrayList<Account> all_account = this.c.getAccounts();
                ArrayList<Account> display_account = new ArrayList<Account>();
                for(int i=0;i<all_account.size();i++) {
                	Account acc = all_account.get(i);
                	if(acc instanceof CheckAccount) {
                		if (!acc.getBalance().getCurrency().getName().equals("USD")) {
                			continue;
                		}
                	}
                	display_account.add(acc);
                	this.from_acc_box.addItem(acc.getAccountType()+" Account("+acc.getBalance().getCurrency().getName()+"):"+acc.getAccountNumber()+",Balance: "+acc.getBalance().get());
                	this.to_acc_box.addItem(acc.getAccountType()+" Account("+acc.getBalance().getCurrency().getName()+"):"+acc.getAccountNumber()+",Balance: "+acc.getBalance().get());
                }
                this.display_account = display_account;
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
        private void initComponents() {

            javax.swing.JLabel from_niti = new javax.swing.JLabel();
            transfer_cancel_button = new javax.swing.JButton();
            javax.swing.JLabel to_noti = new javax.swing.JLabel();
            transfer_submit_button = new javax.swing.JButton();
            javax.swing.JLabel amount_noti = new javax.swing.JLabel();
            amount_text = new javax.swing.JTextField();
            title_noti = new javax.swing.JLabel();
            from_acc_box = new javax.swing.JComboBox<>();
            to_acc_box = new javax.swing.JComboBox<>();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Transfer");
            setSize(new java.awt.Dimension(800, 450));

            from_niti.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
            from_niti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            from_niti.setText("From :");

            transfer_cancel_button.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
            transfer_cancel_button.setText("Cancel");
            transfer_cancel_button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    transfer_cancel_buttonActionPerformed(evt);
                }
            });

            to_noti.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
            to_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            to_noti.setText("To :");

            transfer_submit_button.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
            transfer_submit_button.setText("Submit");
            transfer_submit_button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    transfer_submit_buttonActionPerformed(evt);
                }
            });

            amount_noti.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
            amount_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            amount_noti.setText("Amount :");

            amount_text.setEditable(true);
            amount_text.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
            amount_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            amount_text.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    amount_textActionPerformed(evt);
                }
            });

            title_noti.setFont(new java.awt.Font("Helvetica Neue", 1, 34)); // NOI18N
            title_noti.setText("Transfer");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(100, 100, 100)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(from_niti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(to_noti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(amount_noti, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                                    .addGap(50, 50, 50)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(amount_text, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(from_acc_box, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(to_acc_box, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(117, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(198, 198, 198)
                                    .addComponent(transfer_submit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(68, 68, 68)
                                    .addComponent(transfer_cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(title_noti)
                                    .addGap(284, 284, 284))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addComponent(title_noti)
                                    .addGap(52, 52, 52)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(from_niti)
                                            .addComponent(from_acc_box, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(40, 40, 40)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(to_noti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(to_acc_box, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(39, 39, 39)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(amount_text, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(amount_noti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(55, 55, 55)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(transfer_submit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(transfer_cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(70, 70, 70))
            );

            pack();
        }// </editor-fold>

        private void transfer_cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_transfer_cancel_buttonActionPerformed
                setVisible(false);
                dispose();
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new CustomerMainPage(c).setVisible(true);
                    }
                });
        }// GEN-LAST:event_transfer_cancel_buttonActionPerformed

        private void transfer_submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_transfer_submit_buttonActionPerformed
                // TODO add your handling code here:
        	double transfer_amount = Double.parseDouble(amount_text.getText());
        	int from_ind = this.from_acc_box.getSelectedIndex();
        	int to_ind = this.to_acc_box.getSelectedIndex();
        	if(from_ind==to_ind) {
        		JOptionPane.showMessageDialog(this, "Please select different accounts!",
        	               "Swing Tester", JOptionPane.WARNING_MESSAGE);
        		return;
        	}
            Customer c = this.c;
            Transferable from_acc = (Transferable)this.display_account.get(from_ind);
            Account to_acc = this.display_account.get(to_ind);
            if(to_acc instanceof SecurityAccount) {
            	Double from_bal = ((Account)from_acc).getBalance().get();
            	if( from_bal<5000  ||transfer_amount<1000||from_bal<transfer_amount||from_bal-transfer_amount<2500) {
            		JOptionPane.showMessageDialog(this, "Transfer amount doesn't satisfy security transfer requirement!","Swing Tester",  JOptionPane.WARNING_MESSAGE);
            		return;
            	}
            }
            from_acc.transferTo(to_acc, transfer_amount);
            
            Currency cur = ((Account)from_acc).getBalance().getCurrency();
        	Transaction t = new CashTransaction( ((Account)from_acc).getAccountNumber(), ((Account)to_acc).getAccountNumber(),  new Money(cur,transfer_amount));
        	Data.getInstance().addTransaction(t);
            
            c.save();
        	java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new CustomerMainPage(c).setVisible(true);
                }
            });
        	this.setVisible(false);
        	dispose();
        }// GEN-LAST:event_transfer_submit_buttonActionPerformed

        private void amount_textActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_amount_textActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_amount_textActionPerformed

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
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(CheckingAccountPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(CheckingAccountPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(CheckingAccountPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(CheckingAccountPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                }
                // </editor-fold>
                // </editor-fold>

                /* Create and display the form 
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new CheckingAccountPage().setVisible(true);
                        }
                });
                */
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount_text;
    private javax.swing.JComboBox<String> from_acc_box;
    private javax.swing.JLabel title_noti;
    private javax.swing.JComboBox<String> to_acc_box;
    private javax.swing.JButton transfer_cancel_button;
    private javax.swing.JButton transfer_submit_button;
    // End of variables declaration//GEN-END:variables
}
