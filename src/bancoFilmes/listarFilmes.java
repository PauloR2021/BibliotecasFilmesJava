package bancoFilmes;

//Classe Responsável por Listar os Filmes Cadastrados

public class listarFilmes {
	
	//Metodo Estatico responsável por chamar o Banco
	static BancoDeDados banco = new BancoDeDados();

	public static void main(String[] args) {
		
		try {
			//Conectando o Banco de Dados
			banco.conectar();
			
			System.out.println("########## Listar Todos os Filmes ##########");
			
			if(banco.estaConectado()) {
				System.out.println();
				
				System.out.println("#############################################################################");
				
				//Chamando o Metodo de Listar os Dados do Banco
				banco.ListaFilme();
				
				System.out.println("#############################################################################");
				
				//Fechando o Banco de Dados
				banco.DesconectarBanco();
			}
			else {
				System.out.println("Não Foi Possivel se Conectar ao Banco de Dados");
			}
			
		}catch(Exception e) {
			
			System.out.println("Erro: "+e.getMessage());
			
		}
		
	}

}
