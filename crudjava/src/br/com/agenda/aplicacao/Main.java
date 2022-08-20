package br.com.agenda.aplicacao;

import java.sql.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("Stella Maria Suzuki");
		contato.setId(55);
		contato.setDataCadastro(null);
		
		contatoDao.save(contato);
		
		

	}

}
