package controller.DB;

import java.sql.*;

public class Db_commection {

	public static Connection con=null;
	String url;
	
	public Connection GetMySQLConnection ()
	{
				try{
						Class.forName("com.mysql.jdbc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost/stu_result","root","tharhtetsan");
						System.out.println("Database_connected");
					}catch(ClassNotFoundException cnfx)
					{
						cnfx.printStackTrace();
						System.out.println(cnfx);
					}catch(SQLException sqle)
					{
						sqle.printStackTrace();
						System.out.println(sqle);
					}catch(Exception exp)
					{
						exp.printStackTrace();
						System.out.println(exp);
					}
		
		System.out.println(con);
		return con;
		
	}


	public static void main(String[] args) 
	{
		Db_commection con=new Db_commection();
		con.GetMySQLConnection();
	}
	
	

}
