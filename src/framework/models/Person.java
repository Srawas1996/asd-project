package framework.models;

import banking.strategy.person.PersonTransactionStrategy;
import framework.enums.CustomerType;

import java.time.LocalDate;

public class Person extends Customer {
    private final LocalDate dateOfBirth;

    public Person(String id,String name, Address address, String email,LocalDate dateOfBirth){
        super(id,name,email,address, CustomerType.PERSON,new PersonTransactionStrategy());
        this.dateOfBirth=dateOfBirth;
    }
}
