
package com.intuit.developer.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "sendRequestXML", namespace = "http://developer.intuit.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendRequestXML", namespace = "http://developer.intuit.com/", propOrder = {
    "ticket",
    "strHCPResponse",
    "strCompanyFileName",
    "qbXMLCountry",
    "qbXMLMajorVers",
    "qbXMLMinorVers"
})
public class SendRequestXML {

    @XmlElement(name = "ticket", namespace = "http://developer.intuit.com/")
    private String ticket;
    @XmlElement(name = "strHCPResponse", namespace = "http://developer.intuit.com/")
    private String strHCPResponse;
    @XmlElement(name = "strCompanyFileName", namespace = "http://developer.intuit.com/")
    private String strCompanyFileName;
    @XmlElement(name = "qbXMLCountry", namespace = "http://developer.intuit.com/")
    private String qbXMLCountry;
    @XmlElement(name = "qbXMLMajorVers", namespace = "http://developer.intuit.com/")
    private int qbXMLMajorVers;
    @XmlElement(name = "qbXMLMinorVers", namespace = "http://developer.intuit.com/")
    private int qbXMLMinorVers;

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
    public String getStrHCPResponse() {
        return this.strHCPResponse;
    }

    /**
     * 
     * @param strHCPResponse
     *     the value for the strHCPResponse property
     */
    public void setStrHCPResponse(String strHCPResponse) {
        this.strHCPResponse = strHCPResponse;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getStrCompanyFileName() {
        return this.strCompanyFileName;
    }

    /**
     * 
     * @param strCompanyFileName
     *     the value for the strCompanyFileName property
     */
    public void setStrCompanyFileName(String strCompanyFileName) {
        this.strCompanyFileName = strCompanyFileName;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getQbXMLCountry() {
        return this.qbXMLCountry;
    }

    /**
     * 
     * @param qbXMLCountry
     *     the value for the qbXMLCountry property
     */
    public void setQbXMLCountry(String qbXMLCountry) {
        this.qbXMLCountry = qbXMLCountry;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getQbXMLMajorVers() {
        return this.qbXMLMajorVers;
    }

    /**
     * 
     * @param qbXMLMajorVers
     *     the value for the qbXMLMajorVers property
     */
    public void setQbXMLMajorVers(int qbXMLMajorVers) {
        this.qbXMLMajorVers = qbXMLMajorVers;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getQbXMLMinorVers() {
        return this.qbXMLMinorVers;
    }

    /**
     * 
     * @param qbXMLMinorVers
     *     the value for the qbXMLMinorVers property
     */
    public void setQbXMLMinorVers(int qbXMLMinorVers) {
        this.qbXMLMinorVers = qbXMLMinorVers;
    }

}
