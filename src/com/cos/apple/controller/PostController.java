package com.cos.apple.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.apple.action.Action;
import com.cos.apple.action.post.PostDetailAction;
import com.cos.apple.action.post.PostListAction;
import com.cos.apple.action.post.PostSaveFormAction;
import com.cos.apple.action.post.PostSaveProcAction;
import com.cos.apple.action.post.PostUpdateFormAction;
import com.cos.apple.action.post.PostUpdateProcAction;

//http://localhost:8001/apple/member
@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PostController() {
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
		if (cmd.equals("list")) {
			return new PostListAction();
		}else if (cmd.equals("saveForm")) {
			return new PostSaveFormAction();
		}else if (cmd.equals("saveProc")) {
			return new PostSaveProcAction();
		}else if (cmd.equals("detail")) {
			return new PostDetailAction();
		}else if (cmd.equals("updateForm")) {
			return new PostUpdateFormAction();
		}else if (cmd.equals("updateProc")) {
			return new PostUpdateProcAction();
		}
		return null;
		
		}

}
