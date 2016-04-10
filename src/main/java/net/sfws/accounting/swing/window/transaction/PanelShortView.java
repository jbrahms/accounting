package net.sfws.accounting.swing.window.transaction;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;


public class PanelShortView extends JPanel {
    
    // serial
    private static final long serialVersionUID = 6083629460510629025L;
    
    // controls
    private JPanel panel1;

    /**
     * Standard Constructor
     */
    public PanelShortView() {
    
        // initialisation panel
        this.initPanel();
        
        // pre-fill panel
        this.prefillPanel();
    }
    
    private void initPanel() {
        
        // set layout
        this.setLayout(new MigLayout(" ", "[grow]", "[grow]"));
        
        // create panel with layout
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "Amount of Transation", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout(" ", "[pref!][grow]", "[grow]"));
        
        // add panel to panel
        this.add(this.panel1, "cell 0 0,grow");
    }
    
    private void prefillPanel() {
        
    }
}
