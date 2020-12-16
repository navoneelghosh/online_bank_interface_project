package com.bank.atm.gui.user;
/**
 * The UI for showing the full account details
 *
 * @author Sandra Zhen
 */
import com.bank.atm.backend.accounts.Account;
import com.bank.atm.backend.collections.AccountsCollectionManager;
import com.bank.atm.gui.transactions.DepositUI;
import com.bank.atm.gui.transactions.ViewTransactionsUI;
import com.bank.atm.gui.transactions.WithdrawUI;
import com.bank.atm.util.Formatter;
import com.bank.atm.util.ID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;


public class AccountDetails extends JFrame {
    private final int frameWidth = 500;
    private final int frameHeight = 500;

    private JButton depositButton;
    private JButton withdrawButton;
    private JPanel transactionPanel;
    private JTextArea balanceValueLabel;
    private JComboBox currencyTypeComboBox;
    private JPanel accountDetailsPanel;
    private JTextArea accountTypeValueLabel;
    private JPanel accountDetailsMainPanel;
    private JTextArea currencyTypeLabel;
    private JTextArea dateOpenedTextField;
    private JLabel accountNameLabel;
    private JButton viewTransactionsButton;

    public AccountDetails(ID userID, Account account) {
        super(Formatter.splitCamelCase(account.getClass().getSimpleName()) + " " + account.getID() + " Details");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(accountDetailsMainPanel);//sets content to our menu panel
        this.setPreferredSize(new Dimension(frameWidth, frameHeight));//set width and height of our frame
        this.pack();
        updateLabels(account);

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositUI depositUI = new DepositUI(userID, account);
                depositUI.setVisible(true);
                AccountDetails.this.dispose();
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawUI withdrawUI = new WithdrawUI(userID, account);
                withdrawUI.setVisible(true);
                AccountDetails.this.dispose();
            }
        });
        viewTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewTransactionsUI viewTransactionsUI = new ViewTransactionsUI(account);
                viewTransactionsUI.setVisible(true);
            }
        });
    }

    /**
     * updates labels of this UI based on the account
     *
     * @param account
     */
    private void updateLabels(Account account) {
        accountNameLabel.setText(Formatter.splitCamelCase(account.getClass().getSimpleName()) + " " + account.getID() + " Details");
        accountTypeValueLabel.setText(Formatter.splitCamelCase(account.getClass().getSimpleName()));
        currencyTypeLabel.setText(account.getCurrency().toString());
        balanceValueLabel.setText(account.displayAccountValue());
        dateOpenedTextField.setText("" + account.getOpened());
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        accountDetailsMainPanel = new JPanel();
        accountDetailsMainPanel.setLayout(new GridBagLayout());
        accountDetailsPanel = new JPanel();
        accountDetailsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        accountDetailsMainPanel.add(accountDetailsPanel, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Current Balance");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        accountDetailsPanel.add(label1, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        accountDetailsPanel.add(spacer1, gbc);
        balanceValueLabel = new JTextArea();
        balanceValueLabel.setEditable(false);
        balanceValueLabel.setText("0.00");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(20, 20, 20, 20);
        accountDetailsPanel.add(balanceValueLabel, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Currency Type:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        accountDetailsPanel.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Account Type:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 10, 0, 10);
        accountDetailsPanel.add(label3, gbc);
        accountTypeValueLabel = new JTextArea();
        accountTypeValueLabel.setEditable(false);
        accountTypeValueLabel.setText("Checkings");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        accountDetailsPanel.add(accountTypeValueLabel, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        accountDetailsPanel.add(spacer2, gbc);
        currencyTypeLabel = new JTextArea();
        currencyTypeLabel.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        accountDetailsPanel.add(currencyTypeLabel, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        accountDetailsPanel.add(spacer3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Date Opened:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 10, 0, 10);
        accountDetailsPanel.add(label4, gbc);
        dateOpenedTextField = new JTextArea();
        dateOpenedTextField.setEditable(false);
        dateOpenedTextField.setEnabled(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        accountDetailsPanel.add(dateOpenedTextField, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        accountDetailsPanel.add(spacer4, gbc);
        accountNameLabel = new JLabel();
        accountNameLabel.setHorizontalAlignment(2);
        accountNameLabel.setHorizontalTextPosition(0);
        accountNameLabel.setText("Account Name Details");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        accountDetailsMainPanel.add(accountNameLabel, gbc);
        transactionPanel = new JPanel();
        transactionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        accountDetailsMainPanel.add(transactionPanel, gbc);
        depositButton = new JButton();
        depositButton.setText("Deposit");
        transactionPanel.add(depositButton);
        withdrawButton = new JButton();
        withdrawButton.setText("Withdraw");
        transactionPanel.add(withdrawButton);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(30, 0, 0, 0);
        accountDetailsMainPanel.add(spacer5, gbc);
        viewTransactionsButton = new JButton();
        viewTransactionsButton.setText("View Transactions");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        accountDetailsMainPanel.add(viewTransactionsButton, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.VERTICAL;
        accountDetailsMainPanel.add(spacer6, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return accountDetailsMainPanel;
    }

}
