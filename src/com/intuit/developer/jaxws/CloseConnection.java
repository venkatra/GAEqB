
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "closeConnection", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "closeConnection", namespace = "http://developer.intuit.com/")
public class CloseConnection {

    @XmlElement(name = "ticket", namespace = "http://developer.intuit.com/")
    private String ticket;

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

}
