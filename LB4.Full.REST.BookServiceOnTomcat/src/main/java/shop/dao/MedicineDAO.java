package shop.dao;

import shop.entity.Medicine;
import shop.entity.Medicines;

public interface MedicineDAO {
	public int addMedicine(Medicine item) throws DAOException;
	public Medicine deleteMedicine(int id) throws DAOException;
	public Medicines findByTitleAndPharmacist(String pattern, String pharmacist);
	public Medicines newMedicines();
	public Medicine findById(Integer id) throws DAOException;
	int editMedicine(int id, Medicine medicine) throws DAOException;
}
