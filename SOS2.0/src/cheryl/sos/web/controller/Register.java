package cheryl.sos.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cheryl.sos.dao.impl.UserDaoImpl;
import cheryl.sos.domain.UserInfo;
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
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		String url="/register.jsp";
		
		/*用request包含的parameter表构建javaBean 对象
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String passwd2 = request.getParameter("passwd2");
		String url="/register.jsp";
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
		data.put("user_name", username);
		*/
		Map<String, String[]> map = request.getParameterMap();
		UserInfo user = new UserInfo();
		
		try {
			BeanUtils.populate(user,map);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		
		if(!userServiceImpl.checkValidation(user.getUserName(), "username") ){//username不合法
			request.setAttribute("statusMessage", "username不合法");
		}
		else if(userDaoImpl.userExist(user.getUserName(),user.getPassWd())){//username已存在
			request.setAttribute("statusMessage", "username已存在");
		}
		else if(!userServiceImpl.checkValidation(user.getPassWd(), "passwd")){//密码不合法
			request.setAttribute("statusMessage", "密码不合法");
		}
		else if(userServiceImpl.register(user)){//注册
			request.setAttribute("statusMessage", "注册成功");
		}
		else{
			request.setAttribute("statusMessage", "注册异常，请重试");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
