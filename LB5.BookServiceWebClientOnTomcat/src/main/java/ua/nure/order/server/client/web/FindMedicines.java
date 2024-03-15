package ua.nure.order.server.client.web;

import java.io.IOException;

import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.nure.order.dao.MedicineDAO;
import ua.nure.order.dao.soap.Medicines;

public class FindMedicines extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(FindMedicines.class);

	private MedicineDAO service;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (MedicineDAO) ctx.getAttribute("dao");
		log.trace("Get attribute medicineService: {}", service);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
        String errMsg = null;
        try {
            String pattern = request.getParameter("pattern");
            log.debug("Get find pattern from request : {}", pattern);

			Medicines medicines = service.findByTitle(pattern);
            log.debug("Get medicines from medicinesService : {}", medicines);
            request.setAttribute("medicines", medicines);
            log.trace("Set medicines to the session : {}", medicines);
            request.getRequestDispatcher("list.jsp").forward(request, response);
            log.trace("Redirect to list.jsp");
        } catch (Exception e) {
			System.out.println("Got exceprion" + e);
            errMsg = e.toString();
        }
        if (errMsg != null) {
            session.setAttribute("errorMsg", errMsg);
        }
	}

}
