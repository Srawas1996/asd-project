package ui;

import framework.models.Account;
import framework.models.Address;
import ui.bank.BankFrm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collection;

public abstract class MainFrame extends JFrame{
    private String accountNo, clientName, accountType, clientType,
            amountDeposit, customerEmail;
    private Address address;
    private boolean newAccount;
    private DefaultTableModel model;
    private JTable dataTable;
    private JPanel panel;
    private JScrollPane JScrollPane1;
    private MainFrame frame;
    private Object[] rowData;

    public final void overview(String title, Collection<String> tableColumns, Collection<JButton> buttons) {
        prepareContentPane(title, tableColumns);
        prepareButtons(buttons);
        panelBounds();
        scrollPanelBounds();
        tableBounds();
        windowListeners();
    }


    public MainFrame(String accountNo, String clientName, Address address,
                     String accountType, String clientType, String amountDeposit, String customerEmail, boolean newAccount,
                     DefaultTableModel model, JTable dataTable, JPanel panel, JScrollPane jScrollPane1, MainFrame frame,
                     Object[] rowData) throws HeadlessException {
        super();
        this.accountNo = accountNo;
        this.clientName = clientName;
        this.address = address;
        this.accountType = accountType;
        this.clientType = clientType;
        this.amountDeposit = amountDeposit;
        this.customerEmail = customerEmail;
        this.newAccount = newAccount;
        this.model = model;
        this.dataTable = dataTable;
        this.panel = panel;
        JScrollPane1 = jScrollPane1;
        this.frame = frame;
        this.rowData = rowData;
    }



    public MainFrame() throws HeadlessException {
        super();
    }


    static public void main(String args[])
    {
        try {
            // Add the following code if you want the Look and Feel
            // to be set to the Look and Feel of the native system.

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e) {
            }

            //Create a new instance of our application's frame, and make it visible.
            (new BankFrm()).setVisible(true);
        }
        catch (Throwable t) {
            t.printStackTrace();
            //Ensure the application exits with an error condition.
            System.exit(1);
        }
    }


    private void prepareContentPane(String title, Collection<String> tableColumns) {
        panel = new JPanel();
        setTitle(title);
        setFrameSize();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setVisible(false);
        panel.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, panel);

        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        dataTable = new JTable(model);

        for (String cols : tableColumns) {
            model.addColumn(cols);
        }
        rowData = new Object[tableColumns.size()];
        newAccount = false;
        panel.add(JScrollPane1);
        JScrollPane1.getViewport().add(dataTable);
    }

    public void prepareButtons(Collection<JButton> buttons) {
        for (JButton btn : buttons) {
            panel.add(btn);
        }
    }

    protected void windowListeners() {
    }

    protected void panelBounds() {
        panel.setBounds(0, 0, 575, 310);
    }

    protected void setFrameSize() {
        setSize(575, 310);
    }

    protected void tableBounds() {
        dataTable.setBounds(0, 0, 420, 0);
    }

    protected void scrollPanelBounds() {
        JScrollPane1.setBounds(12, 92, 444, 160);
    }

    protected void changeTableContent(String... cols) {
        System.arraycopy(cols, 0, rowData, 0, rowData.length);
        getModel().addRow(rowData);
        getDataTable().getSelectionModel().setAnchorSelectionIndex(-1);
    }



    private void clearTableData() {
        getModel().setRowCount(0);
    }

    public void updateAllTableRec(Collection<Account> accounts) {
        clearTableData();

        for (Account account:  accounts) {
            setNewAccount(true);
            updateTable(account);
        }
    }

    public abstract void updateTable(Account account);

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getAmountDeposit() {
        return amountDeposit;
    }

    public void setAmountDeposit(String amountDeposit) {
        this.amountDeposit = amountDeposit;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean isNewAccount() {
        return newAccount;
    }

    public void setNewAccount(boolean newAccount) {
        this.newAccount = newAccount;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(JTable dataTable) {
        this.dataTable = dataTable;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JScrollPane getJScrollPane1() {
        return JScrollPane1;
    }

    public void setJScrollPane1(JScrollPane jScrollPane1) {
        JScrollPane1 = jScrollPane1;
    }

    public MainFrame getFrame() {
        return frame;
    }

    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }

    public Object[] getRowData() {
        return rowData;
    }

    public void setRowData(Object[] rowData) {
        this.rowData = rowData;
    }


}
