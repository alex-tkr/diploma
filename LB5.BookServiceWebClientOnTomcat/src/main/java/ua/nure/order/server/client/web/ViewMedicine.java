package ua.nure.order.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.order.dao.MedicineDAO;
import ua.nure.order.dao.soap.Medicine;
import ua.nure.order.dao.soap.service.DAOException_Exception;

import java.io.IOException;

public class ViewMedicine extends HttpServlet {
    private final transient Logger log = LoggerFactory.getLogger(ViewMedicine.class);
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
        HttpSession session = request.getSession();
        String errMsg = null;

        try {
            if (medicineId != null) {
                Medicine medicine = service.findById(Integer.parseInt(medicineId));

                if (medicine != null) {
                    // Set the post object as an attribute in the request
                    request.setAttribute("medicine", medicine);
                    // Forward the request to the view (JSP)
                    request.getRequestDispatcher("/view.jsp").forward(request, response);
                    return;
                }
            } else {
                errMsg = "medicineId have to be specified";
            }
        } catch (DAOException_Exception e) {
            errMsg = "Error: couldn't find medicine with id";
        } catch (Exception e) {
            errMsg = "Error: Something went wrong: " + e.getMessage();
        }
        if (errMsg != null) {
            session.setAttribute("errorMsg", errMsg);
        }
        System.out.println("errorMsg" + errMsg);
        response.sendRedirect("view.jsp");
    }
}
