
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "serverVersionResponse", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serverVersionResponse", namespace = "http://developer.intuit.com/")
public class ServerVersionResponse {

    @XmlElement(name = "serverVersionResult", namespace = "http://developer.intuit.com/")
    private String serverVersionResult;

    /**
     * 
     * @return
     *     returns String
     */
    public String getServerVersionResult() {
        return this.serverVersionResult;
    }

    /**
     * 
     * @param serverVersionResult
     *     the value for the serverVersionResult property
     */
    public void setServerVersionResult(String serverVersionResult) {
        this.serverVersionResult = serverVersionResult;
    }

}
