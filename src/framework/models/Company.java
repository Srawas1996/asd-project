package framework.models;


import banking.strategy.company.CompanyTransactionStrategy;
import framework.enums.CustomerType;



public class Company extends Customer {
    private int numberOfEmployees = 0;

    public Company(String id,String name, Address address, String email,int numberOfEmployees){
        super(id,name,email,address, CustomerType.COMPANY,new CompanyTransactionStrategy());
        this.numberOfEmployees = numberOfEmployees;
    }
}
