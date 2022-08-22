package br.com.agenda.aplicacao;

import java.sql.Date;
import java.util.Scanner;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	
	public static void main(String[] args) {
		
		ContatoDAO contatoDao = new ContatoDAO();
	
	        Scanner sc = new Scanner(System.in);
	       
	        int idade; 
	        int id;
	        int verificaResposta;
	        int verificaId;
	        int op;
	        String nome;
	        String profissao;
	        String aux;	        
	        String casoDelete;
	        Contato contato = new Contato();
	        boolean existe;
	        do {

	            System.out.println("1 - Inserir Dados");
	            System.out.println("2 - Mostrar Dados");
	            System.out.println("3 - Atualizar");
	            System.out.println("4 - Excluir ");
	            System.out.println("9 - Finalizar");
	            op = sc.nextInt();
	            switch (op) {
	                case 1:
	                    System.out.println("---INSERIR NOVO CONTATO---");
	                    System.out.print("NOME: ");
	                    aux = sc.nextLine();
	                    nome = sc.nextLine();
	                    System.out.print("IDADE: ");
	                    idade = sc.nextInt();
	                    System.out.print("PROFISSÃO: ");
	                    aux = sc.nextLine();
	                    profissao = sc.nextLine();
	                    contato.setNome(nome);
	                    contato.setIdade(idade);
	                    contato.setProfissao(profissao);                 

	                    contatoDao.save(contato);
	                    break;
	                case 2:
	                    for (Contato c : contatoDao.getContatos()) {
	                        System.out.println("ID: " + c.getId());
	                        System.out.println("NOME: " + c.getNome());
	                        System.out.println("IDADE: " + c.getIdade());
	                        System.out.println("PROFISSÃO: " + c.getProfissao());
	                        System.out.println("------------------------------------");
	                    }
	                    break;
	                case 3:
	                    verificaId = 0;
	                    existe = false;
	                    System.out.println("---ATUALIZAR CONTATO---");
	                    do {
	                        System.out.print("Informe o ID do Contato: ");
	                        id = sc.nextInt();
	                        for (Contato c : contatoDao.getContatos()) {
	                            if (c.getId() == id) {
	                                existe = true;
	                                verificaId = 1;
	                                break;
	                            }
	                        }
	                        if (!existe) {
	                            System.out.println("ID INCORRETO");
	                        }
	                    } while (verificaId != 1);
	                    System.out.print("NOME: ");
	                    aux = sc.nextLine();
	                    nome = sc.nextLine();
	                    System.out.print("IDADE: ");
	                    idade = sc.nextInt();
	                    System.out.print("PROFISSÃO: ");
	                    aux = sc.nextLine();
	                    profissao = sc.nextLine();
	                    contato.setNome(nome);
	                    contato.setIdade(idade);
	                    contato.setProfissao(profissao);	                   
	                    contato.setId(id);
	                    contatoDao.update(contato);
	                    break;
	                case 4:
	                    verificaResposta = 0;
	                    verificaId = 0;
	                    existe = false;
	                    System.out.println("---EXCLUIR CONTATO---");
	                    do {
	                        System.out.print("Informe o ID do Contato: ");
	                        id = sc.nextInt();
	                        for (Contato c : contatoDao.getContatos()) {
	                            if (c.getId() == id) {
	                                existe = true;
	                                verificaId = 1;
	                                break;
	                            }
	                        }
	                        if (!existe) {
	                            System.out.println("ID INCORRETO");
	                        }
	                    } while (verificaId != 1);

	                    do {
	                        System.out.println("TEM CERTEZA QUE DESJA EXCLUIR O CONTATO? S/N");
	                        casoDelete = sc.next();
	                        if (casoDelete.equals("S") || casoDelete.equals("s")) {
	                            contatoDao.deleteByID(id);
	                            verificaResposta = 1;
	                        } else if (casoDelete.equals("N") || casoDelete.equals("n")) {
	                            verificaResposta = 1;
	                            System.out.println("---OPERAÇÃO CANCELADA---");
	                        } else {
	                            System.out.println("INFORME |S| OU |N|");
	                        }
	                    } while (verificaResposta != 1);

	                    break;
	            }
	        } while (op != 9);
	    }
	}
