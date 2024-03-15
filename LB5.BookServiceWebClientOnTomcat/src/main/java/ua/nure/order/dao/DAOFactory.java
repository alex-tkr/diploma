package ua.nure.order.dao;

import ua.nure.order.dao.soap.service.RESTDao;

public class DAOFactory {
    public static MedicineDAO getInstance(String selectedDao) {
        MedicineDAO instance = null;
        if (selectedDao.equals(SelectedDao.SOAP)) {
            instance = SOAPDao.getInstance();
        } else if (selectedDao.equals(SelectedDao.REST)) {
            instance = RESTDao.getInstance();
        }
        return instance;
    }
}
