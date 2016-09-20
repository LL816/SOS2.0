package cheryl.sos.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cheryl.sos.domain.Order;
import cheryl.sos.service.impl.OrderServiceImpl;

@WebServlet("/Orders")
public class Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Orders() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		List<Order> orders = orderServiceImpl.listOrder(request.getSession().getAttribute("userName").toString());
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/orders.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		if(!orderServiceImpl.removeOrder(request.getParameter("orderSelect").toString())){
			request.setAttribute("statusMessage", "É¾³ý¶©µ¥Ê§°Ü");
		}
		else{
			request.setAttribute("statusMessage", "É¾³ý¶©µ¥³É¹¦");
		}
		doGet(request,response);
	}

}
