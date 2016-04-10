package net.sfws.accounting.swing.window.mainwindow;

import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.swing.control.JValueComboBox;

import javax.swing.ImageIcon;
import javax.swing.JTable;

import java.awt.Insets;
import java.util.HashMap;

public class PanelAccounting extends JPanel {
    
    // serial
    private static final long serialVersionUID = -9079670797168414346L;
    
    // controls
    private JPanel panel1;
    private JLabel lblLabel1;
    private JLabel lblTypeAccountView;
    private JValueComboBox typAccountView;
    private JButton btnView;
    private JLabel lblDateStart;
    private JTextField dateStart;
    private JLabel lblDateEnd;
    private JTextField dateEnd;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel lblTypeAccount;
    private JTextField typeAccount;
    private JLabel lblBankNumber;
    private JTextField bankNumber;
    private JLabel lblDateValidFrom;
    private JTextField dateValidFrom;
    private JLabel lblName;
    private JTextField name;
    private JLabel lblAccountNumber;
    private JTextField accountNumber;
    private JLabel lblDateValidUntil;
    private JTextField dateValidUntil;
    private JLabel lblText;
    private JTextArea text;
    private JLabel lblCurrency;
    private JTextField currency;
    private JLabel lblStatus;
    private JButton btnChangeAccount;
    private JPanel panel4;
    private JLabel lblTypeReverse;
    private JValueComboBox typeReverse;
    private JTable transactions;

    /**
     * Create the panel.
     */
    public PanelAccounting() {
        
        // initialisation panel
        this.initPanel();
        
        // fill controls
        this.prefillPanel();
    }
    
    private void initPanel() {
        
        // set border
        this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        
        // set layout
        this.setLayout(new MigLayout("", "[grow]", "[min!][grow]"));
        
        // create panel1 with layout
        this.panel1 = new JPanel();
        this.panel1.setLayout(new MigLayout("inset 0 3 5 3", "[grow]10[]5[]5[]10[]5[]5[]5[]", "[center][min]"));
        
        // add label to panel1
        this.lblLabel1 = new JLabel("Accouting-Tools");
        this.lblLabel1.setFont(Configuration.FontLargeBold);
        this.panel1.add(this.lblLabel1, "cell 0 0 1 2, aligny top");
        
        // add label to panel1
        this.lblTypeAccountView = new JLabel("View:");
        this.lblTypeAccountView.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblTypeAccountView, "cell 1 0");
        
        // add combo-box to panel1
        this.typAccountView = new JValueComboBox();
        this.typAccountView.setFont(Configuration.FontNormal);
        this.panel1.add(this.typAccountView, "cell 2 0");
        
        // add button to panel1
        this.btnView = new JButton("");
        this.btnView.setMinimumSize(new Dimension(30, 22));
        this.btnView.setMaximumSize(new Dimension(30, 22));
        this.btnView.setPreferredSize(new Dimension(30, 22));
        this.btnView.setMargin(new Insets(2, 5, 2, 5));
        this.btnView.setFont(Configuration.FontNormal);
        this.btnView.setIcon(new ImageIcon(PanelAccounting.class.getResource("/net/sfws/accounting/res/folder.gif")));
        this.btnView.setBorder(UIManager.getBorder("Button.border"));
        this.panel1.add(this.btnView, "cell 3 0,growy");
        
