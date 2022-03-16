package ui.bank;

import framework.enums.CreditCardType;
import framework.interfaces.Controller;
import framework.models.Account;
import ui.ccard.CardFrm;
import ui.ccard.JDialogGenBill;
import ui.ccard.JDialog_AddCCAccount;

import java.awt.event.ActionListener;
import java.time.LocalDate;

public class CardBtnActions extends BtnActions {
    private CardFrm cardFrm;
    public CardBtnActions(Controller controller, CardFrm cardFrm) {
        super(controller, cardFrm);
        this.cardFrm = cardFrm;
    }

    public final ActionListener generateBill = event -> {
        int selection = cardFrm.getDataTable().getSelectionModel().getMinSelectionIndex();
        String accNo = getSelectedAccountNo(selection);
        if (accNo != null) {
            openDialog(new JDialogGenBill(cardFrm, getController().getMonthlyBilling(accNo)));
        }
    };

    public final ActionListener addCreditCardAccount = event -> {
        openDialog(new JDialog_AddCCAccount(cardFrm));
        if (cardFrm.isNewAccount()) {

            Account account = getController().createCreditCardAccount(cardFrm.getCcNumber(), cardFrm.getClientName(), cardFrm.getAddress(),
                    cardFrm.getCustomerEmail(), LocalDate.parse(cardFrm.getExpDate()), getAccType(cardFrm.getAccountType()),
                    getCCType(cardFrm.getAccountType()));

            cardFrm.updateTable(account);
        }
    };

    private CreditCardType getCCType(String accountType) {
        CreditCardType type;
        switch (accountType) {
            case "Gold":
                type = CreditCardType.GOLD;
                break;
            case "Silver":
                type = CreditCardType.SILVER;
                break;
            default:
                type = CreditCardType.BRONZE;
        }
        return type;
    }

    @Override
    protected int balanceColumn() {
        return 4;
    }

    @Override
    protected int getAccountNoColumn() {
        return 1;
    }
}
