package net.sfws.accounting.swing.window.administration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUser extends JPanel {
    
    // serial
    private static final long serialVersionUID = -8440098568783052500L;

    // controls
    private JLabel lblLabel1;
    private JLabel lblLabel2;
    private JLabel lblLabel3;
    private JPanel panel1;
    private JLabel lblUserId;
    private JTextField userId;
    private JLabel lblFirstName;
    private JTextField firstName;
    private JLabel lblMiddleName;
    private JTextField middleName;
    private JLabel lblLastName;
    private JTextField lastName;
    private JLabel lblInitials;
    private JTextField initials;
    private JLabel lblStatus;
    private JLabel lblDateValidFrom;
    private JTextField dateValidFrom;
    private JLabel lblDateValidUntil;
    private JTextField dateValidUntil;
    private JButton btnIgnore;

    /**
     * Create the panel.
     */
    public PanelUser(int option) {
        
        // initialisation panel
        this.initPanel(option);

        // pre-fill panel
        this.prefillPanel();
    }
    
    private void initPanel(int option) {
        
        this.setLayout(new MigLayout("inset 5 5 0 0", "[pref!]20[grow]", "[pref!]0[pref!]20[grow][pref!]"));
        
        this.lblLabel1 = new JLabel("");
        this.lblLabel1.setIcon(new ImageIcon(PanelUser.class.getResource("/net/sfws/accounting/res/icon-user.gif")));
        this.add(this.lblLabel1, "cell 0 0 1 2, alignx left, aligny top");
        
        this.lblLabel2 = new JLabel("Option " + String.valueOf(option) + ":");
        this.lblLabel2.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel2, "cell 1 0");
        
        this.lblLabel3 = new JLabel("General Options");
        this.lblLabel3.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel3, "cell 1 1,aligny top");
        
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "General Options", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout("", "[pref!,left]5[grow,left]10[pref!,left]5[pref!,left]", "[pref!,center]20[pref!,center][pref!,center][pref!,center][pref!,center][grow][pref!,center][pref!,center][pref!,center]"));
        
        this.lblUserId = new JLabel("User-Id:");
        this.lblUserId.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblUserId, "cell 0 0");
        
        this.userId = new JTextField();
        this.userId.setFont(Configuration.FontNormal);
        this.userId.setColumns(10);
        this.panel1.add(this.userId, "cell 1 0 3 1");
        
        this.lblFirstName = new JLabel("Firstname:");
        this.lblFirstName.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblFirstName, "cell 0 1");
        
        this.firstName = new JTextField();
        this.firstName.setFont(Configuration.FontNormal);
        this.panel1.add(this.firstName, "cell 1 1 3 1, growx");
        
        this.lblMiddleName = new JLabel("Middlename:");
        this.lblMiddleName.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblMiddleName, "cell 0 2");
        
        this.middleName = new JTextField();
        this.middleName.setFont(Configuration.FontNormal);
        this.panel1.add(this.middleName, "cell 1 2 3 1, growx");
        
        this.lblLastName = new JLabel("Lastname:");
        this.lblLastName.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblLastName, "cell 0 3");
        
        this.lastName = new JTextField();
        this.lastName.setFont(Configuration.FontNormal);
        this.lastName.setColumns(15);
        this.panel1.add(this.lastName, "cell 1 3 3 1,growx");
        
        this.lblInitials = new JLabel("Initials:");
        this.lblInitials.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblInitials, "cell 0 4");
        
        this.initials = new JTextField();
        this.initials.setFont(Configuration.FontNormal);
        this.initials.setColumns(4);
        this.panel1.add(this.initials, "cell 1 4 3 1");
        
        this.lblStatus = new JLabel("Status");
        this.lblStatus.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblStatus, "cell 0 6 4 1,alignx right");

        this.lblDateValidFrom = new JLabel("Valid:");
        this.lblDateValidFrom.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDateValidFrom, "cell 2 7,alignx right");
        
        this.dateValidFrom = new JTextField();
        this.dateValidFrom.setFont(Configuration.FontNormal);
        this.dateValidFrom.setEditable(true);
        this.dateValidFrom.setColumns(10);
        this.panel1.add(this.dateValidFrom, "cell 3 7");

        this.lblDateValidUntil = new JLabel("Temp. valid until:");
        this.lblDateValidUntil.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDateValidUntil, "cell 2 8,alignx right");

        this.dateValidUntil = new JTextField();
        this.dateValidUntil.setFont(Configuration.FontNormal);
        this.dateValidUntil.setEditable(true);
        this.dateValidUntil.setColumns(10);
        this.panel1.add(this.dateValidUntil, "cell 3 8");
        
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
