
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "receiveResponseXML", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "receiveResponseXML", namespace = "http://developer.intuit.com/", propOrder = {
    "ticket",
    "response",
    "hresult",
    "message"
})
public class ReceiveResponseXML {

    @XmlElement(name = "ticket", namespace = "http://developer.intuit.com/")
    private String ticket;
    @XmlElement(name = "response", namespace = "http://developer.intuit.com/")
    private String response;
    @XmlElement(name = "hresult", namespace = "http://developer.intuit.com/")
    private String hresult;
    @XmlElement(name = "message", namespace = "http://developer.intuit.com/")
    private String message;

    /**
     * 
     * @return
     *     returns String
     */
    public String getTicket() {
        return this.ticket;
    }

    /**
     * 
     * @param ticket
     *     the value for the ticket property
     */
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getResponse() {
        return this.response;
    }

    /**
     * 
     * @param response
     *     the value for the response property
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getHresult() {
        return this.hresult;
    }

    /**
     * 
     * @param hresult
     *     the value for the hresult property
     */
    public void setHresult(String hresult) {
        this.hresult = hresult;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 
     * @param message
     *     the value for the message property
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
