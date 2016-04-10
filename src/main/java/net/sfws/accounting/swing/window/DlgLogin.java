package net.sfws.accounting.swing.window;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JDialog;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class DlgLogin extends JDialog {
    
    // serial
    private static final long serialVersionUID = -8753303506413096491L;

    // controls
    private JPanel panel1;
    private JLabel lblUserId;
    private JTextField userId;
    private JLabel lblPassword;
    private JPasswordField password;
    private JButton btnOK;
    private JButton btnCancel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
            
                try {
                    DlgLogin dialog = new DlgLogin();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the dialog.
     */
    public DlgLogin() {

        // initialisation
        this.initDialog();
        this.prefillDialog();
    }
    
    private void initDialog() {
        
        this.setModal(true);
        this.setResizable(false);
        this.setSize(new Dimension(300, 116));
        this.setMinimumSize(new Dimension(300, 116));
        this.setBounds(0, 0, 300, 116);
        
        getContentPane().setLayout(new MigLayout("inset 0 0 0 0", "[grow]", "[grow]"));
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                btnCancelPressed();
            }
        });

        panel1 = new JPanel();
        getContentPane().add(panel1, "cell 0 0, grow");

        panel1.setLayout(new MigLayout("", "[grow][min!][min!]", "[min!][min!][grow]"));
        
        lblUserId = new JLabel("User:");
        panel1.add(lblUserId, "cell 0 0");
        
        userId = new JTextField();
        lblUserId.setLabelFor(userId);
        panel1.add(userId, "cell 1 0 2 1, growx");
        
        lblPassword = new JLabel("Password:");
        panel1.add(lblPassword, "cell 0 1");
        
        password = new JPasswordField();
        password.setEchoChar('*');
        lblPassword.setLabelFor(password);
        panel1.add(password, "cell 1 1 2 1, growx");
        
        btnOK = new JButton("Login");
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnLoginPressed();
            }
        });
        panel1.add(btnOK, "cell 1 2, alignx right");

        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnCancelPressed();
            }
        });
        panel1.add(btnCancel, "cell 2 2");
    }
    
    private void prefillDialog() {

        // set dialog-title
        this.setTitle(Configuration.languageResources.getString("dlglogin.title"));
        
        // set class-members
        this.lblUserId.setText(Configuration.languageResources.getString("dlglogin.lblUserId")+":");
        this.lblPassword.setText(Configuration.languageResources.getString("dlglogin.lblPassword")+":");
        this.btnOK.setText(Configuration.languageResources.getString("dlglogin.btnLogin"));
        this.btnCancel.setText(Configuration.languageResources.getString("dlglogin.btnCancel"));
    }
    
    private void btnLoginPressed() {
        
    }
    
    private void btnCancelPressed() {
        
    }
}
