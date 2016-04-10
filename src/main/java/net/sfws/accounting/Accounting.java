/*
 * Project: accounting
 * Package: net.sfws.accounting
 * Component: Accounting.java
 * Version Copyright (c) 2014 SF Web Solution 3532 21st Street, San Francisco, CA 94114 All rights reserved.
 * This software is the confidential and proprietary information of SF Web Solution,
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SF Web Solution.
 */
package net.sfws.accounting;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import net.sfws.accounting.swing.window.FrmMainWindow;

/**
 * Class is used for Application-start and -configuration
 *
 * @author Jay
 */
public class Accounting implements Serializable {
    
    // serial
    private static final long serialVersionUID = 596410144005724815L;

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            // set look-and-feel to whatever OS is used
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        
        // set configuration
        try {
            setConfiguration();
        } catch (Exception e1) {
            // initialisations
            ResourceBundle errorResources = null;
            String errorMesssage = new String("");
            String errorTitle = new String("");
            
            try {
                // set resource-bundle to use
                errorResources = ResourceBundle.getBundle("ErrorResources",
                        Locale.getDefault());
            } catch (Exception e2) {}
            
            if (errorResources != null) {
                errorMesssage = errorResources.getString("MSG_0001") + "\n"
                        + errorResources.getString("MSG_0002");
                errorTitle = errorResources.getString("MSG_TITLE_1");
            }
            
            // error-message
            JOptionPane.showMessageDialog(null, errorMesssage, errorTitle,
                    JOptionPane.ERROR_MESSAGE);
            
            // exit application
            System.exit(0);
        }
        
        // Add first Window here
        new FrmMainWindow();
    }
    
    private static void setConfiguration() throws Exception {

        // initialisations
        ResourceBundle languageResources;
        ResourceBundle errorResources;
        
        // retrieve all needed bundles
        languageResources = ResourceBundle.getBundle("languageResources",
                Locale.getDefault());
        errorResources = ResourceBundle.getBundle("errorResources", Locale
                .getDefault());
        
        // initialisation of configuration
        Configuration.initialize(languageResources, errorResources);
    }
}
