package bancoFilmes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Clase Responsável por conectar o Banco de Dados MySQL com o Java

public class BancoDeDados {
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/bibliotecafilmes";
		String usuario = "root";
		String senha = "Pr_16112001";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor,usuario,senha);
			this.statement = this.connection.createStatement();
		
		}catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}
	
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void ListaFilme() {
		
		try {
			String query = "SELECT* FROM filmes ORDER BY nome";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while(this.resultset.next()) {
				System.out.println("ID: "+this.resultset.getString("id")+ " | " + 
								   "Nome: " + this.resultset.getString("nome")+ " | " +
								   "Genero: " + this.resultset.getString("genero")+ " | " + 
								   "Ano: "+this.resultset.getString("ano")+" | ");
			}
		}catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		} 
		
	}
	
	public void AdicionarFilme(String nome, String genero,String ano) {
		
		try{
			String query = "INSERT INTO filmes(nome,genero,ano) VALUES ('"+nome+"','"+genero+"','"+ano+"'); ";
			this.statement.execute(query);
			
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void EditarFilme(String id, String nome, String genero, String ano) {
		try {
			String query = "UPDATE filmes SET nome='"+nome+"', genero = '"+genero+"',ano='"+ano+"' WHERE id = '"+id+"';";
			this.statement.execute(query);
		}catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}
	
	public void ApagarFilme(String id) {
		try {
			String query = "DELETE FROM filmes WHERE id= '"+id+"';";
			this.statement.execute(query);
		}catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}
	
	public void DesconectarBanco() {
		
		try {
			this.connection.close();
		}
		catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
	}

}

