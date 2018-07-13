package org.btm.batchDemo;

import java.sql.*;

public class StatementDemo 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		String inqry="insert into muzeeb.student values(4,'yaswanth',65)";
		String upqry="update muzeeb.student set perc=74.12 where id=2";
		//String upqry2="update muzeeb.user set password='iwantyou' where id=3";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=muzeeb");
			stmt=con.createStatement();
			//ADD DML QUERY INTO BATCH//
			stmt.addBatch(inqry);
			//stmt.addBatch(upqry2);
			stmt.addBatch(upqry);
			int ar[]=stmt.executeBatch();
			for(int i:ar)
			{
				System.out.println(i);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
			{
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
