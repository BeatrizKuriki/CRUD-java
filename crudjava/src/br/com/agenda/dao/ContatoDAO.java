package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	
	//aqui fazemos o CRUD
	
	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES(?, ?, ?)";
		
	   Connection conn = null;
	   PreparedStatement pstm = null;
	   
	   
	   try {
		   
		   //criar uma conexão com o banco
		   conn = ConnectionFactory.createConnectionToMySQL();
		   
		   //para executar uma query
		   pstm = (PreparedStatement)conn.prepareStatement(sql);
		   
		   pstm.setString(1, contato.getNome());
		   pstm.setInt(2, contato.getIdade());
		   pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
		   
		   
		   //executar
		   
		   pstm.execute();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		   
		   try {
			   if(pstm!=null) {
				   pstm.close();
			   }
			   if(conn!=null) {
				   conn.close();
			   }
		   }catch (Exception e) {
			e.printStackTrace();
		}
	   }
		
		
	}

}
