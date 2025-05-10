import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
	
		Scanner leitor = new Scanner(System.in);
		
		Turma turma = new Turma("101", (byte) 3);
	
		boolean encerrar = false;
		
		listarOpcoes();
		
		do {
			System.out.println(ConsoleColors.CYAN);
			System.out.print("--> ");
			String opcao = leitor.next();
			System.out.print(ConsoleColors.RESET);
			
			String nome;
			String sobrenome;
			String cpf;
			
			
			switch (opcao) {
			case "1":
				System.out.print(ConsoleColors.GREEN);
				System.out.println("\nCADASTRO DE ALUNO");
				System.out.print(ConsoleColors.RESET);
				System.out.print("Nome: ");
				System.out.print(ConsoleColors.GREEN);
				nome = leitor.next();
				System.out.print(ConsoleColors.RESET);
				System.out.print("Sobrenome: ");
				System.out.print(ConsoleColors.GREEN);
				sobrenome = leitor.next();
				System.out.print(ConsoleColors.RESET);
				System.out.print("CPF: ");
				System.out.print(ConsoleColors.GREEN);
				cpf = leitor.next();
				System.out.print(ConsoleColors.RESET);
				Aluno aluno = new Aluno(nome, sobrenome, cpf);
				turma.adicionarAluno(aluno);
				break;

			case "2":
				System.out.print(ConsoleColors.RED);
				System.out.println("\nEXCLUIR ALUNO");
				System.out.print(ConsoleColors.RESET);
				System.out.print("INFORME O ");
				System.out.print("CPF: ");
				System.out.print(ConsoleColors.RED);
				cpf = leitor.next();
				System.out.print(ConsoleColors.RESET);
				aluno = new Aluno(null, null, cpf);
				turma.removerAluno(aluno);
				break;
			case "3":
				System.out.print(ConsoleColors.YELLOW);
				System.out.println("\nINCLUIR/ALTERAR PROFESSOR");
				System.out.print(ConsoleColors.RESET);
				System.out.print("Nome: ");
				System.out.print(ConsoleColors.YELLOW);
				nome = leitor.next();
				System.out.print(ConsoleColors.RESET);
				System.out.print("Sobrenome: ");
				System.out.print(ConsoleColors.YELLOW);
				sobrenome = leitor.next();
				System.out.print(ConsoleColors.RESET);
				System.out.print("CPF: ");
				System.out.print(ConsoleColors.YELLOW);
				cpf = leitor.next();
				System.out.print(ConsoleColors.RESET);
				Professor professor = new Professor(nome, sobrenome, cpf);
				turma.alterarProfessor(professor);
				break;

			case "4":
				turma.listarProfessor();
				turma.listarAlunos();

				break;
				
			case "help":
				listarOpcoes();
				break;

			case "0":
				encerrar = true;
				System.out.print(ConsoleColors.RED_BACKGROUND_BRIGHT);
				System.out.println("SYSTEMA ENCERRADO");
				System.out.print(ConsoleColors.RESET);
				break;

			default:
				System.out.print(ConsoleColors.RED_BACKGROUND_BRIGHT);
				System.out.println("CODIGO INVALIDO");
				System.out.print(ConsoleColors.RESET);
			}
			
		} while (encerrar == false);
		
		
		
	leitor.close();
		

		
	}
	
	public static void listarOpcoes() {	
		System.out.print("Digite 0 para encerrar");
		System.out.print("\nDigite 1 para cadastrar um aluno.");
		System.out.print("\nDigite 2 excluir um aluno");
		System.out.print("\nDigite 3 alterar o profressor.");
		System.out.print("\nDigite 4 para listar turma.");
		System.out.println("\nDigite 'help' para listar opções");
	}
	
	public static void soliticarInformaçoes() {
		
		
	}
	
	
}
