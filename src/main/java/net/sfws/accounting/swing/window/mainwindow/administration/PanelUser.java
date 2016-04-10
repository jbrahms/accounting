package net.sfws.accounting.swing.window.mainwindow.administration;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.swing.window.DlgUser;

import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelUser extends JPanel {
    
    // serial
    private static final long serialVersionUID = 4357139160422201829L;

    // controls
    private JLabel lblLabel1;
    private JTextField id;
    private JLabel lblLabel2;
    private JTextField firstName;
    private JLabel lblLabel3;
    private JTextField lastName;
    private JLabel lblIsAdmin;
    private JLabel lblStatus;
    private JLabel lblLabel5;
    private JTextField txtDateValidFrom;
    private JLabel lblLabel6;
    private JTextField txtDateValidUntil;
    private JButton btnDetails;
    
    // class-members
    private Frame parent;

    /**
     * Create the panel.
     */
    public PanelUser(Object parent) {
        
        // set class-members
        this.parent = (Frame)parent;
        
        // initialisation
        this.initPanel();
        
        // fill panel
        this.prefillPanel();
    }
    
    private void initPanel() {
        
        // set border
        setBorder(new TitledBorder(null, "User", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        
        // set layout
        setLayout(new MigLayout("", "[]5[grow]5[pref!]", "[][][][][grow][][][min]"));
        
        this.lblLabel1 = new JLabel("ID:");
        this.lblLabel1.setFont(Configuration.FontNormal);
        add(this.lblLabel1, "cell 0 0");
        
        this.id = new JTextField();
        this.id.setFont(Configuration.FontNormal);
        this.id.setColumns(10);
        add(this.id, "cell 1 0 2 1, alignx left");
        
        this.lblLabel2 = new JLabel("Firstname:");
        this.lblLabel2.setFont(Configuration.FontNormal);
        add(this.lblLabel2, "cell 0 1, alignx left");
        
        this.firstName = new JTextField();
        this.firstName.setFont(Configuration.FontNormal);
        add(this.firstName, "cell 1 1 2 1,growx");
        
        this.lblLabel3 = new JLabel("Lastname:");
        this.lblLabel3.setFont(Configuration.FontNormal);
        add(this.lblLabel3, "cell 0 2, alignx left");
        
        this.lastName = new JTextField();
        this.lastName.setFont(Configuration.FontNormal);
        add(this.lastName, "cell 1 2 2 1,growx");
        
        this.lblIsAdmin = new JLabel("Admin-Status");
        this.lblIsAdmin.setFont(Configuration.FontNormal);
        add(this.lblIsAdmin, "cell 1 3 2 1,alignx left");
        
        this.lblStatus = new JLabel("Status");
        this.lblStatus.setFont(Configuration.FontNormal);
        add(this.lblStatus, "cell 1 4 2 1,alignx right,aligny bottom");

        this.lblLabel5 = new JLabel("Valid:");
        this.lblLabel5.setFont(Configuration.FontNormal);
        add(this.lblLabel5, "cell 1 5, alignx right");
        
        this.txtDateValidFrom = new JTextField();
        this.txtDateValidFrom.setFont(Configuration.FontNormal);
        this.txtDateValidFrom.setEditable(true);
        this.txtDateValidFrom.setColumns(10);
        add(this.txtDateValidFrom, "cell 2 5");

        this.lblLabel6 = new JLabel("Temp. valid until:");
        this.lblLabel6.setFont(Configuration.FontNormal);
        add(this.lblLabel6, "cell 1 6, alignx right");

        this.txtDateValidUntil = new JTextField();
        this.txtDateValidUntil.setFont(Configuration.FontNormal);
        this.txtDateValidUntil.setEditable(true);
        this.txtDateValidUntil.setColumns(10);
        add(this.txtDateValidUntil, "cell 2 6");
        
        this.btnDetails = new JButton("Details");
        btnDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnDetailsClicked();
            }
        });
        this.btnDetails.setFont(Configuration.FontNormal);
        add(this.btnDetails, "cell 0 7 3 1,alignx right");
    }
    
    private void prefillPanel() {
        
    }
    
    private void btnDetailsClicked() {
        
        // open dialog "user"
        new DlgUser(this.parent, true);
    }
}
