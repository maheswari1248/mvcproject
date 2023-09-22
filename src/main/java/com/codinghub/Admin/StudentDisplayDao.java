package com.codinghub.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codinghub.Student.ConnectionFactory;

public class StudentDisplayDao 
{
	public static ResultSet getDao() throws ClassNotFoundException, SQLException
	{
		String Query="SELECT * FROM STUDENT1";
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement(Query);
		return pst.executeQuery();
	}
}
