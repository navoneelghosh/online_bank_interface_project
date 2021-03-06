package com.bank.atm.gui.transactions;
/**
 * @author Sandra Zhen
 * UI for user deposit
 */

import com.bank.atm.backend.accounts.Account;
import com.bank.atm.backend.accounts.loan_accounts.LoanAccount;
import com.bank.atm.backend.collections.AccountsCollectionManager;
import com.bank.atm.backend.collections.TransactionsCollectionManager;
import com.bank.atm.backend.transactions.Deposit;
import com.bank.atm.gui.util_gui.AccountListRenderer;
import com.bank.atm.util.ID;
import com.bank.atm.util.IllegalTransactionException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class DepositUI extends JFrame {

    private final int frameWidth = 500;
    private final int frameHeight = 500;

    private ID userID;

    private JPanel depositPanel;
    private JLabel amountLabel;
    private JFormattedTextField depositAmountField;
    private JComboBox<? extends Account> chooseAccountComboBox;
    private JLabel currencyTypeLabel;
    private JTextField currentBalanceTextField;
    private JButton makeDepositButton;
    private JLabel currencyTypeLabel1;

    public DepositUI(ID userID, Account account) {
        this(userID);
        chooseAccountComboBox.setSelectedItem(account);
        updateLabelsBasedOnSelectedAccount();
    }

    //creates the deposit ui
    public DepositUI(ID userID) {
        this.userID = userID;
        $$$setupUI$$$();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(depositPanel);//sets content to our menu panel
        this.setPreferredSize(new Dimension(frameWidth, frameHeight));//set width and height of our frame
        this.pack(); //packs frame to preferred size
        depositAmountField.addKeyListener(new KeyAdapter() {
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
        chooseAccountComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                updateLabelsBasedOnSelectedAccount();
            }
        });
        makeDepositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Account account = (Account) chooseAccountComboBox.getSelectedItem();
                double amt = makeDeposit(account);
                currentBalanceTextField.setText(account.displayAccountValue());
                if (amt > 0)
                    JOptionPane.showMessageDialog(DepositUI.this, amt + " has been deposited to Account ID " + account.getID() + ".\nNew Balance: " + account.displayAccountValue());
            }
        });
        updateLabelsBasedOnSelectedAccount();
    }

    /**
     * updates the labels of other components based on the account that is currently selected
     */
    private void updateLabelsBasedOnSelectedAccount() {
        Account account = (Account) (chooseAccountComboBox.getSelectedItem());
        if (account == null)
            return;
        currentBalanceTextField.setText(account.displayAccountValue());
        currencyTypeLabel.setText(account.getCurrency().toString());
        currencyTypeLabel1.setText(account.getCurrency().toString());
    }

    /**
     * makes a deposit to the specified account
     *
     * @param account
     * @return amount of money that has been deposited
     */
    private double makeDeposit(Account account) {
        double depositAmt = getDepositAmount();
        //do deposit
        try {
            TransactionsCollectionManager.getInstance().executeTransaction(new Deposit(userID, account.getID(), depositAmt));
        } catch (IllegalTransactionException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            depositAmt = 0;
        }
        return depositAmt;
    }

    /**
     * Returns deposit amount entered by user
     *
     * @return
     */
    private double getDepositAmount() {
        double depositAmt = 0;
        try {
            depositAmt = ((Number) depositAmountField.getValue()).doubleValue();
        } catch (NullPointerException e) {
            depositAmt = 0;
        }
        return depositAmt;
    }

    private void createUIComponents() {
        chooseAccountComboBox = new JComboBox<Account>(getUserNonLoanAccounts());
        chooseAccountComboBox.setRenderer(new AccountListRenderer());

        depositAmountField = new JFormattedTextField(NumberFormat.getNumberInstance());
        depositAmountField.setText("0");//default starting balance to 0
    }

    /**
     * Returns all of user's non-loan accounts
     *
     * @return
     */
    private Account[] getUserNonLoanAccounts() {
        List<Account> accountList = AccountsCollectionManager.getInstance().findByOwnerID(userID);
        List<Account> nonLoanAccounts = new ArrayList<>();
        for (Account account : accountList) {
            if (!(account instanceof LoanAccount)) {
                nonLoanAccounts.add(account);
            }
        }
        Account[] accounts = new Account[nonLoanAccounts.size()];
        for (int i = 0; i < nonLoanAccounts.size(); i++) {
            accounts[i] = nonLoanAccounts.get(i);
        }
        return accounts;
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
        depositPanel = new JPanel();
        depositPanel.setLayout(new GridBagLayout());
        amountLabel = new JLabel();
        amountLabel.setText("Amount");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        depositPanel.add(amountLabel, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        depositPanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(0, 0, 50, 0);
        depositPanel.add(spacer2, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        depositPanel.add(depositAmountField, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Choose Account");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        depositPanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Make Deposit");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        depositPanel.add(label2, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        depositPanel.add(chooseAccountComboBox, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        depositPanel.add(spacer3, gbc);
        currencyTypeLabel = new JLabel();
        currencyTypeLabel.setText("USD");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        depositPanel.add(currencyTypeLabel, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        depositPanel.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        depositPanel.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        depositPanel.add(spacer6, gbc);
        makeDepositButton = new JButton();
        makeDepositButton.setText("Make Deposit");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        depositPanel.add(makeDepositButton, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.VERTICAL;
        depositPanel.add(spacer7, gbc);
        currentBalanceTextField = new JTextField();
        currentBalanceTextField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        depositPanel.add(currentBalanceTextField, gbc);
        currencyTypeLabel1 = new JLabel();
        currencyTypeLabel1.setText("USD");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        depositPanel.add(currencyTypeLabel1, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Current Balance: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        depositPanel.add(label3, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return depositPanel;
    }

}
