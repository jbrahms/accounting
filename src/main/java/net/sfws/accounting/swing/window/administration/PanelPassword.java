package net.sfws.accounting.swing.window.administration;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;

public class PanelPassword extends JPanel {
    
    // serial
    private static final long serialVersionUID = -8440098568783052500L;

    // controls
    private JLabel lblLabel1;
    private JLabel lblLabel2;
    private JLabel lblLabel3;
    private JPanel panel1;
    private JLabel lblPasswordOld;
    private JTextField passwordOld;
    private JLabel lblPasswordNew;
    private JTextField passwordNew;
    private JLabel lblPasswordRepeat;
    private JTextField passwordRepeat;

    /**
     * Create the panel.
     */
    public PanelPassword(int option) {
        
        // initialisation panel
        this.initPanel(option);

        // pre-fill panel
        this.prefillPanel();
    }
    
    private void initPanel(int option) {
        
        this.setLayout(new MigLayout("inset 5 5 0 0", "[pref!]20[grow]", "[pref!]0[pref!]20[grow]"));
        
        this.lblLabel1 = new JLabel("");
        this.lblLabel1.setIcon(new ImageIcon(PanelPassword.class.getResource("/net/sfws/accounting/res/icon-user.gif")));
        this.add(this.lblLabel1, "cell 0 0 1 2, alignx left, aligny top");
        
        this.lblLabel2 = new JLabel("Option " + String.valueOf(option) + ":");
        this.lblLabel2.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel2, "cell 1 0");
        
        this.lblLabel3 = new JLabel("Password");
        this.lblLabel3.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel3, "cell 1 1,aligny top");
        
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "Password", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout("", "[pref!,left]5[grow,left]", "[pref!,center][pref!,center][pref!,center][grow][pref!,center][pref!,center][pref!,center]"));
        
        this.lblPasswordOld = new JLabel("Old Password:");
        this.lblPasswordOld.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblPasswordOld, "cell 0 0");
        
        this.passwordOld = new JTextField();
        this.passwordOld.setFont(Configuration.FontNormal);
        this.panel1.add(this.passwordOld, "cell 1 0,growx");
        
        this.lblPasswordNew = new JLabel("New Password:");
        this.lblPasswordNew.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblPasswordNew, "cell 0 1");
        
        this.passwordNew = new JTextField();
        this.passwordNew.setFont(Configuration.FontNormal);
        this.panel1.add(this.passwordNew, "cell 1 1,growx");
        
        this.lblPasswordRepeat = new JLabel("Repeat Password:");
        this.lblPasswordRepeat.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblPasswordRepeat, "cell 0 2");
        
        this.passwordRepeat = new JTextField();
        this.passwordRepeat.setFont(Configuration.FontNormal);
        this.passwordRepeat.setColumns(15);
        this.panel1.add(this.passwordRepeat, "cell 1 2,growx");
        
        this.add(this.panel1, "cell 0 2 2 1, grow");
    }
    
    private void prefillPanel() {
        
    }
}
