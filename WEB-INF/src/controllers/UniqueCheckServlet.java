package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

import models.User;

public class UniqueCheckServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String key=request.getParameter("key");

		boolean flag=User.uniqueKey(key);
		response.getWriter().write(Boolean.toString(flag));
	}
}