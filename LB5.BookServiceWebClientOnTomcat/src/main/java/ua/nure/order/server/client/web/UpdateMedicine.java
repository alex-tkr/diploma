package ua.nure.order.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.order.dao.MedicineDAO;
import ua.nure.order.dao.soap.Pharmacist;
import ua.nure.order.dao.soap.Image;
import ua.nure.order.dao.soap.Images;
import ua.nure.order.dao.soap.Medicine;
import ua.nure.order.dao.soap.service.DAOException_Exception;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class UpdateMedicine extends HttpServlet {
	private static final String DEBUG_ERROR_MSG = "Set errorMsg to the session";
	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(UpdateMedicine.class);

	private transient MedicineDAO service;
	
	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (MedicineDAO) ctx.getAttribute("dao");
		log.trace("Get attribute dao : {}",service);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String medicineId = request.getParameter("id");
		log.debug("Looking for medicine with id = " + medicineId);
//        HttpSession session = request.getSession();
		String errMsg = null;

		try {
			if (medicineId != null) {
				// Assuming you have a service to retrieve the post details based on the ID
				// Replace MedicineService with your service class
				Medicine medicine = service.findById(Integer.parseInt(medicineId));

				if (medicine != null) {
					// Set the post object as an attribute in the request
					request.setAttribute("medicine", medicine);
					// Forward the request to the view (JSP)
					request.getRequestDispatcher("/update.jsp").forward(request, response);
					return;
				}
			} else {
				errMsg = "medicineId have to be specified";
			}
		} catch (DAOException_Exception e) {
			errMsg = "Error: couldn't find medicine with id";
		} catch (Exception e) {
			errMsg = "Error: Something went wrong";
		}
		if (errMsg != null) {
			request.setAttribute("errorMsg", errMsg);
		}
		response.sendRedirect("update.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String medicineId = request.getParameter("id");
		HttpSession session = request.getSession();
		log.debug("Request encoding : {}",request.getCharacterEncoding());
		String errMsg = null;
		int id = Integer.valueOf(medicineId);
		try {
			Medicine medicine = service.findById(Integer.parseInt(medicineId));
			Part filePart = request.getPart("images");
			Images images = new Images();
			if (filePart != null) {
				for (Part part : request.getParts()) {
					String fileName = part.getSubmittedFileName();
					if (fileName != null && !fileName.isEmpty()) {
						try (InputStream fileContent = part.getInputStream()) {
							byte[] bytes = fileContent.readAllBytes();
							String base64Image = Base64.getEncoder().encodeToString(bytes);
							String base64WithPrefix = "data:" + part.getContentType() + ";base64," + base64Image;
							var newImage = new Image();
							newImage.setImageContent(base64WithPrefix);
							images.getImage().add(newImage);
						} catch (IOException e) {
							e.printStackTrace(); // Handle the exception as needed
						}
					}
				}
			}
			medicine.setImages(images);
			medicine.setHeader(request.getParameter("header"));
			medicine.setText(request.getParameter("text"));
			medicine.setType(request.getParameter("type"));
			var pharmacist = new Pharmacist();
			pharmacist.setUsername(request.getParameter("pharmacist"));
			medicine.setCreatedBy(pharmacist);
			log.debug("Get medicines from request : {}",medicine);

			// send request to web-service
			service.editMedicine(id, medicine);
			log.debug("Medicine added with id : {}",id);

//			session.setAttribute("medicine", medicine);
		} catch (DAOException_Exception e) {
			// Internal exception in web-service
			errMsg = "Error: Can not add medicine into database";
			log.debug(DEBUG_ERROR_MSG, e);
		} catch (NumberFormatException e) {
			// Can not parse price or count
			errMsg = "Error: incorrect price or count";
			log.debug(DEBUG_ERROR_MSG, e);
		} catch (Exception e) {
			// Any other exceptions
			errMsg = "Error: Can not communicate with medicine service";
			log.debug(DEBUG_ERROR_MSG, e);
		}
		if (errMsg != null) {
			session.setAttribute("errorMsg", errMsg);
		}
		
		// PRG pattern
		response.sendRedirect("view?id=" + id);
		log.debug("Redirect to view.jsp");
	}

}
