package framework.models;

import framework.enums.CustomerType;
import framework.storage.Storable;
import framework.strategy.TransactionAlertStrategy;


public abstract  class Customer implements Storable<String> {

    private String id;
    private String name;
    private String email;
	private Address address;
    private CustomerType customerType;
    private TransactionAlertStrategy transactionStrategy;


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer(String id, String name, String email, Address address,
					CustomerType customerType,
					TransactionAlertStrategy transactionStrategy) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.customerType = customerType;
		this.transactionStrategy = transactionStrategy;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public CustomerType getCustomerType() {
		return customerType;
	}



	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public TransactionAlertStrategy getTransactionStrategy() {
		return transactionStrategy;
	}

	public void setTransactionStrategy(TransactionAlertStrategy transactionStrategy) {
		this.transactionStrategy = transactionStrategy;
	}


	@Override
    public String getStorageKey() {
        return this.id;
    }

}
