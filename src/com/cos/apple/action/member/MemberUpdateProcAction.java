package com.cos.apple.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.apple.action.Action;
import com.cos.apple.dao.MemberDao;
import com.cos.apple.model.Member;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class MemberUpdateProcAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.회원수정(id, username, password, email);
		
		if (result == 1) {
			Member principal = memberDao.회원찾기(id);
						HttpSession session = request.getSession();
						session.setAttribute("principal", principal);
						response.sendRedirect("index.jsp");
					}else {
						response.sendRedirect("member/updateForm.jsp");
					
		}
	
	
		
	}
}
