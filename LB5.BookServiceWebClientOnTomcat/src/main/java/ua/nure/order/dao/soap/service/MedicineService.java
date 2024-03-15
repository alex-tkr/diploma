
package ua.nure.order.dao.soap.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;
import jakarta.xml.ws.Holder;

@WebService(name = "MedicineService", targetNamespace = "http://it.nure.ua/medicine/service")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ua.nure.order.dao.soap.ObjectFactory.class,
        ua.nure.order.dao.soap.service.ObjectFactory.class
})
public interface MedicineService {

    @WebMethod
    @WebResult(name = "addMedicineResponse", targetNamespace = "http://it.nure.ua/medicine/service", partName = "result")
    @Action(input = "http://it.nure.ua/medicine/service/MedicineService/addMedicineRequest", output = "http://it.nure.ua/medicine/service/MedicineService/addMedicineResponse", fault = {
        @FaultAction(className = DAOException_Exception.class, value = "http://it.nure.ua/medicine/service/MedicineService/addMedicine/Fault/DAOException")
    })
    public AddMedicineResponse addMedicine(
        @WebParam(name = "addMedicine", targetNamespace = "http://it.nure.ua/medicine/service", partName = "parameters")
        AddMedicine parameters,
        @WebParam(name = "clientToken", targetNamespace = "http://it.nure.ua/medicine/service", header = true, partName = "clientToken")
        String clientToken,
        @WebParam(name = "serverToken", targetNamespace = "http://it.nure.ua/medicine/service", header = true, mode = WebParam.Mode.OUT, partName = "serverToken")
        Holder<String> serverToken)
        throws DAOException_Exception
    ;

    @WebMethod
    @WebResult(name = "findByTitleResponse", targetNamespace = "http://it.nure.ua/medicine/service", partName = "result")
    @Action(input = "http://it.nure.ua/medicine/service/MedicineService/findByTitleRequest", output = "http://it.nure.ua/medicine/service/MedicineService/findByTitleResponse")
    public FindByTitleResponse findByTitle(
        @WebParam(name = "findByTitle", targetNamespace = "http://it.nure.ua/medicine/service", partName = "parameters")
        FindByTitle parameters,
        @WebParam(name = "clientToken", targetNamespace = "http://it.nure.ua/medicine/service", header = true, partName = "clientToken")
        String clientToken,
        @WebParam(name = "serverToken", targetNamespace = "http://it.nure.ua/medicine/service", header = true, mode = WebParam.Mode.OUT, partName = "serverToken")
        Holder<String> serverToken);

    @WebMethod
    @WebResult(name = "getMedicineResponse", targetNamespace = "http://it.nure.ua/medicine/service", partName = "result")
    @Action(input = "http://it.nure.ua/medicine/service/MedicineService/getMedicineRequest", output = "http://it.nure.ua/medicine/service/MedicineService/getMedicineResponse", fault = {
        @FaultAction(className = DAOException_Exception.class, value = "http://it.nure.ua/medicine/service/MedicineService/getMedicine/Fault/DAOException")
    })
    public GetMedicineResponse getMedicine(
        @WebParam(name = "getMedicine", targetNamespace = "http://it.nure.ua/medicine/service", partName = "parameters")
        GetMedicine parameters,
        @WebParam(name = "clientToken", targetNamespace = "http://it.nure.ua/medicine/service", header = true, partName = "clientToken")
        String clientToken,
        @WebParam(name = "serverToken", targetNamespace = "http://it.nure.ua/medicine/service", header = true, mode = WebParam.Mode.OUT, partName = "serverToken")
        Holder<String> serverToken)
        throws DAOException_Exception
    ;

    @WebMethod
    @WebResult(name = "editMedicineResponse", targetNamespace = "http://it.nure.ua/medicine/service", partName = "result")
    @Action(input = "http://it.nure.ua/medicine/service/MedicineService/editMedicineRequest", output = "http://it.nure.ua/medicine/service/MedicineService/editMedicineResponse", fault = {
        @FaultAction(className = DAOException_Exception.class, value = "http://it.nure.ua/medicine/service/MedicineService/editMedicine/Fault/DAOException")
    })
    public EditMedicineResponse editMedicine(
        @WebParam(name = "editMedicine", targetNamespace = "http://it.nure.ua/medicine/service", partName = "parameters")
        EditMedicine parameters,
        @WebParam(name = "clientToken", targetNamespace = "http://it.nure.ua/medicine/service", header = true, partName = "clientToken")
        String clientToken,
        @WebParam(name = "serverToken", targetNamespace = "http://it.nure.ua/medicine/service", header = true, mode = WebParam.Mode.OUT, partName = "serverToken")
        Holder<String> serverToken)
        throws DAOException_Exception
    ;

    @WebMethod
    @WebResult(name = "deleteMedicineResponse", targetNamespace = "http://it.nure.ua/medicine/service", partName = "result")
    @Action(input = "http://it.nure.ua/medicine/service/MedicineService/deleteMedicineRequest", output = "http://it.nure.ua/medicine/service/MedicineService/deleteMedicineResponse", fault = {
        @FaultAction(className = DAOException_Exception.class, value = "http://it.nure.ua/medicine/service/MedicineService/deleteMedicine/Fault/DAOException")
    })
    public DeleteMedicineResponse deleteMedicine(
        @WebParam(name = "deleteMedicine", targetNamespace = "http://it.nure.ua/medicine/service", partName = "parameters")
        DeleteMedicine parameters,
        @WebParam(name = "clientToken", targetNamespace = "http://it.nure.ua/medicine/service", header = true, partName = "clientToken")
        String clientToken,
        @WebParam(name = "serverToken", targetNamespace = "http://it.nure.ua/medicine/service", header = true, mode = WebParam.Mode.OUT, partName = "serverToken")
        Holder<String> serverToken)
        throws DAOException_Exception
    ;

    @WebMethod
    @WebResult(name = "newMedicinesListResponse", targetNamespace = "http://it.nure.ua/medicine/service", partName = "result")
    @Action(input = "http://it.nure.ua/medicine/service/MedicineService/newMedicinesListRequest", output = "http://it.nure.ua/medicine/service/MedicineService/newMedicinesListResponse")
    public NewMedicinesListResponse newMedicinesList(
        @WebParam(name = "newMedicinesList", targetNamespace = "http://it.nure.ua/medicine/service", partName = "parameters")
        NewMedicinesList parameters,
        @WebParam(name = "clientToken", targetNamespace = "http://it.nure.ua/medicine/service", header = true, partName = "clientToken")
        String clientToken,
        @WebParam(name = "serverToken", targetNamespace = "http://it.nure.ua/medicine/service", header = true, mode = WebParam.Mode.OUT, partName = "serverToken")
        Holder<String> serverToken);

}
