/*
 * Project: accounting
 * Package: net.sfws.accounting.swing.control
 * Component: JValueComboBox.java
 * Version Copyright (c) 2014 SF Web Solution 3532 21st Street, San Francisco, CA 94114 All rights reserved.
 * This software is the confidential and proprietary information of SF Web Solution,
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SF Web Solution.
 */
package net.sfws.accounting.swing.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Class is used for
 *
 * @author Jay
 *
 */
public class JValueComboBox extends JComboBox<Object> {

    // serial
    private static final long serialVersionUID = -3473925201628974090L;
    
    private ArrayList<ValueItem> valueList;
    
    public JValueComboBox() {

        // create super
        super();
    }
    
    public JValueComboBox(ArrayList<ValueItem> list) {
        
        // create super
        super();
        
        // set class-members
        this.valueList = list;
        
        // sort viewable text alphabetically
        Collections.sort(this.valueList, new ValueListSorter());
        
        // create a String-List of viewable Values
        String[] valueArray = new String[this.valueList.size()]; 
        for (int i=0; i<this.valueList.size(); i++) {
            valueArray[i] = new String(this.valueList.get(i).getText());
        }

        // set super
        super.setModel(new DefaultComboBoxModel<Object>(valueArray));
   }
    
    public JValueComboBox(HashMap<String, String> list) {
        
        // create super
        super();
        
        // set class-members
        this.valueList = new ArrayList<ValueItem>();
        
        // fill class-members from given HashMap
        ArrayList<String> keys = new ArrayList<String>(list.keySet());
        for (int i=0; i<keys.size(); i++) {
            this.valueList.add(new ValueItem(keys.get(i), list.get(keys.get(i))));
        }
        
        // sort viewable text alphabetically
        Collections.sort(this.valueList, new ValueListSorter());
        
        // create a String-List of viewable Values
        String[] valueArray = new String[this.valueList.size()]; 
        for (int i=0; i<this.valueList.size(); i++) {
            valueArray[i] = new String(this.valueList.get(i).getText());
        }

        // set super
        super.setModel(new DefaultComboBoxModel<Object>(valueArray));
    }
    
    public void setModel(ArrayList<ValueItem> list) {

        this.valueList = list;

        // sort viewable text alphabetically
        Collections.sort(this.valueList, new ValueListSorter());
        
        String[] valueArray = new String[list.size()]; 
        for (int i=0; i<list.size(); i++) {
            valueArray[i] = new String(list.get(i).getText());
        }

        // set super
        super.setModel(new DefaultComboBoxModel<Object>(valueArray));
    }
    
    public void setModel(HashMap<String, String> list) {

        // set class-members
        this.valueList = new ArrayList<ValueItem>();
        
        // fill class-members from given HashMap
        ArrayList<String> keys = new ArrayList<String>(list.keySet());
        for (int i=0; i<keys.size(); i++) {
            this.valueList.add(new ValueItem(keys.get(i), list.get(keys.get(i))));
        }
        
        // sort viewable text alphabetically
        Collections.sort(this.valueList, new ValueListSorter());
        
        // create a String-List of viewable Values
        String[] valueArray = new String[this.valueList.size()]; 
        for (int i=0; i<this.valueList.size(); i++) {
            valueArray[i] = new String(this.valueList.get(i).getText());
        }

        // set super
        super.setModel(new DefaultComboBoxModel<Object>(valueArray));
    }
    
    public String getValue() {
        
        // initialisations
        String retValue = new String("");
        
        if (this.getSelectedIndex() < -1) {
            retValue = this.valueList.get(this.getSelectedIndex()).getValue(); 
        }
        
        return (retValue);
    }
    
    public void setValue(String value) {
        
        int selectIndex = 0;
        
        for (int i=0; i<this.valueList.size(); i++) {
            if (this.valueList.get(i).getValue().equals(value) == true) {
                selectIndex = i;
            }
        }
        
        this.setSelectedIndex(selectIndex);
    }
    
    public static class ValueItem {
        
        private String value;
        private String text;
        
        public ValueItem(String value, String text) {
            
            this.value = value;
            this.text = text;
        }
        
        public String getValue() {
            return this.value;
        }
        
        public String getText() {
            return this.text;
        }
    }

    public class ValueListSorter implements Comparator<ValueItem>, Serializable {
        
        private static final long serialVersionUID = 6955263315831066782L;

        public int compare(ValueItem o1, ValueItem o2) {

            int retInt = 0;
            
            try {
                String text1 = o1.getText();
                String text2 = o2.getText();
                
                retInt = text1.compareTo(text2);
            } catch (Exception e) {}
            
            return retInt;
        }    
    }
}
