
public class Professor extends Empregado{
	
	private Turma turma;
	
	
	public Professor(String nome, String sobrenome, String CPF, float salario) {
		super(nome, sobrenome, CPF, salario);
	}
	
	public Professor(String nome, String sobrenome, String CPF,float salario ,Turma turma) {
		super(nome, sobrenome, CPF, salario);
		setTurma(turma);
	}
	

	public Turma getTurma() {
		return turma;
	}
	
	
	public void setTurma(Turma turma) {
		this.turma =turma;
	}
	
	public float calcularSalario() {

		return getSalario() + 500;

	}
	public float calcularSalario(int quantidadeHorasTrabalhadas) {

		return quantidadeHorasTrabalhadas *50;

	}
	
	
	public void realizarChamada() {
	
	System.out.println("Pessoal, vamos fazer a chamada.");
	
	}	
}
