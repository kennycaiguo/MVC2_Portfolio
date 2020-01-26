package test;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.consrete.ActionCommand;
import util.ImgFileUpload;

public class Testupdate implements Command {

	public Testupdate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String file=request.getParameter("file");
		System.out.println("fileUpdateCommand file name:"+new File(file).getName());
		String fileName=null;
		try {
			ImgFileUpload ifu=new ImgFileUpload(file,"tester");
			fileName = ifu.fileUpdate("(tester)member.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("fileCommand return file name:"+fileName);
		return new ActionCommand(true,"testupdate.jsp");
	}

}
