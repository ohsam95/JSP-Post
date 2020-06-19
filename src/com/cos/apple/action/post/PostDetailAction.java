package com.cos.apple.action.post;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.apple.action.Action;
import com.cos.apple.dao.MemberDao;
import com.cos.apple.dao.PostDao;
import com.cos.apple.dto.DetailDto;
import com.cos.apple.model.Member;
import com.cos.apple.model.Post;

public class PostDetailAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int id = Integer.parseInt(request.getParameter("id"));
			
			PostDao postDao = new PostDao();
			DetailDto detailDto = postDao.상세보기(id);
			request.setAttribute("detailDto",detailDto );
			
			
		
		
			RequestDispatcher dis = request.getRequestDispatcher("post/detail.jsp");
			dis.forward(request, response);
			
		//	response.sendRedirect("post/detail.jsp");
		
		


	}
}
