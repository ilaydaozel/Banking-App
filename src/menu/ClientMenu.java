 package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import account.*;
import accountFactory.*;
import enums.*;
import helpers.*;
import user.*;

public class ClientMenu{
	private static Scanner scanner = new Scanner(System.in);  
	private Client client;
	HelperIO helperIO = new HelperIO();
	HelperMenu helperMenu = new HelperMenu();
    AccountFactoryFactory accountFactoryFactory = new AccountFactoryFactory();
	
	public ClientMenu(Client currentClient) {
		this.client = currentClient;
	}
	
    public void clientMenu() {
        HelperIO helperIO = new HelperIO();
        boolean exit = false;
        while (!exit) {
            helperMenu.printClientMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            	case 1:
            		displayAccounts();
            		break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    createAccountGroup();
                    break;
                case 4:
                	selectAccountAll();
                	break;
                case 5:
                	selectAccountGroupAll();
                	break;
                case 6:
                    checkAccountBalance();
                    break;
                case 7:
                    checkAccountGroupBalance();
                    break;
                case 8:
                    checkExpectedBalance();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
 
    private void displayAccounts() {
		client.getAccountGroup().display();
		
	}
    
    private AccountGroup selectAccountGroup() {
    	//display all the account group types and select one
    	List<AbstractAccount> accountList =  client.getAccountGroup().getAccounts();
    	List<AccountGroup> accountGroupList = new ArrayList<AccountGroup>();
    	System.out.println("Select an Account Group:");
    	System.out.println("1. +AccountGroup: Top Account Group");
    	accountGroupList.add(client.getAccountGroup());
    	int count = 2;
    	for(int i = 0; i< accountList.size(); i++) {
    		AbstractAccount currentAccount = accountList.get(i);
    		if(currentAccount instanceof AccountGroup) {
    			System.out.print(count + ". ");
    			currentAccount.display();
    			accountGroupList.add((AccountGroup) currentAccount);
    			count ++;
    		}
    	}
    	int selection = helperIO.readIntegerInput();
    	if (selection >= 1 && selection <= accountGroupList.size()) {
    		return accountGroupList.get(selection-1);
    	}
    	else {
    		throw new IllegalArgumentException("Invalid account group selection. Please try again.");
    	}
    }

	private void createAccount() {

        AbstractAccount newAccount = null;
        AccountGroup selectedGroup = null;
        
        //First select an account group to add
        try {
            selectedGroup = selectAccountGroup();
            System.out.println("Your account will be created under: "); 
            selectedGroup.display();
            System.out.println("Enter the account type: ");
            helperMenu.printAccountTypeMenu();
            int type = helperIO.readIntegerInput();
            if (type >= 1 && type <= 4) {
            	//create the account factory according to the selection
            	AccountFactory selectedAccountFactory = accountFactoryFactory.createAccountFactory(MainAccountType.getNameByValue(type));
            	if(type == 1) {
            		//regular menu
            		helperMenu.printRegularAccountMenu();
            		int type1 = helperIO.readIntegerInput();
            		if(RegularAccountType.isValue(type1)) {
                		newAccount = selectedAccountFactory.createAccount(RegularAccountType.getNameByValue(type1));
            		}
            		else {
            			System.out.println("Invalid account type. Please try again.");
            		}

            	}
            	else if(type == 2) {
            		//foreign currency menu
            		helperMenu.printForeignCurrencyAccountMenu();
            		int type2 = helperIO.readIntegerInput();
    				if (ForeignCurrencyAccountType.isValue(type2)) {
    				    newAccount = selectedAccountFactory.createAccount(ForeignCurrencyAccountType.getNameByValue(type2));
    				} else {
    				    System.out.println("Invalid account type. Please try again.");
    				}
    			}
            	
            	else if(type == 3) {
            		//gold menu
            		helperMenu.printGoldAccountMenu();
            		int type3 = helperIO.readIntegerInput();
            		if (GoldAccountType.isValue(type3)) {
            		    newAccount = selectedAccountFactory.createAccount(GoldAccountType.getNameByValue(type3));
            		} else {
            		    System.out.println("Invalid account type. Please try again.");
            		}
            	}
            	else if(type == 4) {
            		//investment menu
            		newAccount = selectedAccountFactory.createAccount("investment");
            	}  
            	else {
            		 System.out.println("Invalid account type. Please try again.");
            	}
            } else {
                System.out.println("Invalid account type. Please try again.");
            }
            if (newAccount != null) {
            	if(selectedGroup.equals(client.getAccountGroup())) {
            		client.addToTopAccountGroup(newAccount);
            	}
            	else {
            		client.addToGivenAccountGroup(newAccount, selectedGroup);
            	}
            	
            	System.out.println("New account created successfully.");
            	System.out.println("newAccount" + newAccount.toString());
            }
            System.out.println();
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createAccountGroup() {
        System.out.print("Enter the name of the account group: ");
        String groupName = scanner.nextLine();
        AccountGroup accountGroup = new AccountGroup(groupName);
        client.addToTopAccountGroup(accountGroup);
        System.out.println("Account group created successfully.");
        System.out.println("newAccount group" + accountGroup.toString());
        System.out.println();
    }

    public void selectAccountAll() {
    	client.getAccountGroup().display();
        System.out.print("Enter the id of the account: ");
        int selectedAccountId = HelperIO.readIntegerInput();
        AbstractAccount selectedAccount = client.getAccountGroup().getSelectedAccountByIdAllGroups(selectedAccountId);
        if(selectedAccount != null) {
        	if (selectedAccount instanceof RegularAccountWithInterest) {
        		RegularAccountTRYWithInterestMenu menu = new RegularAccountTRYWithInterestMenu();
        		menu.RegularAccountTRYWithInterestMenu((RegularAccountWithInterest)selectedAccount);
            } 	
        	else if (selectedAccount instanceof RegularAccountWithoutInterest) {
        		RegularAccountTRYWithoutInterestMenu menu = new RegularAccountTRYWithoutInterestMenu();
        		menu.displayRegularAccountTRYWithoutInterestMenu((RegularAccountWithoutInterest)selectedAccount);
            }
        	else if (selectedAccount instanceof GoldAccountWithInterest) {
        		GoldAccountXAUWithInterestMenu menu = new GoldAccountXAUWithInterestMenu();
        		menu.GoldAccountXAUWithInterestMenu();
            }
        	else if (selectedAccount instanceof GoldAccountWithoutInterest) {
        		GoldAccountXAUWithoutInterestMenu menu = new GoldAccountXAUWithoutInterestMenu();
        		menu.GoldAccountXAUWithoutInterestMenu();
            }
        	else if (selectedAccount instanceof ForeignCurrencyAccountWithInterest) {
        		ForeignCurrencyAccountWithInterestMenu menu = new ForeignCurrencyAccountWithInterestMenu();
        		menu.displayMenu();
            }
        	else if (selectedAccount instanceof ForeignCurrencyAccountWithoutInterest) {
        		ForeignCurrencyAccountWithoutInterestMenu menu = new ForeignCurrencyAccountWithoutInterestMenu();
        		menu.ForeignCurrencyAccountEURWithoutInterestMenu();
            }

        	else if (selectedAccount instanceof InvestmentAccount) {
        		InvestmentAccountMenu menu = new InvestmentAccountMenu();
        		menu.InvestmentAccountMenu();
            }

        }
        else {
        	System.out.println("Please enter a valid ID!");
        	System.out.println();
        }
    }
    
    public void selectAccountGroupAll() {
    	client.getAccountGroup().displayGroupName();
    }
    
    private static void checkAccountBalance() {
        /*System.out.print("Enter the account index: ");
        int accountIndex = readIntegerInput();

        if (accountIndex >= 0 && accountIndex < currentClient.getNumAccounts()) {
            Account account = currentClient.getAccount(accountIndex);
            double balance = account.getBalance();
            System.out.println("Account Balance: " + balance);
        } else {
            System.out.println("Invalid account index. Please try again.");
        }
        System.out.println();*/
    }

    private static void checkAccountGroupBalance() {
       /* System.out.print("Enter the account group name: ");
        String groupName = scanner.nextLine();
        AccountGroup accountGroup = currentClient.getAccountGroup(groupName);

        if (accountGroup != null) {
            double balance = accountGroup.getTotalBalance();
            System.out.println("Account Group Balance (TRY): " + balance);
        } else {
            System.out.println("Account group not found. Please try again.");
        }
        System.out.println();*/
    }

    private static void checkExpectedBalance() {
        /*System.out.print("Enter the account index: ");
        int accountIndex = readIntegerInput();

        if (accountIndex >= 0 && accountIndex < currentClient.getNumAccounts()) {
            Account account = currentClient.getAccount(accountIndex);
            System.out.print("Enter the number of days in the future: ");
            int days = readIntegerInput();
            double expectedBalance = account.calculateFutureBalance(days);
            System.out.println("Expected Balance (after " + days + " days): " + expectedBalance);
        } else {
            System.out.println("Invalid account index. Please try again.");
        }
        System.out.println();*/
    }
}
