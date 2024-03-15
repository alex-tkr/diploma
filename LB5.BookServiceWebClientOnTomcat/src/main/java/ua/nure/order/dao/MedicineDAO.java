package ua.nure.order.dao;

import ua.nure.order.dao.soap.Medicine;
import ua.nure.order.dao.soap.Medicines;

public interface MedicineDAO {
	public int addMedicine(Medicine item) throws Exception;
	public Medicine deleteMedicine(int id) throws Exception;
	public Medicines findByTitle(String pattern) throws Exception;
	public Medicines newMedicines() throws Exception;
	public Medicine findById(Integer id) throws Exception;
	int editMedicine(int id, Medicine medicine) throws Exception;
}
