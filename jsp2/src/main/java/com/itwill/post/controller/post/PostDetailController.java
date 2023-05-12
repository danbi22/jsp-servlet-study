package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;
import com.itwill.post.service.PostService;

/**
 * Servlet implementation class PostDetailController
 */
@WebServlet(name = "postDetailController", value = {"/post/detail"})
public class PostDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(PostDetailController.class);
	
	private static PostService postService = PostService.getPostService();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    log.info("detail: doGet()");
	    
	    // 목록 페이지에서 선택된 열의 id를 가져옴
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    // 선택된 열의 id를 가지고 해당 post를 찾음
	    Post post = postService.readAt(id); 
	    log.info("post{}", post);
	    
	    
	    // DB에서 가져온 post를 request에 넣어줌
	    request.setAttribute("post", post);
	    
	    // jsp에 request를 전달
	    request.getRequestDispatcher("/WEB-INF/post/detail.jsp").forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		
	}

}
