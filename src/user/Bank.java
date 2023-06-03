package user;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.Account;
import application.AccountFactory;
import application.Client;
import application.Fund;
import application.Stock;

// Bank class
public class Bank {
    private List<Stock> stocks;
    private List<Fund> funds;
    private Map<String, Double> currencyRates;
    private Map<Integer, Double> interestRates;
    private int currentDay;

    public Bank() {
        stocks = new ArrayList<>();
        funds = new ArrayList<>();
        currencyRates = new HashMap<>();
        interestRates = new HashMap<>();
        currentDay = 0;
    }

    public Account createAccount(int type) {
        AccountFactory accountFactory = AccountFactory.getFactory(type);
        return accountFactory.createAccount();
    }

    public void createStock(String name) {
        Stock stock = new Stock(name);
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

    public void passTime(int days) {
        currentDay += days;
        calculateInterest();
    }

    private void calculateInterest() {
        for (Client client : clients) {
            List<Account> accounts = client.getAccounts();
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
    }
}