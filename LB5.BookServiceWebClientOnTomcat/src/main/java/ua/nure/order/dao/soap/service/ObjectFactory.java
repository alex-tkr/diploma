
package ua.nure.order.dao.soap.service;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


@XmlRegistry
public class ObjectFactory {

    private final static QName _DAOException_QNAME = new QName("http://it.nure.ua/medicine/service", "DAOException");
    private final static QName _AddMedicine_QNAME = new QName("http://it.nure.ua/medicine/service", "addMedicine");
    private final static QName _AddMedicineResponse_QNAME = new QName("http://it.nure.ua/medicine/service", "addMedicineResponse");
    private final static QName _ClientToken_QNAME = new QName("http://it.nure.ua/medicine/service", "clientToken");
    private final static QName _DeleteMedicine_QNAME = new QName("http://it.nure.ua/medicine/service", "deleteMedicine");
    private final static QName _DeleteMedicineResponse_QNAME = new QName("http://it.nure.ua/medicine/service", "deleteMedicineResponse");
    private final static QName _EditMedicine_QNAME = new QName("http://it.nure.ua/medicine/service", "editMedicine");
    private final static QName _EditMedicineResponse_QNAME = new QName("http://it.nure.ua/medicine/service", "editMedicineResponse");
    private final static QName _FindByTitle_QNAME = new QName("http://it.nure.ua/medicine/service", "findByTitle");
    private final static QName _FindByTitleResponse_QNAME = new QName("http://it.nure.ua/medicine/service", "findByTitleResponse");
    private final static QName _GetMedicine_QNAME = new QName("http://it.nure.ua/medicine/service", "getMedicine");
    private final static QName _GetMedicineResponse_QNAME = new QName("http://it.nure.ua/medicine/service", "getMedicineResponse");
    private final static QName _NewMedicinesList_QNAME = new QName("http://it.nure.ua/medicine/service", "newMedicinesList");
    private final static QName _NewMedicinesListResponse_QNAME = new QName("http://it.nure.ua/medicine/service", "newMedicinesListResponse");
    private final static QName _ServerToken_QNAME = new QName("http://it.nure.ua/medicine/service", "serverToken");

    public ObjectFactory() {
    }

    public DAOException createDAOException() {
        return new DAOException();
    }

    public AddMedicine createAddMedicine() {
        return new AddMedicine();
    }

    public AddMedicineResponse createAddMedicineResponse() {
        return new AddMedicineResponse();
    }

    public DeleteMedicine createDeleteMedicine() {
        return new DeleteMedicine();
    }

    public DeleteMedicineResponse createDeleteMedicineResponse() {
        return new DeleteMedicineResponse();
    }

    public EditMedicine createEditMedicine() {
        return new EditMedicine();
    }

    public EditMedicineResponse createEditMedicineResponse() {
        return new EditMedicineResponse();
    }

    public FindByTitle createFindByTitle() {
        return new FindByTitle();
    }

    public FindByTitleResponse createFindByTitleResponse() {
        return new FindByTitleResponse();
    }

    public GetMedicine createGetMedicine() {
        return new GetMedicine();
    }

    public GetMedicineResponse createGetMedicineResponse() {
        return new GetMedicineResponse();
    }

    public NewMedicinesList createNewMedicinesList() {
        return new NewMedicinesList();
    }

    public NewMedicinesListResponse createNewMedicinesListResponse() {
        return new NewMedicinesListResponse();
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "DAOException")
    public JAXBElement<DAOException> createDAOException(DAOException value) {
        return new JAXBElement<DAOException>(_DAOException_QNAME, DAOException.class, null, value);
    }
    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "addMedicine")
    public JAXBElement<AddMedicine> createAddMedicine(AddMedicine value) {
        return new JAXBElement<AddMedicine>(_AddMedicine_QNAME, AddMedicine.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "addMedicineResponse")
    public JAXBElement<AddMedicineResponse> createAddMedicineResponse(AddMedicineResponse value) {
        return new JAXBElement<AddMedicineResponse>(_AddMedicineResponse_QNAME, AddMedicineResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "clientToken")
    public JAXBElement<String> createClientToken(String value) {
        return new JAXBElement<String>(_ClientToken_QNAME, String.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "deleteMedicine")
    public JAXBElement<DeleteMedicine> createDeleteMedicine(DeleteMedicine value) {
        return new JAXBElement<DeleteMedicine>(_DeleteMedicine_QNAME, DeleteMedicine.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "deleteMedicineResponse")
    public JAXBElement<DeleteMedicineResponse> createDeleteMedicineResponse(DeleteMedicineResponse value) {
        return new JAXBElement<DeleteMedicineResponse>(_DeleteMedicineResponse_QNAME, DeleteMedicineResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "editMedicine")
    public JAXBElement<EditMedicine> createEditMedicine(EditMedicine value) {
        return new JAXBElement<EditMedicine>(_EditMedicine_QNAME, EditMedicine.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "editMedicineResponse")
    public JAXBElement<EditMedicineResponse> createEditMedicineResponse(EditMedicineResponse value) {
        return new JAXBElement<EditMedicineResponse>(_EditMedicineResponse_QNAME, EditMedicineResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "findByTitle")
    public JAXBElement<FindByTitle> createFindByTitle(FindByTitle value) {
        return new JAXBElement<FindByTitle>(_FindByTitle_QNAME, FindByTitle.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "findByTitleResponse")
    public JAXBElement<FindByTitleResponse> createFindByTitleResponse(FindByTitleResponse value) {
        return new JAXBElement<FindByTitleResponse>(_FindByTitleResponse_QNAME, FindByTitleResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "getMedicine")
    public JAXBElement<GetMedicine> createGetMedicine(GetMedicine value) {
        return new JAXBElement<GetMedicine>(_GetMedicine_QNAME, GetMedicine.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "getMedicineResponse")
    public JAXBElement<GetMedicineResponse> createGetMedicineResponse(GetMedicineResponse value) {
        return new JAXBElement<GetMedicineResponse>(_GetMedicineResponse_QNAME, GetMedicineResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "newMedicinesList")
    public JAXBElement<NewMedicinesList> createNewMedicinesList(NewMedicinesList value) {
        return new JAXBElement<NewMedicinesList>(_NewMedicinesList_QNAME, NewMedicinesList.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "newMedicinesListResponse")
    public JAXBElement<NewMedicinesListResponse> createNewPostsListResponse(NewMedicinesListResponse value) {
        return new JAXBElement<NewMedicinesListResponse>(_NewMedicinesListResponse_QNAME, NewMedicinesListResponse.class, null, value);
    }

    @XmlElementDecl(namespace = "http://it.nure.ua/medicine/service", name = "serverToken")
    public JAXBElement<String> createServerToken(String value) {
        return new JAXBElement<String>(_ServerToken_QNAME, String.class, null, value);
    }

}
