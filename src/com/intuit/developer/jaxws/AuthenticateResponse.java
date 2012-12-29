
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "authenticateResponse", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authenticateResponse", namespace = "http://developer.intuit.com/")
public class AuthenticateResponse {

    @XmlElement(name = "authenticateResult", namespace = "http://developer.intuit.com/")
    private com.intuit.developer.ArrayOfString authenticateResult;

    /**
     * 
     * @return
     *     returns ArrayOfString
     */
    public com.intuit.developer.ArrayOfString getAuthenticateResult() {
        return this.authenticateResult;
    }

    /**
     * 
     * @param authenticateResult
     *     the value for the authenticateResult property
     */
    public void setAuthenticateResult(com.intuit.developer.ArrayOfString authenticateResult) {
        this.authenticateResult = authenticateResult;
    }

}
