package shop.dao;

import shop.additions.SearchParams;
import shop.dao.dbtable.DBTable;
import shop.dao.dbtable.DBTableFactory;
import shop.dao.dbtable.Filter;
import shop.entity.*;

import java.sql.SQLException;
import java.util.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class MedicineDAOInMemoryImpl implements MedicineDAO {

	DBTable<Medicine> Medicines = DBTableFactory.instance();
	
	private static MedicineDAOInMemoryImpl instance;

	private MedicineDAOInMemoryImpl() {
		try {
			initMedicines();
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static synchronized MedicineDAOInMemoryImpl instance() {
		if (instance == null) {
			instance = new MedicineDAOInMemoryImpl();
		}
		return instance;
	}
	
	@Override
	public synchronized int addMedicine(Medicine item) {
		System.out.println("item " + item);
		int id = Medicines.insert(item);
		try {
			var date = new GregorianCalendar();
			XMLGregorianCalendar xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
			item.setId(id);
			item.setDate(xmlGregCal);
			Medicines.update(id, item);
		} catch (Exception e) {
			try {
				Medicines.delete(id);
			} catch (SQLException e1) {
				// Do nothing
			}
		}
		return id;
	}

	@Override
	public synchronized Medicine deleteMedicine(int id) throws DAOException {
		try {
			return Medicines.delete(id);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	Filter<Medicine> headerFilter = new Filter<>() {
		@Override
		public boolean accept(Medicine item, Object searchParams) {
			SearchParams params = (SearchParams) searchParams;
			if (item.getHeader() != null && params.getPattern() != null && !item.getHeader().toUpperCase().contains(params.getPattern().toUpperCase())) {
				return false;
			}
			if (item.getCreatedBy() != null && item.getCreatedBy().getUsername() != null && params.getPharmacist() != null && !item.getCreatedBy().getUsername().toUpperCase().contains(params.getPharmacist().toUpperCase())) {
				return false;
			}
			return true;
		}
	};
	
	Filter<Medicine> pharmacistFilter = new Filter<>() {
		@Override
		public boolean accept(Medicine item, Object pattern) {
			String p = (String) pattern;
			Pharmacist author = item.getCreatedBy();
            return author.getUsername().toUpperCase().contains(p.toUpperCase());
        }
	};

	Comparator<Medicine> byDate = new Comparator<Medicine>() {
		@Override
		public int compare(Medicine o1, Medicine o2) {
			var date1 = o1.getDate();
			var date2 = o2.getDate();
			if (date1 == null || date2 == null) return 0;
			return o1.getDate().compare(o2.getDate());
		}
	};
	
	@Override
	public Medicines findByTitleAndPharmacist(String pattern, String pharmacist) {
		var medicines = Medicines.filter(new SearchParams(pattern, pharmacist), headerFilter);
		Medicines result = new Medicines();
		result.getMedicine().addAll(medicines);
		return result;
	}

	@Override
	public Medicines newMedicines() {
		var medicines = new ArrayList<>(Medicines.selectAll());
		medicines.sort(byDate);
		Medicines result = new Medicines();
		result.getMedicine().addAll(medicines);
		return result;
	}

	@Override
	public Medicine findById(Integer id) throws DAOException {
		try {
			return Medicines.get(id);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public int editMedicine(int id, Medicine medicine) throws DAOException {
		try {
			var oldPost = findById(id);
			Medicines.update(id, medicine);
			return medicine.getId();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	private Medicine newMedicine(String header, String text, Images images, Pharmacist author, Type type) throws DatatypeConfigurationException {
		Medicine post = new Medicine();
		post.setHeader(header);
		post.setText(text);
		post.setImages(images);
		post.setCreatedBy(author);
		post.setType(type);
		var date = new GregorianCalendar();
		XMLGregorianCalendar xmlGregCal =  DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
		post.setDate(xmlGregCal);
		return post;
	}

	private void initMedicines() throws DatatypeConfigurationException {
		Medicine[] medicines = new Medicine[] {
				newMedicine("111", "test", new Images(), null, Type.LIQUID)
				};
		for (int i = 0; i < medicines.length; i++) {
			addMedicine(medicines[i]);
		}
	}
}
