package net.sfws.accounting.swing.window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.swing.control.JIconList;
import net.sfws.accounting.swing.control.JIconList.ListItem;
import net.sfws.accounting.swing.window.account.*;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JTextField;

import java.awt.CardLayout;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgAccount extends JDialog {
    
    // serial
    private static final long serialVersionUID = 375636156908309280L;
    
    // panel-name
    private final static String PANEL_GENERAL = "GENERAL";
    private final static String PANEL_BANK = "BANK";
    private final static String PANEL_CLOSING = "CLOSING";
    
    // controls
    private JLabel lblDate;
    private JTextField date;
    private JPanel panel1;
    private JButton btnApply;
    private JButton btnSelect;
    private JButton btnNew;
    private JButton btnClose;
    private JIconList option;
    private JPanel panel2;
    private PanelGeneral panelGeneral;
    private PanelBank panelBank;
    private PanelClosing panelClosing;
    private JLabel lblStatus;
    private JLabel lblDateValidFrom;
    private JTextField dateValidFrom;
    private JLabel lblDateValidUntil;
    private JTextField dateValidUntil;
    private JButton btnIgnore;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    
        try {
            DlgAccount dialog = new DlgAccount();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Create the dialog.
     */
    public DlgAccount() {
        this.initDialog();
        this.prefillDialog();
    }
    
    /**
     * Secondary Constructor
     */
    public DlgAccount(Frame parent, boolean modal) {
    
        // initialisation dialog-window
        super(parent, modal);
        this.initDialog();
        this.prefillDialog();
        this.pack();
        
        this.setLocationRelativeTo(super.getParent());
        this.setVisible(true);
    }
    
    private void initDialog() {
        
        // set size
        this.setBounds(0, 0, 800, 600);
        this.setPreferredSize(new Dimension(800, 600));
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/net/sfws/accounting/res/toolbar-account.gif")).getImage());
    
        // set layout
        this.getContentPane().setLayout(new MigLayout("", "[min][min][min][grow][min][pref!]", "[min][grow][min][]"));
        
        // add label to content-pane
        lblDate = new JLabel("Date:");
        this.getContentPane().add(lblDate, "cell 4 0");

        // add text-field to content-pane
        this.date = new JTextField();
        this.date.setColumns(10);
        this.date.setEditable(false);
        this.getContentPane().add(this.date, "cell 5 0");
        
        // create panel with layout
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "Selected Account", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout("", "[100!][grow][pref!]", "[grow][min][min][min][min]"));

        // add panel to content-pane
        this.getContentPane().add(this.panel1, "cell 0 1 6 1,grow");
        
        option = new JIconList();
        option.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                optionSelectionChanged();
            }
        });
        option.setForeground(Color.BLACK);
        option.setBackground(Color.WHITE);
        option.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        panel1.add(option, "cell 0 0, grow");

        panel2 = new JPanel();
        panel2.setLayout(new CardLayout(0, 0));
        
        // create panels
        this.panelGeneral = new PanelGeneral();
        this.panelBank = new PanelBank(this);
        this.panelClosing = new PanelClosing();
        
        // add panels to panel3
        this.panel2.add(this.panelGeneral, PANEL_GENERAL);
        this.panel2.add(this.panelBank, PANEL_BANK);
        this.panel2.add(this.panelClosing, PANEL_CLOSING);

        panel1.add(panel2, "cell 1 0 2 1, grow");
        
        this.lblStatus = new JLabel("Status");
        this.lblStatus.setFont(Configuration.FontNormal);
        panel1.add(this.lblStatus, "cell 1 2 2 1,alignx right,aligny bottom");

        this.lblDateValidFrom = new JLabel("Valid:");
        this.lblDateValidFrom.setFont(Configuration.FontNormal);
        panel1.add(this.lblDateValidFrom, "cell 1 3, alignx right");
        
        this.dateValidFrom = new JTextField();
        this.dateValidFrom.setFont(Configuration.FontNormal);
        this.dateValidFrom.setEditable(true);
        this.dateValidFrom.setColumns(10);
        panel1.add(this.dateValidFrom, "cell 2 3");

        this.lblDateValidUntil = new JLabel("Temp. valid until:");
        this.lblDateValidUntil.setFont(Configuration.FontNormal);
        panel1.add(this.lblDateValidUntil, "cell 1 4, alignx right");

        this.dateValidUntil = new JTextField();
        this.dateValidUntil.setFont(Configuration.FontNormal);
        this.dateValidUntil.setEditable(true);
        this.dateValidUntil.setColumns(10);
        panel1.add(this.dateValidUntil, "cell 2 4");

        this.btnIgnore = new JButton("Ignore");
        btnIgnore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnIgnoreClicked();
            }
        });
        panel1.add(this.btnIgnore, "cell 1 5 2 1, alignx right");

        // add button to content-pane
        this.btnApply = new JButton("Apply");
        btnApply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnApplyClicked();
            }
        });
        this.getContentPane().add(this.btnApply, "cell 0 3");
        
        // add button to content-pane
        this.btnSelect = new JButton("Select");
        btnSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnSelectClicked();
            }
        });
        this.getContentPane().add(this.btnSelect, "cell 1 3");
        
        // add button to content-pane
        this.btnNew = new JButton("New");
        btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnNewClicked();
            }
        });
        this.getContentPane().add(this.btnNew, "cell 2 3");
        
        // add button to content-pane
        this.btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnCloseClicked();
            }
        });
        this.getContentPane().add(this.btnClose, "cell 4 3 2 1, alignx right");
    }
    
    private void prefillDialog() {
        
        ArrayList<JIconList.ListItem> dataList = new ArrayList<JIconList.ListItem>();
        Image image = new ImageIcon(getClass().getResource("/net/sfws/accounting/res/toolbar-account.gif")).getImage();

        // create list
        dataList.add(new ListItem(image, "General"));
        dataList.add(new ListItem(image, "Bank"));
        dataList.add(new ListItem(image, "Closings"));
        
        // set title
        this.setTitle("Account");
        
        this.option.setListData(dataList);
        this.option.setSelectedIndex(0);
        this.option.revalidate();
    }
    
    private void optionSelectionChanged() {
        
        if (this.option.getSelectedIndex() == 0) {
            CardLayout cl = (CardLayout)(this.panel2.getLayout());
            cl.show(this.panel2, PANEL_GENERAL);            
        } else if (this.option.getSelectedIndex() == 1) {
            CardLayout cl = (CardLayout)(this.panel2.getLayout());
            cl.show(this.panel2, PANEL_BANK);            
        } else if (this.option.getSelectedIndex() == 2) {
            CardLayout cl = (CardLayout)(this.panel2.getLayout());
            cl.show(this.panel2, PANEL_CLOSING);            
        }
    }
    
    private void btnIgnoreClicked() {
        
    }
    
    private void btnApplyClicked() {
        
    }
    
    private void btnSelectClicked() {
        
    }
    
    private void btnNewClicked() {
        
    }
    
    private void btnCloseClicked() {
        
        // close dialog-window
        this.setVisible(false);
        this.dispose();
    }
}
