
package com.training.resources;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.training.resources package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SeatAvailable_QNAME = new QName("http://ifaces.training.com/", "seatAvailable");
    private final static QName _SeatAvailableResponse_QNAME = new QName("http://ifaces.training.com/", "seatAvailableResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.training.resources
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SeatAvailable }
     * 
     */
    public SeatAvailable createSeatAvailable() {
        return new SeatAvailable();
    }

    /**
     * Create an instance of {@link SeatAvailableResponse }
     * 
     */
    public SeatAvailableResponse createSeatAvailableResponse() {
        return new SeatAvailableResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeatAvailable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ifaces.training.com/", name = "seatAvailable")
    public JAXBElement<SeatAvailable> createSeatAvailable(SeatAvailable value) {
        return new JAXBElement<SeatAvailable>(_SeatAvailable_QNAME, SeatAvailable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeatAvailableResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ifaces.training.com/", name = "seatAvailableResponse")
    public JAXBElement<SeatAvailableResponse> createSeatAvailableResponse(SeatAvailableResponse value) {
        return new JAXBElement<SeatAvailableResponse>(_SeatAvailableResponse_QNAME, SeatAvailableResponse.class, null, value);
    }

}
