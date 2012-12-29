
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "clientVersionResponse", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clientVersionResponse", namespace = "http://developer.intuit.com/")
public class ClientVersionResponse {

    @XmlElement(name = "clientVersionResult", namespace = "http://developer.intuit.com/")
    private String clientVersionResult;

    /**
     * 
     * @return
     *     returns String
     */
    public String getClientVersionResult() {
        return this.clientVersionResult;
    }

    /**
     * 
     * @param clientVersionResult
     *     the value for the clientVersionResult property
     */
    public void setClientVersionResult(String clientVersionResult) {
        this.clientVersionResult = clientVersionResult;
    }

}
