/*
 * Project: accounting
 * Package: net.sfws.accounting
 * Component: Configuration.java
 * Version Copyright (c) 2014 SF Web Solution 3532 21st Street, San Francisco, CA 94114 All rights reserved.
 * This software is the confidential and proprietary information of SF Web Solution,
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SF Web Solution.
 */
package net.sfws.accounting;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Class is used for Configuration
 *
 * @author Jay Brahms
 */
public class Configuration implements Serializable {

    private static final long serialVersionUID = 7917164525683699249L;
    
    // instance
    private static Configuration theInstance = null;
    
    // class-members
    public static ResourceBundle languageResources = null;
    public static ResourceBundle errorResources = null;
    public static Locale DEFAULT_LOCALE = null;
    public static Font FontNormal = new Font("Tahoma", Font.PLAIN, 11);
    public static Font FontNormalBold = new Font("Tahoma", Font.BOLD, 11);
    public static Font FontLargeBold = new Font("Tahoma", Font.BOLD, 24);
    
    private Configuration(ResourceBundle languageResources,
            ResourceBundle errorResources) throws Exception {

        Configuration.languageResources = languageResources;
        Configuration.errorResources = errorResources;
        
        Configuration.DEFAULT_LOCALE = Locale.getDefault();
        
        // preset configuration
        try {
            PropertyResourceBundle appProperties = Configuration.readProperties("accounting.properties");
            // FIND: Add Application-Properties from Resources here
        } catch (Exception e) {}
    }
    
    public static void initialize(ResourceBundle languageResources,
            ResourceBundle errorResources) throws Exception {

        // create an instance of configuration
        Configuration.theInstance = new Configuration(languageResources,
                errorResources);
    }
    
    public static Configuration getInstance() {

        if (theInstance == null) {
            throw new IllegalStateException("Configuration not initialized.");
        }
        
        return theInstance;
    }
    
    private static PropertyResourceBundle readProperties(String filePath)
            throws Exception {

        // initialisations
        PropertyResourceBundle retProperties;
        
        try {
            retProperties = new PropertyResourceBundle(new FileInputStream(
                    filePath));
        } catch (Exception e) {
            // throw exception
            throw new Exception("Unable to read Application Property-File!");
        }
        
        // return
        return (retProperties);
    }
}    
