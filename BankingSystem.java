import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class BankingSystem {
    private static HashMap<String, Integer> accounts = new HashMap<>();

    public static void main(String[] args) {
        // Dummy data (account number -> balance)
        accounts.put("A0001", 5000);
        accounts.put("A0002", 3000);
        accounts.put("A0003", 10000);

        // Create JFrame (Main Window)
        JFrame frame = new JFrame("Online Banking System");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Title Label
        JLabel titleLabel = new JLabel("Welcome to Online Banking");
        titleLabel.setBounds(150, 20, 200, 30);
        frame.add(titleLabel);

        // Account Number Label & Field
        JLabel accLabel = new JLabel("Enter Account No:");
        accLabel.setBounds(50, 80, 150, 25);
        frame.add(accLabel);

        JTextField accField = new JTextField();
        accField.setBounds(200, 80, 150, 25);
        frame.add(accField);

        // Find Account Button
        JButton findButton = new JButton("Find Account");
        findButton.setBounds(360, 80, 120, 25);
        frame.add(findButton);

        // Balance Label
        JLabel balanceLabel = new JLabel("");
        balanceLabel.setBounds(200, 120, 200, 25);
        frame.add(balanceLabel);

        // Deposit Button
        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(200, 160, 100, 25);
        frame.add(depositButton);
        depositButton.setVisible(false); // Hidden until account is found

        // Withdraw Button
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(320, 160, 100, 25);
        frame.add(withdrawButton);
        withdrawButton.setVisible(false); // Hidden until account is found

        // Find Account Action
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accNumber = accField.getText();
                if (accounts.containsKey(accNumber)) {
                    balanceLabel.setText("Balance: $" + accounts.get(accNumber));
                    depositButton.setVisible(true);  // Show deposit button
                    withdrawButton.setVisible(true); // Show withdraw button
                } else {
                    balanceLabel.setText("Account Not Found!");
                    depositButton.setVisible(false);
                    withdrawButton.setVisible(false);
                }
            }
        });

        // Deposit Money Action
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accNumber = accField.getText();
                if (accounts.containsKey(accNumber)) {
                    String amountStr = JOptionPane.showInputDialog("Enter deposit amount:");
                    if (amountStr != null) {
                        try {
                            int amount = Integer.parseInt(amountStr);
                            if (amount > 0) {
                                accounts.put(accNumber, accounts.get(accNumber) + amount);
                                balanceLabel.setText("Balance: $" + accounts.get(accNumber));
                                JOptionPane.showMessageDialog(frame, "Deposit Successful!");
                            } else {
                                JOptionPane.showMessageDialog(frame, "Invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Account Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Withdraw Money Action
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accNumber = accField.getText();
                if (accounts.containsKey(accNumber)) {
                    String amountStr = JOptionPane.showInputDialog("Enter withdrawal amount:");
                    if (amountStr != null) {
                        try {
                            int amount = Integer.parseInt(amountStr);
                            if (amount > 0 && amount <= accounts.get(accNumber)) {
                                accounts.put(accNumber, accounts.get(accNumber) - amount);
                                balanceLabel.setText("Balance: $" + accounts.get(accNumber));
                                JOptionPane.showMessageDialog(frame, "Withdrawal Successful!");
                            } else if (amount > accounts.get(accNumber)) {
                                JOptionPane.showMessageDialog(frame, "Insufficient Funds!", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(frame, "Invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Account Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Show Frame
        frame.setVisible(true);
    }
}