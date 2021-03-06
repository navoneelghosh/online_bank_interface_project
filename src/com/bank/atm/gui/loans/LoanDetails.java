package com.bank.atm.gui.loans;
/**
 * @author Sandra Zhen
 * UI for viewing details on loan
 */

import com.bank.atm.backend.accounts.Account;
import com.bank.atm.backend.accounts.loan_accounts.LoanAccount;
import com.bank.atm.backend.accounts.loan_accounts.LoanState;
import com.bank.atm.backend.currency.CurrencyType;
import com.bank.atm.backend.currency.JPY;
import com.bank.atm.backend.interest.InterestEarnable;
import com.bank.atm.backend.interest.InterestEarningExecutor;
import com.bank.atm.util.Formatter;
import com.bank.atm.util.ID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;

public class LoanDetails extends JFrame {
    private final int frameWidth = 500;
    private final int frameHeight = 500;
    private JTextArea collateralValueTextArea;
    private JTextArea interestTextArea;
    private JTextArea collateralTextArea;
    private JTextArea currencyTypeTextArea;
    private JTextArea balanceOwedTextArea;
    private JTextArea balancePaidTextArea;
    private JPanel loanDetailsPanel;
    private JPanel viewLoanPanel;
    private JTextArea dateOpenedTextArea;
    private JButton payLoanButton;


    public LoanDetails(ID userID, LoanAccount loanAccount) {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(loanDetailsPanel);//sets content to our menu panel
        this.setPreferredSize(new Dimension(frameWidth, frameHeight));//set width and height of our frame
        this.pack();

        setLabels(loanAccount);
        //ENABLE LOAN PAYMENT ONLY WHEN LOAN HAS BEEN APPROVED
        payLoanButton.setEnabled(loanAccount.hasState(LoanState.APPROVED));
        payLoanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PayLoanUI payLoanUI = new PayLoanUI(userID, loanAccount);
                payLoanUI.setVisible(true);
                setLabels(loanAccount);
            }
        });

    }

    /**
     * Sets labels of each gui component according to loan account values
     *
     * @param loanAccount
     */
    private void setLabels(LoanAccount loanAccount) {
        collateralValueTextArea.setText(loanAccount.getCollateralValue() + "");
        collateralTextArea.setText(loanAccount.getCollateral());
        currencyTypeTextArea.setText(loanAccount.getCurrency() + "");
        balanceOwedTextArea.setText(loanAccount.getMoneyOwed() + "");
        balancePaidTextArea.setText(loanAccount.getMoneyPaid() + "");
        dateOpenedTextArea.setText(loanAccount.getOpened() + "");

        if (loanAccount instanceof InterestEarnable) {
            InterestEarnable earnable = (InterestEarnable) loanAccount;
            InterestEarningExecutor executor = earnable.getInterestEarningExecutor();
            interestTextArea.setText(executor.getApy() + "");
        }
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
        loanDetailsPanel = new JPanel();
        loanDetailsPanel.setLayout(new GridBagLayout());
        viewLoanPanel = new JPanel();
        viewLoanPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        loanDetailsPanel.add(viewLoanPanel, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Balance Paid:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        viewLoanPanel.add(label1, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewLoanPanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        viewLoanPanel.add(spacer2, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Balance Owed:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        viewLoanPanel.add(label2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        viewLoanPanel.add(spacer3, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Currency Type:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        viewLoanPanel.add(label3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        viewLoanPanel.add(spacer4, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Collateral:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        viewLoanPanel.add(label4, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("Collateral Value:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.anchor = GridBagConstraints.WEST;
        viewLoanPanel.add(label5, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.VERTICAL;
        viewLoanPanel.add(spacer5, gbc);
        final JLabel label6 = new JLabel();
        label6.setText("Interest:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        viewLoanPanel.add(label6, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        viewLoanPanel.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.VERTICAL;
        viewLoanPanel.add(spacer7, gbc);
        final JLabel label7 = new JLabel();
        label7.setText("Date Opened:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        viewLoanPanel.add(label7, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewLoanPanel.add(spacer8, gbc);
        balancePaidTextArea = new JTextArea();
        balancePaidTextArea.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewLoanPanel.add(balancePaidTextArea, gbc);
        balanceOwedTextArea = new JTextArea();
        balanceOwedTextArea.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewLoanPanel.add(balanceOwedTextArea, gbc);
        currencyTypeTextArea = new JTextArea();
        currencyTypeTextArea.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewLoanPanel.add(currencyTypeTextArea, gbc);
        interestTextArea = new JTextArea();
        interestTextArea.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewLoanPanel.add(interestTextArea, gbc);
        dateOpenedTextArea = new JTextArea();
        dateOpenedTextArea.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewLoanPanel.add(dateOpenedTextArea, gbc);
        collateralTextArea = new JTextArea();
        collateralTextArea.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewLoanPanel.add(collateralTextArea, gbc);
        collateralValueTextArea = new JTextArea();
        collateralValueTextArea.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 12;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        viewLoanPanel.add(collateralValueTextArea, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        loanDetailsPanel.add(spacer9, gbc);
        final JLabel label8 = new JLabel();
        label8.setText("Loan Details");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        loanDetailsPanel.add(label8, gbc);
        payLoanButton = new JButton();
        payLoanButton.setText("Pay Loan");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loanDetailsPanel.add(payLoanButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return loanDetailsPanel;
    }
}
