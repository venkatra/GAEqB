
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "receiveResponseXMLResponse", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receiveResponseXMLResponse", namespace = "http://developer.intuit.com/")
public class ReceiveResponseXMLResponse {

    @XmlElement(name = "receiveResponseXMLResult", namespace = "http://developer.intuit.com/")
    private int receiveResponseXMLResult;

    /**
     * 
     * @return
     *     returns int
     */
    public int getReceiveResponseXMLResult() {
        return this.receiveResponseXMLResult;
    }

    /**
     * 
     * @param receiveResponseXMLResult
     *     the value for the receiveResponseXMLResult property
     */
    public void setReceiveResponseXMLResult(int receiveResponseXMLResult) {
        this.receiveResponseXMLResult = receiveResponseXMLResult;
    }

}
