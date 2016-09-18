package cheryl.sos.web.controller;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cheryl.sos.dao.impl.UserDaoImpl;
import cheryl.sos.service.impl.UserServiceImpl;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public Register() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String passwd2 = request.getParameter("passwd2");
		String url="/register.jsp";
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
		data.put("user_name", username);

		if(!userServiceImpl.checkValidation(username, "username") ){//username不合法
			request.setAttribute("statusMessage", "username不合法");
		}
		else if(userDaoImpl.userExist(data)){//username已存在
			request.setAttribute("statusMessage", "username已存在");
		}
		else if(!userServiceImpl.checkValidation(passwd, "passwd")){//密码不合法
			request.setAttribute("statusMessage", "密码不合法");
		}
		else if(!passwd.equals(passwd2)){//两次密码输入不匹配
			request.setAttribute("statusMessage", "两次密码输入不匹配");
		}
		else if(userServiceImpl.register(username,passwd)){//注册
			request.setAttribute("statusMessage", "注册成功");
		}
		else{
			request.setAttribute("statusMessage", "注册异常，请重试");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
