package fancybank.gui;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author xiekangxian Di Wang
 */
public class MoneyOperationPage extends javax.swing.JFrame {

    /**
     * Creates new form MoneyOperationPage
     * checking:type=0
     * saving: type=1
     * security:type=2
     * 
     * deposit: operation=0
     * withdraw: operation=1
     * request loan: operation=2
     */
    private int account_type;
    private int operation_type;

    public MoneyOperationPage(int account_type, int operation) {
        initComponents();
        this.account_type = account_type;
        this.operation_type = operation;
        set_display_information(account_type, operation);
    }

    public void set_display_information(int account_type, int operation) {
        String title = "";
        switch (account_type) {
            case 0:
                title += "Checking";
                this.acc_type_text.setText("Checking");
                break;
            case 1:
                title += "Saving";
                this.acc_type_text.setText("Saving");
                break;
            case 2:
                title += "Security";
                this.acc_type_text.setText("Security");
                break;
            default:
                break;
        }
        title += " Account: ";
        switch (operation) {
            case 0:
                title += "Deposite";
                this.operation_text.setText("Deposite");
                break;
            case 1:
                this.operation_text.setText("Withdraw");
                title += "Withdraw";
                break;
            case 2:
                this.operation_text.setText("Loan Request");
                title += "Loan Request";
                break;
            default:
                break;
        }
        setTitle(title);
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

        amount_text = new javax.swing.JTextField();
        javax.swing.JLabel amount_noti = new javax.swing.JLabel();
        cancel_button = new javax.swing.JButton();
        submit_button = new javax.swing.JButton();
        javax.swing.JLabel acc_type_noti = new javax.swing.JLabel();
        acc_type_text = new javax.swing.JTextField();
        javax.swing.JLabel operation_noti = new javax.swing.JLabel();
        operation_text = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Operation");

        amount_text.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        amount_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amount_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amount_textActionPerformed(evt);
            }
        });
        amount_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amount_textKeyTyped(evt);
            }
        });

        amount_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        amount_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amount_noti.setText("Amount:");

        cancel_button.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cancel_button.setText("Cancel");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });

        submit_button.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        submit_button.setText("Submit");
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });

        acc_type_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        acc_type_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_type_noti.setText("Account Type :");

        acc_type_text.setEditable(false);
        acc_type_text.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        acc_type_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        operation_noti.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        operation_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        operation_noti.setText("Operation :");

        operation_text.setEditable(false);
        operation_text.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        operation_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(160, 160, 160)
                                                .addComponent(submit_button, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(92, 92, 92)
                                                .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(acc_type_noti)
                                                        .addComponent(operation_noti,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 123,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(amount_noti,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 123,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(45, 45, 45)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(operation_text)
                                                        .addComponent(acc_type_text,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 350,
                                                                Short.MAX_VALUE)
                                                        .addComponent(amount_text))))
                                .addContainerGap(100, Short.MAX_VALUE)));

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
                new java.awt.Component[] { cancel_button, submit_button });

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(operation_noti, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(operation_text, javax.swing.GroupLayout.DEFAULT_SIZE, 50,
                                                Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(acc_type_text, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(acc_type_noti, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(amount_noti, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(amount_text, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancel_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(submit_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)));

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { amount_text, operation_text });

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_submit_buttonActionPerformed
        // TODO add your handling code here:
        String amount = this.amount_text.getText();
        this.amount_text.setText("");
        if (this.account_type == 0 && this.operation_type == 2) {
            // do request a loan,need to submit a file as proof
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new LoanRequestPage().setVisible(true);
                }
            });

        }
    }// GEN-LAST:event_submit_buttonActionPerformed

    private void amount_textKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_amount_textKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if ((!(Character.isDigit(enter))) && enter != '.') {
            evt.consume();
        }
    }// GEN-LAST:event_amount_textKeyTyped

    private void amount_textActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_amount_textActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_amount_textActionPerformed

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancel_buttonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }// GEN-LAST:event_cancel_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(MoneyOperationPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MoneyOperationPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MoneyOperationPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MoneyOperationPage.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MoneyOperationPage(0, 2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acc_type_text;
    private javax.swing.JTextField amount_text;
    private javax.swing.JButton cancel_button;
    private javax.swing.JTextField operation_text;
    private javax.swing.JButton submit_button;
    // End of variables declaration//GEN-END:variables
}
