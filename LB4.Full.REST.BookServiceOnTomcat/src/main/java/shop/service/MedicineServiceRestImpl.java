package shop.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import shop.additions.ReturnsAtomic;
import shop.dao.DAOException;
import shop.dao.MedicineDAO;
import shop.dao.MedicineDAOInMemoryImpl;
import shop.entity.Medicine;

@Path(Constants.MEDICINES_SERVICE_PATH)
public class MedicineServiceRestImpl {

	private static final long LONG_WORK_WAIT_TIMEOUT = 1000;

	private static final int DEFAULT_THREAD_POOL_SIZE = 10;

	private MedicineDAO store;

	ExecutorService executor = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE);

	private void log(String msg) {
		System.out.println(this.getClass().getSimpleName() + ": " + msg);
	}

	@PostConstruct
	public void init() {
		log("init");
		store = MedicineDAOInMemoryImpl.instance();
	}

	@PreDestroy
	public void destroy() {
		log("destroy");
		store = null;
		executor.shutdown();
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response all() {
		log("all");
		var posts = this.store.newMedicines();
		System.out.println("Running all");
		return Response.ok(posts).build();
	}

	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response find(@PathParam("id") Integer id) throws NotFoundException {
		try {
			log("by id");
			var posts = store.findById(id);
			return Response.ok(posts).build();
		} catch (DAOException e) {
			throw new NotFoundException(e);
		}
	}

	@Path("search")
	public MedicineSearcher find() {
		return new MedicineSearcher();
	}

	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ReturnsAtomic<Integer> add(Medicine post) throws DAOException {
		log("add");
		var id = store.addMedicine(post);
		return new ReturnsAtomic<Integer>(id);
	}

	@PUT
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ReturnsAtomic<Integer> update(Medicine post, @PathParam("id") int id) throws DAOException {
		log("update");
		var resId = store.editMedicine(id, post);
		return new ReturnsAtomic<Integer>(resId);
	}

	@DELETE
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Medicine remove(@PathParam("id") int id) throws DAOException {
		log("remove");
		var res = store.deleteMedicine(id);
		return res;
	}
}
