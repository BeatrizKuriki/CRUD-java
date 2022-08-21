package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	
	//senha do bancoDeDados
	private static final String PASSWORD = "";
	
	//caminho do banco de dados, porta, nome do banco
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	//conexão com o banco de dados
	
	public static Connection createConnectionToMySQL() throws SQLException{
		//faz com que a classe seja carregada pela jvm
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//cria a conexão com o banco de dados		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
		
	}
	
	public static void main(String[] args) throws SQLException{
		//recuperar uma conexão com o banco de dados 
		
		Connection con = createConnectionToMySQL();
		
		//testar se a conexão é nula
		
		
		if(con!=null) {
			System.out.println("Conexão realizada com sucesso!!");
			con.close();
		}
		
		
	}
	
	
	
	

}
