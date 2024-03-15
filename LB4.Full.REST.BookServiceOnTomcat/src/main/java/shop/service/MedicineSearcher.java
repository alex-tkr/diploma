package shop.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import shop.dao.MedicineDAO;
import shop.dao.MedicineDAOInMemoryImpl;
import shop.entity.Medicines;

public class MedicineSearcher {

	private MedicineDAO store = MedicineDAOInMemoryImpl.instance();

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Medicines search(@QueryParam("pattern") String pattern, @QueryParam("pharmacist") String pharmacist) {
		System.out.println("search for Title: " + pattern + " Pharmacist: " + pharmacist);
        return store.findByTitleAndPharmacist(pattern, pharmacist);
	}

}
