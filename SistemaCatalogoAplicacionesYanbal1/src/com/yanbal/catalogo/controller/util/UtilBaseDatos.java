package com.yanbal.catalogo.controller.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilBaseDatos 
{
	public static Connection conexion;
	
	public static Connection getConexion()
	{
		if(conexion == null )
		{
			try 
			{
				Class.forName("com.ibm.db2.jcc.DB2Driver");
			}
		    catch (ClassNotFoundException e) 
		    {
				System.out.println("DB2 JDBC Driver not found.");
				e.printStackTrace();
				System.exit(1);
		    }
			   
		    try 
		    {
		    	conexion = DriverManager.getConnection("jdbc:db2://10.28.21.143:50000/ARQUITE","usrarq","lima");
		    	//conexion = DriverManager.getConnection("jdbc:db2://localhost:50000/ARQUITE","db2admin","P@$$w0rd");
				conexion.setAutoCommit(false);
		    }
		    catch (SQLException e) 
		    {
		      System.out.println("Error de conexión: " + e.getMessage());
		      System.exit(4);
		    }
		}
			
		return conexion;
	}
}
