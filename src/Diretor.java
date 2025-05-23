
public class Diretor extends Empregado implements RH  {

	public Diretor(String nome, String sobrenome, String CPF, float salario) {
		super(nome, sobrenome, CPF, salario) ;
		
	
	}
	
	public Diretor(String nome, String sobrenome, String CPF, float salario,Situacao situacao) {
		super(nome, sobrenome, CPF, salario) ;
		
	
	}
	
	
	public float calcularSalario() {

		return getSalario() + 1500;

	}
	
	public void contratarEmpregado(Empregado empregado) {
		empregado.setSituacao(Situacao.ATIVO);
	}
	
	public void demitirEmpregado(Empregado empregado) {
		empregado.setSituacao(Situacao.INATIVO);
	}
	
	
	
}
