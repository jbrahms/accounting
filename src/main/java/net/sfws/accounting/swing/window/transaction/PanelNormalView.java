package net.sfws.accounting.swing.window.transaction;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;


public class PanelNormalView extends JPanel {
    
    // serial
    private static final long serialVersionUID = 6083629460510629025L;
    
    // controls
    private JPanel panel1;
    private JPanel panel2;

    /**
     * Standard Constructor
     */
    public PanelNormalView() {
    
        // initialisation panel
        this.initPanel();
        
        // pre-fill panel
        this.prefillPanel();
    }
    
    private void initPanel() {
        
        // set layout
        this.setLayout(new MigLayout("", "[grow]10[grow]", "[grow]"));
        
        // create panel with layout
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "Accounts to be credited", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout(" ", "[grow]", "[grow][pref!][pref!]"));
        
        // add panel to panel
        this.add(this.panel1, "cell 0 0, grow");
        
        // create panel with layout
        this.panel2 = new JPanel();
        this.panel2.setBorder(new TitledBorder(null, "Accounts to be debited", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel2.setLayout(new MigLayout(" ", "[grow]", "[grow][pref!][pref!]"));
        
        // add panel to panel
        this.add(this.panel2, "cell 1 0, grow");
    }
    
    private void prefillPanel() {
        
    }
}
