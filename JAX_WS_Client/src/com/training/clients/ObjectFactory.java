
package com.training.clients;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.training.clients package. 
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

    private final static QName _DolorToRupees_QNAME = new QName("http://ifaces.training.com/", "dolorToRupees");
    private final static QName _DolorToRupeesResponse_QNAME = new QName("http://ifaces.training.com/", "dolorToRupeesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.training.clients
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DolorToRupeesResponse }
     * 
     */
    public DolorToRupeesResponse createDolorToRupeesResponse() {
        return new DolorToRupeesResponse();
    }

    /**
     * Create an instance of {@link DolorToRupees }
     * 
     */
    public DolorToRupees createDolorToRupees() {
        return new DolorToRupees();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DolorToRupees }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ifaces.training.com/", name = "dolorToRupees")
    public JAXBElement<DolorToRupees> createDolorToRupees(DolorToRupees value) {
        return new JAXBElement<DolorToRupees>(_DolorToRupees_QNAME, DolorToRupees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DolorToRupeesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ifaces.training.com/", name = "dolorToRupeesResponse")
    public JAXBElement<DolorToRupeesResponse> createDolorToRupeesResponse(DolorToRupeesResponse value) {
        return new JAXBElement<DolorToRupeesResponse>(_DolorToRupeesResponse_QNAME, DolorToRupeesResponse.class, null, value);
    }

}
