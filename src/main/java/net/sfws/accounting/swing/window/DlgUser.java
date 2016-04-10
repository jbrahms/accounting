package net.sfws.accounting.swing.window;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.swing.control.JIconList;
import net.sfws.accounting.swing.control.JIconList.ListItem;
import net.sfws.accounting.swing.window.administration.PanelAddress;
import net.sfws.accounting.swing.window.administration.PanelContact;
import net.sfws.accounting.swing.window.administration.PanelPassword;
import net.sfws.accounting.swing.window.administration.PanelUser;

import javax.swing.border.TitledBorder;


public class DlgUser extends JDialog {
    
    // static
    private static final long serialVersionUID = -6909956926245422074L;

    // panel-name
    private final static String PANEL_GENERAL = "GENERAL";
    private final static String PANEL_ADDRESS = "ADDRESS";
    private final static String PANEL_CONTACT = "CONTACT";
    private final static String PANEL_PASSWORD = "PASSWORD";
    
    // controls
    private JLabel lblDate;
    private JTextField date;
    private JPanel panel1;
    private JIconList option;
    private JPanel panel2;
    private PanelUser panelGeneral;
    private PanelAddress panelAddress;
    private PanelContact panelContact;
    private PanelPassword panelPassword;
    private JPanel panel3;
    private JButton btnSave;
    private JButton btnUndo;
    private JButton btnNew;
    private JButton btnCancel;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    
        try {
            DlgUser dialog = new DlgUser();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Create the dialog.
     */
    public DlgUser() {
        
        //  initialisation dialog
        this.initDialog();
        
        // pre-fill dialog
        this.prefillDialog();
    }

    /**
     * Secondary Constructor
     */
    public DlgUser(Frame frame, boolean modal) {
        
        // initialisation dialog-window
        super(frame, modal);
        this.initDialog();
        this.prefillDialog();
        this.pack();
        
        this.setLocationRelativeTo(super.getParent());
        this.setVisible(true);
    }

    /**
     * Third Constructor
     */
    public DlgUser(Dialog dialog, boolean modal) {
        
        // initialisation dialog-window
        super(dialog, modal);
        this.initDialog();
        this.prefillDialog();
        this.pack();
        
        this.setLocationRelativeTo(super.getParent());
        this.setVisible(true);
    }
    
    private void initDialog() {
        
        this.setBounds(0, 0, 600, 600);
        this.setPreferredSize(new Dimension(600, 600));
        this.setResizable(false);
        this.setIconImage(new ImageIcon(getClass().getResource("/net/sfws/accounting/res/toolbar-user.gif")).getImage());
        
        this.getContentPane().setLayout(new MigLayout("", "[grow]5[pref!]", "[pref!, center][grow, top][pref!, center]"));
        
        this.lblDate = new JLabel("Date:");
        this.lblDate.setFont(Configuration.FontNormal);
        this.getContentPane().add(this.lblDate, "cell 0 0, align right");
        
        this.date = new JTextField();
        this.date.setFont(Configuration.FontNormal);
        this.date.setColumns(10);
        this.date.setEditable(false);
        this.getContentPane().add(this.date, "cell 1 0");
        
        this.panel1 = new JPanel();
        this.panel1.setBorder(new TitledBorder(null, "User", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel1.setLayout(new MigLayout("", "[100!]5[grow]", "[grow]"));
        
        this.option = new JIconList();
        option.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent arg0) {
                optionSelectionChanged();
            }
        });
        this.option.setFont(Configuration.FontNormal);
        this.option.setForeground(Color.BLACK);
        this.option.setBackground(Color.WHITE);
        this.option.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        this.panel1.add(this.option, "cell 0 0, grow");
        
        this.panel2 = new JPanel();
        this.panel2.setLayout(new CardLayout(0, 0));
        
        // create panels
        this.panelGeneral = new PanelUser(1);
        this.panelAddress = new PanelAddress(PanelAddress.PARENT_USER, 2);
        this.panelContact = new PanelContact(PanelContact.PARENT_USER, 3);
        this.panelPassword = new PanelPassword(4);
        
        // add panels to panel2
        this.panel2.add(this.panelGeneral, PANEL_GENERAL);
        this.panel2.add(this.panelAddress, PANEL_ADDRESS);
        this.panel2.add(this.panelContact, PANEL_CONTACT);
        this.panel2.add(this.panelPassword, PANEL_PASSWORD);

        this.panel1.add(this.panel2, "cell 1 0 2 1,grow");
        
        this.getContentPane().add(this.panel1, "cell 0 1 2 1,grow");
        
        this.panel3 = new JPanel();
        this.panel3.setLayout(new MigLayout("inset 0 0 0 0", "[pref!][pref!][pref!][grow, right]", "[pref!, center]"));
        
        this.btnSave = new JButton("Save");
        this.btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnSaveClicked();
            }
        });
        this.btnSave.setFont(Configuration.FontNormal);
        this.panel3.add(this.btnSave, "cell 0 0");
        
        this.btnUndo = new JButton("Undo");
        this.btnUndo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnUndoClicked();
            }
        });
        this.btnUndo.setFont(Configuration.FontNormal);
        this.panel3.add(this.btnUndo, "cell 1 0");
        
        this.btnNew = new JButton("New");
        this.btnNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnNewClicked();
            }
        });
        this.btnNew.setFont(Configuration.FontNormal);
        this.panel3.add(this.btnNew, "cell 2 0");
        
        this.btnCancel = new JButton("Cancel");
        this.btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnCancelClicked();
            }
        });
        this.btnCancel.setFont(Configuration.FontNormal);
        this.panel3.add(this.btnCancel, "cell 3 0");

        this.getContentPane().add(this.panel3, "cell 0 2 2 1,grow");
    }
    
    private void prefillDialog() {

        ArrayList<JIconList.ListItem> dataList = new ArrayList<JIconList.ListItem>();
        Image image = new ImageIcon(getClass().getResource("/net/sfws/accounting/res/toolbar-user.gif")).getImage();

        // create list
        dataList.add(new ListItem(image, "General"));
        dataList.add(new ListItem(image, "Address"));
        dataList.add(new ListItem(image, "Contact"));
        dataList.add(new ListItem(image, "Password"));
        
        // set title
        this.setTitle("User");
        
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
            cl.show(this.panel2, PANEL_ADDRESS);            
        } else if (this.option.getSelectedIndex() == 2) {
            CardLayout cl = (CardLayout)(this.panel2.getLayout());
            cl.show(this.panel2, PANEL_CONTACT);            
        } else if (this.option.getSelectedIndex() == 3) {
            CardLayout cl = (CardLayout)(this.panel2.getLayout());
            cl.show(this.panel2, PANEL_PASSWORD);            
        }
    }
    
    private void btnSaveClicked() {
        
    }
    
    private void btnUndoClicked() {
        
    }
    
    private void btnNewClicked() {
        
    }
    
    private void btnCancelClicked() {
        
        // close dialog-window
        this.setVisible(false);
        this.dispose();
    }
}
