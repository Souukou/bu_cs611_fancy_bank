package fancybank.gui;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.table.DefaultTableModel;

import fancybank.data.Data;
import fancybank.data.Handlers.SimulateTime;
import fancybank.stock.Stock;
import fancybank.transaction.Transaction;
import fancybank.user.Manager;

/**
 *
 * @author Di Wang
 */
public class DailyTransactionsPage extends javax.swing.JFrame {

        /**
         * Creates new form StockMarketPage
         */
		private Manager m;
        public DailyTransactionsPage(Manager m) {
                initComponents();
                this.m = m;
                Transaction[] ts = Data.getInstance().getTransactionByDay(new SimulateTime());
                
                DefaultTableModel model = (DefaultTableModel) this.stack_market_table.getModel();
                for(int i =0;i<ts.length;i++) {
                	Transaction t = ts[i];
                	String from = new Integer(t.getFrom()).toString();
                	String to = new Integer(t.getTo()).toString();
                	if(from.equals("-1")) from="cash";
                	if(to.equals("-1")) to="cash";
                	if(from.equals("-2")) from="Stock";
                	if(to.equals("-2")) to="Stock";
                	model.addRow(new Object[]{from, to, t.getMoney().getAmount()});
                }
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

                back_button = new javax.swing.JButton();
                table = new javax.swing.JPanel();
                javax.swing.JScrollPane daily_transaction_list = new javax.swing.JScrollPane();
                stack_market_table = new javax.swing.JTable();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Daily Transactions report");

                back_button.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
                back_button.setText("Back");
                back_button.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                back_buttonActionPerformed(evt);
                        }
                });

                stack_market_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                stack_market_table.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "From", "To", "Amount"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                stack_market_table.setRowSelectionAllowed(false);
                stack_market_table.setShowGrid(true);
                daily_transaction_list.setViewportView(stack_market_table);

                javax.swing.GroupLayout tableLayout = new javax.swing.GroupLayout(table);
                table.setLayout(tableLayout);
                tableLayout.setHorizontalGroup(
                        tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(tableLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(daily_transaction_list, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );
                tableLayout.setVerticalGroup(
                        tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(tableLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(daily_transaction_list, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(311, Short.MAX_VALUE)
                                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(311, 311, 311))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(65, 65, 65)
                                        .addComponent(back_button, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(71, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>

        private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_back_buttonActionPerformed
                // TODO add your handling code here:
                setVisible(false);
                dispose();
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                            new ManagerMainPage(m).setVisible(true);
                    }
            });
        }// GEN-LAST:event_back_buttonActionPerformed

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
                        java.util.logging.Logger.getLogger(StockMarketPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(StockMarketPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(StockMarketPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(StockMarketPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new StockMarketPage().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton back_button;
        private javax.swing.JTable stack_market_table;
        private javax.swing.JPanel table;
        // End of variables declaration//GEN-END:variables
}
