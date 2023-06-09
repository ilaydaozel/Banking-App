package user;

import investment.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import account.AccountGroup;
import currency.*;


// Bank class
public class Bank {
    private List<Stock> stocks;
    private List<Fund> funds;
    private List<Client> clients;
    private EUR eurCur;
    private USD usdCur;
    private TRY tryCur;
    private XAU auxCur;		
    private Map<Integer, Double> interestRates;
    private int currentDay;

    public Bank() {
        stocks = new ArrayList<>();
        funds = new ArrayList<>();
        clients = new ArrayList<>();
        clients.add(new Client("ilayda"));
        eurCur = new EUR(24.97);
        usdCur = new USD(23.22);
        tryCur = new  TRY(1);
        auxCur = new XAU(1.94);
        //interestRates = new HashMap<>();
        currentDay = 0;
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

	
	public Map<Integer, Double> getInterestRates() {
		return interestRates;
	}

	public void setInterestRates(Map<Integer, Double> interestRates) {
		this.interestRates = interestRates;
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

	public XAU getAuxCur() {
		return auxCur;
	}

	public void setAuxCur(XAU auxCur) {
		this.auxCur = auxCur;
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

    public void setInterestRate(int accountType, double rate) {
        interestRates.put(accountType, rate);
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
    private Stock getStock(String name) {
        for (Stock stock : stocks) {
            if (stock.getName().equalsIgnoreCase(name)) {
                return stock;
            }
        }
        return null;
    }

    private Fund getFund(String name) {
        for (Fund fund : funds) {
            if (fund.getName().equalsIgnoreCase(name)) {
                return fund;
            }
        }
        return null;
    }
}