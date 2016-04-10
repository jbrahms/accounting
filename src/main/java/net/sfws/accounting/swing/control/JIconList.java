/*
 * Project: accounting
 * Package: net.sfws.accounting.swing.control
 * Component: JIconList.java
 * Version Copyright (c) 2014 SF Web Solution 3532 21st Street, San Francisco, CA 94114 All rights reserved.
 * This software is the confidential and proprietary information of SF Web Solution,
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SF Web Solution.
 */
package net.sfws.accounting.swing.control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import net.miginfocom.swing.MigLayout;

/**
 * Class is used for
 *
 * @author Jay
 *
 */
public class JIconList extends JList<Object> {

    // serial
    private static final long serialVersionUID = -8060342605808432794L;

    private IconListCellRenderer cellRenderer;
    
    public JIconList() {
        
        cellRenderer = new IconListCellRenderer();
        this.setCellRenderer(cellRenderer);
    }
    
    public JIconList(ArrayList<ListItem> list) {
        
        // create super
        super(list.toArray());
        
        cellRenderer = new IconListCellRenderer();
        this.setCellRenderer(cellRenderer);
    }
    
    public void setListData(ArrayList<ListItem> list) {
        
        // set super
        super.setListData(list.toArray());
    }
    
    public static class ListItem {
        
        private Image image;
        private String name;
        
        public ListItem(Image image, String name) {
            
            this.image = image;
            this.name = name;
        }
        
        public Image getImage() {
            return this.image;
        }
        
        public String getName() {
            return this.name;
        }
    }
    
    private class IconListCellRenderer extends JPanel implements ListCellRenderer {

        private static final long serialVersionUID = 1L;
        
        private JLabel label;
        
        public IconListCellRenderer() {
        
            setLayout(new MigLayout("", "[grow]", "[grow]"));
            label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setOpaque(true);
            this.add(label, "cell 0 0, growx");
        }
        
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {
            
            ListItem cellData = new ListItem(null, null);
        
            if (value.getClass() == ListItem.class) {
                cellData = (ListItem) value;
            }
                
            label.setIcon(new ImageIcon(cellData.getImage()));
            label.setText(cellData.getName());
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);
            label.setIconTextGap(0);
            
            // Colour logic, highly configurable.
            if (isSelected) {
                this.setBackground(list.getBackground());
                this.label.setBackground(list.getSelectionBackground());
                this.label.setForeground(list.getSelectionForeground());
            } else {
                this.setBackground(list.getBackground());
                this.label.setBackground(list.getBackground());
                this.label.setForeground(list.getForeground());
            }
            
            super.setEnabled(list.isEnabled());
            super.setFont(list.getFont());
            return this;
        }
    }
}
