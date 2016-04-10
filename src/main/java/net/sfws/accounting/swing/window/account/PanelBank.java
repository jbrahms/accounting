package net.sfws.accounting.swing.window.account;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.swing.control.JValueComboBox;
import net.sfws.accounting.swing.window.DlgBank;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.Dialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelBank extends JPanel {
    
    // serial
    private static final long serialVersionUID = 4703034039232189827L;
    
    // controls
    private JLabel lblLabel1;
    private JLabel lblLabel2;
    private JLabel lblLabel3;
    private JPanel panel1;
    private JCheckBox isBankAccount;
    private JPanel panel2;
    private JLabel lblBank;
    private JValueComboBox bank;
    private JLabel lblBranchName;
    private JTextField branchName;
    private JLabel lblBankNumber;
    private JTextField bankNumber;
    private JLabel lblCity;
    private JTextField city;
    private JLabel lblState;
    private JTextField state;
    private JLabel lblZipcode1;
    private JTextField zipCode1;
    private JLabel lblZipcode2;
    private JTextField zipCode2;
    private JLabel lblCountry;
    private JTextField country;
    private JLabel lblStatus;
    private JLabel lblDateValidFrom;
    private JTextField txtDateValidFrom;
    private JLabel lblDateValidUntil;
    private JTextField txtDateValidUntil;
    private JPanel panel3;
    private JButton btnNew;
    private JButton btnDetails;
    
    // class members
    private Dialog parent;
    
    
    /**
     * Create the panel.
     */
    public PanelBank(Object parent) {
        
        // set class-membes
        this.parent = (Dialog)parent;
        
        // initialisation
        this.initPanel();
        
        // pre-fill panel
        this.prefillPanel();
    }
    
    private void initPanel() {
        
        this.setLayout(new MigLayout("inset 5 5 0 0", "[min]20[grow]", "[min]0[min]20[grow]"));
        
        this.lblLabel1 = new JLabel("");
        this.lblLabel1.setIcon(new ImageIcon(PanelBank.class.getResource("/net/sfws/accounting/res/icon-account.gif")));
        add(this.lblLabel1, "cell 0 0 1 2, alignx left, aligny top");
        
        this.lblLabel2 = new JLabel("Option 2:");
        this.lblLabel2.setFont(Configuration.FontNormalBold);
        add(this.lblLabel2, "cell 1 0");
        
        this.lblLabel3 = new JLabel("Banking Options");
        this.lblLabel3.setFont(Configuration.FontNormalBold);
        add(this.lblLabel3, "cell 1 1,aligny top");
        
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "Banking Options", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout("", "[grow]", "[min][grow]"));
        
        this.isBankAccount = new JCheckBox("Is Bank-Account");
        this.isBankAccount.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                isBankAccountStateChanged();
            }
        });
        this.isBankAccount.setHorizontalAlignment(SwingConstants.TRAILING);
        this.panel1.add(this.isBankAccount, "cell 0 0");
        
        this.panel2 = new JPanel();
        this.panel2.setBorder(new TitledBorder(null, "Corresponding Bank", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel2.setLayout(new MigLayout("", "[pref!]5[pref!]5[pref!]5[pref!]5[150!]10[grow,right]5[pref!]", "[][][][][][][][grow,bottom]"));
        
        this.lblBank = new JLabel("Name:");
        this.lblBank.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblBank, "cell 0 0");
        
        this.bank = new JValueComboBox();
        this.bank.setFont(Configuration.FontNormal);
        this.panel2.add(this.bank, "cell 1 0 6 1,growx");
        
        this.lblBranchName = new JLabel("Banch-Name:");
        this.lblBranchName.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblBranchName, "cell 0 1");
        
        this.branchName = new JTextField();
        this.branchName.setFont(Configuration.FontNormal);
        this.branchName.setEditable(false);
        this.panel2.add(this.branchName, "cell 1 1 4 1,growx");
        
        this.lblBankNumber = new JLabel("Bank-Number:");
        this.lblBankNumber.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblBankNumber, "cell 0 2");
        
        this.bankNumber = new JTextField();
        this.bankNumber.setFont(Configuration.FontNormal);
        this.bankNumber.setEditable(false);
        this.panel2.add(this.bankNumber, "cell 1 2 4 1,growx");

        this.lblCity = new JLabel("City:");
        this.lblCity.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblCity, "cell 0 3");
        
        this.city = new JTextField();
        this.city.setFont(Configuration.FontNormal);
        this.city.setEditable(false);
        this.panel2.add(this.city, "cell 1 3 4 1,growx");
        
        this.lblState = new JLabel("State:");
        this.lblState.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblState, "cell 0 4");
        
        this.state = new JTextField();
        this.state.setFont(Configuration.FontNormal);
        this.state.setEditable(false);
        this.panel2.add(this.state, "cell 1 4 4 1,growx");
        
        this.lblZipcode1 = new JLabel("Zipcode:");
        this.lblZipcode1.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblZipcode1, "cell 0 5");
        
        this.zipCode1 = new JTextField();
        this.zipCode1.setFont(Configuration.FontNormal);
        this.zipCode1.setColumns(5);
        this.zipCode1.setEditable(false);
        this.panel2.add(this.zipCode1, "cell 1 5");
        
        this.lblZipcode2 = new JLabel("-");
        this.lblZipcode2.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblZipcode2, "cell 2 5");
        
        this.zipCode2 = new JTextField();
        this.zipCode2.setFont(Configuration.FontNormal);
        this.zipCode2.setColumns(4);
        this.zipCode2.setEditable(false);
        this.panel2.add(this.zipCode2, "cell 3 5");

        this.lblCountry = new JLabel("Country:");
        this.lblCountry.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblCountry, "cell 0 6");
        
        this.country = new JTextField();
        this.country.setFont(Configuration.FontNormal);
        this.country.setEditable(false);
        this.panel2.add(this.country, "cell 1 6 4 1,growx");
        
        this.lblStatus = new JLabel("Status");
        this.lblStatus.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblStatus, "cell 5 4 2 1,alignx right");

        this.lblDateValidFrom = new JLabel("Valid:");
        this.lblDateValidFrom.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblDateValidFrom, "cell 5 5,alignx right");
        
        this.txtDateValidFrom = new JTextField();
        this.txtDateValidFrom.setFont(Configuration.FontNormal);
        this.txtDateValidFrom.setEditable(false);
        this.txtDateValidFrom.setColumns(10);
        this.panel2.add(this.txtDateValidFrom, "cell 6 5");

        this.lblDateValidUntil = new JLabel("Temp. valid until:");
        this.lblDateValidUntil.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblDateValidUntil, "cell 5 6, alignx right");

        this.txtDateValidUntil = new JTextField();
        this.txtDateValidUntil.setFont(Configuration.FontNormal);
        this.txtDateValidUntil.setEditable(false);
        this.txtDateValidUntil.setColumns(10);
        this.panel2.add(this.txtDateValidUntil, "cell 6 6");
        
        panel3 = new JPanel();
        panel3.setLayout(new MigLayout("inset 0 0 0 0", "[pref!][grow, left]", "[grow, bottom]"));
        
        this.btnNew = new JButton("New");
        this.btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnNewClicked();
            }
        });
        this.btnNew.setFont(Configuration.FontNormal);
        this.panel3.add(this.btnNew, "cell 0 0");
        
        this.btnDetails = new JButton("Details");
        this.btnDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnDetailsClicked();
            }
        });
        this.btnDetails.setFont(Configuration.FontNormal);
        this.panel3.add(this.btnDetails, "cell 1 0");
                
        this.panel2.add(this.panel3, "cell 0 7 7 1");

        this.panel1.add(this.panel2, "cell 0 1, grow");

        this.add(this.panel1, "cell 0 2 2 1, grow");
    }
    
    private void prefillPanel() {
        
        // set panel
        this.setEnablePanel(this.isBankAccount.isSelected());
    }
    
    private void setEnablePanel(boolean enabled) {
        
        // set controls
        this.lblBank.setEnabled(enabled);
        this.lblBankNumber.setEnabled(enabled);
        this.lblBranchName.setEnabled(enabled);
        this.lblCity.setEnabled(enabled);
        this.lblCountry.setEnabled(enabled);
        this.lblDateValidFrom.setEnabled(enabled);
        this.lblDateValidUntil.setEnabled(enabled);
        this.lblState.setEnabled(enabled);
        this.lblStatus.setEnabled(enabled);
        this.lblZipcode1.setEnabled(enabled);
        this.lblZipcode2.setEnabled(enabled);
        
        this.panel2.setEnabled(enabled);
        
        this.bank.setEnabled(enabled);
        this.btnDetails.setEnabled(enabled);
        this.btnNew.setEnabled(enabled);
    }
    
    private void isBankAccountStateChanged() {
        
        // set panel
        this.setEnablePanel(this.isBankAccount.isSelected());
    }
    
    private void btnNewClicked() {
        
        // open "DlgBank"
        new DlgBank(this.parent, true);
    }
    
    private void btnDetailsClicked() {
        
        // open "DlgBank"
        new DlgBank(this.parent, true);
    }
}
