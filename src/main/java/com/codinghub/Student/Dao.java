package com.codinghub.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao 
{
	static Bean bean=new Bean();
	public static int getData(Bean bean) throws ClassNotFoundException, SQLException
	{
		String Query="INSERT INTO STUDENT1 VALUES(?,?,?)";
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pst=con.prepareStatement(Query);
		pst.setString(1, bean.getUsername());
		pst.setString(2, bean.getMobile());
		pst.setString(3, bean.getPassword());
		return pst.executeUpdate();
	}
}
