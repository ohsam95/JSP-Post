package com.cos.apple.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.apple.action.Action;
import com.cos.apple.dao.MemberDao;
import com.cos.apple.model.Member;

public class MemberLoginProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		MemberDao memberDao = new MemberDao();
		Member principal = memberDao.로그인(username,password);
		 
		if(principal == null) {
			response.sendRedirect("member/loginForm.jsp");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("principal", principal);
			response.sendRedirect("index.jsp");
		}
	}
}
