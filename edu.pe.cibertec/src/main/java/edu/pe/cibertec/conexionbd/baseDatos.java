package edu.pe.cibertec.conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baseDatos {

	
		private String _usuario =  "root";
		private String _pwd = "mysql";
		private static String _bd="bdAQUANET";
		static String _url = "jdbc:mysql://localhost/"+_bd;
		private Connection conn = null;
		
		public  baseDatos() {
			try {
				Class.forName("com.mysql.jdbc.Connection");
				conn = (Connection)DriverManager.getConnection(_url, _usuario, _pwd);
				if(conn != null) 
				{
					System.out.println("Conexión a base de datos"+ _url+ ". . . Ok");
				}
			} 
			
			catch ( SQLException ex) {
				System.out.println("Hubo un problema al intentar conectarse a la base de datos"+_url);
			} 
			
			catch(ClassNotFoundException ex)
			{
				System.out.println(ex);
			}	
		}

	
		public ResultSet getQuery(String _query)
		{
			Statement state = null;
			ResultSet resultado = null;
			try 
			{
				state = (Statement) conn.createStatement();
				resultado = state.executeQuery(_query);
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
			return resultado;
		}
		
		public void setQuery(String _query) {
			Statement state = null;
			try {
				state = (Statement) conn.createStatement();
				state.executeQuery(_query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
