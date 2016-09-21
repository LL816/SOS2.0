package cheryl.sos.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cheryl.sos.domain.Order;
import cheryl.sos.domain.PageDisplayInfo;
import cheryl.sos.service.impl.OrderServiceImpl;
import cheryl.sos.service.impl.PageDisplayServiceImpl;

@WebServlet("/Orders")
public class Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Orders() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageDisplayServiceImpl pageDisplayServiceImpl = new PageDisplayServiceImpl();
		
		String username = request.getSession().getAttribute("userName").toString();
		String currentPageNum = request.getParameter("currentPageNum");
		String limitInOnePage = request.getParameter("limitInOnePage");
		
		PageDisplayInfo pageDisplayInfo = pageDisplayServiceImpl.initPageDisplayInfo(username,currentPageNum, limitInOnePage);

		request.setAttribute("pageDisplayInfo", pageDisplayInfo);
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
