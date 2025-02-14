
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import project.connectionpro;
import java.sql.PreparedStatement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author acer
 */
public class cupdateinfo extends javax.swing.JFrame {
    private String loggedInMeterNumber;
    /**
     * Creates new form cupdateinfo
     */
    public cupdateinfo(String meter) {
        initComponents();
        this.loggedInMeterNumber = meter;  // Initialize with the logged-in meter number
        populateUserInfo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void populateUserInfo() {
        
        try {
            // Establish the database connection
            Connection con = connectionpro.getconn();
            Statement st = con.createStatement();
            
            // Query to get the user data for the logged-in meter number
            String query = "SELECT name, address, branch, email, phone FROM newcustomer WHERE `meter number` = '" + loggedInMeterNumber + "'";
            ResultSet rs = st.executeQuery(query);
            
            // If data exists for the meter number, populate the fields
            if (rs.next()) {
                jTextField1.setText(loggedInMeterNumber);  // Set the meter number
                jTextField2.setText(rs.getString("name"));  // Set the name
                jTextField3.setText(rs.getString("address"));  // Set the address
                jTextField4.setText(rs.getString("branch"));  // Set the branch
                jTextField5.setText(rs.getString("email"));  // Set the email
                jTextField6.setText(rs.getString("phone"));  // Set the phone number
            }
        } catch (Exception e) {
            e.printStackTrace();  // Log any exceptions that occur
        }
    }
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
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jLabel1.setText("Update Information");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 47, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Meter Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 127, 105, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 167, 105, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Address");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 207, 105, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Branch");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 247, 105, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Email");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 287, 105, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Phone");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 327, 105, -1));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 127, 130, -1));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 167, 130, -1));

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 207, 130, -1));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 247, 130, -1));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 287, 130, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 327, 130, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 379, 86, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red-x-mark-transparent-background-3.png"))); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 379, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pexels-jessbaileydesign-1119793 re.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, -290, 850, 740));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String Email = jTextField5.getText().trim();  // Get the updated email from the email input field
        String Phone = jTextField6.getText().trim();
        if (Email.isEmpty() || Phone.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Email and Phone fields cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit the method if any field is empty
    }
<<<<<<< HEAD
         else if (!Phone.matches("\\d{10}")) {  // Check if phone contains only digits (regex for digits only)
            JOptionPane.showMessageDialog(null, "Phone Number must be exactly 10 digits.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;  // Exit if meter nb or phone is invalid
        }
=======
        
          else if (!Phone.matches("\\d{10}")) {  
        JOptionPane.showMessageDialog(null, "Phone Number must be exactly 10 digits.", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;  // Exit if phone number is invalid
    }
>>>>>>> 148d2c60c5739be05087b1840d372c4ea861b9b0
        else if (!Email.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")) {  // Check if phone contains only digits (regex for digits only)
            JOptionPane.showMessageDialog(null, "Email must be in correct format.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;  // Exit if email is invalid
        }
        try
        {
             Connection con = connectionpro.getconn();
              String query = "UPDATE newcustomer SET email = ?, phone = ? WHERE `meter number` = ?";
        
        // Use a PreparedStatement to prevent SQL injection
        try (PreparedStatement pst = con.prepareStatement(query)) {
            // Set the parameters for the query
            pst.setString(1, Email);  // Set the new email
            pst.setString(2, Phone);  // Set the new phone
            pst.setString(3, loggedInMeterNumber);  // Use the logged-in meter number as condition
            
            // Execute the query
            int rowsUpdated = pst.executeUpdate();
            
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Information updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                 String updateMessage = "Customer '" +  jTextField2.getName() + "' has updated their information.";
    
    // 3. Notify the admin about the update (this can be done via an in-app push notification or system message)
              notification.getInstance().addNotification(updateMessage);  // Push the message to NotificationManager (Admin's side)
            } else {
                JOptionPane.showMessageDialog(this, "No record found for the specified meter number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error updating information: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        }catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(cupdateinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cupdateinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cupdateinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cupdateinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cupdateinfo("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
