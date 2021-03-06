package com.ecu.project;

import java.io.IOException;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class GameMakerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user = req.getParameter("user");
		String vocabularySet = req.getParameter("vocabularySet");
		String gameType = req.getParameter("gameType");
		if (gameType!=null && user!=null && vocabularySet!=null && !"".equals(user) && !"".equals(vocabularySet)) {
			HttpSession session = req.getSession();
			session.setAttribute("username", user);
			session.setAttribute("gameType", gameType);
			session.setAttribute("vocabulary", vocabularySet);
			resp.sendRedirect("singlePlayer.jsp");
		} 
		else
		{
			response(resp, "Invalid Credentials");
		}
	}

	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}
}