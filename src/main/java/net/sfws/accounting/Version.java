/*
 * Project: accounting
 * Package: net.sfws.accounting
 * Component: Version.java
 * Version Copyright (c) 2014 SF Web Solution 3532 21st Street, San Francisco, CA 94114 All rights reserved.
 * This software is the confidential and proprietary information of SF Web Solution,
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SF Web Solution.
 */
package net.sfws.accounting;

import java.io.Serializable;


/**
 * Class is used for Version-numbering
 *
 * @author Jay Brahms
 */
public class Version implements Serializable {

    // static
    private static final long serialVersionUID = -8399541546374485995L;
    
    
    // class-members
    /** complete version-number */
    public static final String VERSION = "ACCOUNTING_1.00.00.0001";
    
    /** version-number */
    public static final String vNumber = "1.00.00";
    
    /** build-number */
    public static final String bNumber = "0001";
}
