
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getLastErrorResponse", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLastErrorResponse", namespace = "http://developer.intuit.com/")
public class GetLastErrorResponse {

    @XmlElement(name = "getLastErrorResult", namespace = "http://developer.intuit.com/")
    private String getLastErrorResult;

    /**
     * 
     * @return
     *     returns String
     */
    public String getGetLastErrorResult() {
        return this.getLastErrorResult;
    }

    /**
     * 
     * @param getLastErrorResult
     *     the value for the getLastErrorResult property
     */
    public void setGetLastErrorResult(String getLastErrorResult) {
        this.getLastErrorResult = getLastErrorResult;
    }

}
