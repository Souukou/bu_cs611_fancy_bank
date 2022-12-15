package fancybank.gui;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import fancybank.user.Address;
import fancybank.user.Customer;
import fancybank.user.Email;
import fancybank.user.Manager;
import fancybank.user.Name;
import fancybank.user.Password;
import fancybank.user.UID;
import fancybank.user.Username;

/**
 *
 * @author xiekangxian Di Wang
 */
public class ManagerMainPage extends javax.swing.JFrame {

    /**
     * Creates new form ManagerMainPage
     */
	private Manager m;
    public ManagerMainPage(Manager m) {
    	this.m=m;
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

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        customer_info_button = new javax.swing.JButton();
        transaction_button = new javax.swing.JButton();
        stock_button = new javax.swing.JButton();
        financial_report_button = new javax.swing.JButton();
        logoff_button = new javax.swing.JButton();
        exchange_rate_button = new javax.swing.JButton();
        approve_loan_button = new javax.swing.JButton();
        bank_manager_noti = new javax.swing.JLabel();
        time_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manager Main Menu");

        customer_info_button.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        customer_info_button.setText("Customer Info");
        customer_info_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_info_buttonActionPerformed(evt);
            }
        });

        transaction_button.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        transaction_button.setText("Transaction Report");
        transaction_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaction_buttonActionPerformed(evt);
            }
        });

        stock_button.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        stock_button.setText("Stock Manage");
        stock_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stock_buttonActionPerformed(evt);
            }
        });

        financial_report_button.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        financial_report_button.setText("Financial Report");
        financial_report_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financial_report_buttonActionPerformed(evt);
            }
        });

        logoff_button.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        logoff_button.setText("Log off");
        logoff_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoff_buttonActionPerformed(evt);
            }
        });

        exchange_rate_button.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        exchange_rate_button.setText("Exchange Rate");
        exchange_rate_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exchange_rate_buttonActionPerformed(evt);
            }
        });

        approve_loan_button.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        approve_loan_button.setText("Approve Loan");
        approve_loan_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approve_loan_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(approve_loan_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(customer_info_button, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(transaction_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stock_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(financial_report_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exchange_rate_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(logoff_button, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(customer_info_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exchange_rate_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stock_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(approve_loan_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(transaction_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(financial_report_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoff_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        bank_manager_noti.setFont(new java.awt.Font("Helvetica Neue", 1, 28)); // NOI18N
        bank_manager_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bank_manager_noti.setText("Hello! Bank Manager.");

        time_button.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        time_button.setText("Time");
        time_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                time_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(bank_manager_noti, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(time_button)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(time_button)
                .addGap(18, 18, 18)
                .addComponent(bank_manager_noti, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stock_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stock_buttonActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockEditPage(m).setVisible(true);
            }
        });
    }//GEN-LAST:event_stock_buttonActionPerformed

    private void customer_info_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_info_buttonActionPerformed
        // TODO add your handling code here:
    	Manager m = this.m;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerListPage(m).setVisible(true);
            }
        });
    }//GEN-LAST:event_customer_info_buttonActionPerformed

    private void logoff_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoff_buttonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }//GEN-LAST:event_logoff_buttonActionPerformed

    private void time_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_time_buttonActionPerformed
        // TODO add your handling code here:
        // add time accelerator
    }//GEN-LAST:event_time_buttonActionPerformed

    private void transaction_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaction_buttonActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailyTransactionsPage(m).setVisible(true);
            }
        });
    }//GEN-LAST:event_transaction_buttonActionPerformed

    private void financial_report_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financial_report_buttonActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinancialReportPage().setVisible(true);
            }
        });
    }//GEN-LAST:event_financial_report_buttonActionPerformed

    private void exchange_rate_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exchange_rate_buttonActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExchangeRateChangePage().setVisible(true);
            }
        });
    }//GEN-LAST:event_exchange_rate_buttonActionPerformed

    private void approve_loan_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approve_loan_buttonActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApproveLoanPage().setVisible(true);
            }
        });
    }//GEN-LAST:event_approve_loan_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(ManagerMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerMainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerMainPage().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approve_loan_button;
    private javax.swing.JLabel bank_manager_noti;
    private javax.swing.JButton customer_info_button;
    private javax.swing.JButton exchange_rate_button;
    private javax.swing.JButton financial_report_button;
    private javax.swing.JButton logoff_button;
    private javax.swing.JButton stock_button;
    private javax.swing.JButton time_button;
    private javax.swing.JButton transaction_button;
    // End of variables declaration//GEN-END:variables
}
