package com.itwill.post.controller.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.post.model.Post;
import com.itwill.post.service.PostService;

/**
 * Servlet implementation class amollang
 */
@WebServlet(name = "postListController", urlPatterns = { "/post" })
//"http://localhost:8081/post/post" 요청주소(context root)를 처리하는 서블릿
public class PostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PostListController.class);
    
	private final PostService postservice = PostService.getPostService();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    log.info("doGet()");
	    
	    //  서비스 계층의 메서드를 호출해서 포스트 목록을 불러옴
	    List<Post> posts = postservice.read();
	    
	    // 포스트 목록을 JSP에게 전달
	    request.setAttribute("posts", posts);
	    
	    request.getRequestDispatcher("/WEB-INF/post/list.jsp").forward(request, response);
	}


}
