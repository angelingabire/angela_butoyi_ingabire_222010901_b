package ange;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import angela.customerform;
import butoyi.branchform;
import ingabire.accountform;
import manzi.transactionform;
import mugabo.employeeform;

public class Menu extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu homeMenu;
    private JMenuItem  customerItem;
    private JMenuItem  branchItem;
    private JMenuItem accountItem;
    private JMenuItem transactionItem;
    private JMenuItem employeeItem;
    private JMenuItem settingsItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public Menu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        homeMenu = new JMenu("Home");

        // Create menu items
        customerItem = new JMenuItem(" customer");
        customerItem.addActionListener(this);
        branchItem = new JMenuItem("branch");
        branchItem.addActionListener(this);
        accountItem = new JMenuItem("account");
        accountItem.addActionListener(this);
        transactionItem = new JMenuItem("transaction");
        transactionItem.addActionListener(this);
        employeeItem = new JMenuItem("employee");
        employeeItem.addActionListener(this);
        settingsItem = new JMenuItem("Settings");
        settingsItem.addActionListener(this);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        homeMenu.add(customerItem);
        homeMenu.add(branchItem);
        homeMenu.add(accountItem);
        homeMenu.add(transactionItem);
        homeMenu.add(employeeItem);
        homeMenu.addSeparator();
        homeMenu.add(settingsItem);
        homeMenu.addSeparator();
        homeMenu.add(logoutItem);

        // Add home menu to menu bar
        menuBar.add(homeMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel
        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("Welcome " + loggedInUser + " to Dashboard");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customerItem) {
            JOptionPane.showMessageDialog(this, "customer form...");
            new customerform();
        } else if (e.getSource() == branchItem) {
            JOptionPane.showMessageDialog(this, "branch form...");
            new branchform();
        } else if (e.getSource() == accountItem) {
            JOptionPane.showMessageDialog(this, "account form...");
            new accountform();
        } else if (e.getSource() ==transactionItem) {
            JOptionPane.showMessageDialog(this, "transaction form...");
            new transactionform();
        } else if (e.getSource() == employeeItem) {
            JOptionPane.showMessageDialog(this, "employee form...");
            new employeeform();
        } else if (e.getSource() == settingsItem) {
            String newUsername = JOptionPane.showInputDialog(this, "Enter new username:");
            String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
            JOptionPane.showMessageDialog(this, "User registered successfully: " + newUsername);
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu("angela_butoyi_ingabire_b_m_s"));
    }
}

 


