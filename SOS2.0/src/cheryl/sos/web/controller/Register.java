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
		
		/*��request������parameter����javaBean ����
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
		
		
		if(!userServiceImpl.checkValidation(user.getUserName(), "username") ){//username���Ϸ�
			request.setAttribute("statusMessage", "username���Ϸ�");
		}
		else if(userDaoImpl.userExist(user.getUserName(),user.getPassWd())){//username�Ѵ���
			request.setAttribute("statusMessage", "username�Ѵ���");
		}
		else if(!userServiceImpl.checkValidation(user.getPassWd(), "passwd")){//���벻�Ϸ�
			request.setAttribute("statusMessage", "���벻�Ϸ�");
		}
		else if(userServiceImpl.register(user)){//ע��
			request.setAttribute("statusMessage", "ע��ɹ�");
		}
		else{
			request.setAttribute("statusMessage", "ע���쳣��������");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
