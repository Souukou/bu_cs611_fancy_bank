package fancybank.gui;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import fancybank.user.Customer;

/**
 *
 * @author Di Wang
 */
public class CustomerEditPage extends javax.swing.JFrame {

    /**
     * Creates new form CustomerInfoPage
     */
    Customer c;
    public CustomerEditPage(Customer c) {
    	this.c = c;
        initComponents();
        this.address_text.setText(this.c.getAddress().getStreet()+" "+this.c.getAddress().getCity());
        this.email_text.setText(this.c.getEmail().get());
        this.name_text.setText(this.c.getName().getFirstName()+" "+this.c.getName().getLastName());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name_noti = new javax.swing.JLabel();
        javax.swing.JLabel email_noti = new javax.swing.JLabel();
        javax.swing.JLabel mobile_noti = new javax.swing.JLabel();
        javax.swing.JLabel DOB_noti = new javax.swing.JLabel();
        javax.swing.JLabel address_niti = new javax.swing.JLabel();
        javax.swing.JTextField name_text = new javax.swing.JTextField();
        email_text = new javax.swing.JTextField();
        address_text = new javax.swing.JTextField();
        mobile_text = new javax.swing.JTextField();
        dob_text = new javax.swing.JTextField();
        customer_info_noti = new javax.swing.JLabel();
        confirm_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Information");

        name_noti.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        name_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name_noti.setText(" Name :");

        email_noti.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        email_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        email_noti.setText(" Email :");

        mobile_noti.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        mobile_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mobile_noti.setText("Mobile :");

        DOB_noti.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        DOB_noti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOB_noti.setText("DOB :");

        address_niti.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        address_niti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        address_niti.setText("Address :");

        name_text.setEditable(false);

        email_text.setEditable(false);

        address_text.setEditable(false);

        mobile_text.setEditable(false);

        dob_text.setEditable(false);

        customer_info_noti.setFont(new java.awt.Font("Helvetica Neue", 1, 28)); // NOI18N
        customer_info_noti.setText("Customer Information:");

        confirm_button.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        confirm_button.setText("Confirm");
        confirm_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_buttonActionPerformed(evt);
            }
        });

        delete_button.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(customer_info_noti)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mobile_noti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(address_niti, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(DOB_noti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(email_noti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name_noti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mobile_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_text, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dob_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(123, 123, 123))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirm_button, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {address_text, dob_text, email_text, mobile_text, name_text});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(customer_info_noti)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name_noti, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(email_noti)
                        .addGap(34, 34, 34)
                        .addComponent(DOB_noti)
                        .addGap(32, 32, 32)
                        .addComponent(mobile_noti)
                        .addGap(33, 33, 33)
                        .addComponent(address_niti))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name_text, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(email_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(dob_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(mobile_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(address_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirm_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {DOB_noti, address_niti, email_noti, mobile_noti, name_noti});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {address_text, dob_text, email_text, mobile_text, name_text});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirm_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_buttonActionPerformed
        // TODO add your handling code here:
        // TODO add passing the edited information
        setVisible(false);
        dispose();
    }//GEN-LAST:event_confirm_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        // TODO add your handling code here:
        // TODO delete the user
    }//GEN-LAST:event_delete_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerInfoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CustomerInfoPage().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address_text;
    private javax.swing.JTextField name_text;
    private javax.swing.JButton confirm_button;
    private javax.swing.JLabel customer_info_noti;
    private javax.swing.JButton delete_button;
    private javax.swing.JTextField dob_text;
    private javax.swing.JTextField email_text;
    private javax.swing.JTextField mobile_text;
    private javax.swing.JLabel name_noti;
    // End of variables declaration//GEN-END:variables
}
