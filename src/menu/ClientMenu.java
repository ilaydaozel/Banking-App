 package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import account.*;
import accountFactory.*;
import enums.*;
import helpers.*;
import interfaces.IMenu;
import user.*;

public class ClientMenu implements IMenu{
	private static Scanner scanner = new Scanner(System.in);  
	private Client client;
	private HelperIO helperIO = new HelperIO();
	private HelperMenu helperMenu = new HelperMenu();
	private HelperClient helperClient;
    private AccountFactoryFactory accountFactoryFactory = new AccountFactoryFactory();
	
	public ClientMenu(Client currentClient) {
		this.client = currentClient;
		this.helperClient = new HelperClient(currentClient);
	}
	
	@Override
	public void handleChoice() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = helperIO.readIntegerInput();

            switch (choice) {
            	case 1:
            		System.out.println();
            		helperClient.displayAccounts();
            		System.out.println();
            		break;
                case 2:
                	System.out.println();
                    createAccount();
                    System.out.println();
                    break;
                case 3:
                	System.out.println();
                    createAccountGroup();
                    System.out.println();
                    break;
                case 4:
                	System.out.println();
                	selectAccountAll();
                	System.out.println();
                	break;
                case 5:
                	System.out.println();
                	selectAccountGroupAll();
                	System.out.println();
                	break;
                case 0:
                    exit = true;
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
 

    private AccountGroup selectAccountGroup() {
    	//display all the account group types and select one
    	List<AbstractAccount> accountList =  client.getAccountGroup().getAccounts();
    	List<AccountGroup> accountGroupList = new ArrayList<AccountGroup>();
    	System.out.println("Select an Account Group:");
    	System.out.println("1. +AccountGroup:" + client.getAccountGroup().getName());
    	accountGroupList.add(client.getAccountGroup());
    	int count = 2;
    	for(int i = 0; i< accountList.size(); i++) {
    		AbstractAccount currentAccount = accountList.get(i);
    		if(currentAccount instanceof AccountGroup) {
    			System.out.print(count + ". +AccountGroup:");
    			System.out.println(((AccountGroup) currentAccount).getName());
    			
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

        try {
            //First select an account group to add
            selectedGroup = selectAccountGroup();
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
        System.out.println();
    }

    public void selectAccountAll() {
    	AbstractAccount selectedAccount = helperClient.selectAnAccount();
    	IMenu selectedMenu = null;
        if(selectedAccount != null) {
        	if (selectedAccount instanceof RegularAccountWithInterest) {
        		selectedMenu = new RegularAccountWithInterestMenu((RegularAccountWithInterest) selectedAccount, client);      
            } 	
        	else if (selectedAccount instanceof RegularAccountWithoutInterest) {
        		selectedMenu = new RegularAccountWithoutInterestMenu((RegularAccountWithoutInterest) selectedAccount, client);         
            }
        	else if (selectedAccount instanceof GoldAccountWithInterest) {
        		selectedMenu = new GoldAccountWithInterestMenu((GoldAccountWithInterest) selectedAccount, client);
            }
        	else if (selectedAccount instanceof GoldAccountWithoutInterest) {
        		selectedMenu = new GoldAccountWithoutInterestMenu((GoldAccountWithoutInterest) selectedAccount, client);
            }
        	else if (selectedAccount instanceof ForeignCurrencyAccountWithInterest) {
        		selectedMenu = new ForeignCurrencyAccountWithInterestMenu((ForeignCurrencyAccountWithInterest) selectedAccount, client);
            }
        	else if (selectedAccount instanceof ForeignCurrencyAccountWithoutInterest) {
        		selectedMenu = new ForeignCurrencyAccountWithoutInterestMenu((ForeignCurrencyAccountWithoutInterest) selectedAccount, client);
            }
        	else if (selectedAccount instanceof InvestmentAccount) {
        		selectedMenu = new InvestmentAccountMenu((InvestmentAccount) selectedAccount);    
            }
        	if(selectedMenu != null) {
        		System.out.println();
        		selectedMenu.executeMenu();
        	}
        	else {
        		System.out.println("No menu selected");
        	}
        	
        }
        else {
        	System.out.println("Please enter a valid ID!");
        	System.out.println();
        }
    }
    
    public void selectAccountGroupAll() {
		System.out.println("=== Account Groups ===");
    	client.getAccountGroup().displayAllGroupsName();
    	System.out.print("Enter the name of the account group: ");
    	String groupName = scanner.nextLine();
    	AccountGroup selectedGroup = client.getAccountGroup().getAccountGroupByName(groupName);
    	if(selectedGroup != null) {
    		AccountGroupMenu menu = new AccountGroupMenu(selectedGroup);
    		System.out.println();
    		menu.executeMenu();
    	}
    	else {
    		System.out.println("There is no group named as " + groupName + "! ");
    	}
    }
    
    public void displayMenu() {
        System.out.println("--- Client Menu Of " + client.getUsername() + " ---");
        System.out.println("1. Display Accounts");
        System.out.println("2. Create Account");
        System.out.println("3. Create Account Group");
        System.out.println("4. Select An Account For Operation");
        System.out.println("5. Select An Account Group For Operation");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

	@Override
	public void executeMenu() {
		handleChoice();
		
	}
    
}
