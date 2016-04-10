package net.sfws.accounting.swing.window.account;

import java.util.HashMap;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.swing.control.JValueComboBox;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;


public class PanelClosing extends JPanel {
    
    // serial
    private static final long serialVersionUID = 4703034039232189827L;
    
    // controls
    private JLabel lblLabel1;
    private JLabel lblLabel2;
    private JLabel lblLabel3;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel lblDate;
    private JTextField date;
    private JLabel lblAmount;
    private JTextField amount;
    private JLabel lblCurrency;
    private JPanel panel3;
    private JLabel lblTypeClosing;
    private JValueComboBox typeClosing;
    private JTable closings;

    /**
     * Create the panel.
     */
    public PanelClosing() {
        
        // initialisation panel
        this.initPanel();
        
        // pre-fill panel
        this.prefillPanel();
    }
    
    private void initPanel() {
        
        this.setLayout(new MigLayout("inset 5 5 0 0", "[min]20[grow]", "[min]0[min]20[grow]"));
        
        this.lblLabel1 = new JLabel("");
        this.lblLabel1.setIcon(new ImageIcon(PanelClosing.class.getResource("/net/sfws/accounting/res/icon-account.gif")));
        this.add(this.lblLabel1, "cell 0 0 1 2, alignx left, aligny top");
        
        this.lblLabel2 = new JLabel("Option 3:");
        this.lblLabel2.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel2, "cell 1 0");
        
        this.lblLabel3 = new JLabel("Closings");
        this.lblLabel3.setFont(Configuration.FontNormalBold);
        this.add(this.lblLabel3, "cell 1 1,aligny top");
        
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "Closings", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout("", "[grow]", "[min][grow]"));
        
        this.panel2 = new JPanel();
        this.panel2.setBorder(new TitledBorder(null, "Opening Balance", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel2.setLayout(new MigLayout("", "[pref!]5[pref!]5[pref!]10[grow]", "[pref!][pref!]"));
        
        this.lblDate = new JLabel("Date:");
        this.lblDate.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblDate, "cell 0 0");
        
        this.date = new JTextField();
        this.date.setFont(Configuration.FontNormal);
        this.date.setColumns(10);
        this.date.setEditable(false);
        this.panel2.add(this.date, "cell 1 0");
        
        this.lblAmount = new JLabel("Amount:");
        this.lblAmount.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblAmount, "cell 0 1");
        
        this.amount = new JTextField();
        this.amount.setFont(Configuration.FontNormal);
        this.amount.setEditable(false);
        this.panel2.add(this.amount, "cell 1 1,growx");
        
        this.lblCurrency = new JLabel("[$]");
        this.lblCurrency.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblCurrency, "cell 2 1");

        this.panel1.add(this.panel2, "cell 0 0, growx");
        
        this.panel3 = new JPanel();
        this.panel3.setBorder(new TitledBorder(null, "Closing Balances since Opening", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel3.setLayout(new MigLayout("", "[pref!][pref!][grow]", "[pref!, center][grow]"));
        
        this.lblTypeClosing = new JLabel("Closing-Type:");
        this.lblTypeClosing.setFont(Configuration.FontNormal);
        this.panel3.add(this.lblTypeClosing, "cell 0 0");
        
        this.typeClosing = new JValueComboBox();
        this.typeClosing.setFont(Configuration.FontNormal);
        this.panel3.add(this.typeClosing, "cell 1 0");
        
        this.closings = new JTable();
        this.closings.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        this.closings.setFont(Configuration.FontNormal);
        this.panel3.add(this.closings, "cell 0 1 3 1, grow");

        this.panel1.add(this.panel3, "cell 0 1, grow");

        this.add(this.panel1, "cell 0 2 2 1, grow");
    }
    
    private void prefillPanel() {

        // initialisations
        HashMap<String, String> closingType = new HashMap<String, String>();
        
        // create list of entries
        closingType.put("-", Configuration.languageResources.getString("typeClosing.null"));
        closingType.put("HLF", Configuration.languageResources.getString("typeClosing.HLF"));
        closingType.put("MON", Configuration.languageResources.getString("typeClosing.MON"));
        closingType.put("QTR", Configuration.languageResources.getString("typeClosing.QTR"));
        closingType.put("STR", Configuration.languageResources.getString("typeClosing.STR"));
        closingType.put("YRE", Configuration.languageResources.getString("typeClosing.YRE"));
        
        this.typeClosing.setModel(closingType);
        this.typeClosing.setValue("MON");
    }
}
