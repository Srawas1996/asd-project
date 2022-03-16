package framework.models;

import framework.storage.Storable;

import java.time.LocalDate;
import java.util.UUID;

public  class AccountEntry implements Storable<String> {

    private String id;
    private LocalDate date;
    private double amount;
    private String description;
    private String fromAccountNumber;

    private Account account;


    public AccountEntry(double amount, String description, String fromAccountNumber) {
        super();
        this.id = UUID.randomUUID().toString();
        this.date = LocalDate.now();
        this.amount = amount;
        this.description = description;
        this.fromAccountNumber = fromAccountNumber;
    }

    @Override
    public String getStorageKey() {
        return this.id;
    }
    
    

    public String getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
    public String toString() {
        return "[" +
                "id='" + id  +
                ", date=" + date +
                ", amount=" + amount +
                ", description='" + description +
                ", fromAccountNumber='" + fromAccountNumber +
                ",\n balance=" + account.getBalance() +
                 ']' + "\n";
    }
}
