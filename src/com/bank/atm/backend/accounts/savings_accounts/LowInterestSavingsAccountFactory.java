package com.bank.atm.backend.accounts.savings_accounts;

import com.bank.atm.backend.accounts.Account;
import com.bank.atm.backend.accounts.AccountFactoryCreator;
import com.bank.atm.backend.accounts.AccountsUtil;
import com.bank.atm.backend.accounts.interest.InterestCompoundedMonthly;
import com.bank.atm.backend.accounts.interest.InterestEarnable;
import com.bank.atm.backend.accounts.interest.InterestEarningExecutor;
import com.bank.atm.backend.currency.Currency;
import com.bank.atm.backend.currency.Money;
import com.bank.atm.backend.users.User;
import com.bank.atm.util.ID;

import java.util.Date;
import java.util.List;

/**
 * Class LowInterestSavingsAccountFactory is a Factory which creates a LowInterestSavingsAccount
 *
 * @author: Nathan Lauer
 * @email: lauern@bu.edu
 * Creation Date: 12/10/20
 * <p>
 * Please feel free to ask me any questions. I hope you're having a nice day!
 */
public class LowInterestSavingsAccountFactory implements AccountFactoryCreator {
    private final Currency currency;
    private final double initialAmount;
    private final User user;
    private final ID accountId;

    /**
     * Standard constructor
     * @param currency the Currency to use for this Account
     * @param initialAmount the initial monetary value for this account
     * @param user the User creating this Account.
     */
    public LowInterestSavingsAccountFactory(Currency currency, double initialAmount, User user, ID accountId) {
        this.currency = currency;
        this.initialAmount = initialAmount;
        this.user = user;
        this.accountId = accountId;
    }

    /**
     * Creates the appropriate type of Account
     *
     * @return Account object of appropriate subtype.
     */
    @Override
    public Account createAccount() {
        // First, build the basic account
        List<ID> managers = AccountsUtil.buildManagerListFromUser(user);
        Account account = new LowInterestSavingsAccount(currency, new Money(initialAmount), managers, accountId);

        // This account earns interest: 1.5% interest per year
        double apy = 1.5;
        InterestEarningExecutor interestEarningExecutor = new InterestCompoundedMonthly(account, new Date(), apy);
        InterestEarnable earnable = (InterestEarnable)account;
        earnable.setInterestEarningExecutor(interestEarningExecutor);

        return account;
    }
}
