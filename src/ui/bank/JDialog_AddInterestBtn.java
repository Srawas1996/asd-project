package ui.bank;

import framework.enums.AccountType;
import framework.interfaces.Controller;
import framework.models.Account;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Collection;

public abstract class JDialog_AddInterestBtn extends JFrame {
    private DefaultTableModel model;
    private boolean updatedAccount;
    private Controller controller;
    private BankFrm bankFrm;

    protected JDialog_AddInterestBtn(Controller controller, BankFrm bankFrm) {
        this.controller = controller;
        this.bankFrm = bankFrm;
    }

    public boolean isUpdatedAccount() {
        return updatedAccount;
    }

    public void setUpdatedAccount(boolean updatedAccount) {
        this.updatedAccount = updatedAccount;
    }

    public final ActionListener exitWindow = event -> System.exit(0);

    public final ActionListener deposit = event -> {
        int selection = bankFrm.getJTable1().getSelectionModel().getMinSelectionIndex();
        String accNo = getSelectedAccountNo(selection);
        if (accNo != null) {
            openDialog(new JDialog_Deposit(bankFrm, accNo), 430, 15, 275, 140);
            double inpAmount = Double.parseDouble(bankFrm.getAmountDeposit());
            controller.deposit(accNo, inpAmount,"deposit");
            double newAmount = getCurrentBalance(accNo);
            bankFrm.getJTable1().setValueAt(String.valueOf(newAmount), selection, balanceColumn());
        }
    };

    private double getCurrentBalance(String accNo) {
        Account account = controller.getAccountById(accNo);
        return account.getBalance();
    }

    protected String getSelectedAccountNo(int selection) {
        if (selection >= 0)
            return (String) bankFrm.getJTable1().getValueAt(selection, getAccountNoColumn());
        return null;
    }

    public final ActionListener withdraw = event -> {
        int selection = bankFrm.getJTable1().getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accNo = getSelectedAccountNo(selection);
            openDialog(new JDialog_Withdraw(bankFrm, accNo), 430, 15, 275, 140);
            long withdrawAmt = Long.parseLong(bankFrm.getAmountDeposit());
            controller.withdraw(accNo, withdrawAmt);
            double newAmount = getCurrentBalance(accNo);
            bankFrm.getJTable1().setValueAt(String.valueOf(newAmount), selection, balanceColumn());
            if (newAmount < 0) {
                JOptionPane.showMessageDialog(bankFrm, " Account " +
                                accNo + " : balance is negative: $" + newAmount + " !",
                        "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
            }
        }
    };

    public DefaultTableModel getModel() {
        return model;
    }

    private void clearTableData() {
        getModel().setRowCount(0);
    }

    public void updateAllTableRec(Collection<Account> accounts) {
        clearTableData();
        for (Account account:  accounts) {
            setUpdatedAccount(true);
            updateTable(account);
        }
    }

     abstract void updateTable(Account account);

    protected abstract int balanceColumn();

    protected abstract int getAccountNoColumn();

    public final ActionListener applyInterest = event -> {
        JOptionPane.showMessageDialog(bankFrm, "Add interest to all accounts",
                "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
        controller.addInterest();
        updateAllTableRec(controller.getAllAccounts());
    };

    public void openDialog(JDialog jDialog) {
        openDialog(jDialog, 450, 20, 300, 330);
    }

    public void openDialog(JDialog jDialog, int x, int y, int width, int height) {
        jDialog.setBounds(x, y, width, height);
        jDialog.show();
    }

    protected AccountType getAccType(String accountType) {
        if ("Ch".equals(accountType)) {
            return AccountType.CHECKING;
        }
        return AccountType.SAVING;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public BankFrm getFrame() {
        return bankFrm;
    }

    public void setFrame(BankFrm bankFrm) {
        this.bankFrm = bankFrm;
    }

    public ActionListener getExitWindow() {
        return exitWindow;
    }

    public ActionListener getDeposit() {
        return deposit;
    }

    public ActionListener getWithdraw() {
        return withdraw;
    }

    public ActionListener getApplyInterest() {
        return applyInterest;
    }

}
