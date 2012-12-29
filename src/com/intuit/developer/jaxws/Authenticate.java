
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "authenticate", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authenticate", namespace = "http://developer.intuit.com/", propOrder = {
    "strUserName",
    "strPassword"
})
public class Authenticate {

    @XmlElement(name = "strUserName", namespace = "http://developer.intuit.com/")
    private String strUserName;
    @XmlElement(name = "strPassword", namespace = "http://developer.intuit.com/")
    private String strPassword;

    /**
     * 
     * @return
     *     returns String
     */
    public String getStrUserName() {
        return this.strUserName;
    }

    /**
     * 
     * @param strUserName
     *     the value for the strUserName property
     */
    public void setStrUserName(String strUserName) {
        this.strUserName = strUserName;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getStrPassword() {
        return this.strPassword;
    }

    /**
     * 
     * @param strPassword
     *     the value for the strPassword property
     */
    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword;
    }

}
