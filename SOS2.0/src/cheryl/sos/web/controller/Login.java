package cheryl.sos.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cheryl.sos.service.impl.UserServiceImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String input = request.getParameter("inputRandom");
		String defined = (String) request.getSession().getAttribute("random");
		String url="";
		if(input.isEmpty()){
			request.setAttribute("statusMessage", "验证码不能为空");
			url = "/entry.jsp";
		}
		else if(!input.equals(defined)){
			request.setAttribute("statusMessage", "验证码不匹配");
			url = "/entry.jsp";
		}
		else{
			UserServiceImpl service = new UserServiceImpl();
			boolean status=false;
			String username = request.getParameter("username");
			String passwd = request.getParameter("passwd");
			status = service.login(username,passwd);
			if(!status){
				request.setAttribute("statusMessage", service.messageBuffer);
				url = "/entry.jsp";
			}
			else{		
				request.setAttribute("statusMessage", service.messageBuffer);
				url = "/main.jsp";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
