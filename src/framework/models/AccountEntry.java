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
    private String fromPersonName;
    private Account account;


    public AccountEntry(double amount, String description, String fromAccountNumber, String fromPersonName) {
        super();
        this.id = UUID.randomUUID().toString();
        this.date = LocalDate.now();
        this.amount = amount;
        this.description = description;
        this.fromAccountNumber = fromAccountNumber;
        this.fromPersonName = fromPersonName;
    }

    @Override
    public String getStorageKey() {
        return this.id;
    }
    
    

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getFromPersonName() {
		return fromPersonName;
	}

	public void setFromPersonName(String fromPersonName) {
		this.fromPersonName = fromPersonName;
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
                "id='" + id + '\'' + "\n"+
                ", date=" + date + "\n"+
                ", amount=" + amount + "\n"+
                ", description='" + description + '\''+ "\n"+
                ", fromAccountNumber='" + fromAccountNumber + '\'' + "\n"+
                ", fromPersonName='" + fromPersonName + '\'' + "\n"+
                ", balance=" + account.getBalance() + "\n"+ 
                ']';
    }
}
