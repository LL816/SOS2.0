package cheryl.sos.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cheryl.sos.domain.Order;
import cheryl.sos.service.impl.MerchandiseServiceImpl;
import cheryl.sos.service.impl.OrderServiceImpl;

@WebServlet("/Merchandise")
public class Merchandise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Merchandise() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MerchandiseServiceImpl merServiceImpl = new MerchandiseServiceImpl();
		List<cheryl.sos.domain.Merchandise> mers = merServiceImpl.listMerchandise();
		request.setAttribute("mers", mers);
		request.getRequestDispatcher("/merchandise.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		Map<String, String[]> map = request.getParameterMap();
		Order order = new Order();
		try {
			BeanUtils.populate(order, map);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		if(orderServiceImpl.addOrder(order, request.getSession().getAttribute("userName").toString())){
			request.setAttribute("statusMessage", "订单添加成功");
		}
		else{
			request.setAttribute("statusMessage", "订单添加失败");
		}
		doGet(request,response);
	}

}
