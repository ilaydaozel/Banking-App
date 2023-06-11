package account;

import java.util.*;

import enums.CurrencyType;
import enums.ForeignCurrencyAccountType;
import interfaces.IWithInterest;

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
            	if(curAccount instanceof IWithInterest) {
            		//calculate amount with interest and add it
            		((IWithInterest) curAccount).updateInterest();
            		totalBalance += curAccount.getBalance();
            	}
            	else if (curAccount.getCurrencyType() != CurrencyType.TRY) {
            		//convert the money to try and add it
            		double convertedToTRYBalance= getBank().convert(curAccount.getCurrencyType(), CurrencyType.TRY, curAccount.getBalance());
            		totalBalance += convertedToTRYBalance;
            	}
            	else if(curAccount instanceof InvestmentAccount) {
            		//get the commodity values and add it
            		totalBalance += ((InvestmentAccount) curAccount).getTotalCommodityValue();
            		totalBalance += curAccount.getBalance();
            	}
            	else {
                	totalBalance += curAccount.getBalance();
            	}

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
	
	public void displayAllGroupsName() {
		System.out.println("+Account Group: " + name);
		for(int i = 0; i< accounts.size(); i++) {
    		AbstractAccount currentAccount = accounts.get(i);
    		if(currentAccount instanceof AccountGroup) {
    			((AccountGroup)currentAccount).displayAllGroupsName();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
