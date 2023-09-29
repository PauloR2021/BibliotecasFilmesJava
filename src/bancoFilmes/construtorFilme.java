package bancoFilmes;


//Metodo Construtor Responsável por 
//Criar os Metodos de Informações do Filmes


public class construtorFilme {
		
	public construtorFilme(String n, String g, String a) {
		this.nome = n;
		this.genero = g;
		this.ano = a;
	}
	
	String nome;
	String genero;
	String ano;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}

}
