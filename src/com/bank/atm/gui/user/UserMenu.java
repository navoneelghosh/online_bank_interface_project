package com.bank.atm.gui.user;

/**
 * @author Sandra Zhen
 * Class represents user menu interface when user first logs in
 */
import com.bank.atm.gui.loans.PayLoanUI;
import com.bank.atm.gui.loans.RequestLoansUI;
import com.bank.atm.gui.loans.ViewLoansUI;
import com.bank.atm.gui.transactions.DepositUI;
import com.bank.atm.gui.transactions.TransferMoneyUI;
import com.bank.atm.gui.transactions.WithdrawUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends JFrame {
    private final int frameWidth = 500;
    private final int frameHeight = 500;

    private JPanel userMenuPanel;
    private JLabel usernameLabel;
    private JButton viewAccountsButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferMoneyButton;
    private JButton viewLoansButton;
    private JButton addNewAccountButton;
    private JButton payLoansButton;
    private JButton requestLoansButton;

    public UserMenu(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(userMenuPanel);//sets content to our menu panel
        this.setPreferredSize(new Dimension(frameWidth, frameHeight));//set width and height of our frame
        this.pack(); //packs frame to preferred size
        usernameLabel.setText("Welcome " + getUserName() + "!");
        addNewAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserAddAccount userAddAccount = new UserAddAccount(getID());
                userAddAccount.setVisible(true);
            }
        });
        viewAccountsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UserViewAccounts userViewAccounts = new UserViewAccounts(getID());
                userViewAccounts.setVisible(true);
            }
        });
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositUI depositUI = new DepositUI();
                depositUI.setVisible(true);
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawUI withdrawUI = new WithdrawUI();
                withdrawUI.setVisible(true);
            }
        });
        transferMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransferMoneyUI transferMoneyUI = new TransferMoneyUI();
                transferMoneyUI.setVisible(true);
            }
        });
        requestLoansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RequestLoansUI requestLoansUI = new RequestLoansUI();
                requestLoansUI.setVisible(true);
            }
        });
        viewLoansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewLoansUI viewLoansUI = new ViewLoansUI();
                viewLoansUI.setVisible(true);
            }
        });
        payLoansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PayLoanUI payLoanUI = new PayLoanUI();
                payLoanUI.setVisible(true);
            }
        });
    }

    /**
     * Returns name of the user
     *
     * @return
     */
    private String getUserName() {
        //TODO retrieve and return username from oauth
        return "Name";
    }

    private String getID() {
        //TODO retrieve and return userID from oauth
        return "98454598";
    }

    //TODO delete later. this for testing purposes
    public static void main(String[] args) {
        JFrame frame = new UserMenu("User Menu");
        frame.setVisible(true);
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
        userMenuPanel = new JPanel();
        userMenuPanel.setLayout(new GridBagLayout());
        userMenuPanel.setEnabled(true);
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.insets = new Insets(50, 0, 0, 0);
        userMenuPanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        userMenuPanel.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.VERTICAL;
        userMenuPanel.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        userMenuPanel.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        userMenuPanel.add(spacer5, gbc);
        addNewAccountButton = new JButton();
        addNewAccountButton.setText("Add New Account");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        userMenuPanel.add(addNewAccountButton, gbc);
        viewAccountsButton = new JButton();
        viewAccountsButton.setText("View Accounts");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        userMenuPanel.add(viewAccountsButton, gbc);
        depositButton = new JButton();
        depositButton.setText("Deposit");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        userMenuPanel.add(depositButton, gbc);
        withdrawButton = new JButton();
        withdrawButton.setHorizontalTextPosition(0);
        withdrawButton.setText("Withdraw");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        userMenuPanel.add(withdrawButton, gbc);
        transferMoneyButton = new JButton();
        transferMoneyButton.setText("Transfer Money");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        userMenuPanel.add(transferMoneyButton, gbc);
        usernameLabel = new JLabel();
        usernameLabel.setText("Welcome");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        userMenuPanel.add(usernameLabel, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 0, 0);
        userMenuPanel.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 50, 0, 0);
        userMenuPanel.add(spacer7, gbc);
        viewLoansButton = new JButton();
        viewLoansButton.setText("View Loans");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        userMenuPanel.add(viewLoansButton, gbc);
        payLoansButton = new JButton();
        payLoansButton.setText("Pay Loans");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        userMenuPanel.add(payLoansButton, gbc);
        requestLoansButton = new JButton();
        requestLoansButton.setText("Request Loans");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        userMenuPanel.add(requestLoansButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return userMenuPanel;
    }

}
