package net.sfws.accounting.swing.window.administration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;

public class PanelContact extends JPanel {
    
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
    private JLabel lblPhone;
    private JTextField phone;
    private JLabel lblFax;
    private JTextField fax;
    private JLabel lblMobile;
    private JTextField mobile;
    private JLabel lblEmail;
    private JTextField email;
    private JLabel lblWebsite;
    private JTextField website;
    private JLabel lblContact;
    private JTextField contact;
    private JLabel lblStatus;
    private JLabel lblDateValidFrom;
    private JTextField dateValidFrom;
    private JLabel lblDateValidUntil;
    private JTextField dateValidUntil;
    private JButton btnIgnore;

    /**
     * Create the panel.
     */
    public PanelContact(String parent, int option) {
        
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
        
        this.lblLabel3 = new JLabel("Contact");
        this.lblLabel3.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel3, "cell 1 1,aligny top");
        
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "Contact", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout("", "[pref!,left]10[grow,left]5[pref!,left]", "[pref!,center][pref!,center][pref!,center][pref!,center][pref!,center][pref!,center][grow][pref!,center][pref!,center][pref!,center]"));
        
        this.lblPhone = new JLabel("Phone:");
        this.lblPhone.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblPhone, "cell 0 0");
        
        this.phone = new JTextField();
        this.phone.setFont(Configuration.FontNormal);
        this.panel1.add(this.phone, "cell 1 0 2 1,growx");
        
        this.lblFax = new JLabel("Fax:");
        this.lblFax.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblFax, "cell 0 1");
        
        this.fax = new JTextField();
        this.fax.setFont(Configuration.FontNormal);
        this.panel1.add(this.fax, "cell 1 1 2 1,growx");
        
        this.lblMobile = new JLabel("Mobile:");
        this.lblMobile.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblMobile, "cell 0 2");
        
        this.mobile = new JTextField();
        this.mobile.setFont(Configuration.FontNormal);
        this.panel1.add(this.mobile, "cell 1 2 2 1,growx");
        
        this.lblEmail = new JLabel("Email:");
        this.lblEmail.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblEmail, "cell 0 3");
        
        this.email = new JTextField();
        this.email.setFont(Configuration.FontNormal);
        this.panel1.add(this.email, "cell 1 3 2 1,growx");
        
        this.lblWebsite = new JLabel("Website:");
        this.lblWebsite.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblWebsite, "cell 0 4");
        
        this.website = new JTextField();
        this.website.setFont(Configuration.FontNormal);
        this.panel1.add(this.website, "cell 1 4 2 1,growx");
        
        this.lblContact = new JLabel("Contact:");
        this.lblContact.setFont(Configuration.FontNormal);
        if (parent.endsWith("USER") == true) {
            this.lblContact.setVisible(false);
        }
        this.panel1.add(this.lblContact, "cell 0 5");
        
        this.contact = new JTextField();
        this.contact.setFont(Configuration.FontNormal);
        if (parent.endsWith("USER") == true) {
            this.contact.setVisible(false);
        }
        this.panel1.add(this.contact, "cell 1 5 2 1,growx");
        
        this.lblStatus = new JLabel("Status");
        this.lblStatus.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblStatus, "cell 0 7 3 1,alignx right");
        
        this.lblDateValidFrom = new JLabel("Valid:");
        this.lblDateValidFrom.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDateValidFrom, "cell 1 8,alignx right");
        
        this.dateValidFrom = new JTextField();
        this.dateValidFrom.setFont(Configuration.FontNormal);
        this.dateValidFrom.setEditable(true);
        this.dateValidFrom.setColumns(10);
        this.panel1.add(this.dateValidFrom, "cell 2 8");

        this.lblDateValidUntil = new JLabel("Temp. valid until:");
        this.lblDateValidUntil.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDateValidUntil, "cell 1 9,alignx right");
        
        this.dateValidUntil = new JTextField();
        this.dateValidUntil.setFont(Configuration.FontNormal);
        this.dateValidUntil.setEditable(true);
        this.dateValidUntil.setColumns(10);
        this.panel1.add(this.dateValidUntil, "cell 2 9");
        
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
        
    }
    
    private void btnIgoreClicked() {
        
    }
}
