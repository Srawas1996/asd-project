package ui.bank;


import framework.enums.CustomerType;
import framework.interfaces.Controller;
import framework.models.Account;

import java.awt.event.ActionListener;
import java.time.LocalDate;

public class BankBtnActions extends BtnActions {
    private BankFrm bankFrm;

    public BankBtnActions(Controller accountController, BankFrm bankFrm) {
        super(accountController, bankFrm);
        this.bankFrm = bankFrm;
    }

    public final ActionListener addPersonalAccount = event -> {
        openDialog(new JDialog_AddPAcc(bankFrm));
        if (bankFrm.isNewAccount()) {
            Account account = getController().createBankingAccount(CustomerType.PERSON,bankFrm.getAccountNo(),
                    bankFrm.getClientName(), bankFrm.getAddress() , bankFrm.getCustomerEmail(), LocalDate.parse(bankFrm.getBirthDate()), getAccType(bankFrm.getAccountType()),0);

            bankFrm.updateTable(account);
        }
    };

    public ActionListener addBusinessAccount = event -> {
        openDialog(new JDialog_AddCompAcc(bankFrm));
        Account account = getController().createBankingAccount(CustomerType.COMPANY,bankFrm.getAccountNo(), bankFrm.getClientName(), bankFrm.getAddress(),
                bankFrm.getCustomerEmail(), LocalDate.parse(bankFrm.getBirthDate()), getAccType(bankFrm.getAccountType()),Integer.parseInt(bankFrm.getNoOfEmployees()));
        bankFrm.updateTable(account);
    };

    @Override
    protected int balanceColumn() {
        return 5;
    }

    @Override
    protected int getAccountNoColumn() {
        return 0;
    }
}
