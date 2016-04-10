package net.sfws.accounting.swing.window.mainwindow;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;
import net.sfws.accounting.Configuration;
import net.sfws.accounting.swing.control.JValueComboBox;
import net.sfws.accounting.swing.window.mainwindow.administration.*;

import javax.swing.JTree;

import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Dimension;
import java.util.HashMap;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class PanelAdministrator extends JPanel {
    
    // serial
    private static final long serialVersionUID = 5851562681276716998L;
    
    // panel-name
    private final static String PANEL_COMPANY = "COMPANY";
    private final static String PANEL_GROUP = "GROUP";
    private final static String PANEL_USER = "USER";
    
    // controls
    private JPanel panel1;
    private JLabel lblLabel1;
    private JLabel lblTypeAccountView;
    private JValueComboBox typeAccountView;
    private JButton btnView;
    private JLabel lblDateStart;
    private JTextField dateStart;
    private JLabel lblDateEnd;
    private JTextField dateEnd;
    private JPanel panel2;
    private JScrollPane scrollPane;
    private JTree tree;
    private JPanel panel3;
    private JPanel panel4;
    private PanelCompany panelCompany;
    private PanelGroup panelGroup;
    private PanelUser panelUser;
    private JButton btnExpandAll;
    private JButton btnCollapseAll;
    private JButton btnAddGroup;
    private JButton btnAddUser;
    
    // class-members
    private Frame parent;

    /**
     * Create the panel.
     */
    public PanelAdministrator(Object parent) {
        
        // set class-members
        this.parent = (Frame)parent;
        
        // initialisation
        this.initPanel();
        
        // fill panel
        this.prefillPanel();
    }
    
    private void initPanel() {

        // set border
        this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        
        // set layout
        this.setLayout(new MigLayout("", "[grow]", "[][grow]"));
        
        // create panel1 with layout
        this.panel1 = new JPanel();
        this.panel1.setLayout(new MigLayout("inset 0 3 5 3", "[grow]10[]5[]5[]10[]5[]5[]5[]", "[center][min]"));
        
        // add label to panel1
        this.lblLabel1 = new JLabel("User-Administration");
        this.lblLabel1.setFont(Configuration.FontLargeBold);
        this.panel1.add(this.lblLabel1, "cell 0 0 1 2, aligny top");
        
        // add label to panel1
        this.lblTypeAccountView = new JLabel("View:");
        this.lblTypeAccountView.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblTypeAccountView, "cell 1 0");
        
        // add combo-box to panel1
        this.typeAccountView = new JValueComboBox();
        this.typeAccountView.setFont(Configuration.FontNormal);
        this.panel1.add(this.typeAccountView, "cell 2 0");
        
        // add button to panel1
        this.btnView = new JButton("");
        this.btnView.setMinimumSize(new Dimension(30, 22));
        this.btnView.setMaximumSize(new Dimension(30, 22));
        this.btnView.setPreferredSize(new Dimension(30, 22));
        this.btnView.setMargin(new Insets(2, 5, 2, 5));
        this.btnView.setFont(Configuration.FontNormal);
        this.btnView.setIcon(new ImageIcon(PanelAccounting.class.getResource("/net/sfws/accounting/res/folder.gif")));
        this.btnView.setBorder(UIManager.getBorder("Button.border"));
        this.panel1.add(this.btnView, "cell 3 0,growy");
        
        // add label to panel1
        this.lblDateStart = new JLabel("Date:");
        this.lblDateStart.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDateStart, "cell 4 0");

        // add text-box to panel1
        this.dateStart = new JTextField();
        this.dateStart.setFont(Configuration.FontNormal);
        this.dateStart.setEditable(false);
        this.dateStart.setColumns(10);
        this.panel1.add(this.dateStart, "cell 5 0");
        
        // add label to panel1
        this.lblDateEnd = new JLabel("-");
        this.lblDateEnd.setFont(Configuration.FontNormal);
        this.panel1.add(this.lblDateEnd, "cell 6 0");

        // add text-box to panel1
        this.dateEnd = new JTextField();
        this.dateEnd.setFont(Configuration.FontNormal);
        this.dateEnd.setEditable(false);
        this.dateEnd.setColumns(10);
        this.panel1.add(this.dateEnd, "cell 7 0");
        
        // add panel1 to accounting-panel
        this.add(this.panel1, "cell 0 0, growx");

        // create panel2 with layout
        this.panel2 = new JPanel();
        this.panel2.setBorder(new TitledBorder(null, "User-Administration", TitledBorder.LEADING, TitledBorder.TOP, Configuration.FontNormalBold, null));
        this.panel2.setLayout(new MigLayout("", "[280!][grow]", "[grow][]"));
        
        // add tree to panel2
        this.tree = new JTree();
        this.tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        this.tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent arg0) {
                selectTreeRow();
            }
        });
        tree.setModel(new DefaultTreeModel(
            new DefaultMutableTreeNode("Company") {
                private static final long serialVersionUID = -5552350771249537953L;

                {
                    DefaultMutableTreeNode node_1;
                    node_1 = new DefaultMutableTreeNode("Group #1");
                        node_1.add(new DefaultMutableTreeNode("Brahms, Jay (JBRAHMS) [A]"));
                        node_1.add(new DefaultMutableTreeNode("Oliver, Charles (COLIVER)"));
                        node_1.add(new DefaultMutableTreeNode("Kleinebrahm, Brigitte (BKLEINEBRA) [A]"));
                        node_1.add(new DefaultMutableTreeNode("User #4 (XXXXXXXX)"));
                    add(node_1);
                    node_1 = new DefaultMutableTreeNode("Group #2");
                        node_1.add(new DefaultMutableTreeNode("User #5 (XXXXXXXX)"));
                        node_1.add(new DefaultMutableTreeNode("User #6 (XXXXXXXX)"));
                        node_1.add(new DefaultMutableTreeNode("User #7 (XXXXXXXX)"));
                        node_1.add(new DefaultMutableTreeNode("User #8 (XXXXXXXX)"));
                    add(node_1);
                    node_1 = new DefaultMutableTreeNode("Group #3");
                        node_1.add(new DefaultMutableTreeNode("User #9 (XXXXXXXX)"));
                        node_1.add(new DefaultMutableTreeNode("User #10 (XXXXXXXX)"));
                        node_1.add(new DefaultMutableTreeNode("User #11 (XXXXXXXX)"));
                        node_1.add(new DefaultMutableTreeNode("User #12 (XXXXXXXX)"));
                    add(node_1);
                }
            }
        ));
        this.tree.setFont(Configuration.FontNormal);
        this.scrollPane = new JScrollPane(this.tree,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        this.panel2.add(this.scrollPane, "cell 0 0,grow");
        
        // create panel3 with card-layout
        panel3 = new JPanel();
        panel3.setLayout(new CardLayout(0, 0));
        
        // create panels
        this.panelCompany = new PanelCompany(this.parent);
        this.panelGroup = new PanelGroup(this.parent);
        this.panelUser = new PanelUser(this.parent);
        
        // add panels to panel3
        this.panel3.add(this.panelCompany, PANEL_COMPANY);
        this.panel3.add(this.panelGroup, PANEL_GROUP);
        this.panel3.add(this.panelUser, PANEL_USER);
        
        // add panel3 to panel2
        panel2.add(panel3, "cell 1 0,grow");
        
        // create panel4 with layout
        panel4 = new JPanel();
        panel4.setLayout(new MigLayout("inset 0 0 0 0", "[pref!][pref!][pref!][pref!]", "[min!]"));
        
        // add button to panel4
        this.btnExpandAll = new JButton("+");
        this.btnExpandAll.setPreferredSize(new Dimension(23, 23));
        this.btnExpandAll.setMaximumSize(new Dimension(23, 23));
        this.btnExpandAll.setMinimumSize(new Dimension(23, 23));
        this.btnExpandAll.setMargin(new Insets(2, 2, 2, 2));
        this.btnExpandAll.setFont(Configuration.FontNormal);
        panel4.add(this.btnExpandAll, "cell 0 0");
        
        // add button to panel4
        this.btnCollapseAll = new JButton("-");
        this.btnCollapseAll.setPreferredSize(new Dimension(23, 23));
        this.btnCollapseAll.setMinimumSize(new Dimension(23, 23));
        this.btnCollapseAll.setMaximumSize(new Dimension(23, 23));
        this.btnCollapseAll.setMargin(new Insets(2, 2, 2, 2));
        this.btnCollapseAll.setFont(Configuration.FontNormal);
        panel4.add(this.btnCollapseAll, "cell 1 0");
        
        // add button to panel4
        this.btnAddGroup = new JButton("Add Group");
        this.btnAddGroup.setFont(Configuration.FontNormal);
        panel4.add(this.btnAddGroup, "cell 2 0");
        
        // add button to panel4
        this.btnAddUser = new JButton("Add User");
        this.btnAddUser.setFont(Configuration.FontNormal);
        panel4.add(this.btnAddUser, "cell 3 0");

        // add panel4 to panel2
        panel2.add(panel4, "cell 0 1 2 1,grow");

        // add panel1 to accounting-panel
        this.add(this.panel2, "cell 0 1, grow");
    }
    
    private void prefillPanel() {
        
        // initialisations
        HashMap<String, String> accountView = new HashMap<String, String>();
        
        // create list of entries
        accountView.put("ACT_MONTH", Configuration.languageResources.getString("typeAccountView.ACT_MONTH"));
        accountView.put("ACT_QUARTER", Configuration.languageResources.getString("typeAccountView.ACT_QUARTER"));
        accountView.put("ACT_HALFYEAR", Configuration.languageResources.getString("typeAccountView.ACT_HALFYEAR"));
        accountView.put("ACT_YEAR", Configuration.languageResources.getString("typeAccountView.ACT_YEAR"));
        accountView.put("ANY_MONTH", Configuration.languageResources.getString("typeAccountView.ANY_MONTH"));
        accountView.put("ANY_QUARTER", Configuration.languageResources.getString("typeAccountView.ANY_QUARTER"));
        accountView.put("ANY_HALFYEAR", Configuration.languageResources.getString("typeAccountView.ANY_HALFYEAR"));
        accountView.put("ANY_YEAR", Configuration.languageResources.getString("typeAccountView.ANY_YEAR"));
        accountView.put("ANY_DATE", Configuration.languageResources.getString("typeAccountView.ANY_DATE"));
        
        // fill all controls by language
        this.lblLabel1.setText(Configuration.languageResources.getString("paneladministrator.lblLable1"));
        this.lblTypeAccountView.setText(Configuration.languageResources.getString("paneladministrator.lblTypeAccountView") + ":");
        this.typeAccountView.setModel(accountView);
        this.lblDateStart.setText(Configuration.languageResources.getString("paneladministrator.lblDateStart") + ":");
        ((TitledBorder)this.panel2.getBorder()).setTitle(Configuration.languageResources.getString("paneladministrator.panel2"));
    }
    
    private void selectTreeRow() {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

        if (node == null) {
            //Nothing is selected.     
            return;
        }

        // change to other panels
        if (node.getLevel() == 0) {
            CardLayout cl = (CardLayout)(this.panel3.getLayout());
            cl.show(this.panel3, PANEL_COMPANY);            
        } else if (node.getLevel() == 1) {
            CardLayout cl = (CardLayout)(this.panel3.getLayout());
            cl.show(this.panel3, PANEL_GROUP);            
        } else if (node.getLevel() == 2) {
            CardLayout cl = (CardLayout)(this.panel3.getLayout());
            cl.show(this.panel3, PANEL_USER);            
        }
    }
}
