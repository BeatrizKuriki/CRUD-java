package br.com.agenda.aplicacao;

import java.sql.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	
	public static void main(String[] args) {
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("Anderson Shigueo Kyoto");
		contato.setIdade(40);		
		contato.setProfissao("desenvolvedor");
		//contatoDao.save(contato);
		
		//atualizar contato
		Contato c1 = new Contato();
		
		c1.setNome("Anderson Silva");
		c1.setIdade(41);
		c1.setProfissao("professor");
		c1.setId(6);
		//contatoDao.update(c1);
		
		//deletar contato pelo numero do ID
		contatoDao.deleteByID(5);
		
		
		
		
		
		
		
		//ver os todos registros do banco
		
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Contato: "+ c.getNome());
		}
		
		
		
		

	}

}
