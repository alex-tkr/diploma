package ua.nure.order.dao.soap.service;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ua.nure.order.dao.Constants;
import ua.nure.order.dao.MedicineDAO;
import ua.nure.order.dao.additions.ReturnsAtomic;
import ua.nure.order.dao.rest.JSONMessageBodyReader;
import ua.nure.order.dao.soap.Medicine;
import ua.nure.order.dao.soap.Medicines;

import java.net.URI;

public class RESTDao implements MedicineDAO {
    private static final URI BASE_URI = URI.create(Constants.SERVICE_BASE_URL);
    Client client = ClientBuilder.newBuilder().register(JSONMessageBodyReader.class).build();

    private static RESTDao instance;

    public static RESTDao getInstance() {
        if (instance == null) {
            instance = new RESTDao();
        }
        return instance;
    }

    @Override
    public int addMedicine(Medicine item) throws Exception {
        WebTarget target = client.target(BASE_URI);
        Invocation.Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<Medicine> payload = jakarta.ws.rs.client.Entity.json(item);
        Response resp = request.post(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body = (ReturnsAtomic<Integer>) resp.readEntity(ReturnsAtomic.class);
            return body.getItem();
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    @Override
    public Medicine deleteMedicine(int id) throws Exception {
        WebTarget target = client.target(BASE_URI).path(String.valueOf(id));
        Invocation.Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response resp = request.delete();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body = resp.readEntity(Medicine.class);
            return body;
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    @Override
    public Medicines findByTitle(String pattern) throws Exception {
        WebTarget target = client.target(BASE_URI).path("search").queryParam("pattern", pattern);
        Invocation.Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response resp = request.get();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body = resp.readEntity(Medicines.class);
            return body;
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    @Override
    public Medicines newMedicines() throws Exception {
        WebTarget target = client.target(BASE_URI);
        Invocation.Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response resp = request.get();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body = resp.readEntity(Medicines.class);
            return body;
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    @Override
    public Medicine findById(Integer id) throws Exception {
        WebTarget target = client.target(BASE_URI).path(id.toString());
        Invocation.Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response resp = request.get();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var post = resp.readEntity(Medicine.class);
            return post;
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    @Override
    public int editMedicine(int id, Medicine medicine) throws Exception {
        System.out.println("Enter id of medicine to edit: ");
        WebTarget target = client.target(BASE_URI).path(String.valueOf(id));
        Invocation.Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<Medicine> payload = jakarta.ws.rs.client.Entity.json(medicine);
        Response resp = request.put(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body = (ReturnsAtomic<Integer>) resp.readEntity(ReturnsAtomic.class);
            return body.getItem();
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }
}
