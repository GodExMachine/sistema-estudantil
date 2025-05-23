
public abstract class Pessoa {

	
	
	private	String nome;
	private String sobrenome;
	private String CPF;
	
	protected Pessoa(String  nome, String sobrenome, String CPF) {
		
		super();
		setNome(nome);
		setSobrenome(sobrenome);
		setCPF(CPF);
		
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		
		this.nome = nome;
		
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	

	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	
	
	
	
}
