
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "clientVersion", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clientVersion", namespace = "http://developer.intuit.com/")
public class ClientVersion {

    @XmlElement(name = "strVersion", namespace = "http://developer.intuit.com/")
    private String strVersion;

    /**
     * 
     * @return
     *     returns String
     */
    public String getStrVersion() {
        return this.strVersion;
    }

    /**
     * 
     * @param strVersion
     *     the value for the strVersion property
     */
    public void setStrVersion(String strVersion) {
        this.strVersion = strVersion;
    }

}
