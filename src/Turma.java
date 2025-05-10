

public class Turma {

	private String codigo;
	private byte cargaHoraria;
	private Professor professor;
	private Aluno[] alunos;
	private final static byte TAMANHO_TURMA = 5;
	private int quantidadeAlunos;


	public Turma(String codigo, byte cargaHoraria) {

		setCodigo(codigo);
		setCargaHoraria(cargaHoraria);
		alunos = new Aluno[TAMANHO_TURMA];
		quantidadeAlunos = 0;
	}

	public Turma(String codigo, byte cargaHoraria, Professor professor) {

		setCodigo(codigo);
		setCargaHoraria(cargaHoraria);
		setProfessor(professor);
		alunos = new Aluno[TAMANHO_TURMA];
		quantidadeAlunos = 0;
	}

	public Turma(String codigo, byte cargaHoraria, Professor professor, Aluno aluno) {

		setCodigo(codigo);
		setCargaHoraria(cargaHoraria);
		setProfessor(professor);
		alunos = new Aluno[TAMANHO_TURMA];
		quantidadeAlunos = 0;
	}

	public String getCodigo() {

		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public byte getCargaHoraria() {

		return cargaHoraria;
	}

	public void setCargaHoraria(byte cargaHoraria) {

		this.cargaHoraria = cargaHoraria;

	}

	public Professor getProfessor() {

		return professor;
	}

	public void setProfessor(Professor professor) {

		this.professor = professor;

	}

	
	public boolean adicionarAluno(Aluno aluno) {

		for (int i = 0; i < TAMANHO_TURMA; i++) {
			
			if (alunos[i] != null && alunos[i].getCPF().equals(aluno.getCPF())) {
				System.out.println("ALUNO "+alunos[i].getNome()+" JÁ CADASTRADO");
				return false;
			}
		}
		
		for (int i = 0; i < TAMANHO_TURMA; i++) {
			if (alunos[i] == null) {
				alunos[quantidadeAlunos] = aluno;
				quantidadeAlunos++;
				return true;
			}
		}

		
		

		if (TAMANHO_TURMA == quantidadeAlunos) {
			return false;

		}

		alunos[quantidadeAlunos] = aluno;
		quantidadeAlunos++;

		return true;

	}

	public boolean removerAluno(Aluno aluno) {

		if (quantidadeAlunos == 0) {
			return false;

		}

		for (int i = 0; i < TAMANHO_TURMA; i++) {
			if (alunos[i].getCPF().equals(aluno.getCPF())) {
				alunos[i] = null;
				alunos = reorganizarVetor(alunos);
				quantidadeAlunos--;
				return true;

			}
		}

		return false;

	}

	private Aluno[] reorganizarVetor(Aluno[] alunos) {

		for (int i = 0; i < alunos.length; i++) {

			for (int j = 0; j < alunos.length; j++) {

				if (alunos[j] == null && alunos.length != j + 1) {

					alunos[j] = alunos[j + 1];
					alunos[j + 1] = null;

				}

			}
		}

		return alunos;

	}


	public void listarAlunos() {
		for (int i = 0; i < quantidadeAlunos; i++) {
				System.out.println(alunos[i].getNome());
//				System.out.println(alunos[i].getSobrenome());
//				System.out.println(alunos[i].getCPF());
//				System.out.println();
		}
		
	}
	
	
	public void teste() {
		
		
		
		for (int i = 0; i < quantidadeAlunos; i++) {
		System.out.println("");

		
		}

		
	
		
	}
	
	
	
	

}
