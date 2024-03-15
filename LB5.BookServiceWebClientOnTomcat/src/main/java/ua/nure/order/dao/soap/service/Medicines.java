
package ua.nure.order.dao.soap.service;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


@WebServiceClient(name = "Medicines", targetNamespace = "http://it.nure.ua/medicine/service", wsdlLocation = "http://localhost:8080/medicines?wsdl")
public class Medicines
    extends Service
{

    private final static URL MEDICINES_WSDL_LOCATION;
    private final static WebServiceException MEDICINES_EXCEPTION;
    private final static QName MEDICINES_QNAME = new QName("http://it.nure.ua/medicine/service", "Medicines");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/medicines?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MEDICINES_WSDL_LOCATION = url;
        MEDICINES_EXCEPTION = e;
    }

    public Medicines() {
        super(__getWsdlLocation(), MEDICINES_QNAME);
    }

    public Medicines(WebServiceFeature... features) {
        super(__getWsdlLocation(), MEDICINES_QNAME, features);
    }

    public Medicines(URL wsdlLocation) {
        super(wsdlLocation, MEDICINES_QNAME);
    }

    public Medicines(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MEDICINES_QNAME, features);
    }

    public Medicines(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Medicines(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    @WebEndpoint(name = "MedicinePort")
    public MedicineService getMedicinePort() {
        return super.getPort(new QName("http://it.nure.ua/medicine/service", "MedicinePort"), MedicineService.class);
    }


    @WebEndpoint(name = "MedicinePort")
    public MedicineService getMedicinePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://it.nure.ua/medicine/service", "MedicinePort"), MedicineService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MEDICINES_EXCEPTION!= null) {
            throw MEDICINES_EXCEPTION;
        }
        return MEDICINES_WSDL_LOCATION;
    }

}
