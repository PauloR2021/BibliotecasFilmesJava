package bancoFilmes;

import java.util.Scanner;

//Classe Responsável por Cadastrar Os Filmes

public class cadastrarFilmes {
	

	//Criando Váriaveis Estáticas para chamar Metodos e Funções no Programa
	
	static Scanner sc = new Scanner(System.in);
	static construtorFilme construtor;
	static BancoDeDados banco = new BancoDeDados();
	static String nome_banco;
	static String genero_banco;
	static String ano_banco;
	
	public static void main(String[] args) {
		
		
		try {
			//Conectando se ao Banco de Dados
			banco.conectar();
			
			System.out.println();
			//Iniciando as Informações para o usuário
			System.out.println("##### Cadastrando Filme ######");
			System.out.println();
			
			System.out.print("Digite o Nome do Filme: ");
			String nome = sc.nextLine();
			
			//Verificando se o Campo Nome Está Vazio
			
			while(nome.isEmpty()) {
				System.out.print("Digite o Nome do Filme: ");
				nome = sc.nextLine();
			}
			
			
			System.out.print("Digite o Genero do Filme: ");
			String genero = sc.nextLine();
			
			//Verificando se o Campo Gebero está Vazio
			
			while(genero.isEmpty()) {
				System.out.print("Digite o Genero do Filme: ");
				genero = sc.nextLine();
				
			}
			System.out.print("Digite o Ano do Filme: ");
			String ano = sc.nextLine();
			
			//Verificando se o Campo Ano Está Vazio
			
			while(ano.isEmpty()) {
				System.out.print("Digite o Ano do Filme: ");
				ano = sc.nextLine();
			}
			
			//Chamando o Método Construntor
			construtor = new construtorFilme(nome,genero,ano);
			
			//Atribuindo as Informações do métodos as Variaveis
			
			nome_banco = construtor.getNome();
			genero_banco = construtor.getGenero();
			ano_banco = construtor.getAno();
			
			
			System.out.println("Dados Inseridos: Nome: "+nome_banco + " | "+
								"Genero: " + genero_banco + " | "+
								"Ano: " + ano_banco + " | ");
			
			System.out.println("Dados Cadastrados com Sucesso!!");
			
			if(banco.estaConectado()) {
				//Adicionando os Dados Ao Banco 
				banco.AdicionarFilme(nome_banco,genero_banco,ano_banco);
				System.out.println("#######################################");
				menu.main(args);
				
			}
			else {
				System.out.println("Não Foi Possivel se Conectar ao Banco de Dados");
			}
			
			//Fechando o banco de Dados
			banco.DesconectarBanco();
			
			sc.close();
			
			
			
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		

	}

}
