package account;

import java.util.*;

import enums.CurrencyType;
import enums.ForeignCurrencyAccountType;

public class AccountGroup extends AbstractAccount{
	private String name;
    private List<AbstractAccount> accounts;

	public AccountGroup(String name) {
		this.name = name;
		this.accounts = new ArrayList<AbstractAccount>();
		super.setCurrencyType(CurrencyType.TRY);
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
	
	public double getSingleAccountGroupBalance() {
		//for only the accounts that are under one accountgroup
		double totalBalance = 0;
		for (AbstractAccount curAccount : this.accounts) {
            if (!(curAccount instanceof AccountGroup)) {
            	totalBalance += curAccount.getBalance();
            }
		}
		return totalBalance;
	}
	
	public double getTotalAccountGroupBalance() {
		double totalBalance = 0;
		//gets first its own balance
		totalBalance += getSingleAccountGroupBalance();
		//traverses through all accountgroups under this accountgroup to get the whole balance
		for (AbstractAccount curAccountGroup : accounts) {
            if (curAccountGroup instanceof AccountGroup) {
            	totalBalance += ((AccountGroup)curAccountGroup).getSingleAccountGroupBalance();
            }
		}
		//set etmeli mi?
		return totalBalance;	
	}
	
	@Override
	public void display() {
       System.out.println("+Account Group: " + name);
        for (AbstractAccount component : accounts) {
        	System.out.print("--");
            component.display();
        }
	}
	
	public void displayGroupName() {
		System.out.println("+Account Group: " + name);
		for(int i = 0; i< accounts.size(); i++) {
    		AbstractAccount currentAccount = accounts.get(i);
    		if(currentAccount instanceof AccountGroup) {
    			((AccountGroup)currentAccount).displayGroupName();
    		}
    	}
	}
	
	public AbstractAccount getSelectedAccountById(int id) {
        for (AbstractAccount acc : this.accounts) {
            if (acc instanceof AbstractRegularAccount) {
            	if (((AbstractRegularAccount) acc).getId() == id) {
            		return acc;
            	}
            } 	
        	else if (acc instanceof AbstractForeignCurrencyAccount) {
	        	if (((AbstractForeignCurrencyAccount) acc).getId() == id) {
	        			return acc;
	        		}
            }
        	else if (acc instanceof AbstractGoldAccount) {
	        	if (((AbstractGoldAccount) acc).getId() == id) {
	        			return acc;
	        		}
            }
        	else if (acc instanceof AbstractInvestmentAccount) {
	        	if (((AbstractInvestmentAccount) acc).getId() == id) {
	        			return acc;
	        		}
            }
           
        }
        return null;
	}
	public AbstractAccount getSelectedAccountByIdAllGroups(int id) {
		//first search for top account group
		AbstractAccount resultThis = getSelectedAccountById(id);
		if(resultThis != null) {
			return resultThis;
		}
		else {
			//if not in the top account group search all the other account groups
			for (AbstractAccount accGroup : accounts) {
	            if (accGroup instanceof AccountGroup) {
	            	AbstractAccount result = ((AccountGroup)accGroup).getSelectedAccountById(id);
	            	if(result != null) {
	            		return result;
	            	}
	            } 
			}
		}

		return null;
	}
	
	public AccountGroup getAccountGroupByName(String name) {
	    if (this.name.toLowerCase().equals(name.toLowerCase())) {
	        return this;
	    }
	    for (AbstractAccount account : accounts) {
	        if (account instanceof AccountGroup) {
	            AccountGroup group = ((AccountGroup) account).getAccountGroupByName(name);
	            if (group != null) {
	                return group;
	            }
	        }
	    }

	    return null; // Account group with the given name not found
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
