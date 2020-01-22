package command.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.consrete.ActionCommand;
import member.MemberDAO;

public class InsertUICommand implements Command {

	public InsertUICommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		return new ActionCommand(false ,"insert.jsp");
	}

}
