package net.sfws.accounting.swing.window.mainwindow.administration;

import java.awt.Frame;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.swing.window.DlgCompany;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelCompany extends JPanel {
    
    // serial
    private static final long serialVersionUID = 4357139160422201829L;
    
    // controls
    private JLabel lblLabel1;
    private JLabel lblLabel2;
    private JTextField id;
    private JTextField name;
    private JLabel lblStatus;
    private JLabel lblLabel3;
    private JTextField txtDateValidFrom;
    private JLabel lblLabel4;
    private JTextField txtDateValidUntil;
    private JButton btnDetails;
    
    // class-members
    private Frame parent;

    /**
     * Create the panel.
     */
    public PanelCompany(Object parent) {
        
        // set class-members
        this.parent = (Frame)parent;
      
        // initialisation
        this.initPanel();
        
        // fill panel
        this.prefillPanel();
    }
    
    private void initPanel() {
        
        // set border
        setBorder(new TitledBorder(null, "Company", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        
        // set layout
        setLayout(new MigLayout("", "[]5[grow]5[pref!]", "[][][grow][][][min]"));
        
        this.lblLabel1 = new JLabel("ID:");
        this.lblLabel1.setFont(Configuration.FontNormal);
        add(this.lblLabel1, "cell 0 0");
        
        this.id = new JTextField();
        this.id.setFont(Configuration.FontNormal);
        this.id.setColumns(10);
        add(this.id, "cell 1 0 2 1, alignx left");
        
        this.lblLabel2 = new JLabel("Name:");
        this.lblLabel2.setFont(Configuration.FontNormal);
        add(this.lblLabel2, "cell 0 1, alignx left");
        
        this.name = new JTextField();
        this.name.setFont(Configuration.FontNormal);
        add(this.name, "cell 1 1 2 1,growx");
        
        this.lblStatus = new JLabel("Status");
        this.lblStatus.setFont(Configuration.FontNormal);
        add(this.lblStatus, "cell 1 2 2 1,alignx right,aligny bottom");

        this.lblLabel3 = new JLabel("Valid:");
        this.lblLabel3.setFont(Configuration.FontNormal);
        add(this.lblLabel3, "cell 1 3, alignx right");
        
        this.txtDateValidFrom = new JTextField();
        this.txtDateValidFrom.setFont(Configuration.FontNormal);
        this.txtDateValidFrom.setEditable(true);
        this.txtDateValidFrom.setColumns(10);
        add(this.txtDateValidFrom, "cell 2 3");

        this.lblLabel4 = new JLabel("Temp. valid until:");
        this.lblLabel4.setFont(Configuration.FontNormal);
        add(this.lblLabel4, "cell 1 4, alignx right");

        this.txtDateValidUntil = new JTextField();
        this.txtDateValidUntil.setFont(Configuration.FontNormal);
        this.txtDateValidUntil.setEditable(true);
        this.txtDateValidUntil.setColumns(10);
        add(this.txtDateValidUntil, "cell 2 4");
        
        this.btnDetails = new JButton("Details");
        btnDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnDetailsClicked();
            }
        });
        this.btnDetails.setFont(Configuration.FontNormal);
        add(this.btnDetails, "cell 0 5 3 1,alignx right");
    }
    
    private void prefillPanel() {
        
    }
    
    private void btnDetailsClicked() {
        
        // open dialog "company"
        new DlgCompany(this.parent, true);
    }
}
