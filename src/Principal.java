import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
	
		Scanner leitor = new Scanner(System.in);
		
		Turma turma = new Turma("101", (byte) 3);
	
		boolean encerrar = false;
		
		do {
			System.out.print("Digite 0 para encerrar");
			System.out.print("\nDigite 1 para cadastrar um aluno.");
			System.out.print("\nDigite 2 remover um aluno");
			System.out.print("\nDigite 3 alterar o profressor.");
			System.out.println("\nDigite 4 para listar turma.");
			System.out.print("--> ");
			
			int opcao = leitor.nextInt();

			switch (opcao) {
			case 1:
				System.out.print("Nome: ");
				String nome = leitor.next();
				System.out.print("Sobrenome: ");
				String sobrenome = leitor.next();
				System.out.print("CPF: ");
				String cpf = leitor.next();
				Aluno aluno = new Aluno(nome, sobrenome, cpf);
				turma.adicionarAluno(aluno);
				break;

			case 2:
				System.out.println("Digite o CPF do aluno que deseja remover");
				cpf = leitor.next();
				aluno = new Aluno("A", "A", cpf);
				turma.removerAluno(aluno);
				break;
			case 3:
				System.out.print("Nome: ");
				nome = leitor.next();
				System.out.print("Sobrenome: ");
				sobrenome = leitor.next();
				System.out.print("CPF: ");
				cpf = leitor.next();
				Professor professor = new Professor(nome, sobrenome, cpf);
				turma.alterarProfessor(professor);
				break;
				
				
			case 4:
				turma.listarProfessor();
				turma.listarAlunos();
				
				break;

			default:
				encerrar = true;
			}

		} while (encerrar == false);
		
		
		
	leitor.close();
		

		
	}
}
