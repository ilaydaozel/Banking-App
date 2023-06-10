package user;

import investment.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import account.AccountGroup;
import currency.*;
import enums.CurrencyType;


// Bank class
public class Bank {
    private List<Stock> stocks;
    private List<Fund> funds;
    private List<Client> clients;
    private EUR eurCur;
    private USD usdCur;
    private TRY tryCur;
    private XAU xauCur;		

    private int currentDay;
    //singleton class pattern
    private static final Bank instance = new Bank();
    
    private Bank() {
        stocks = new ArrayList<>();
        funds = new ArrayList<>();
        clients = new ArrayList<>();
        clients.add(new Client("ilayda"));
        eurCur = new EUR(20.0,0.03);
        usdCur = new USD(10.0,0.04);
        tryCur = new  TRY(1,0.02);
        xauCur = new XAU(45.0,0.05);
        //interestRates = new HashMap<>();
        currentDay = 0;
    }
    //eager instantiation
    public static Bank getInstance() {
        return instance;
    }
    
    public double convert(CurrencyType sourceCurrency, CurrencyType targetCurrency, double amount) {
        double sourceRate = getCurrencyRateOf(sourceCurrency);
        double targetRate = getCurrencyRateOf(targetCurrency);
        
        double targetAmount = amount * (sourceRate / targetRate);
        return targetAmount;
    }
    
    private double getCurrencyRateOf(CurrencyType sourceCurrency) {
        if (sourceCurrency.toString().equals(eurCur.toString())) {
            return eurCur.getRate();
        } else if (sourceCurrency.toString().equals(usdCur.toString())) {
            return usdCur.getRate();
        } else if (sourceCurrency.toString().equals(tryCur.toString())) {
            return tryCur.getRate();
        } else if (sourceCurrency.toString().equals(xauCur.toString())) {
            return xauCur.getRate();
        }
        
        return 0.0;
    }
    
    public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public List<Fund> getFunds() {
		return funds;
	}

	public void setFunds(List<Fund> funds) {
		this.funds = funds;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	
	public int getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}
	

	public EUR getEurCur() {
		return eurCur;
	}

	public void setEurCur(EUR eurCur) {
		this.eurCur = eurCur;
	}

	public USD getUsdCur() {
		return usdCur;
	}

	public void setUsdCur(USD usdCur) {
		this.usdCur = usdCur;
	}

	public TRY getTryCur() {
		return tryCur;
	}

	public void setTryCur(TRY tryCur) {
		this.tryCur = tryCur;
	}

	public XAU getXauCur() {
		return xauCur;
	}

	public void setXauCur(XAU xauCur) {
		this.xauCur = xauCur;
	}
	
	
	public void addNewClient(Client client) {
		clients.add(client);
	}
	public void passTime(int days) {
        currentDay += days;
        //calculateInterest();
    }

    public void createStock(String name,double value) {
        Stock stock = new Stock(name,value);
        stocks.add(stock);
    }

    public void createFund(String name, double value) {
        Fund fund = new Fund(name, value);
        funds.add(fund);
    }

    public void setStockValue(String name, double value) {
        Stock stock = getStock(name);
        if (stock != null) {
            stock.setValue(value);
        }
    }

    public void setFundValue(String name, double value) {
        Fund fund = getFund(name);
        if (fund != null) {
            fund.setValue(value);
        }
    }
 
    public Stock deleteStock(String name) {
        for (Stock stock : stocks) {
            if (stock.getName().equalsIgnoreCase(name)) {
                stocks.remove(stock);
            }
        }
        return null;
    }

    public Fund deleteFund(String name) {
        for (Fund fund : funds) {
            if (fund.getName().equalsIgnoreCase(name)) {
                funds.remove(fund);
            }
        }
        return null;
    }

    public void setInterestRate(String accountType, double rate) {
        switch (accountType) {
            case "EUR":
                getEurCur().setDailyInterestRate(rate);
                System.out.println("Interest rate for EUR set to: " + rate);
                break;
            case "USD":
                getUsdCur().setDailyInterestRate(rate);
                System.out.println("Interest rate for USD set to: " + rate);
                break;
            case "TRY":
                getTryCur().setDailyInterestRate(rate);
                System.out.println("Interest rate for TRY set to: " + rate);
                break;
            case "XAU":
                getXauCur().setDailyInterestRate(rate);
                System.out.println("Interest rate for XAU set to: " + rate);
                break;
            default:
                System.out.println("Invalid currency type.");
                break;
        }
    }
    public double getInterestRate(String accountType) {
        switch (accountType) {
            case "EUR":
                return getEurCur().getDailyInterestRate();
            case "USD":      
                return getUsdCur().getDailyInterestRate();
                
            case "TRY":
                return getTryCur().getDailyInterestRate();
            case "XAU":
                return getXauCur().getDailyInterestRate();
            default:
                System.out.println("Invalid currency type.");
                
                return 0.0;
        }
    }


/*
    private void calculateInterest() {
        for (Client client : clients) {
            List<AccountGroup> accounts = (List<AccountGroup>) client.getAccountGroup();
            for (AccountGroup account : accounts) {
                if (((Account) account).hasInterest() && !((Account) account).isInterestBlocked()) {
                    int accountType = ((Object) account).getType();
                    double interestRate = interestRates.getOrDefault(accountType, 0.0);
                    double balance = account.getBalance();
                    double interest = balance * interestRate * currentDay;
                    account.addInterest(interest);
                }
            }
        }
    }
*/
    public Stock getStock(String name) {
        for (Stock stock : stocks) {
            if (stock.getName().equalsIgnoreCase(name)) {
                return stock;
            }
        }
        return null;
    }

    public Fund getFund(String name) {
        for (Fund fund : funds) {
            if (fund.getName().equalsIgnoreCase(name)) {
                return fund;
            }
        }
        return null;
    }
}