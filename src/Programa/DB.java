package Programa;

import java.sql.Statement;

import java.sql.Connection; 
import 	java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import 	java.sql.SQLException;
import javax.swing.JComboBox;

public class DB {

	//Atributos
	private static DB DB = new DB();
	public static Connection conn;
	public static Statement stmt;
	public static PreparedStatement pstmt;
	public static ResultSet rs;
	
	private String driverDB = "org.postgresql.Driver";
	//cambie el postgres por su usuario del pgadmin
	private String dbUser = "postgres";
	private String dbName = "dbhh";
	private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
	//cambie el asd por su contraseña del pgadmin
	private String passwordDB = "asd";
	
	
	//conexion
	private DB() {
		try {
			Class.forName(driverDB);
			this.conn = DriverManager.getConnection(urlDB, dbUser, passwordDB);
			
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			} 
		
	}	
		
		//parte 3
		public static DB getInstances() {
			return DB;
			}
		
		} 