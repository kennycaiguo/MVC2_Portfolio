package test;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.consrete.ActionCommand;
import util.ImgFileUpload;

public class Testfile implements Command {

	public Testfile() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			System.out.println(request.getParameter("year"));
			System.out.println(request.getParameter("month"));
			System.out.println(request.getParameter("date"));
			return  new ActionCommand(false,"insertui.do");
	}

}
