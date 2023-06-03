package user;

import java.util.ArrayList;
import java.util.List;

import application.Account;
import application.AccountGroup;
import user.Bank;

// Client class
public class Client {
    private List<Account> accounts;
    private List<AccountGroup> accountGroups;
    private AccountGroup topAccountGroup;

    public Client() {
        accounts = new ArrayList<>();
        accountGroups = new ArrayList<>();
        topAccountGroup = new AccountGroup("Top Account Group");
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        topAccountGroup.addAccount(account);
    }

    public Account getAccount(int index) {
        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        }
        return null;
    }

    public int getNumAccounts() {
        return accounts.size();
    }

    public void addAccountGroup(AccountGroup accountGroup) {
        accountGroups.add(accountGroup);
        topAccountGroup.addAccountGroup(accountGroup);
    }

    public AccountGroup getAccountGroup(int index) {
        if (index >= 0 && index < accountGroups.size()) {
            return accountGroups.get(index);
        }
        return null;
    }

    public int getNumAccountGroups() {
        return accountGroups.size();
    }

    public double calculateAccountGroupBalance(AccountGroup accountGroup) {
        double balance = 0.0;
        List<Account> groupAccounts = accountGroup.getAccounts();
        for (Account account : groupAccounts) {
            balance += account.getBalance();
        }

        List<AccountGroup> childGroups = accountGroup.getAccountGroups();
        for (AccountGroup childGroup : childGroups) {
            balance += calculateAccountGroupBalance(childGroup);
        }

        return balance;
    }

    public double calculateAccountGroupBalanceInTRY(AccountGroup accountGroup, Bank bank) {
        double balance = calculateAccountGroupBalance(accountGroup);
        double exchangeRate = bank.getCurrencyRate("TRY");
        return balance * exchangeRate;
    }

    public double calculateFutureBalance(Account account, int days) {
        return account.calculateFutureBalance(days);
    }

    public double calculateFutureBalance(AccountGroup accountGroup, int days) {
        double balance = 0.0;
        List<Account> groupAccounts = accountGroup.getAccounts();
        for (Account account : groupAccounts) {
            balance += calculateFutureBalance(account, days);
        }

        List<AccountGroup> childGroups = accountGroup.getAccountGroups();
        for (AccountGroup childGroup : childGroups) {
            balance += calculateFutureBalance(childGroup, days);
        }

        return balance;
    }
}