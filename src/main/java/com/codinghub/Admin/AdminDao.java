package com.codinghub.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codinghub.Student.ConnectionFactory;

public class AdminDao 
{
	public static ResultSet getDao(String emailId,String password) throws ClassNotFoundException, SQLException
	{
		String Query="SELECT * FROM Admin WHERE emailid=? AND PASSWORD=?";
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement(Query);
		pst.setString(1, emailId);
		pst.setString(2, password);
		return pst.executeQuery();
	}
}
