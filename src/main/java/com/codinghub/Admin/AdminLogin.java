package com.codinghub.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin")
public class AdminLogin extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try 
		{
			ResultSet rs=AdminDao.getDao(emailId, password);
			if(rs.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("StudentDisplay");
				rd.forward(request, response);
			}
			else
			{
				out.println("PLEASE TRY AGIAN");
				response.sendRedirect("AdminLogin.html");
			}
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
