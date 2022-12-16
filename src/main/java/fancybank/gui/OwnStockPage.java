/*
 * Page to show the owned stock
 */
package fancybank.gui;

import fancybank.account.SecurityAccount;
import fancybank.account.StockHoldingList;
import fancybank.stock.Stock;
import fancybank.stock.StockHolding;
import fancybank.stock.StockMarket;
import fancybank.user.Customer;

import java.util.*;

import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author xiekangxian Di Wang
 */
public class OwnStockPage extends javax.swing.JFrame {

    /**
     * Creates new form OwnStockPage
     */
    private SecurityAccount acc;
    private Customer c;

    public OwnStockPage(Customer c, SecurityAccount acc) {// StockHoldingList ownedStockList) {
        initComponents();
        this.c = c;
        this.acc = acc;
        StockHoldingList owned = this.acc.getStockHoldingList();

        Hashtable<String, StockHolding> stockholds = new Hashtable<String, StockHolding>();
        Hashtable<String, Double> unrealized_profit = new Hashtable<String, Double>();
        for (int i = 0; i < owned.size(); i++) {
            StockHolding curr = owned.getStockHoldingList().get(i);
            if (stockholds.containsKey(curr.getSymbol())) {
                // current share
                Double profit = unrealized_profit.get(curr.getSymbol());
                profit += curr.getUnrealizedProfit();
                unrealized_profit.put(curr.getSymbol(), profit);

                StockHolding stockhold = stockholds.get(curr.getSymbol());
                int addon = curr.getQuantity();
                stockhold.setQuantity(addon + stockhold.getQuantity());
            } else {
                // owned[sh.getSymbol] = sh.get_quantity;
                unrealized_profit.put(curr.getSymbol(), curr.getUnrealizedProfit());
                StockHolding copy = new StockHolding(curr.getSymbol(), curr.getBoughtPrice(), curr.getQuantity());
                stockholds.put(curr.getSymbol(), copy);
            }
        }
        Set<String> keys = stockholds.keySet();
        DefaultTableModel model = (DefaultTableModel) this.own_stock_table.getModel();
        for (String key : keys) {
            StockHolding currStock = stockholds.get(key);
            Double profit = unrealized_profit.get(key);
            Stock st = StockMarket.getInstance().getStock(currStock.getSymbol());
            model.addRow(new Object[] { currStock.getSymbol(), st.getPrice(), currStock.getQuantity(),
                    st.getPrice() * currStock.getQuantity(), profit });
        }
        //
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        own_stock_table = new javax.swing.JTable();
        trade_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        stockmarket_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Owned Stock");

        own_stock_table.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        own_stock_table.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Stock Name", "Current Price", "Share Owned", "Current Value", "Unrealized Profit"
                }));
        own_stock_table.setShowGrid(true);
        jScrollPane1.setViewportView(own_stock_table);

        trade_button.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        trade_button.setText("Trade");
        trade_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trade_buttonActionPerformed(evt);
            }
        });

        back_button.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        stockmarket_button.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        stockmarket_button.setText("Stock Market");
        stockmarket_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockmarket_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694,
                                                        Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addComponent(trade_button, javax.swing.GroupLayout.PREFERRED_SIZE, 228,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(70, 70, 70)
                                                .addComponent(stockmarket_button,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 219,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(back_button)))
                                .addGap(28, 28, 28)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(back_button)
                                                .addGap(18, 18, 18))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(stockmarket_button,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(trade_button,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 52,
                                                                Short.MAX_VALUE))
                                                .addContainerGap(40, Short.MAX_VALUE)))));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stockmarket_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_stockmarket_buttonActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockMarketPage().setVisible(true);
            }
        });
    }// GEN-LAST:event_stockmarket_buttonActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_back_buttonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
        Customer c = this.c;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecurityAccountPage(c).setVisible(true);
            }
        });
    }// GEN-LAST:event_back_buttonActionPerformed

    private void trade_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_trade_buttonActionPerformed
        // TODO add your handling code here:
        Customer c = this.c;
        SecurityAccount acc = this.acc;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockOperationPage(c, acc).setVisible(true);
            }
        });
        setVisible(false);
        dispose();
    }// GEN-LAST:event_trade_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(OwnStockPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OwnStockPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OwnStockPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OwnStockPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /*
         * Create and display the form
         * java.awt.EventQueue.invokeLater(new Runnable() {
         * public void run() {
         * new OwnStockPage().setVisible(true);
         * }
         * });
         */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JTable own_stock_table;
    private javax.swing.JButton stockmarket_button;
    private javax.swing.JButton trade_button;
    // End of variables declaration//GEN-END:variables
}
