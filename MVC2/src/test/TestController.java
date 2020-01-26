package test;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.consrete.ActionCommand;
/**
 * Servlet implementation class FlontServlet
 */
@WebServlet("*.test")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath()+File.separator+"test";
		String uri = request.getRequestURI();
		String what = uri.substring(path.length()).toLowerCase();
		Command com = null;
		System.out.println(path);
		System.out.println(uri);
		System.out.println(what);
		switch (what) {
		case "/testfileui.test":
			com=new Testfileui();
			break;
		case "/test.test":
			com=new Testfile();
			break;
		case "/testupdatefileui.test":
			com=new TestUpdatefileui();
			break;
		case "/testupdate.test":
			com=new Testupdate();
			break;
		}
		if (com != null) {
			ActionCommand ac = com.execute(request, response);
			if (ac.isFlag()) {
				response.sendRedirect(ac.getUrl());
				return;
			}
			request.getRequestDispatcher(ac.getUrl()).forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
