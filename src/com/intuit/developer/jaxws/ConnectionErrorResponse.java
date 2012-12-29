
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "connectionErrorResponse", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connectionErrorResponse", namespace = "http://developer.intuit.com/")
public class ConnectionErrorResponse {

    @XmlElement(name = "connectionErrorResult", namespace = "http://developer.intuit.com/")
    private String connectionErrorResult;

    /**
     * 
     * @return
     *     returns String
     */
    public String getConnectionErrorResult() {
        return this.connectionErrorResult;
    }

    /**
     * 
     * @param connectionErrorResult
     *     the value for the connectionErrorResult property
     */
    public void setConnectionErrorResult(String connectionErrorResult) {
        this.connectionErrorResult = connectionErrorResult;
    }

}
