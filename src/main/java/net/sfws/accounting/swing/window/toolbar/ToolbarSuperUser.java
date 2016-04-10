/*
 * Project: accounting
 * Package: net.sfws.accounting.swing.window.toolbar
 * Component: Toolbar1.java
 * Version Copyright (c) 2014 SF Web Solution 3532 21st Street, San Francisco, CA 94114 All rights reserved.
 * This software is the confidential and proprietary information of SF Web Solution,
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SF Web Solution.
 */
package net.sfws.accounting.swing.window.toolbar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import net.sfws.accounting.swing.window.FrmMainWindow;

import javax.swing.JSeparator;


/**
 * Class is used for
 *
 * @author Jay
 *
 */
public class ToolbarSuperUser extends JToolBar implements Serializable {
    
    // serial
    private static final long serialVersionUID = -8654879746103280911L;

    // class-members
    FrmMainWindow parent;

    /**
     * 
     */
    public ToolbarSuperUser() {
    
        this.initToolbar();
    }
    
    /**
     * @param arg0
     */
    public ToolbarSuperUser(int arg0) {
    
        super(arg0);
        this.initToolbar();
    }
    
    /**
     * @param arg0
     */
    public ToolbarSuperUser(String arg0) {
    
        super(arg0);
        this.initToolbar();
    }
    
    /**
     * @param arg0
     */
    public ToolbarSuperUser(String arg0, FrmMainWindow parent) {
    
        super(arg0);
        this.parent = parent;
        this.initToolbar();
    }
    
    /**
     * @param arg0
     * @param arg1
     */
    public ToolbarSuperUser(String arg0, int arg1) {
    
        super(arg0, arg1);
        this.initToolbar();
    }
    
private void initToolbar() {
        
        this.setFloatable(false);
        this.setRollover(true);
        
        JButton btnTbExit = new JButton("Exit");
        btnTbExit.setMinimumSize(new Dimension(55, 55));
        btnTbExit.setMaximumSize(new Dimension(55, 55));
        btnTbExit.setPreferredSize(new Dimension(55, 55));
        btnTbExit.setSize(new Dimension(55, 55));
        btnTbExit.setIconTextGap(0);
        btnTbExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                parent.mnuFileExitActionPerformed();
            }
        });
        btnTbExit.setIcon(new ImageIcon(ToolbarAdministrator.class.getResource("/net/sfws/accounting/res/toolbar-exit.gif")));
        btnTbExit.setHorizontalTextPosition(SwingConstants.CENTER);
        btnTbExit.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.add(btnTbExit);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        add(separator_1);
        
        JButton btnTbUser = new JButton("User");
        btnTbUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                parent.mnuViewUserActionPerformed();
            }
        });
        btnTbUser.setIconTextGap(0);
        btnTbUser.setIcon(new ImageIcon(ToolbarAdministrator.class.getResource("/net/sfws/accounting/res/toolbar-user.gif")));
        btnTbUser.setHorizontalTextPosition(SwingConstants.CENTER);
        btnTbUser.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnTbUser.setMinimumSize(new Dimension(55, 55));
        btnTbUser.setMaximumSize(new Dimension(55, 55));
        btnTbUser.setPreferredSize(new Dimension(55, 55));
        btnTbUser.setSize(new Dimension(55, 55));
        this.add(btnTbUser);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setOrientation(SwingConstants.VERTICAL);
        add(separator_2);
        
        JButton btnTbOptions = new JButton("Options");
        btnTbOptions.setIconTextGap(0);
        btnTbOptions.setIcon(new ImageIcon(ToolbarUser.class.getResource("/net/sfws/accounting/res/toolbar-option.gif")));
        btnTbOptions.setHorizontalTextPosition(SwingConstants.CENTER);
        btnTbOptions.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnTbOptions.setMinimumSize(new Dimension(55, 55));
        btnTbOptions.setMaximumSize(new Dimension(55, 55));
        btnTbOptions.setPreferredSize(new Dimension(55, 55));
        btnTbOptions.setSize(new Dimension(55, 55));
        this.add(btnTbOptions);
        
        JButton btnTbAbout = new JButton("About");
        btnTbAbout.setIconTextGap(0);
        btnTbAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                parent.mnuHelpAboutActionPerformed();
            }
        });
        btnTbAbout.setIcon(new ImageIcon(ToolbarAdministrator.class.getResource("/net/sfws/accounting/res/toolbar-about.gif")));
        btnTbAbout.setHorizontalTextPosition(SwingConstants.CENTER);
        btnTbAbout.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnTbAbout.setMinimumSize(new Dimension(55, 55));
        btnTbAbout.setMaximumSize(new Dimension(55, 55));
        btnTbAbout.setPreferredSize(new Dimension(55, 55));
        btnTbAbout.setSize(new Dimension(55, 55));
        this.add(btnTbAbout);
    }
}
