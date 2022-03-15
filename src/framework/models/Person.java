package framework.models;

import banking.strategy.person.PersonTransactionStrategy;
import framework.enums.CustomerType;

import java.time.LocalDate;

public class Person extends Customer {
    private LocalDate dob;

    public Person(String id,String name, Address address, String email,LocalDate dob){
        super(id,name,email,address, CustomerType.PERSON,new PersonTransactionStrategy());
        this.dob=dob;
    }
}
