package com.cos.apple.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.apple.action.Action;
import com.cos.apple.action.member.MemberJoinFormAction;
import com.cos.apple.action.member.MemberJoinProcAction;
import com.cos.apple.action.member.MemberLoginFormAction;
import com.cos.apple.action.member.MemberLoginProcAction;
import com.cos.apple.action.member.MemberLogoutAction;
import com.cos.apple.action.member.MemberUpdateFormAction;
import com.cos.apple.action.member.MemberUpdateProcAction;
import com.cos.apple.action.post.PostListAction;

//http://localhost:8001/apple/member
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. request UTF-8 세팅 = web.xml 필터등록함.
		//2. response UTF-8 세팅
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8 ");
		
		String cmd = request.getParameter("cmd");
		Action action = router(cmd);
		action.execute(request,response);
		
	}
	private Action router(String cmd) {
		if (cmd.equals("joinForm")) {
			return new MemberJoinFormAction();
		}else if (cmd.equals("joinProc")) {
			return new MemberJoinProcAction();
		}else if (cmd.equals("loginForm")) {
			return new MemberLoginFormAction();
		}else if (cmd.equals("loginProc")) {
			return new MemberLoginProcAction();
		}else if (cmd.equals("updateForm")) {
			return new MemberUpdateFormAction();
		}else if (cmd.equals("updateProc")) {
			return new MemberUpdateProcAction();
		}else if (cmd.equals("logout")) {
			return new MemberLogoutAction();
		}
		return null;
		
		}

}