        // add label to panel1
        this.lblDateStart = new JLabel("Date:");
        this.lblDateStart.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDateStart, "cell 4 0");

        // add text-box to panel1
        this.dateStart = new JTextField();
        this.dateStart.setFont(Configuration.FontNormal);
        this.dateStart.setEditable(false);
        this.dateStart.setColumns(10);
        this.panel1.add(this.dateStart, "cell 5 0");
        
        // add label to panel1
        this.lblDateEnd = new JLabel("-");
        this.lblDateEnd.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDateEnd, "cell 6 0");

        // add text-box to panel1
        this.dateEnd = new JTextField();
        this.dateEnd.setFont(Configuration.FontNormal);
        this.dateEnd.setEditable(false);
        this.dateEnd.setColumns(10);
        this.panel1.add(this.dateEnd, "cell 7 0");
        
        // add panel1 to accounting-panel
        this.add(this.panel1, "cell 0 0, growx");

        // create panel2 with layout
        this.panel2 = new JPanel();
        this.panel2.setBorder(new TitledBorder(null, "Chosen Account", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel2.setLayout(new MigLayout("", "[grow]", "[min!][grow]"));

        // create panel3 with layout
        this.panel3 = new JPanel();
        this.panel3.setFont(Configuration.FontNormalBold);
        this.panel3.setBorder(new TitledBorder(null, "Account-Information", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel3.setLayout(new MigLayout("", "[]5[grow]10[]5[grow]10[]5[]", "[center][center][center][center]"));

        this.lblTypeAccount = new JLabel("Account-Type:");
        this.lblTypeAccount.setFont(Configuration.FontNormal);
        this.panel3.add(this.lblTypeAccount, "cell 0 0");

        this.typeAccount = new JTextField();
        this.typeAccount.setFont(Configuration.FontNormal);
        this.typeAccount.setEditable(false);
        this.panel3.add(this.typeAccount, "cell 1 0,growx");

        this.lblBankNumber = new JLabel("Bank [Number]:");
        this.lblBankNumber.setFont(Configuration.FontNormal);
        this.panel3.add(this.lblBankNumber, "cell 2 0");

        this.bankNumber = new JTextField();
        this.bankNumber.setFont(Configuration.FontNormal);
        this.bankNumber.setEditable(false);
        this.panel3.add(this.bankNumber, "cell 3 0,growx");

        this.lblDateValidFrom = new JLabel("Valid:");
        this.lblDateValidFrom.setFont(Configuration.FontNormal);
        this.panel3.add(this.lblDateValidFrom, "cell 4 0");
        
        this.dateValidFrom = new JTextField();
        this.dateValidFrom.setFont(Configuration.FontNormal);
        this.dateValidFrom.setEditable(false);
        this.dateValidFrom.setColumns(10);
        this.panel3.add(this.dateValidFrom, "cell 5 0");

        this.lblName = new JLabel("Name:");
        this.lblName.setFont(Configuration.FontNormal);
        this.panel3.add(this.lblName, "cell 0 1");

        this.name = new JTextField();
        this.name.setFont(Configuration.FontNormal);
        this.name.setEditable(false);
        this.panel3.add(this.name, "cell 1 1,growx");

        this.lblAccountNumber = new JLabel("Account-Number:");
        this.lblAccountNumber.setFont(Configuration.FontNormal);
        this.panel3.add(this.lblAccountNumber, "cell 2 1");

        this.accountNumber = new JTextField();
        this.accountNumber.setFont(Configuration.FontNormal);
        this.accountNumber.setEditable(false);
        this.panel3.add(this.accountNumber, "cell 3 1,growx");

        this.lblDateValidUntil = new JLabel("Temp. valid until:");
        this.lblDateValidUntil.setFont(Configuration.FontNormal);
        this.panel3.add(this.lblDateValidUntil, "cell 4 1");

        this.dateValidUntil = new JTextField();
        this.dateValidUntil.setFont(Configuration.FontNormal);
        this.dateValidUntil.setEditable(false);
        this.dateValidUntil.setColumns(10);
        this.panel3.add(this.dateValidUntil, "cell 5 1");

        this.lblText = new JLabel("Text:");
        this.lblText.setFont(Configuration.FontNormal);
        this.panel3.add(this.lblText, "cell 0 2");

        this.text = new JTextArea();
        this.text.setFont(Configuration.FontNormal);
        this.text.setEditable(false);
        this.text.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
        this.panel3.add(this.text, "cell 1 2 1 2,grow");

        this.lblCurrency = new JLabel("Currency:");
        this.lblCurrency.setFont(Configuration.FontNormal);
        this.panel3.add(this.lblCurrency, "cell 2 2");
        
        this.currency = new JTextField();
        this.currency.setFont(Configuration.FontNormal);
        this.currency.setEditable(false);
        this.panel3.add(this.currency, "cell 3 2,growx");

        this.lblStatus = new JLabel("Account-Status");
        this.lblStatus.setFont(Configuration.FontNormal);
        this.panel3.add(this.lblStatus, "cell 4 2 2 1,alignx right");
        
        this.btnChangeAccount = new JButton("Change Account");
        this.btnChangeAccount.setFont(Configuration.FontNormal);
        this.panel3.add(this.btnChangeAccount, "cell 4 3 2 1,growx");
        
        // add panel2 to panel2
        panel2.add(this.panel3, "cell 0 0, grow");
        
        // create panel4 with layout
        this.panel4 = new JPanel();
        this.panel4.setFont(Configuration.FontNormalBold);
        this.panel4.setBorder(new TitledBorder(null, "Transactions", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel4.setLayout(new MigLayout("", "[]5[][grow]", "[center][grow]"));

        // add label to panel4
        this.lblTypeReverse = new JLabel("View:");
        this.lblTypeReverse.setFont(Configuration.FontNormal);
        this.panel4.add(this.lblTypeReverse, "cell 0 0");
        
        // add combo-box to panel4
        this.typeReverse = new JValueComboBox();
        this.typeReverse.setFont(Configuration.FontNormal);
        this.panel4.add(this.typeReverse, "cell 1 0");
        
        // add table to panel4
        this.transactions = new JTable();
        this.transactions.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        this.panel4.add(this.transactions, "cell 0 1 3 1, grow");

        // add panel3 to panel2
        this.panel2.add(this.panel4, "cell 0 1, grow");

        // add panel1 to accounting-panel
        this.add(this.panel2, "cell 0 1, grow");
    }
    
    private void prefillPanel() {

        // initialisations
        HashMap<String, String> accountView = new HashMap<String, String>();
        HashMap<String, String> revTransactionView = new HashMap<String, String>();
        
        // create list of entries
        accountView.put("ACT_MONTH", Configuration.languageResources.getString("typeAccountView.ACT_MONTH"));
        accountView.put("ACT_QUARTER", Configuration.languageResources.getString("typeAccountView.ACT_QUARTER"));
        accountView.put("ACT_HALFYEAR", Configuration.languageResources.getString("typeAccountView.ACT_HALFYEAR"));
        accountView.put("ACT_YEAR", Configuration.languageResources.getString("typeAccountView.ACT_YEAR"));
        accountView.put("ANY_MONTH", Configuration.languageResources.getString("typeAccountView.ANY_MONTH"));
        accountView.put("ANY_QUARTER", Configuration.languageResources.getString("typeAccountView.ANY_QUARTER"));
        accountView.put("ANY_HALFYEAR", Configuration.languageResources.getString("typeAccountView.ANY_HALFYEAR"));
        accountView.put("ANY_YEAR", Configuration.languageResources.getString("typeAccountView.ANY_YEAR"));
        accountView.put("ANY_DATE", Configuration.languageResources.getString("typeAccountView.ANY_DATE"));
        
        // create list of entries
        revTransactionView.put("N", Configuration.languageResources.getString("typeReverse.N"));
        revTransactionView.put("R", Configuration.languageResources.getString("typeReverse.R"));
        revTransactionView.put("A", Configuration.languageResources.getString("typeReverse.A"));

        // fill all controls by language
        this.lblLabel1.setText(Configuration.languageResources.getString("panelaccounting.lblLable1"));
        this.lblTypeAccountView.setText(Configuration.languageResources.getString("panelaccounting.lblTypeAccountView") + ":");
        this.typAccountView.setModel(accountView);
        this.lblDateStart.setText(Configuration.languageResources.getString("panelaccounting.lblDateStart") + ":");
        ((TitledBorder)this.panel2.getBorder()).setTitle(Configuration.languageResources.getString("panelaccounting.panel2"));
        ((TitledBorder)this.panel3.getBorder()).setTitle(Configuration.languageResources.getString("panelaccounting.panel3"));
        this.lblTypeAccount.setText(Configuration.languageResources.getString("panelaccounting.lblTypeAccount") + ":");
        this.lblBankNumber.setText(Configuration.languageResources.getString("panelaccounting.lblBankNumber") + ":");
        this.lblDateValidFrom.setText(Configuration.languageResources.getString("panelaccounting.lblDateValidFrom") + ":");
        this.lblName.setText(Configuration.languageResources.getString("panelaccounting.lblName") + ":");
        this.lblAccountNumber.setText(Configuration.languageResources.getString("panelaccounting.lblAccountNumber") + ":");
        this.lblDateValidUntil.setText(Configuration.languageResources.getString("panelaccounting.lblDateValidUntil") + ":");
        this.lblText.setText(Configuration.languageResources.getString("panelaccounting.lblText") + ":");
        this.lblCurrency.setText(Configuration.languageResources.getString("panelaccounting.lblCurrency") + ":");
        this.lblStatus.setText(Configuration.languageResources.getString("panelaccounting.lblStatus"));
        this.btnChangeAccount.setText(Configuration.languageResources.getString("panelaccounting.btnChangeAccount"));
        ((TitledBorder)this.panel4.getBorder()).setTitle(Configuration.languageResources.getString("panelaccounting.panel4"));
        this.lblTypeReverse.setText(Configuration.languageResources.getString("panelaccounting.lblTypeReverse") + ":");
        this.typeReverse.setModel(revTransactionView);
    }
}
