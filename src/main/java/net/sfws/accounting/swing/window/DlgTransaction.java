package net.sfws.accounting.swing.window;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.swing.control.JValueComboBox;
import net.sfws.accounting.swing.window.transaction.PanelNormalView;
import net.sfws.accounting.swing.window.transaction.PanelShortView;

import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgTransaction extends JDialog {
    
    // serial
    private static final long serialVersionUID = -8936933735576062694L;
    
    // controls
    private JPanel panel1;
    private JLabel lblDraftId;
    private JValueComboBox draftId;
    private JPanel panel2;
    private JLabel lblDateBooking;
    private JTextField dateBooking;
    private JLabel lblDateValidate;
    private JTextField dateValidate;
    private JLabel lblCheckNumber;
    private JTextField checkNumber;
    private JLabel lblDescription;
    private JTextField description;
    private JLabel lblTypeTransaction;
    private JValueComboBox typeTransaction;
    private JTabbedPane tabbedPane;
    private PanelShortView panelShortView;
    private PanelNormalView panelNormalView;
    private JButton btnBook;
    private JButton btnCancel;
    
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    
        try {
            DlgTransaction dialog = new DlgTransaction();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Standard-Constructor
     */
    public DlgTransaction() {
        
        // initialisation dialog
        this.initDialog();
        
        // pre-fll dialog
        this.prefillDialog();
    }
    
    /**
     * Secondary Constructor
     * @param frame parent as Frame
     * @param modal modal-marker as boolean
     */
    public DlgTransaction(Frame frame, boolean modal) {
        
        // set super
        super(frame, modal);
        
        // initialisation dialog
        this.initDialog();
        
        // pre-fll dialog
        this.prefillDialog();
        this.pack();
        
        this.setLocationRelativeTo(super.getParent());
        this.setVisible(true);
    }
    
    /**
     * Initialisation of Dialog-Content
     */
    private void initDialog() {
        
        // set size
        this.setBounds(0, 0, 800, 600);
        this.setPreferredSize(new Dimension(800, 600));
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/net/sfws/accounting/res/toolbar-new.gif")).getImage());
    
        // set layout
        this.getContentPane().setLayout(new MigLayout("", "[pref!][grow, right]", "[grow][pref!]"));
        
        // create panel with layout
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "Create new Transfer", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout("", "[pref!]5[grow]", "[pref!][grow]"));
        
        // add label
        this.lblDraftId = new JLabel("Use Draft:");
        this.lblDraftId.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDraftId, "cell 0 0");
        
        // add combo-box
        this.draftId = new JValueComboBox();
        this.draftId.setFont(Configuration.FontNormal);
        this.panel1.add(this.draftId, "cell 1 0");

        // create panel with layout
        this.panel2 = new JPanel();
        this.panel2.setBorder(new TitledBorder(null, "Transaction-Details", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel2.setLayout(new MigLayout("", "[pref!,grow,left][grow,left]", "[pref!,center][pref!,center][pref!,center][pref!,center][pref!,center][grow]"));
        
        // add label
        this.lblDateBooking = new JLabel("Booking-Date:");
        this.lblDateBooking.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblDateBooking, "cell 0 0");
        
        // add text-field
        this.dateBooking = new JTextField();
        this.dateBooking.setFont(Configuration.FontNormal);
        this.dateBooking.setColumns(10);
        this.panel2.add(this.dateBooking, "cell 1 0");
        
        // add label
        this.lblDateValidate = new JLabel("Validation-Date:");
        this.lblDateValidate.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblDateValidate, "cell 0 1");
        
        // add text-field
        this.dateValidate = new JTextField();
        this.dateValidate.setFont(Configuration.FontNormal);
        this.dateValidate.setColumns(10);
        this.panel2.add(this.dateValidate, "cell 1 1");
        
        // add label
        this.lblCheckNumber = new JLabel("Check-Number:");
        this.lblCheckNumber.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblCheckNumber, "cell 0 2");
        
        // add text-field
        this.checkNumber = new JTextField();
        this.checkNumber.setFont(Configuration.FontNormal);
        this.checkNumber.setColumns(20);
        this.panel2.add(this.checkNumber, "cell 1 2");
        
        // add label
        this.lblDescription = new JLabel("Description:");
        this.lblDescription.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblDescription, "cell 0 3");
        
        // add text-field
        this.description = new JTextField();
        this.description.setFont(Configuration.FontNormal);
        this.panel2.add(this.description, "cell 1 3, growx");
        
        // add label
        this.lblTypeTransaction = new JLabel("Type:");
        this.lblTypeTransaction.setFont(Configuration.FontNormal);
        this.panel2.add(this.lblTypeTransaction, "cell 0 4");
        
        // add combo-box
        this.typeTransaction = new JValueComboBox();
        this.typeTransaction.setFont(Configuration.FontNormal);
        this.panel2.add(this.typeTransaction, "cell 1 4");
        
        // add tabbed-pane
        this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        this.tabbedPane.setFont(Configuration.FontNormalBold);
        panel2.add(tabbedPane, "cell 0 5 2 1,grow");
        
        // create panels
        this.panelShortView = new PanelShortView();
        this.panelNormalView = new PanelNormalView();
        
        // add tabs to pane
        this.tabbedPane.addTab("Short View", this.panelShortView);
        this.tabbedPane.addTab("Normal View", this.panelNormalView);

        // add panel to panel
        this.panel1.add(this.panel2, "cell 0 1 2 1,grow");
        
        // add panel to content-pane
        this.getContentPane().add(this.panel1, "cell 0 0 2 1, grow");
        
        // add button
        this.btnBook = new JButton("Book");
        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnBookClicked();
            }
        });
        this.btnBook.setFont(Configuration.FontNormal);
        this.getContentPane().add(this.btnBook, "cell 0 1");
        
        // add button
        this.btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnCancelClicked();
            }
        });
        this.btnCancel.setFont(Configuration.FontNormal);
        this.getContentPane().add(this.btnCancel, "cell 1 1");
    }
    
    /**
     * Pre-fill Dialog after creation
     */
    private void prefillDialog() {
        
    }
    
    private void btnBookClicked() {
        
    }
    
    private void btnCancelClicked() {
        
        // close dialog-window
        this.setVisible(false);
        this.dispose();
    }
}
