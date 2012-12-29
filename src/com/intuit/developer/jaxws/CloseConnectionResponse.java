
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "closeConnectionResponse", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "closeConnectionResponse", namespace = "http://developer.intuit.com/")
public class CloseConnectionResponse {

    @XmlElement(name = "closeConnectionResult", namespace = "http://developer.intuit.com/")
    private String closeConnectionResult;

    /**
     * 
     * @return
     *     returns String
     */
    public String getCloseConnectionResult() {
        return this.closeConnectionResult;
    }

    /**
     * 
     * @param closeConnectionResult
     *     the value for the closeConnectionResult property
     */
    public void setCloseConnectionResult(String closeConnectionResult) {
        this.closeConnectionResult = closeConnectionResult;
    }

}
