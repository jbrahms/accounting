/*
 * Project: accounting
 * Package: net.sfws.accounting.swing.control
 * Component: jImagePanel.java
 * Version Copyright (c) 2014 SF Web Solution 3532 21st Street, San Francisco, CA 94114 All rights reserved.
 * This software is the confidential and proprietary information of SF Web Solution,
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SF Web Solution.
 */
package net.sfws.accounting.swing.control;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;


/**
 * Class is used for
 *
 * @author Jay Brahms
 */
public class JImagePanel extends JPanel {

    // serial
    private static final long serialVersionUID = 4648656137355778193L;
    
    // class members
    private Image image;
    
    /**
     * Standard-constructor
     * @param image given Image as Image
     */
    public JImagePanel(Image image) {
        
        // initialisation super
        super();
        
        // set class-members
        this.image = image;
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics arg0) {

        super.paintComponent(arg0);
        arg0.drawImage(image,0,0,getWidth(),getHeight(),this);
    }
}