
package ua.nure.order.dao.soap.service;

import jakarta.xml.ws.WebFault;


@WebFault(name = "DAOException", targetNamespace = "http://it.nure.ua/medicine/service")
public class DAOException_Exception
    extends Exception
{

    private DAOException faultInfo;

    public DAOException_Exception(String message, DAOException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public DAOException_Exception(String message, DAOException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    public DAOException getFaultInfo() {
        return faultInfo;
    }

}
