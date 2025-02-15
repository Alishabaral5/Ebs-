/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author acer
 */

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import project.connectionpro;
public class paybill extends javax.swing.JFrame {
     private String loggedInMeterNumber;
    /**
     * Creates new form paybill
     */
  public paybill(String meter) {
        initComponents();
         this.loggedInMeterNumber = meter;  // Initialize with the logged-in meter number
        populateUserInfo(); 
         checkPendingBillAndNotify();
   jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateBillDetails();
            }

           
        });
   jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                payBill();
            }

            
        });
  }
     private void populateUserInfo() {
          try {
            Connection con = connectionpro.getconn();
            Statement st = con.createStatement();
            String query = "SELECT name, Year FROM bills  WHERE `meter number` = '" + loggedInMeterNumber + "'";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                //jTextField1.setText(loggedInMeterNumber);
               // jTextField2.setText(rs.getString("name"));
                jTextField1.setText(loggedInMeterNumber);
                jTextField1.setEditable(false); // Prevent user modification

                jTextField2.setText(rs.getString("name"));
                jTextField2.setEditable(false); // Prevent user modification
               
                 jTextField6.setText(rs.getString("Year"));
                jTextField6.setEditable(false); // Prevent user modification
              
            }

            updateBillDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
    private void updateBillDetails() {
    try {
        Connection con = connectionpro.getconn();
        Statement st = con.createStatement();
        String selectedMonth = jComboBox1.getSelectedItem().toString();
        String query = "SELECT `Unit Consumed`, `Total_bill`, `Payment_status` FROM bills WHERE `meter number` = '" + loggedInMeterNumber + "' AND Month = '" + selectedMonth + "'";
        ResultSet rs = st.executeQuery(query);
        
        if (rs.next()) {
            
            jTextField3.setText(rs.getString("Unit Consumed"));  
            jTextField4.setText(rs.getString("Total_bill"));  
            jTextField5.setText(rs.getString("Payment_status")); 
            
        }
        else
        {
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();  
    }
}

   private void payBill() {
       String selectedMonth = jComboBox1.getSelectedItem().toString();
    String totalBill = jTextField4.getText(); // Get total bill amount

    if (totalBill.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please select a month first!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
      checkPendingBillAndNotify();
    try {
        Connection con = connectionpro.getconn();
        Statement st = con.createStatement();
        //String selectedMonth = jComboBox1.getSelectedItem().toString();
        String query = "UPDATE bills SET Payment_status = 'Paid' WHERE `meter number` = '" + loggedInMeterNumber + "' AND Month = '" + selectedMonth + "'";
        st.executeUpdate(query);
        JOptionPane.showMessageDialog(this, "Redirecting to Paytm for Payment...");
        
        // Open the Paytm payment window
        setVisible(false);
        new Paytm(totalBill);


        //JOptionPane.showMessageDialog(this, "Payment Successful!");
       // jTextField5.setText("Paid");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Payment failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    checkPendingBillAndNotify();
}
private void checkPendingBillAndNotify() {
    try {
        Connection con = connectionpro.getconn();
        Statement st = con.createStatement();
        String query = "SELECT `Payment_status` FROM bills WHERE `meter number` = '" + loggedInMeterNumber + "' AND `Payment_status` != 'Paid'";
        ResultSet rs = st.executeQuery(query);

       /* if (rs.next()) {
            String paymentStatus = rs.getString("Payment_status");
            //String meterReadingDay = rs.getString("meter reading day");
            String month = rs.getString("Month");

            if (paymentStatus != null && !paymentStatus.equals("Paid")) {
                // Notify the user about the pending bill
                JOptionPane.showMessageDialog(this, "Your bill is pending for months. Please pay it as soon as possible" , "Pending Bill", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Your bill is paid, no pending bills.", "No Pending Bill", JOptionPane.INFORMATION_MESSAGE);
        }*/
       while (rs.next()) {
            String month = rs.getString("Month");
            String paymentStatus = rs.getString("Payment_status");
           boolean hasPendingBill = false;
        String pendingMonths = "";
            // Check if the bill for the month is not paid
            if ("Unpaid".equals(paymentStatus)) {
                hasPendingBill = true;
                pendingMonths += month + ", ";  // Store months with pending bills
            }
        

        if (hasPendingBill) {
            // Remove the last comma and space from the list of months
            if (pendingMonths.length() > 0) {
                pendingMonths = pendingMonths.substring(0, pendingMonths.length() - 2);
            }
            JOptionPane.showMessageDialog(this, "You have pending bills for the following months: " + pendingMonths + ". Please pay them as soon as possible.", "Pending Bill(s)", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Your bill is fully paid. No pending bills.", "No Pending Bill", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    }catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error fetching bill details", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(70, 240));
        setMinimumSize(new java.awt.Dimension(800, 540));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pay.png"))); // NOI18N
        jLabel1.setText("Pay Electricity Bill");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 260, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Meter Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 90, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Month");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 90, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Units");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 90, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Total Bill");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 90, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Status");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 90, -1));

        jTextField1.setEditable(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 120, 110, -1));

        jTextField2.setEditable(false);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 174, 110, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", " " }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 276, 110, -1));

        jTextField3.setEditable(false);
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 321, 110, -1));

        jTextField4.setEditable(false);
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 369, 110, -1));

        jTextField5.setEditable(false);
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 423, 110, -1));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Pay");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, 90, -1));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red-x-mark-transparent-background-3.png"))); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Year");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 98, -1));

        jTextField6.setEditable(false);
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 227, 110, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payre.png"))); // NOI18N
        jLabel9.setText("jLabel9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         
        setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(paybill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(paybill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(paybill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(paybill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new paybill("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
