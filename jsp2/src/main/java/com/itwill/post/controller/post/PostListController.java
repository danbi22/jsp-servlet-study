package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class amollang
 */
@WebServlet(name = "postListController", urlPatterns = { "/post" })
//"http://localhost:8081/post/post" 요청주소(context root)를 처리하는 서블릿
public class PostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    request.getRequestDispatcher("/WEB-INF/post/post.jsp").forward(request, response);
	}


}
