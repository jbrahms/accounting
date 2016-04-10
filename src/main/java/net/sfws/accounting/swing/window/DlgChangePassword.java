package net.sfws.accounting.swing.window;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JDialog;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgChangePassword extends JDialog {
    
    // serial
    private static final long serialVersionUID = 2375687084052547603L;
    
    // controls
    private JPanel panel1;
    private JLabel lblPasswordOld;
    private JPasswordField passwordOld;
    private JLabel lblPasswordNew;
    private JPasswordField passwordNew;
    private JLabel lblPasswordRepeat;
    private JPasswordField passwordRepeat;
    private JButton btnChange;
    private JButton btnCancel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
            
                try {
                    DlgChangePassword dialog = new DlgChangePassword();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Standard-Constructor
     */
    public DlgChangePassword() {
        
        // initialisation
        this.initDialog();
        this.prefillDialog();
    }
    
    /**
     * Function is used to initialise Dialog-window
     */
    private void initDialog() {
        
        // set general dialog-settings
        this.setSize(new Dimension(300, 140));
        this.setMinimumSize(new Dimension(300, 140));
        this.setBounds(0, 0, 300, 140);
        this.setModal(true);
        this.setResizable(false);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                btnCancelPressed();
            }
        });
    
        // set layout for content-pane
        this.getContentPane().setLayout(new MigLayout("inset 0 0 0 0", "[grow]", "[grow]"));
        
        // add panel to content-pane
        this.panel1 = new JPanel();
        this.getContentPane().add(this.panel1, "cell 0 0, grow");

        // set layout for panel
        panel1.setLayout(new MigLayout("", "[grow][min!][min!]", "[min!][min!][min!][grow]"));
        
        // add label to panel
        this.lblPasswordOld = new JLabel("Old Password:");
        this.panel1.add(this.lblPasswordOld, "cell 0 0");
        
        // add password-control to panel
        this.passwordOld = new JPasswordField();
        this.passwordOld.setEchoChar('*');
        lblPasswordOld.setLabelFor(passwordOld);
        this.panel1.add(this.passwordOld, "cell 1 0 2 1, growx");
        
        // add label to panel
        this.lblPasswordNew = new JLabel("New Password:");
        this.panel1.add(this.lblPasswordNew, "cell 0 1");
        
        // add password-control to panel
        this.passwordNew = new JPasswordField();
        this.passwordNew.setEchoChar('*');
        lblPasswordNew.setLabelFor(passwordNew);
        this.panel1.add(this.passwordNew, "cell 1 1 2 1, growx");
        
        // add label to panel
        this.lblPasswordRepeat = new JLabel("Repeat Password:");
        this.panel1.add(this.lblPasswordRepeat, "cell 0 2");
        
        // add password-control to panel
        this.passwordRepeat = new JPasswordField();
        this.passwordRepeat.setEchoChar('*');
        lblPasswordRepeat.setLabelFor(passwordRepeat);
        this.panel1.add(this.passwordRepeat, "cell 1 2 2 1, growx");
        
        // add button to panel
        this.btnChange = new JButton("Change");
        this.btnChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnChangePressed();
            }
        });
        this.panel1.add(this.btnChange, "cell 1 3, alignx right");
        
        // add button to panel
        this.btnCancel = new JButton("Cancel");
        this.btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnCancelPressed();
            }
        });
        this.panel1.add(this.btnCancel, "cell 2 3");
    }
    
    /**
     * Function is used to fill Dialog-window
     */
    private void prefillDialog() {
        
        // set title
        this.setTitle(Configuration.languageResources.getString("dlgchangepassword.title"));
        
        // fill all controls
        this.lblPasswordOld.setText(Configuration.languageResources.getString("dlgchangepassword.lblPasswordOld")+":");
        this.lblPasswordNew.setText(Configuration.languageResources.getString("dlgchangepassword.lblPasswordNew")+":");
        this.lblPasswordRepeat.setText(Configuration.languageResources.getString("dlgchangepassword.lblPasswordRepeat")+":");
        this.btnChange.setText(Configuration.languageResources.getString("dlgchangepassword.btnChange"));
        this.btnCancel.setText(Configuration.languageResources.getString("dlgchangepassword.btnCancel"));
    }
    
    /**
     * Function is used to describe 'Change' Button-Pressed
     */
    private void btnChangePressed() {
        
    }
    
    /**
     * Function is used to describe 'Cancel' Button-Pressed
     */
    private void btnCancelPressed() {
        
    }
}
