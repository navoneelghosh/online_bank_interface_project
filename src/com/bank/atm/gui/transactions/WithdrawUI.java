package com.bank.atm.gui.transactions;

import com.bank.atm.backend.accounts.Account;
import com.bank.atm.backend.collections.AccountsCollectionManager;
import com.bank.atm.util.ID;
import com.bank.atm.util.IllegalTransactionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

public class WithdrawUI extends JFrame {

    private final int frameWidth = 500;
    private final int frameHeight = 500;
    private ID userID;

    private JPanel withdrawPanel;
    private JComboBox accountComboBox;
    private JLabel currencyTypeLabel;
    private JFormattedTextField amountTextField;
    private JTextField currentBalanceTextField;
    private JButton withdrawButton;
    private JLabel currencyTypeLabel1;

    /**
     * TODO add field for choosing account to withdraw from and adjust currency format according to locale of that account
     */
    public WithdrawUI(ID userID) {
        this.userID = userID;
        $$$setupUI$$$();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(withdrawPanel);//sets content to our menu panel
        this.setPreferredSize(new Dimension(frameWidth, frameHeight));//set width and height of our frame
        this.pack(); //packs frame to preferred size
        amountTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                //do not allow user to enter any characters besides digits and backspace/delete
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == '.')) {
                    e.consume();
                }
                super.keyTyped(e);
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Account account = (Account) accountComboBox.getSelectedItem();
                double amt = withdrawFromAccount(account);
                currentBalanceTextField.setText(account.displayAccountValue());
                JOptionPane.showMessageDialog(WithdrawUI.this, amt + " has been withdrawn from Account ID " + account.getID() + ".\nNew Balance: " + account.displayAccountValue());
            }
        });
        accountComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                updateLabelsBasedOnSelectedAccount();
            }
        });
        updateLabelsBasedOnSelectedAccount();
    }

    private void createUIComponents() {
        accountComboBox = new JComboBox<Account>(getUserAccounts());
        accountComboBox.setRenderer(new AccountListRenderer());
        amountTextField = new JFormattedTextField(NumberFormat.getInstance());

    }

    /**
     * updates the labels of other components based on the account that is currently selected
     */
    private void updateLabelsBasedOnSelectedAccount() {
        Account account = (Account) (accountComboBox.getSelectedItem());
        if (account == null)
            return;
        currentBalanceTextField.setText(account.displayAccountValue());
        currencyTypeLabel.setText(account.getCurrency().toString());
        currencyTypeLabel1.setText(account.getCurrency().toString());
    }

    private Account[] getUserAccounts() {
        List<Account> accountList = AccountsCollectionManager.getInstance().findByOwnerID(userID);
        Account[] accounts = new Account[accountList.size()];
        for (int i = 0; i < accountList.size(); i++) {
            accounts[i] = accountList.get(i);
        }
        return accounts;
    }

    /**
     * withdraws money from the account
     *
     * @param account
     * @return amount of money that has been withdrawn
     */
    private double withdrawFromAccount(Account account) {
        double amt = 0;
        try {
            amt = ((Number) amountTextField.getValue()).doubleValue();
        } catch (NullPointerException ignored) {
            System.out.println("OH NULL POINTER");
        }
        System.out.println("Attempting to withdraw " + amt);
        try {
            account.removeValue(amt);
        } catch (IllegalTransactionException e) {
            JOptionPane.showMessageDialog(this, e);
        }
        try {
            AccountsCollectionManager.getInstance().save(account);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "ERROR WITHDRAWING");
        }
        return amt;
    }


    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        withdrawPanel = new JPanel();
        withdrawPanel.setLayout(new GridBagLayout());
        final JLabel label1 = new JLabel();
        label1.setText("Make Withdrawal");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        withdrawPanel.add(label1, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        withdrawPanel.add(spacer1, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        withdrawPanel.add(accountComboBox, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Choose Account:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        withdrawPanel.add(label2, gbc);
        currencyTypeLabel = new JLabel();
        currencyTypeLabel.setText("USD");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        withdrawPanel.add(currencyTypeLabel, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        withdrawPanel.add(amountTextField, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(0, 0, 50, 0);
        withdrawPanel.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        withdrawPanel.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        withdrawPanel.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        withdrawPanel.add(spacer5, gbc);
        withdrawButton = new JButton();
        withdrawButton.setText("Withdraw");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        withdrawPanel.add(withdrawButton, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        withdrawPanel.add(spacer6, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Current Balance");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        withdrawPanel.add(label3, gbc);
        currentBalanceTextField = new JTextField();
        currentBalanceTextField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        withdrawPanel.add(currentBalanceTextField, gbc);
        currencyTypeLabel1 = new JLabel();
        currencyTypeLabel1.setText("USD");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        withdrawPanel.add(currencyTypeLabel1, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Withdraw Amount:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        withdrawPanel.add(label4, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return withdrawPanel;
    }

}
