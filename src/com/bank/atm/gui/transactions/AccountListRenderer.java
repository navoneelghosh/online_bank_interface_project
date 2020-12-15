package com.bank.atm.gui.transactions;
/**
 * @author Sandra Zhen
 * This class renders the account combo box (the select-account drop-down menu)
 */

import com.bank.atm.backend.accounts.Account;
import com.bank.atm.util.Formatter;

import javax.swing.*;
import java.awt.*;

public class AccountListRenderer extends JLabel implements ListCellRenderer<Account> {
    public AccountListRenderer(){
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Account> list, Account value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(Formatter.splitCamelCase(value.getClass().getSimpleName())+" "+ value.getID());
        return this;
    }
}
