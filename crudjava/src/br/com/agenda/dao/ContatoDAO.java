package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PacketTooBigException;
import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	
	//aqui fazemos o CRUD
	
	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade, profissao) VALUES(?, ?,?)";
		
	   Connection conn = null;
	   PreparedStatement pstm = null;
	   
	   
	   try {
		   
		   //criar uma conexão com o banco
		   conn = ConnectionFactory.createConnectionToMySQL();
		   
		   //para executar uma query
		   pstm = (PreparedStatement)conn.prepareStatement(sql);
		   
		   pstm.setString(1, contato.getNome());
		   pstm.setInt(2, contato.getIdade());		
		   pstm.setString(3, contato.getProfissao());
		   
		   
		   //executar
		   
		   pstm.execute();
		   System.out.println("Contato salvo com sucesso!!");
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

	//implementando o read- segunda função do crud
	public List<Contato> getContatos(){
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//classe que vai recuperar os dados do banco
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Contato contato = new Contato();
				
				//ler o id
				
				contato.setId(rset.getInt("id"));
				
				//ler o nome
				contato.setNome(rset.getString("nome"));
				
				
				//ler idade
				contato.setIdade(rset.getInt("idade"));
				
				
				//ler profissao
				contato.setProfissao(rset.getString("profissao"));		
				
				
				
				contatos.add(contato);
				
			}
		}catch(Exception e) {
				e.printStackTrace();
			}finally {
				
			try {
				
		
			
				if(rset!=null) {
					rset.close();
				}
				
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
	
		
	}
		return contatos;
		

 

}
}



