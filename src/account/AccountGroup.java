package account;

import java.util.*;

public class AccountGroup extends AbstractAccount{
	private String name;
    private List<AbstractAccount> accounts;

	public AccountGroup(String name) {
		super();
		this.name = name;
		this.accounts = new ArrayList<AbstractAccount>();
	}

	public void addAccount(AbstractAccount account) {
		accounts.add(account);
	}
	
	public void removeAccount(AbstractAccount account) {
		if(accounts.contains(account)) {
			accounts.remove(account);
		}
		else {
			System.out.println("This account can't be removed because it doesn't exist");
		}

	}
	
	public List<AbstractAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AbstractAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public void display() {
       System.out.println("+Account Group: " + name);
        for (AbstractAccount component : accounts) {
        	System.out.print("----");
            component.display();
        }
        System.out.println();
	}

	
/*  public List<Account> getAccounts() {
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
    }*/
    

}
