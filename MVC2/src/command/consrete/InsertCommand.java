package command.consrete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Command;
import member.MemberDAO;
import member.MemberDTO;
import util.Utility;

public class InsertCommand implements Command {

	public InsertCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Utility util=new Utility();
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String year=request.getParameter("year");
		String month= request.getParameter("month");
		String date=request.getParameter("date");
		String birth=year+"-"+month+"-"+date;
		String email=request.getParameter("email");
		String img=request.getParameter("img");
		int i=0;
		try {
			int age=util.getAge(year,month);  
			i = new MemberDAO().create(new MemberDTO());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (i == 1) {
			request.setAttribute("id",id);
			return new ActionCommand(false, "success.do");
		}
		return new ActionCommand(true, "fail.do");

	}

}
