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
			String file=request.getParameter("file");
			System.out.println("fileCommand file name:"+new File(file).getName());
			String fileName=null;
			try {
				//fileName = new ImgFileUpload(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("fileCommand return file name:"+fileName);
			return  new ActionCommand(false,"test.jsp");
	}

}
