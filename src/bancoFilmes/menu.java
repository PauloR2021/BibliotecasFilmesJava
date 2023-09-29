package bancoFilmes;

import java.util.Scanner;


//Classe de Menu do Programa

public class menu {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		try {
			while(true) {
				System.out.println();
				System.out.println("##### Menu #####");
				System.out.println("1 - Adicionar Filme");
				System.out.println("2 - Consultar Filme");
				System.out.println("3 - Aterar Filme");
				System.out.println("4 - Excluir Filme");
				
				System.out.print(">: ");
				int resp = sc.nextInt();
				
				System.out.println("##################");
				
				switch(resp) {
				
					//Chamando as Classes apartir de uma Decisão do Usuário
					case 1:
						cadastrarFilmes.main(args);
						break;
					case 2:
						listarFilmes.main(args);
						break;
					case 3:
						editarFilmes.main(args);
						break;
					case 4:
						deletarFilmes.main(args);
						break;
					default:
						System.out.println("Opção Inválida tente de Novo !");
				}
			}
			
		}
		catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		sc.close();
	}

}
