package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.consrete.ActionCommand;
import command.consrete.InsertCommand;
import command.ui.FailUICommand;
import command.ui.IndexUICommand;
import command.ui.InsertUICommand;

/**
 * Servlet implementation class FlontServlet
 */
//@WebServlet("*.do")
public class FlontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FlontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		String what = uri.substring(path.length()).toLowerCase();
		Command com = null;
		switch (what) {
		case "/fail.do":
			com = new FailUICommand();
			break;
		case "/index.do":
			com = new IndexUICommand();
			break;
		case "/insertui.do":
			com = new InsertUICommand();
			break;
		case "/insert.do":
			com = new InsertCommand();
			break;
		default:
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
