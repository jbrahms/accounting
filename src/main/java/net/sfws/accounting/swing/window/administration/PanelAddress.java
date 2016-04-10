package net.sfws.accounting.swing.window.administration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.swing.control.JValueComboBox;

public class PanelAddress extends JPanel {
    
    // serial
    private static final long serialVersionUID = -8440098568783052500L;
    
    // statics
    public static final String PARENT_BANK = "BANK";
    public static final String PARENT_USER = "USER";
    public static final String PARENT_COMPANY = "COMPANY";

    // controls
    private JLabel lblLabel1;
    private JLabel lblLabel2;
    private JLabel lblLabel3;
    private JPanel panel1;
    private JLabel lblStreet;
    private JTextField street;
    private JTextField street2;
    private JLabel lblAppNo;
    private JTextField appNo;
    private JLabel lblCity;
    private JTextField city;
    private JLabel lblState;
    private JValueComboBox state;
    private JLabel lblZipCode1;
    private JTextField zipcode1;
    private JLabel lblZipCode2;
    private JTextField zipcode2;
    private JLabel lblCountry;
    private JValueComboBox country;
    private JLabel lblStatus;
    private JLabel lblDateValidFrom;
    private JTextField dateValidFrom;
    private JLabel lblDateValidUntil;
    private JTextField dateValidUntil;
    private JButton btnIgnore;

    /**
     * Create the panel.
     */
    public PanelAddress(String parent, int option) {
        
        // initialisation panel
        this.initPanel(parent, option);

        // pre-fill panel
        this.prefillPanel();
    }
    
    private void initPanel(String parent, int option) {
        
        this.setLayout(new MigLayout("inset 5 5 0 0", "[pref!]20[grow]", "[pref!]0[pref!]20[grow][pref!]"));
        
        this.lblLabel1 = new JLabel("");
        if (parent.endsWith("BANK") == true) {
            this.lblLabel1.setIcon(new ImageIcon(PanelAddress.class.getResource("/net/sfws/accounting/res/icon-bank.gif")));
        } else if (parent.endsWith("COMPANY") == true) {
            this.lblLabel1.setIcon(new ImageIcon(PanelAddress.class.getResource("/net/sfws/accounting/res/icon-bank.gif")));
        } else if (parent.endsWith("USER") == true) {
            this.lblLabel1.setIcon(new ImageIcon(PanelAddress.class.getResource("/net/sfws/accounting/res/icon-user.gif")));
        } 
        this.add(this.lblLabel1, "cell 0 0 1 2, alignx left, aligny top");
        
        this.lblLabel2 = new JLabel("Option " + String.valueOf(option) + ":");
        this.lblLabel2.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel2, "cell 1 0");
        
        this.lblLabel3 = new JLabel("Address");
        this.lblLabel3.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel3, "cell 1 1,aligny top");
        
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "Address", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout("", "[pref!,left]5[pref!,left]10[grow,right]5[]", "[pref!,center][pref!,center][pref!,center][pref!,center][pref!,center][pref!,center][pref!,center][grow][pref!,center][pref!,center][pref!,center]"));
        
        this.lblStreet = new JLabel("Street:");
        this.lblStreet.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblStreet, "cell 0 0");
        
        this.street = new JTextField();
        this.street.setFont(Configuration.FontNormal);
        this.panel1.add(this.street, "cell 1 0 3 1,growx");
        
        this.street2 = new JTextField();
        this.street2.setFont(Configuration.FontNormal);
        this.panel1.add(this.street2, "cell 1 1 3 1,growx");
        
        this.lblAppNo = new JLabel("App-No.:");
        this.lblAppNo.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblAppNo, "cell 0 2");
        
        this.appNo = new JTextField();
        this.appNo.setFont(Configuration.FontNormal);
        this.appNo.setColumns(5);
        this.panel1.add(this.appNo, "cell 1 2");
        
        this.lblCity = new JLabel("City:");
        this.lblCity.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblCity, "cell 0 3");
        
        this.city = new JTextField();
        this.city.setFont(Configuration.FontNormal);
        this.panel1.add(this.city, "cell 1 3,growx");
        
        this.lblState = new JLabel("State:");
        this.lblState.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblState, "cell 0 4");
        
        this.state = new JValueComboBox();
        this.state.setFont(Configuration.FontNormal);
        this.panel1.add(this.state, "cell 1 4,growx");
        
        this.lblZipCode1 = new JLabel("Zipcode:");
        this.lblZipCode1.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblZipCode1, "cell 0 5");
        
        JPanel zipcodePanel = new JPanel();
        zipcodePanel.setLayout(new MigLayout("inset 0 0 0 0", "[pref!]5[pref!]5[pref!]", "[pref!]"));
        
        this.zipcode1 = new JTextField();
        this.zipcode1.setFont(Configuration.FontNormal);
        this.zipcode1.setColumns(5);
        zipcodePanel.add(this.zipcode1, "cell 0 0,growx");
        
        this.lblZipCode2 = new JLabel("-");
        this.lblZipCode2.setFont(Configuration.FontNormal);
        zipcodePanel.add(this.lblZipCode2, "cell 1 0");
        
        this.zipcode2 = new JTextField();
        this.zipcode2.setFont(Configuration.FontNormal);
        this.zipcode2.setColumns(4);
        zipcodePanel.add(this.zipcode2, "cell 2 0");
        
        this.panel1.add(zipcodePanel, "cell 1 5");
        
        this.lblCountry = new JLabel("Country:");
        this.lblCountry.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblCountry, "cell 0 6");
        
        this.country = new JValueComboBox();
        this.country.setFont(Configuration.FontNormal);
        this.panel1.add(this.country, "cell 1 6,growx");
        
        this.lblStatus = new JLabel("Status");
        this.lblStatus.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblStatus, "cell 0 8 4 1,alignx right");
        
        this.lblDateValidFrom = new JLabel("Valid:");
        this.lblDateValidFrom.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDateValidFrom, "cell 2 9,alignx right");
        
        this.dateValidFrom = new JTextField();
        this.dateValidFrom.setFont(Configuration.FontNormal);
        this.dateValidFrom.setEditable(true);
        this.dateValidFrom.setColumns(10);
        this.panel1.add(this.dateValidFrom, "cell 3 9");

        this.lblDateValidUntil = new JLabel("Temp. valid until:");
        this.lblDateValidUntil.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDateValidUntil, "cell 2 10,alignx right");
        
        this.dateValidUntil = new JTextField();
        this.dateValidUntil.setFont(Configuration.FontNormal);
        this.dateValidUntil.setEditable(true);
        this.dateValidUntil.setColumns(10);
        this.panel1.add(this.dateValidUntil, "cell 3 10");
        
        this.add(this.panel1, "cell 0 2 2 1, grow");
        
        this.btnIgnore = new JButton("Ignore");
        this.btnIgnore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnIgoreClicked();
            }
        });
        this.btnIgnore.setFont(Configuration.FontNormal);
        this.add(this.btnIgnore, "cell 0 3 2 1, alignx right");
    }
    
    private void prefillPanel() {
        
        // initialisations
        HashMap<String, String> state = new HashMap<String, String>();
        HashMap<String, String> country = new HashMap<String, String>();
        
        // fill state
        state.put("-", "- please select state -");
        state.put("CA", "California");
        
        // fill
        country.put("-", "- please select country -");
        country.put("GER", "Germany");
        country.put("UK", "United Kingdom");
        country.put("USA", "United States of America");
        
        // set combo-boxes
        this.state.setModel(state);
        this.country.setModel(country);
        
    }
    
    private void btnIgoreClicked() {
        
    }
}
