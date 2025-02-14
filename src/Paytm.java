/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SAMSUNG
 */



import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class Paytm extends JFrame implements ActionListener {
    String totalBill;
    JButton back;

    // Constructor
    Paytm(String totalBill) {
        this.totalBill = totalBill.trim(); // Remove spaces

        if (this.totalBill.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid bill amount: Amount is empty.");
            return;
        }

        // GUI Setup
        JPanel panel = new JPanel();
        panel.setLayout(null);

        back = new JButton("Back");
        back.setBounds(640, 20, 80, 30);
        back.addActionListener(this);
        panel.add(back);

        setSize(800, 600);
        setLocation(400, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Generate Stripe Checkout session
        String checkoutUrl = createCheckoutSession();
        if (checkoutUrl != null) {
            openCheckoutInBrowser(checkoutUrl);
        } else {
            JOptionPane.showMessageDialog(this, "Error creating Stripe session.");
        }
    }

    private String createCheckoutSession() {
        Stripe.apiKey = "sk_test_51QpTonRTZuNqdvcczxSVsa3a8TKZ8786stm5mJARgQXelXbeUhjK2y9yqfEZDVZHI6JWfW22GnQBSgI4mKQXFc8800MGYCNt22";

        long amountInCents;
        try {
            double amount = Double.parseDouble(totalBill);
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Invalid bill amount: Should be greater than zero.");
                return null;
            }
            amountInCents = (long) (amount * 100); // Convert dollars to cents
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid bill amount: Not a valid number.");
            return null;
        }

        try {
            SessionCreateParams params = SessionCreateParams.builder()
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl("https://yourwebsite.com/success?session_id={CHECKOUT_SESSION_ID}")
                    .setCancelUrl("https://yourwebsite.com/cancel")
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()
                                    .setQuantity(1L)
                                    .setPriceData(
                                            SessionCreateParams.LineItem.PriceData.builder()
                                                    .setCurrency("USD")
                                                    .setUnitAmount(amountInCents) // Amount in cents
                                                    .setProductData(
                                                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                    .setName("Meter Payment")
                                                                    .build()
                                                    )
                                                    .build()
                                    )
                                    .build()
                    )
                    .build();

            Session session = Session.create(params);
            return session.getUrl();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error creating Stripe session: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private void openCheckoutInBrowser(String checkoutUrl) {
        try {
            URI uri = new URI(checkoutUrl);
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error opening Stripe Checkout in browser.");
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Paytm(totalBill);
    }

    public static void main(String[] args) {
        new Paytm("10"); // Example amount: $10
    }
}
