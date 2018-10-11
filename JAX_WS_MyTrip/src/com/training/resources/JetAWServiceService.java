
package com.training.resources;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "JetAWServiceService", targetNamespace = "http://services.training.com/", wsdlLocation = "http://localhost:8040/jet?wsdl")
public class JetAWServiceService
    extends Service
{

    private final static URL JETAWSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException JETAWSERVICESERVICE_EXCEPTION;
    private final static QName JETAWSERVICESERVICE_QNAME = new QName("http://services.training.com/", "JetAWServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8040/jet?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        JETAWSERVICESERVICE_WSDL_LOCATION = url;
        JETAWSERVICESERVICE_EXCEPTION = e;
    }

    public JetAWServiceService() {
        super(__getWsdlLocation(), JETAWSERVICESERVICE_QNAME);
    }

    public JetAWServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), JETAWSERVICESERVICE_QNAME, features);
    }

    public JetAWServiceService(URL wsdlLocation) {
        super(wsdlLocation, JETAWSERVICESERVICE_QNAME);
    }

    public JetAWServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, JETAWSERVICESERVICE_QNAME, features);
    }

    public JetAWServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public JetAWServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Flight
     */
    @WebEndpoint(name = "JetAWServicePort")
    public Flight getJetAWServicePort() {
        return super.getPort(new QName("http://services.training.com/", "JetAWServicePort"), Flight.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Flight
     */
    @WebEndpoint(name = "JetAWServicePort")
    public Flight getJetAWServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.training.com/", "JetAWServicePort"), Flight.class, features);
    }

    private static URL __getWsdlLocation() {
        if (JETAWSERVICESERVICE_EXCEPTION!= null) {
            throw JETAWSERVICESERVICE_EXCEPTION;
        }
        return JETAWSERVICESERVICE_WSDL_LOCATION;
    }

}
