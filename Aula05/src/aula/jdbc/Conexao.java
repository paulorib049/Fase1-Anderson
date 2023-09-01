package aula.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

 public static void main(String[] args){
		String driver = "com.mysql.cj.jdbc.Driver";
		String sUsuario = "root";
		String sSenha = "MySQL049";
		String sFonte = "jdbc:mysql://localhost:3306/poojdbc";

	 try{
		 Class.forName(driver);
		 Connection con = null;

		 con = (Connection) DriverManager.getConnection(sFonte, sUsuario, sSenha);

		 System.out.println("Conexão realizada com sucesso.");

	 }
	 catch (ClassNotFoundException ex){
		 System.err.print(ex.getMessage());
	 }
	 catch (SQLException e){
		 System.err.print(e.getMessage());
	 }
 	}
}