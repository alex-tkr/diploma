package ua.nure.order.dao;

import ua.nure.order.dao.soap.Medicine;
import ua.nure.order.dao.soap.Medicines;
import ua.nure.order.dao.soap.service.*;

public class SOAPDao implements MedicineDAO{
    private static final String CLIENT_TOKEN = "clientToken";
    private static final MedicineService service = new ua.nure.order.dao.soap.service.Medicines().getMedicinePort();

    private static SOAPDao instance;

    public static SOAPDao getInstance() {
        if (instance == null) {
            instance = new SOAPDao();
        }
        return instance;
    }
    @Override
    public int addMedicine(Medicine item) throws Exception {
        var params = new AddMedicine();
        params.setMedicine(item);
        var request = service.addMedicine(params, CLIENT_TOKEN, null);
        var res = request.getReturn();
        return res;
    }

    @Override
    public Medicine deleteMedicine(int id) throws Exception {
        var params = new DeleteMedicine();
        params.setId(id);
        var request = service.deleteMedicine(params, CLIENT_TOKEN, null);
        var res = request.getReturn();
        return res;
    }

    @Override
    public Medicines findByTitle(String pattern) {
        var params = new FindByTitle();
        params.setPattern(pattern);
        var raw = service.findByTitle(params, CLIENT_TOKEN, null).getReturn();
        return raw;
    }

    @Override
    public Medicines newMedicines() {
        var raw = service.newMedicinesList(new NewMedicinesList(), CLIENT_TOKEN, null);
        return raw.getReturn();
    }

    @Override
    public Medicine findById(Integer id) throws Exception {
        var params = new GetMedicine();
        params.setId(id);
        var raw = service.getMedicine(params, CLIENT_TOKEN, null).getReturn();
        return raw;
    }

    @Override
    public int editMedicine(int id, Medicine medicine) throws Exception {
        var params = new EditMedicine();
        params.setMedicine(medicine);
        params.setId(id);
        var request = service.editMedicine(params, CLIENT_TOKEN, null);
        var resObject = request.getReturn();
        var res = 0; // Default value or appropriate fallback
        if (resObject instanceof Integer) {
            res = (int) resObject;
        } else {
            // Handle the case where the return value is not an Integer
            // You might want to log a warning or throw an exception
        }
        return res;
    }
}