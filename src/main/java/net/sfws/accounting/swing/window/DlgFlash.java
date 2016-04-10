package net.sfws.accounting.swing.window;

import java.awt.EventQueue;

import javax.swing.JDialog;

import javax.swing.JLabel;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.Version;
import net.sfws.accounting.swing.control.JImagePanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.util.Calendar;


public class DlgFlash extends JDialog {
    
    // serial
    private static final long serialVersionUID = -1697916132075523530L;
    
    // controls
    private JImagePanel imagePanel;
    private JLabel lblAppTitle;
    private JLabel lblVersion;
    private JLabel lblCopyright;
    private JProgressBar progressBar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
            
                try {
                    DlgFlash dialog = new DlgFlash();
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
    public DlgFlash() {
        
        // initialisation dialog-window
        this.initDialog();
        this.prefillDialog();
    }
    
    private void initDialog() {
        
        // generals
        setResizable(false);
        setUndecorated(true);
        setMinimumSize(new Dimension(734, 341));
        setSize(new Dimension(734, 341));
        setBounds(0, 0, 734, 341);

        // set layout for dialog-content
        getContentPane().setLayout(new MigLayout("inset 0 0 0 0", "[grow]", "[grow]"));
        
        // add image-panel to dialog-content
        imagePanel = new JImagePanel(new ImageIcon(getClass().getResource("/net/sfws/accounting/res/flashbanner.gif")).getImage());
        getContentPane().add(imagePanel, "cell 0 0, grow");

        // set layout for image-panel
        imagePanel.setLayout(new MigLayout("inset 0 0 0 0", "[grow]", "[grow][min!]0[min!][min!]"));
        
        // add label to image-panel
        lblAppTitle = new JLabel("Accouting");
        lblAppTitle.setForeground(Color.BLACK);
        lblAppTitle.setFont(new Font("Tahoma", Font.PLAIN, 40));
        imagePanel.add(lblAppTitle, "cell 0 0, alignx center");
        
        // add label to image-panel
        lblVersion = new JLabel("Version");
        imagePanel.add(lblVersion, "cell 0 1, alignx center");
        
        // add label to image-panel
        lblCopyright = new JLabel("Copyright");
        imagePanel.add(lblCopyright, "cell 0 2, alignx center");
        
        // add progress-bar to image-panel
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        imagePanel.add(progressBar, "cell 0 3, growx");
    }
    
    private void prefillDialog() {

        // fill all controls
        this.lblAppTitle.setText(Configuration.languageResources.getString("app.name"));
        this.lblVersion.setText(Configuration.languageResources.getString("dlgflash.lblVersion")
                + " "
                + Version.vNumber
                + " "
                + Configuration.languageResources.getString("dlgflash.lblBuild")
                + " "
                + Version.bNumber);
        this.lblCopyright.setText(Configuration.languageResources.getString("dlgflash.lblCopyright")
                + " "
                + String.valueOf(Calendar.getInstance().get(Calendar.YEAR))
                + " "
                + Configuration.languageResources.getString("app.company"));
    }
}
