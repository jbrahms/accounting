package net.sfws.accounting.swing.window;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.Version;
import net.sfws.accounting.swing.control.JImagePanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Frame;
import java.util.Calendar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DlgAbout extends JDialog {
    
    // serial
    private static final long serialVersionUID = -1697916132075523530L;
    
    // controls
    private JImagePanel imagePanel;
    private JLabel lblTitle;
    private JLabel lblVersion;
    private JLabel lblCopyright;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    
        EventQueue.invokeLater(new Runnable() {
            
            public void run() {
            
                try {
                    DlgAbout dialog = new DlgAbout();
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
    public DlgAbout() {
    
        // initialisation dialog-window
        this.initDialog();
        this.prefillDialog();
    }
    
    /**
     * Secondary Constructor
     */
    public DlgAbout(Frame parent, boolean modal) {
    
        // initialisation dialog-window
        super(parent, modal);
        this.initDialog();
        this.prefillDialog();
        this.pack();
        
        this.setLocationRelativeTo(super.getParent());
        this.setVisible(true);
    }
    
    private void initDialog() {
    
        // generals
        setResizable(false);
        setUndecorated(true);
        setMinimumSize(new Dimension(734, 341));
        setSize(new Dimension(734, 341));
        setBounds(0, 0, 734, 341);
        
        // add event-handler for dialog-window
        addMouseListener(new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent arg0) {
            
                closeDialog();
            }
        });
        addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyPressed(KeyEvent arg0) {
            
                closeDialog();
            }
        });
        
        // set layout for dialog-content
        getContentPane().setLayout(
                new MigLayout("inset 0 0 0 0", "[grow]", "[grow]"));
        
        // add image-panel to dialog-content
        imagePanel = new JImagePanel(new ImageIcon(getClass().getResource(
                "/net/sfws/accounting/res/flashbanner.gif")).getImage());
        getContentPane().add(imagePanel, "cell 0 0, grow");
        
        // set layout for image-panel
        imagePanel.setLayout(new MigLayout("inset 0 0 0 0", "[grow]",
                "[grow][min!]0[min!]"));
        
        // add label to image-panel
        lblTitle = new JLabel("Accouting");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 40));
        imagePanel.add(lblTitle, "cell 0 0, alignx center");
        
        // add label to image-panel
        lblVersion = new JLabel("Version");
        imagePanel.add(lblVersion, "cell 0 1, alignx center");
        
        // add label to image-panel
        lblCopyright = new JLabel("Copyright");
        imagePanel.add(lblCopyright, "cell 0 2, alignx center");
    }
    
    private void prefillDialog() {
    
        // fill all controls
        this.lblTitle.setText(Configuration.languageResources
                .getString("app.name"));
        this.lblVersion.setText(Configuration.languageResources
                .getString("dlgflash.lblVersion")
                + " "
                + Version.vNumber
                + " "
                + Configuration.languageResources
                        .getString("dlgflash.lblBuild")
                + " "
                + Version.bNumber);
        this.lblCopyright.setText(Configuration.languageResources
                .getString("dlgflash.lblCopyright")
                + " "
                + String.valueOf(Calendar.getInstance().get(Calendar.YEAR))
                + " "
                + Configuration.languageResources.getString("app.company"));
    }
    
    private void closeDialog() {
    
        // close dialog-window
        this.setVisible(false);
        this.dispose();
    }
}
