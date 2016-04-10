package net.sfws.accounting.swing.window.account;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.swing.control.JValueComboBox;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;
import java.util.HashMap;

import javax.swing.JCheckBox;


public class PanelGeneral extends JPanel {
    
    // serial
    private static final long serialVersionUID = 4703034039232189827L;
    
    // controls
    private JLabel lblLabel1;
    private JLabel lblLabel2;
    private JLabel lblLabel3;
    private JPanel panel1;
    private JLabel lblName;
    private JTextField name;
    private JLabel lblText;
    private JTextArea text;
    private JLabel lblTypeAccount;
    private JValueComboBox typeAccount;
    private JLabel lblTypeClosing;
    private JValueComboBox typeClosing;
    private JLabel lblAccountNumber;
    private JTextField accountNumber;
    private JLabel lblCurrency;
    private JValueComboBox currency;
    private JLabel lblIsDefault;
    private JCheckBox isDefault;

    /**
     * Create the panel.
     */
    public PanelGeneral() {
        
        // initialisation panel
        this.initPanel();
        
        // pre-fill panel
        this.prefillPanel();
    }
    
    private void initPanel() {
        
        this.setLayout(new MigLayout("inset 5 5 0 0", "[min]20[grow]", "[min]0[min]20[grow]"));
        
        this.lblLabel1 = new JLabel("");
        this.lblLabel1.setIcon(new ImageIcon(PanelGeneral.class.getResource("/net/sfws/accounting/res/icon-account.gif")));
        this.add(this.lblLabel1, "cell 0 0 1 2, alignx left, aligny top");
        
        this.lblLabel2 = new JLabel("Option 1:");
        this.lblLabel2.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel2, "cell 1 0");
        
        this.lblLabel3 = new JLabel("General Options");
        this.lblLabel3.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel3, "cell 1 1,aligny top");
        
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "General Options", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout("", "[min!, left]5[pref!, left]10[grow]", "[min!,center][pref!,center][pref!][min!,center][min!,center][min!,center][min!,center][grow][min!,center]"));
        
        this.lblName = new JLabel("Name:");
        this.lblName.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblName, "cell 0 0");
        
        this.name = new JTextField();
        this.name.setFont(Configuration.FontNormal);
        this.panel1.add(this.name, "cell 1 0,growx");
        
        this.lblText = new JLabel("Text:");
        this.lblText.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblText, "cell 0 1");
        
        this.text = new JTextArea();
        this.text.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
        this.text.setFont(Configuration.FontNormal);
        this.panel1.add(this.text, "cell 1 1 2 2,grow");
        
        JLabel lblFiller = new JLabel("   ");
        lblFiller.setFont(Configuration.FontNormal);
        this.panel1.add(lblFiller, "cell 0 2");

        this.lblTypeAccount = new JLabel("Account-Type:");
        this.lblTypeAccount.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblTypeAccount, "cell 0 3");
        
        this.typeAccount = new JValueComboBox();
        this.typeAccount.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
        this.typeAccount.setFont(Configuration.FontNormal);
        this.panel1.add(this.typeAccount, "cell 1 3,grow");

        this.lblTypeClosing = new JLabel("Closing-Type:");
        this.lblTypeClosing.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblTypeClosing, "cell 0 4");
        
        this.typeClosing = new JValueComboBox();
        this.typeClosing.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
        this.typeClosing.setFont(Configuration.FontNormal);
        this.panel1.add(this.typeClosing, "cell 1 4,grow");
        
        this.lblAccountNumber = new JLabel("Account-Number:");
        this.lblAccountNumber.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblAccountNumber, "cell 0 5");
        
        this.accountNumber = new JTextField();
        this.accountNumber.setFont(Configuration.FontNormal);
        this.panel1.add(this.accountNumber, "cell 1 5,growx");

        this.lblCurrency = new JLabel("Currency:");
        this.lblCurrency.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblCurrency, "cell 0 6");
        
        this.currency = new JValueComboBox();
        this.currency.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
        this.currency.setFont(Configuration.FontNormal);
        this.panel1.add(this.currency, "cell 1 6,grow");
        
        this.lblIsDefault = new JLabel("Is Default:");
        this.lblIsDefault.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblIsDefault, "cell 0 8");
        
        this.isDefault = new JCheckBox();
        this.panel1.add(this.isDefault, "cell 1 8");
        
        this.add(this.panel1, "cell 0 2 2 1, grow");
    }
    
    private void prefillPanel() {
        
        // initialisations
        HashMap<String, String> accountType = new HashMap<String, String>();
        HashMap<String, String> closingType = new HashMap<String, String>();
        HashMap<String, String> currency = new HashMap<String, String>();
        
        // create list of entries
        accountType.put("-", Configuration.languageResources.getString("typeAccount.null"));
        accountType.put("C1", Configuration.languageResources.getString("typeAccount.C1"));
        accountType.put("CA", Configuration.languageResources.getString("typeAccount.CA"));
        accountType.put("CC", Configuration.languageResources.getString("typeAccount.CC"));
        accountType.put("CS", Configuration.languageResources.getString("typeAccount.CS"));
        accountType.put("DC", Configuration.languageResources.getString("typeAccount.DC"));
        accountType.put("ED", Configuration.languageResources.getString("typeAccount.ED"));
        accountType.put("FE", Configuration.languageResources.getString("typeAccount.FE"));
        accountType.put("IN", Configuration.languageResources.getString("typeAccount.IN"));
        accountType.put("MA", Configuration.languageResources.getString("typeAccount.MA"));
        accountType.put("ME", Configuration.languageResources.getString("typeAccount.ME"));
        accountType.put("MO", Configuration.languageResources.getString("typeAccount.MO"));
        accountType.put("RA", Configuration.languageResources.getString("typeAccount.RA"));
        accountType.put("SA", Configuration.languageResources.getString("typeAccount.SA"));
        accountType.put("UA", Configuration.languageResources.getString("typeAccount.UA"));
        
        // create list of entries
        closingType.put("-", Configuration.languageResources.getString("typeClose.null"));
        closingType.put("A", Configuration.languageResources.getString("typeClose.A"));
        closingType.put("L", Configuration.languageResources.getString("typeClose.L"));
        closingType.put("N", Configuration.languageResources.getString("typeClose.N"));
        
        // create list of entries
        currency.put("-", Configuration.languageResources.getString("currency.null"));
        currency.put("BTC", Configuration.languageResources.getString("currencyLong.BTC") + " [" + Configuration.languageResources.getString("currencyShort.BTC") + "]");
        currency.put("DEM", Configuration.languageResources.getString("currencyLong.DEM") + " [" + Configuration.languageResources.getString("currencyShort.DEM") + "]");
        currency.put("ECU", Configuration.languageResources.getString("currencyLong.ECU") + " [" + Configuration.languageResources.getString("currencyShort.ECU") + "]");
        currency.put("GBP", Configuration.languageResources.getString("currencyLong.GBP") + " [" + Configuration.languageResources.getString("currencyShort.GBP") + "]");
        currency.put("RUB", Configuration.languageResources.getString("currencyLong.RUB") + " [" + Configuration.languageResources.getString("currencyShort.RUB") + "]");
        currency.put("USD", Configuration.languageResources.getString("currencyLong.USD") + " [" + Configuration.languageResources.getString("currencyShort.USD") + "]");

        this.typeAccount.setModel(accountType);
        this.typeClosing.setModel(closingType);
        this.currency.setModel(currency);
    }
}
