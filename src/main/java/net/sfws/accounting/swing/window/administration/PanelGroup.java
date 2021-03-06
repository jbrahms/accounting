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

public class PanelGroup extends JPanel {
    
    // serial
    private static final long serialVersionUID = -8440098568783052500L;

    // controls
    private JLabel lblLabel1;
    private JLabel lblLabel2;
    private JLabel lblLabel3;
    private JPanel panel1;
    private JLabel lblGroupId;
    private JTextField groupId;
    private JLabel lblName;
    private JTextField name;
    private JLabel lblDescription;
    private JTextField description;
    private JLabel lblStatus;
    private JLabel lblDateValidFrom;
    private JTextField dateValidFrom;
    private JLabel lblDateValidUntil;
    private JTextField dateValidUntil;
    private JButton btnIgnore;

    /**
     * Create the panel.
     */
    public PanelGroup(int option) {
        
        // initialisation panel
        this.initPanel(option);

        // pre-fill panel
        this.prefillPanel();
    }
    
    private void initPanel(int option) {
        
        this.setLayout(new MigLayout("inset 5 5 0 0", "[pref!]20[grow]", "[pref!]0[pref!]20[grow][pref!]"));
        
        this.lblLabel1 = new JLabel("");
        this.lblLabel1.setIcon(new ImageIcon(PanelGroup.class.getResource("/net/sfws/accounting/res/icon-user.gif")));
        this.add(this.lblLabel1, "cell 0 0 1 2, alignx left, aligny top");
        
        this.lblLabel2 = new JLabel("Option " + String.valueOf(option) + ":");
        this.lblLabel2.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel2, "cell 1 0");
        
        this.lblLabel3 = new JLabel("General Options");
        this.lblLabel3.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel3, "cell 1 1,aligny top");
        
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "General Options", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout("", "[pref!,left]5[grow,left]10[pref!,left]5[pref!,left]", "[pref!,center]20[pref!,center][pref!,center][grow][pref!,center][pref!,center][pref!,center]"));
        
        this.lblGroupId = new JLabel("Group-Id:");
        this.lblGroupId.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblGroupId, "cell 0 0");
        
        this.groupId = new JTextField();
        this.groupId.setFont(Configuration.FontNormal);
        this.groupId.setColumns(10);
        this.panel1.add(this.groupId, "cell 1 0 3 1");
        
        this.lblName = new JLabel("Name:");
        this.lblName.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblName, "cell 0 1");
        
        this.name = new JTextField();
        this.name.setFont(Configuration.FontNormal);
        this.panel1.add(this.name, "cell 1 1 3 1, growx");
        
        this.lblDescription = new JLabel("Description:");
        this.lblDescription.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDescription, "cell 0 2");
        
        this.description = new JTextField();
        this.description.setFont(Configuration.FontNormal);
        this.panel1.add(this.description, "cell 1 2 3 1, growx");
        
        this.lblStatus = new JLabel("Status");
        this.lblStatus.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblStatus, "cell 0 4 4 1,alignx right");

        this.lblDateValidFrom = new JLabel("Valid:");
        this.lblDateValidFrom.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDateValidFrom, "cell 2 5,alignx right");
        
        this.dateValidFrom = new JTextField();
        this.dateValidFrom.setFont(Configuration.FontNormal);
        this.dateValidFrom.setEditable(true);
        this.dateValidFrom.setColumns(10);
        this.panel1.add(this.dateValidFrom, "cell 3 5");

        this.lblDateValidUntil = new JLabel("Temp. valid until:");
        this.lblDateValidUntil.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDateValidUntil, "cell 2 6,alignx right");

        this.dateValidUntil = new JTextField();
        this.dateValidUntil.setFont(Configuration.FontNormal);
        this.dateValidUntil.setEditable(true);
        this.dateValidUntil.setColumns(10);
        this.panel1.add(this.dateValidUntil, "cell 3 6");
        
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
