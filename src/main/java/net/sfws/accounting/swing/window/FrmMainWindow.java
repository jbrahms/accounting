package net.sfws.accounting.swing.window;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.swing.window.mainwindow.PanelAccounting;
import net.sfws.accounting.swing.window.mainwindow.PanelAdministrator;
import net.sfws.accounting.swing.window.mainwindow.PanelSuperUser;
import net.sfws.accounting.swing.window.toolbar.ToolbarAdministrator;
import net.sfws.accounting.swing.window.toolbar.ToolbarUser;
import net.sfws.accounting.swing.window.toolbar.ToolbarSuperUser;

import java.awt.Toolkit;
import javax.swing.JSeparator;

public class FrmMainWindow extends JFrame {
    
    // serial
    private static final long serialVersionUID = 1543257242382529083L;
    
    // panel-name
    private final static String PANEL_SUPER = "SUPER";
    private final static String PANEL_ADMIN = "ADMIN";
    private final static String PANEL_USER = "USER";
    
    // controls
    private JPanel panel1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
            
                try {
                    FrmMainWindow frame = new FrmMainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public FrmMainWindow() {
        
        // initialisation form
        this.initForm();
        this.prefillForm();
        this.pack();
        
        // Set Icon
        Image image = Toolkit.getDefaultToolkit().getImage(
                getClass().getResource(
                        "/net/sfws/accounting/res/accounting.gif"));
        this.setIconImage(image);
        
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Determine the new location of the window
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        
        // Move the window
        this.setLocation(x, y);
        
        this.setVisible(true);
    }
    
    private void initForm() {

        // set general options
        setMinimumSize(new Dimension(1000, 680));
        setSize(new Dimension(1000, 680));
        setTitle("app.name");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1000, 680);
    
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                mnuFileExitActionPerformed();
            }
        });
        
        // set layout for content-pane
        getContentPane().setLayout(new MigLayout("inset 0 0 0 0", "[grow]", "[min!]0[grow]"));
        
        // set tool-bar
        this.setToolbar();
        
        // set panel
        this.setPanel();
        
        JMenuBar mnMain = new JMenuBar();
        setJMenuBar(mnMain);
        
        JMenu mnFile = new JMenu("File");
        mnFile.setMnemonic('F');
        mnMain.add(mnFile);
        
        JMenuItem mnExit = new JMenuItem("Exit");
        mnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mnuFileExitActionPerformed();
            }
        });
        mnExit.setMnemonic('E');
        mnExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
        mnFile.add(mnExit);
        
        JMenu mnView = new JMenu("View");
        mnView.setMnemonic('V');
        mnMain.add(mnView);
        
        JMenuItem mnAdministration = new JMenuItem("Administration");
        mnAdministration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mnuViewAdministrationActionPerformed();
            }
        });
        mnView.add(mnAdministration);
        
        JMenuItem mnAccounting = new JMenuItem("Accounting");
        mnAccounting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mnuViewAccountingActionPerformed();
            }
        });
        mnView.add(mnAccounting);
        
        JMenuItem mnAccount = new JMenuItem("Account");
        mnAccount.setMnemonic('A');
        mnAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mnuViewAccountActionPerformed();
            }
        });
        
        JSeparator separator = new JSeparator();
        mnView.add(separator);
        mnView.add(mnAccount);
        
        JMenuItem mnBank = new JMenuItem("Bank");
        mnBank.setMnemonic('B');
        mnBank.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mnuViewBankActionPerformed();
            }
        });
        mnView.add(mnBank);

        JMenuItem mnUser = new JMenuItem("User");
        mnUser.setMnemonic('U');
        mnUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mnuViewUserActionPerformed();
            }
        });
        mnView.add(mnUser);
        
        JMenu mnTransaction = new JMenu("Transaction");
        mnTransaction.setMnemonic('T');
        mnMain.add(mnTransaction);
        
        JMenuItem mnNewTransaction = new JMenuItem("New Transaction");
        mnNewTransaction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mnuTransactionNewActionPerformed();
            }
        });
        mnNewTransaction.setMnemonic('N');
        mnTransaction.add(mnNewTransaction);

        JMenu mnHelp = new JMenu("Help");
        mnHelp.setMnemonic('H');
        mnMain.add(mnHelp);
        
        JMenuItem mnAbout = new JMenuItem("About");
        mnAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mnuHelpAboutActionPerformed();
            }
        });
        mnAbout.setMnemonic('A');
        mnHelp.add(mnAbout);
    }
    
    private void setToolbar() {
        
        // initialisations
        ToolbarSuperUser tbSuperUser = new ToolbarSuperUser("Toolbar", this);
        ToolbarAdministrator tbAdministrator = new ToolbarAdministrator("Toolbar", this);
        ToolbarUser tbUser = new ToolbarUser("Toolbar", this);
        int toolbar = -1;
        
        // determine tool-bar status by given user-rights
        toolbar = 1;
        
        // add specific tool-bar by status
        if (toolbar==0) {
            getContentPane().add(tbSuperUser, "cell 0 0");
        } else if (toolbar==1) {
            getContentPane().add(tbAdministrator, "cell 0 0");
        } else if (toolbar==2) {
            getContentPane().add(tbUser, "cell 0 0");
        }
    }
    
    private void setPanel() {

        // initialisations
        PanelSuperUser pnlSuperUser = new PanelSuperUser(this);
        PanelAdministrator pnlAdministrator = new PanelAdministrator(this);
        PanelAccounting pnlAccounting = new PanelAccounting();
        int panel = -1;
        
        // determine panel status by given user-rights
        panel = 1;
        
        this.panel1 = new JPanel();
        this.panel1.setLayout(new CardLayout());
        
        // add needed panels into card-layout
        if (panel==0) {
            this.panel1.add(pnlSuperUser, PANEL_SUPER); 
        } else if (panel==1) {
            this.panel1.add(pnlAdministrator, PANEL_ADMIN); 
            this.panel1.add(pnlAccounting, PANEL_USER); 
        } else if (panel==2) {
            this.panel1.add(pnlAccounting, PANEL_USER); 
        }
        
        // add panel to content-pane
        this.getContentPane().add(this.panel1, "cell 0 1, grow");
    }
    
    private void prefillForm() {
        
        // set window-title
        this.setTitle(Configuration.languageResources.getString("app.name"));
    }
    
    public void mnuFileExitActionPerformed() {

        // show option message-box
        int answer = JOptionPane.showConfirmDialog(this,
                "",
                "",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (answer == JOptionPane.YES_OPTION) {
            // exit application
            System.exit(0);
        } else {
            this.setVisible(true);
        }
    }
    
    public void mnuViewAdministrationActionPerformed() {
        
        // change card-panel
        CardLayout cl = (CardLayout)(this.panel1.getLayout());
        cl.show(this.panel1, PANEL_ADMIN);            
    }
    
    public void mnuViewAccountingActionPerformed() {
        
        // change card-panel
        CardLayout cl = (CardLayout)(this.panel1.getLayout());
        cl.show(this.panel1, PANEL_USER);            
    }
    
    public void mnuViewAccountActionPerformed() {

        // open Dialog "DlgAccount"
        new DlgAccount(this, true);
    }
    
    public void mnuViewBankActionPerformed() {

        // open Dialog "DlgBank"
        new DlgBank(this, true);
    }
    
    public void mnuViewUserActionPerformed() {

        // open Dialog "DlgUSer"
        new DlgUser(this, true);
    }
    
    public void mnuTransactionNewActionPerformed() {

        // open Dialog "DlgTransaction"
        new DlgTransaction(this, true);
    }
    
    public void mnuHelpAboutActionPerformed() {

        // open Dialog "DlgAbout"
        new DlgAbout(this, true);
    }
}
