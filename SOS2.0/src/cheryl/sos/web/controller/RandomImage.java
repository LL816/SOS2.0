package cheryl.sos.web.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import cheryl.sos.utils.RandomImageGenerator;
/**
 * Servlet implementation class RandomImage
 */
@WebServlet("/RandomImage")
public class RandomImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");//通知浏览器将要显示图片
		response.setDateHeader("expires", -1);//禁止缓存，地址栏敲回车，默认会拿缓存给你
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		request.setCharacterEncoding("UTF-8");

		OutputStream out = response.getOutputStream();
		RandomImageGenerator generator= new RandomImageGenerator();
		generator.generateImage();
		request.getSession().setAttribute("random", generator.random.toString());
		ImageIO.write(generator.image, "jpg", out);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
