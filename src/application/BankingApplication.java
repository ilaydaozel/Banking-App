
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import menu.*;
import user.*;

public class BankingApplication {
    private static Bank bank;
    private static Scanner scanner  = new Scanner(System.in);
    private static MainMenu mainMenu;
    private static BankMenu bankMenu;
    
    public static double readDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
    }
    
    public static int readIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }
        }
    }
    
    public static void main(String[] args) {
        bank = new Bank();
        mainMenu = new MainMenu(bank);
        boolean exit = false;
        while (!exit) {
            mainMenu.printMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    mainMenu.createClient();
                    break;
                case 2:
                    //mainMenu.selectClient();
                    break;
                case 3:
                	System.out.println("bank menu");
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

}



/*
// AccountFactory class
public abstract class AccountFactory {
    public abstract Account createAccount();

    public static AccountFactory getFactory(int type) {
        switch (type) {
            case 1:
                return new RegularAccountFactory(false);
            case 2:
                return new RegularAccountFactory(true);
            case 3:
                return new ForeignCurrencyAccountFactory("EUR", false);
            case 4:
                return new ForeignCurrencyAccountFactory("EUR", true);
            case 5:
                return new ForeignCurrencyAccountFactory("USD", false);
            case 6:
                return new ForeignCurrencyAccountFactory("USD", true);
            case 7:
                return new GoldAccountFactory(false);
            case 8:
                return new GoldAccountFactory(true);
            case 9:
                return new InvestmentAccountFactory();
            default:
                throw new IllegalArgumentException("Invalid account type: " + type);
        }
    }
}

// RegularAccountFactory class
public class RegularAccountFactory extends AccountFactory {
    private boolean hasInterest;

    public RegularAccountFactory(boolean hasInterest) {
        this.hasInterest = hasInterest;
    }

    @Override
    public Account createAccount() {
        return new RegularAccount(hasInterest);
    }
}

// ForeignCurrencyAccountFactory class
public class ForeignCurrencyAccountFactory extends AccountFactory {
    private String currencyCode;
    private boolean hasInterest;

    public ForeignCurrencyAccountFactory(String currencyCode, boolean hasInterest) {
        this.currencyCode = currencyCode;
        this.hasInterest = hasInterest;
    }

    @Override
    public Account createAccount() {
        return new ForeignCurrencyAccount(currencyCode, hasInterest);
    }
}

// GoldAccountFactory class
public class GoldAccountFactory extends AccountFactory {
    private boolean hasInterest;

    public GoldAccountFactory(boolean hasInterest) {
        this.hasInterest = hasInterest;
    }

    @Override
    public Account createAccount() {
        return new GoldAccount(hasInterest);
    }
}

// InvestmentAccountFactory class
public class InvestmentAccountFactory extends AccountFactory {
    @Override
    public Account createAccount() {
        return new InvestmentAccount();
    }
}

// Account class
public abstract class Account {
    protected double balance;
    protected boolean hasInterest;
    protected boolean interestBlocked;

    public Account(boolean hasInterest) {
        this.balance = 0.0;
        this.hasInterest = hasInterest;
        this.interestBlocked = false;
    }

    public abstract int getType();

    public double getBalance() {
        return balance;
    }

    public boolean hasInterest() {
        return hasInterest;
    }

    public boolean isInterestBlocked() {
        return interestBlocked;
    }

    public void addInterest(double interest) {
        balance += interest;
    }

    public void blockInterest() {
        interestBlocked = true;
    }

    public void unblockInterest() {
        interestBlocked = false;
    }

    public double calculateFutureBalance(int days) {
        return balance;
    }
}

// RegularAccount class
public class RegularAccount extends Account {
    public RegularAccount(boolean hasInterest) {
        super(hasInterest);
    }

    @Override
    public int getType() {
        return 1;
    }
}

// ForeignCurrencyAccount class
public class ForeignCurrencyAccount extends Account {
    private String currencyCode;

    public ForeignCurrencyAccount(String currencyCode, boolean hasInterest) {
        super(hasInterest);
        this.currencyCode = currencyCode;
    }

    @Override
    public int getType() {
        if (currencyCode.equalsIgnoreCase("EUR")) {
            return hasInterest ? 4 : 3;
        } else if (currencyCode.equalsIgnoreCase("USD")) {
            return hasInterest ? 6 : 5;
        } else {
            throw new IllegalArgumentException("Invalid currency code: " + currencyCode);
        }
    }
}





// AccountGroup class
public class AccountGroup {
    private String name;
    private List<Account> accounts;
    private List<AccountGroup> accountGroups;

    public AccountGroup(String name) {
        this.name = name;
        accounts = new ArrayList<>();
        accountGroups = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
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
}*/
