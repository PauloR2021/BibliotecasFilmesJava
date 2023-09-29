package bancoFilmes;

import java.util.Scanner;

//Classe Responsável por Deletar Os Filmes
public class deletarFilmes {
	
	//Criando Váriaveis Estáticas para chamar Metodos e Funções no Programa
	static BancoDeDados banco = new BancoDeDados();
	static Scanner sc = new Scanner(System.in);
	static String id;
	static String resp;
	
	public static void main(String[] args) {
		
		try {
			//Conectando se ao Banco de Dados
			banco.conectar();
			System.out.println("########## Apagar Filmes ##########");
			
			System.out.println();
			System.out.println("#############################################################");
			
			
			if(banco.estaConectado()) {
				//Chamando o Método de Lista os Dados do banco
				banco.ListaFilme();
				System.out.println("#############################################################");
			}
			else {
				System.out.println("Não Foi Possivel se Conectar ao Banco de Dados");
			}
			
			
			System.out.println();
			
			//Solicitando ao Usuário a ID que deseja Excluir
			System.out.print("Digite a ID do Filme que Deseja Apagar:  ");
			id = sc.nextLine();
			
			System.out.println("Deseja Apagar o Filme de ID: " +id);
			System.out.print("S - Sim | N - Não >: ");
			resp = sc.nextLine().toUpperCase();
			
			if(resp.equals("S")) {
				//Chamando o método de Apagar os Dados do Banco
				banco.ApagarFilme(id);
				
				System.out.println("Filme Apagado Com Sucesso !!");
				System.out.println();
				menu.main(args);
				
			}
			else if(resp.equals("N")) {
				System.out.println("FIlme não será Apagado !!");
				System.out.println();
				deletarFilmes.main(args);
			}
			else {
				System.out.println("Comando Inválido, Tente Novamente");
				System.out.println();
				deletarFilmes.main(args);
			}
			//Desconectando do Banco de Dados
			banco.DesconectarBanco();
		}
		catch(Exception e)
		{
			System.out.println("Error: "+e.getMessage());
		}
		
		//Encerrando o método Scanner
		sc.close();
		
		
		
		
	}

}
