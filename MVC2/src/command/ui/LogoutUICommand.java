package command.ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.consrete.ActionCommand;

public class LogoutUICommand implements Command {

	public LogoutUICommand() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getSession(false).invalidate();
		return  new ActionCommand(true,"index.do");
	}

}
