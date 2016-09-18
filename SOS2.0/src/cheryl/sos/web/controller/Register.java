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

		if(!userServiceImpl.checkValidation(username, "username") ){//username���Ϸ�
			request.setAttribute("statusMessage", "username���Ϸ�");
		}
		else if(userDaoImpl.userExist(data)){//username�Ѵ���
			request.setAttribute("statusMessage", "username�Ѵ���");
		}
		else if(!userServiceImpl.checkValidation(passwd, "passwd")){//���벻�Ϸ�
			request.setAttribute("statusMessage", "���벻�Ϸ�");
		}
		else if(!passwd.equals(passwd2)){//�����������벻ƥ��
			request.setAttribute("statusMessage", "�����������벻ƥ��");
		}
		else if(userServiceImpl.register(username,passwd)){//ע��
			request.setAttribute("statusMessage", "ע��ɹ�");
		}
		else{
			request.setAttribute("statusMessage", "ע���쳣��������");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
