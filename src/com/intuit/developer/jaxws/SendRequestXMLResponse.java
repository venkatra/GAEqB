
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "sendRequestXMLResponse", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendRequestXMLResponse", namespace = "http://developer.intuit.com/")
public class SendRequestXMLResponse {

    @XmlElement(name = "sendRequestXMLResult", namespace = "http://developer.intuit.com/")
    private String sendRequestXMLResult;

    /**
     * 
     * @return
     *     returns String
     */
    public String getSendRequestXMLResult() {
        return this.sendRequestXMLResult;
    }

    /**
     * 
     * @param sendRequestXMLResult
     *     the value for the sendRequestXMLResult property
     */
    public void setSendRequestXMLResult(String sendRequestXMLResult) {
        this.sendRequestXMLResult = sendRequestXMLResult;
    }

}
