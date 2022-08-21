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
		contatoDao.save(contato);
		
		

	}

}
