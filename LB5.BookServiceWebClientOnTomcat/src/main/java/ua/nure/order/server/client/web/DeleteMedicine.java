package ua.nure.order.server.client.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ua.nure.order.dao.MedicineDAO;
import ua.nure.order.dao.soap.Medicine;
import ua.nure.order.dao.soap.service.DAOException_Exception;

public class DeleteMedicine extends HttpServlet {
	private static final String DEBUG_ERROR_MSG = "Set errorMsg to the session";
	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(DeleteMedicine.class);

	private transient MedicineDAO service;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (MedicineDAO) ctx.getAttribute("dao");
		log.trace("Get attribute MedicinesService : {}",service);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String errMsg = null;
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			log.debug("Get id from request : {}",id);
			service.deleteMedicine(id);
		} catch (DAOException_Exception e) {
			// Internal exception in web-service
			errMsg = "Error: Can not delete medicine from database";
			log.debug(DEBUG_ERROR_MSG, e.getMessage());
		} catch (NumberFormatException e) {
			// Can not parse price or count
			errMsg = "Error: incorrect id";
			log.debug(DEBUG_ERROR_MSG, e.getMessage());
		} catch (Exception e) {
			// Any other exceptions
			errMsg = "Error: Can not communicate with medicine service";
			log.debug(DEBUG_ERROR_MSG, e.getMessage());
		}
		if (errMsg != null) {
			session.setAttribute("errorMsg", errMsg);
		}

		// PRG pattern
		response.sendRedirect("list");
	}

}
