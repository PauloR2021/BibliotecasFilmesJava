package bancoFilmes;

import java.util.Scanner;

public class editarFilmes {
	
	//Criando váriaveis Staticas para chamar Funções, Métodos e Salvar Processos
	static BancoDeDados banco = new BancoDeDados();
	static Scanner sc = new Scanner(System.in);
	static String resp;
	static String id;
	static String nome;
	static String genero;
	static String ano;

	public static void main(String[] args) {
		
		try {
			//Se conectando ao Banco de Dados
			banco.conectar();
			
			System.out.println();
			System.out.println("########## Editar Filmes ##########");
			
			//Verificando se Está Conectado o Banco 
			if(banco.estaConectado()) {
				
				System.out.println("#############################################################################");
				banco.ListaFilme();
				System.out.println("#############################################################################");
			}
			else {
				System.out.println("Não Foi Possivel se Conectar ao Banco de Dados");
			}
			
			
			
			//Perguntando ao Usuário qual ID deseja Editars
			System.out.print("Digite a ID do Filme: ");
			id= sc.nextLine();
			
			while(id.isEmpty()) {
				System.out.print("Digite a ID do Filme: ");
				id= sc.nextLine();
			}
			
			
			//Confirmando com o Usuário se quer continuar com o Processo
			System.out.println("Deseja Editar o Filme de ID: "+id);
			System.out.print("S - Sim | N - Não >: ");
			
			
			resp = sc.nextLine().toUpperCase();
			
			System.out.println();
			
			//Criando laços de Condições para cada Escolha do Usuário
			if(resp.equals("S")) {
				
				//Chamando as Informações para Preencher do Filme
				System.out.print("Digite o Nome do Filme: ");
				nome = sc.nextLine();
				
				while(nome.isEmpty()) {
					System.out.print("Digite o Nome do Filme: ");
					nome = sc.nextLine();
				}
				
				System.out.print("Digite o Genero do Filme: ");
				genero = sc.nextLine();
				
				while(genero.isEmpty()) {
					System.out.print("Digite o Genero do Filme: ");
					genero = sc.nextLine();
					
				}
				
				System.out.print("Digite o Ano do Filme: ");
				ano = sc.nextLine();
				
				while(ano.isEmpty()) {
					System.out.print("Digite o Ano do Filme: ");
					ano = sc.nextLine();
				}
				
				//Chamando o Método de Editar o Banco da classe BancoDeDados
				banco.EditarFilme(id, nome, genero, ano);
				
				//Encerrando o Banco de Dados
				banco.DesconectarBanco();
				
				//Mostrando para o usuário os dados editados
				System.out.println("ID: "+id + " | "+
								   "Nome: " + nome + " | "+
								   "Genero: " + genero + " | " + 
								   "Ano: " + ano + " | ");
				System.out.println("Filme Editado com Sucesso!! ");
				System.out.println("################################");
				System.out.println();
				System.out.println();
				
				//Chamando a Classe do Menu 
				menu.main(args);
			
			}
			else if(resp.equals("N")) {
				System.out.println("Saindo da Tela de Edição...");
				System.out.println("################################");
				System.out.println();
				System.out.println();
				
				editarFilmes.main(args);
			}
			else {
				System.out.println("Opção Inválida. Tente novamente!!");
				System.out.println("################################");
				System.out.println();
				System.out.println();
				
				editarFilmes.main(args);
			}
			
			
			
		}catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		sc.close();
		
		
	}

}
