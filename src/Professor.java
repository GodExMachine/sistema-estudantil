
public class Professor {
	
	private String nome;
	
	private String sobrenome;
	
	private String CPF;
	
	public Professor(String nome, String sobrenome, String CPF) {
		
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
	
	public void realizarChamada() {
	
	System.out.println("Pessoal, vamos fazer a chamada.");
	
	}	
}
