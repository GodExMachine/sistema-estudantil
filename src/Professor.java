
public class Professor extends Pessoa{
	
	private Turma turma;
	
	
	public Professor(String nome, String sobrenome, String CPF) {
		super(nome, sobrenome, CPF);
	}
	
	public Professor(String nome, String sobrenome, String CPF, Turma turma) {
		super(nome, sobrenome, CPF);
		setTurma(turma);
	}
	

	public Turma getTurma() {
		return turma;
	}
	
	
	public void setTurma(Turma turma) {
		this.turma =turma;
	}
	
	
	
	
	public void realizarChamada() {
	
	System.out.println("Pessoal, vamos fazer a chamada.");
	
	}	
}
