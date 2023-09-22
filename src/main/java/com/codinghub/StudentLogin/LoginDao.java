package com.codinghub.StudentLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codinghub.Student.ConnectionFactory;

public class LoginDao
{
	public static ResultSet getDao(String userName,String password) throws ClassNotFoundException, SQLException
	{
		String Query="SELECT * FROM STUDENT1 WHERE USERNAME=? AND PASSWORD=?";
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement(Query);
		pst.setString(1, userName);
		pst.setString(2, password);
		return pst.executeQuery();
	}
}
