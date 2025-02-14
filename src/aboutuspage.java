import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class aboutuspage extends JFrame {
    
    public aboutuspage() {
        // Set up the frame
        setTitle("About Us - Electricity Billing System");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Set up the panel and layout
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(20, 20)); // Add space between components
        
        // Add header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(70, 130, 180)); // Steel Blue
        headerPanel.setPreferredSize(new Dimension(600, 100));
        JLabel headerLabel = new JLabel("About Us", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 36));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        
        // Add content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(245, 245, 245)); // Light grey background
        
        // Title and intro
        JLabel titleLabel = new JLabel("Welcome to the Electricity Billing System!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        
        JLabel introText = new JLabel("<html><p style='width: 500px; text-align: center;'>Our Electricity Billing System is designed to automate the entire process of generating and managing electricity bills. Developed by a team of passionate students at [Your College Name], we aim to make billing more efficient and accurate for users.</p></html>", SwingConstants.CENTER);
        introText.setFont(new Font("Arial", Font.PLAIN, 16));
        introText.setAlignmentX(Component.CENTER_ALIGNMENT);
        introText.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        
        // Team section
        JLabel teamLabel = new JLabel("Our Team", SwingConstants.CENTER);
        teamLabel.setFont(new Font("Arial", Font.BOLD, 20));
        teamLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        teamLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        
        JPanel teamPanel = new JPanel();
        teamPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        teamPanel.setBackground(new Color(245, 245, 245)); // Same light grey
        
        String[] teamMembers = {"[Your Name] - Project Manager & Backend Developer", 
                                 "[Team Member 2] - Frontend Developer", 
                                 "[Team Member 3] - Database Administrator"};
        
        for (String member : teamMembers) {
            JLabel memberLabel = new JLabel(member);
            memberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            memberLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            teamPanel.add(memberLabel);
        }
        
        // Technologies used section
        JLabel techLabel = new JLabel("Technologies Used", SwingConstants.CENTER);
        techLabel.setFont(new Font("Arial", Font.BOLD, 20));
        techLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        techLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        
        JPanel techPanel = new JPanel();
        techPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        techPanel.setBackground(new Color(245, 245, 245)); // Same light grey
        
        String[] technologies = {"Java", "MySQL", "JasperReports", "Java Swing"};
        
        for (String tech : technologies) {
            JLabel techLabelItem = new JLabel(tech);
            techLabelItem.setFont(new Font("Arial", Font.PLAIN, 16));
            techLabelItem.setAlignmentX(Component.CENTER_ALIGNMENT);
            techPanel.add(techLabelItem);
        }
        
        // Add content panel to the main panel
        contentPanel.add(titleLabel);
        contentPanel.add(introText);
        contentPanel.add(teamLabel);
        contentPanel.add(teamPanel);
        contentPanel.add(techLabel);
        contentPanel.add(techPanel);
        
        // Footer section with "Contact Us" button
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(70, 130, 180)); // Same Steel Blue as header
        JButton contactButton = new JButton("Contact Us");
        contactButton.setFont(new Font("Arial", Font.BOLD, 16));
        contactButton.setBackground(Color.WHITE);
        contactButton.setForeground(new Color(70, 130, 180)); // Steel Blue
        contactButton.setPreferredSize(new Dimension(150, 40));
        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simulate contact action (you can open an email client, or contact form)
                JOptionPane.showMessageDialog(null, "For inquiries, email us at: contact@yourproject.com");
            }
        });
        footerPanel.add(contactButton);
        
        // Add panels to the frame
        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(contentPanel, BorderLayout.CENTER);
        panel.add(footerPanel, BorderLayout.SOUTH);
        
        add(panel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new aboutuspage().setVisible(true);
            }
        });
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author acer
 */
