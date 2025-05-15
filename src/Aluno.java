
public class Aluno extends Pessoa {
	
	
	private Turma turma;
	
	
	public Aluno(String nome, String sobrenome, String CPF) {
		super(nome, sobrenome, CPF);
	}
	
	public Aluno(String nome, String sobrenome, String CPF, Turma turma) {
		super(nome, sobrenome, CPF);
		setTurma(turma);
	}
	

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
	
	
	
	
	
	
	public void responderChamada() {
		
		
		System.out.println(getNome()+": presente!");
		
	}
}
