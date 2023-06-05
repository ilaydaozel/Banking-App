package user;

import investment.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// Bank class
public class Bank {
    private List<Stock> stocks;
    private List<Fund> funds;
    private List<Client> clients;
    private Map<String, Double> currencyRates;
    private Map<Integer, Double> interestRates;
    private int currentDay;

    public Bank() {
        stocks = new ArrayList<>();
        funds = new ArrayList<>();
        clients = new ArrayList<>();
        //currencyRates = new HashMap<>();
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

	public Map<String, Double> getCurrencyRates() {
		return currencyRates;
	}

	public void setCurrencyRates(Map<String, Double> currencyRates) {
		this.currencyRates = currencyRates;
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

	public void addNewClient(Client client) {
		clients.add(client);
	}
	/*public void passTime(int days) {
        currentDay += days;
        calculateInterest();
    }

    public void createStock(String name) {
        Stock stock = new Stock(name,);
        stocks.add(stock);
    }

    public void createFund(String name) {
        Fund fund = new Fund(name);
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

    public void setCurrencyRate(String currencyCode, double rate) {
        currencyRates.put(currencyCode, rate);
    }

    public void setInterestRate(int accountType, double rate) {
        interestRates.put(accountType, rate);
    }

    private void calculateInterest() {
        for (Client client : clients) {
            List<AccountGroup> accounts = client.getAccounts();
            for (Account account : accounts) {
                if (account.hasInterest() && !account.isInterestBlocked()) {
                    int accountType = account.getType();
                    double interestRate = interestRates.getOrDefault(accountType, 0.0);
                    double balance = account.getBalance();
                    double interest = balance * interestRate * currentDay;
                    account.addInterest(interest);
                }
            }
        }
    }

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
    }*/
}