package com.bharath.ws.trainings;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2017-12-15T18:31:28.424-05:00
 * Generated source version: 3.0.2
 * 
 */
@WebServiceClient(name = "CustomerOrdersService", 
                  wsdlLocation = "file:/F:/Programming%20Projects/java-web-services-class/top-down-ws/wsdlfirstws/src/main/webapp/WEB-INF/wsdl/CustomerOrders.wsdl",
                  targetNamespace = "http://trainings.ws.bharath.com/") 
public class CustomerOrdersService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://trainings.ws.bharath.com/", "CustomerOrdersService");
    public final static QName CustomerOrdersPort = new QName("http://trainings.ws.bharath.com/", "CustomerOrdersPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/F:/Programming%20Projects/java-web-services-class/top-down-ws/wsdlfirstws/src/main/webapp/WEB-INF/wsdl/CustomerOrders.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CustomerOrdersService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/F:/Programming%20Projects/java-web-services-class/top-down-ws/wsdlfirstws/src/main/webapp/WEB-INF/wsdl/CustomerOrders.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerOrdersService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerOrdersService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerOrdersService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CustomerOrdersService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CustomerOrdersService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CustomerOrdersService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns CustomerOrdersPortType
     */
    @WebEndpoint(name = "CustomerOrdersPort")
    public CustomerOrdersPortType getCustomerOrdersPort() {
        return super.getPort(CustomerOrdersPort, CustomerOrdersPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerOrdersPortType
     */
    @WebEndpoint(name = "CustomerOrdersPort")
    public CustomerOrdersPortType getCustomerOrdersPort(WebServiceFeature... features) {
        return super.getPort(CustomerOrdersPort, CustomerOrdersPortType.class, features);
    }

}
