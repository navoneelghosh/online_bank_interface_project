package com.bank.atm.gui.util_gui;
/**
 * @author Sandra Zhen
 * This class renders the account combo box (the select-account drop-down menu)
 */

import com.bank.atm.backend.accounts.Account;
import com.bank.atm.backend.accounts.loan_accounts.LoanAccount;
import com.bank.atm.util.Formatter;

import javax.swing.*;
import java.awt.*;

public class LoansListRenderer extends JTextArea implements ListCellRenderer<Account> {
    private static final int DEFAULT_ROWS = 5;
    private static final int DEFAULT_COLS = 15;
    public LoansListRenderer(){
        this(DEFAULT_ROWS,DEFAULT_COLS);
    }

    /**
     *
     * @param rows - number of rows this component spans
     * @param cols - number of columns this component spans
     */
    public LoansListRenderer(int rows, int cols){
        super(rows,cols);
        setOpaque(true);
        setLineWrap(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Account> list, Account value, int index, boolean isSelected, boolean cellHasFocus) {
        String s = "";
        if(value!=null) {
            s=Formatter.splitCamelCase(value.getClass().getSimpleName()) + " " + value.getID();
            if(value instanceof LoanAccount)
                s+=" STATUS: "+((LoanAccount) value).getLoanState();
            setText(s);
        }
        return this;
    }
}
