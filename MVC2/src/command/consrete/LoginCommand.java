package command.consrete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import member.MemberDAO;

public class LoginCommand implements Command {

	public LoginCommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String id= request.getParameter("id");
		if(new MemberDAO().login(id,request.getParameter("password"))) {
			request.getSession().setAttribute("id",id);
			return new ActionCommand(true,"index.do");
		}
		request.setAttribute("msg","아이디와 비빌번호를 확인해 주세요.");
		request.setAttribute("id",id);
		return new ActionCommand(false,"loginui.do");
	}

}
