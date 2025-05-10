
public class Principal {

	public static void main(String[] args) {
		
	
	
		Professor professor = new Professor("Carlos","Silva","123.456.789-10");
		
		Aluno aluno = new Aluno("Alex","Jung","123.456.789-10");
		Aluno aluno2 = new Aluno("Pedro","Silva","111.111.111-11");
		Aluno aluno3 = new Aluno("Alice","Maria","999.999.999-99");
		Aluno aluno4 = new Aluno("Ana","julia","000.000.000-00");
			
		Turma turma = new Turma("101", (byte) 3,professor, aluno);
		
		
		
	
		turma.adicionarAluno(aluno);
		turma.adicionarAluno(aluno2);
		turma.adicionarAluno(aluno3);
		turma.adicionarAluno(aluno4);
		
		turma.removerAluno(aluno2);
	
		turma.listarAlunos();
		
				
	
		

		
	}
}
