package com.codinghub.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Reg")
public class Register extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Bean bean=new Bean();
		String userName=request.getParameter("userName");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		String login=userName.concat(password);
		bean.setUsername(userName);
		bean.setMobile(mobile);
		bean.setPassword(password);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.setAttribute("login", login);
		try 
		{
			int rows=Dao.getData(bean);
			out.println("<HTML>"
					+ "<BODY>"
					+ "<FORM ACTION='Two' METHOD='post'>"
					+ " USERNAME"
					+ "<INPUT TYPE='TEXT' NAME='USERNAME' value="+userName+"><BR>"
					+"MOBILE"
					+ "<INPUT TYPE='TEXT' NAME='MOBILE' value ="+mobile+"><BR>"
					+ "PASSWORD"
					+ "<INPUT TYPE='TEXT' NAME='PASSWORD' value ="+password+"><BR>"
					+ "<INPUT TYPE='SUBMIT' VALUE='FINAL SUBMIT'><BR>"
					+ "<INPUT TYPE='RESET' VALUE='CANCEL'><BR>"
					+"</FORM>"
					+ "</BODY>"
					+ "</HTML>");
					
		
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}