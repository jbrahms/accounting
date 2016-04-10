package net.sfws.accounting.swing.window.mainwindow.administration;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;


public class PanelDatabase extends JPanel {
    
    // serial
    private static final long serialVersionUID = 4357139160422201829L;
    
    // controls

    /**
     * Create the panel.
     */
    public PanelDatabase() {
        
        // initialisation
        this.initPanel();
        
        // fill panel
        this.prefillPanel();
    }
    
    private void initPanel() {
        
        // set border
        setBorder(new TitledBorder(null, "Database", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        
        // set layout
        setLayout(new MigLayout("", "[grow]", "[grow]"));
    }
    
    private void prefillPanel() {
        
    }
}
