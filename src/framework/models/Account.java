package framework.models;


import framework.enums.AccountType;
import framework.storage.Storable;
import framework.strategy.InterestStrategy;

import java.util.ArrayList;
import java.util.List;


public  class Account implements Storable<String> {
	
    private String id;
    private InterestStrategy interestStrategy;
    private Customer customer;
    private AccountType accountType;
    private Double balance = 0.0;
    private List<AccountEntry> entryList;

    public Account(String id, Customer customer, AccountType accountType) {
        this.id = id;
        this.customer = customer;
        this.accountType = accountType;
        entryList = new ArrayList<AccountEntry>();
    }

    @Override
    public String getStorageKey() {
        return this.id;
    }

    public void addEntry(AccountEntry accountEntry){
        entryList.add(accountEntry);
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public InterestStrategy getInterestStrategy() {
		return interestStrategy;
	}

	public void setInterestStrategy(InterestStrategy interestStrategy) {
		this.interestStrategy = interestStrategy;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public List<AccountEntry> getEntryList() {
		return entryList;
	}

	public void setEntryList(List<AccountEntry> entryList) {
		this.entryList = entryList;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
    
    
}
