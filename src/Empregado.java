
public abstract class Empregado extends Pessoa {

	private float salario;
	private Situacao situacao;

	protected Empregado(String nome, String sobrenome, String CPF, float salario) {
		super(nome, sobrenome, CPF);
		setSalario(salario);
	}

	protected Empregado(String nome, String sobrenome, String CPF, float salario, Situacao situacao) {
		super(nome, sobrenome, CPF);
		setSalario(salario);
		setSituacao(situacao);
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {

		this.salario = salario;

	}
	
	public Situacao getSituacao() {
		return situacao;
	}
	
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
		
	}
	
	public abstract float calcularSalario();

}
