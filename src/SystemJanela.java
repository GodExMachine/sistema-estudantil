import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SystemJanela {

	public static void iniciaSistemaJanela() {

		JFrame janela = new JFrame("Sistema Estudantil");

		Turma turma = new Turma("101", (byte) 3);

		janela.setSize(500, 500);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(null);

		janela.setVisible(true);

		JPanel painelConteudo = new JPanel();
		painelConteudo.setLayout(null);
		painelConteudo.setBounds(0, 0, 500, 500);
		janela.add(painelConteudo);

		// Adicionar um novo aluno
		JButton botaoNovoAluno = new JButton("Adicionar aluno");
		botaoNovoAluno.setBounds(175, 100, 150, 30);
		painelConteudo.add(botaoNovoAluno);

		// remover um aluno
		JButton botaoRemoverAluno = new JButton("Remover aluno");
		botaoRemoverAluno.setBounds(175, 150, 150, 30);
		painelConteudo.add(botaoRemoverAluno);

		// Trocar o Professor
		JButton botaoNovoProfessor = new JButton("Adicionar professor");
		botaoNovoProfessor.setBounds(175, 200, 150, 30);
		painelConteudo.add(botaoNovoProfessor);

		// Listar Turma
		JButton botaoListarTurma = new JButton("Listar turma");
		botaoListarTurma.setBounds(175, 250, 150, 30);
		painelConteudo.add(botaoListarTurma);
		
		Runnable mostrarMenuPrincipal = () -> {
			painelConteudo.removeAll();
			painelConteudo.add(botaoNovoAluno);
			painelConteudo.add(botaoRemoverAluno);
			painelConteudo.add(botaoNovoProfessor);
			painelConteudo.add(botaoListarTurma);
			painelConteudo.revalidate();
			painelConteudo.repaint();
		};
		
		

		// listar turma botao
		botaoListarTurma.addActionListener(e -> {

			turma.listarProfessor();
			turma.listarAlunos();

			JButton botaoVoltar = new JButton("Voltar");
			botaoVoltar.setBounds(175, 250, 150, 30);
			painelConteudo.add(botaoVoltar);
			botaoVoltar.addActionListener(ev -> {
				mostrarMenuPrincipal.run();
			});
			painelConteudo.revalidate();
			painelConteudo.repaint();
		});

		janela.setVisible(true);
		
		botaoListarTurma.addActionListener(e -> {
			painelConteudo.removeAll();

			JLabel titulo = new JLabel("Turma:");
			titulo.setBounds(20, 0, 200, 20);
			painelConteudo.add(titulo);

			// Captura a saída do console
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(buffer);
			PrintStream originalOut = System.out;
			System.setOut(ps);

			// Chama os métodos que imprimem no console
			turma.listarProfessor();
			turma.listarAlunos();

			// Restaura o System.out original
			System.out.flush();
			System.setOut(originalOut);

			// Mostra o conteúdo no JTextArea
			JTextArea areaTexto = new JTextArea(buffer.toString());
			areaTexto.setEditable(false);
			areaTexto.setBounds(20, 30, 440, 300);
			painelConteudo.add(areaTexto);
			painelConteudo.add(criarBotaoVoltar(mostrarMenuPrincipal, 420));
			painelConteudo.revalidate();
			painelConteudo.repaint();
		});
		
		

		// Ação do botão "Adicionar Aluno"
		botaoNovoAluno.addActionListener(e -> {
			painelConteudo.removeAll();

			// Nome
			JLabel nomeAluno = new JLabel("Nome do aluno:");
			nomeAluno.setBounds(175, 50, 150, 20);
			painelConteudo.add(nomeAluno);
			JTextField textoNomeAluno = new JTextField();
			textoNomeAluno.setBounds(175, 70, 150, 30);
			painelConteudo.add(textoNomeAluno);

			// Sobrenome
			JLabel sobrenomeAluno = new JLabel("Sobrenome do aluno:");
			sobrenomeAluno.setBounds(175, 120, 150, 20);
			painelConteudo.add(sobrenomeAluno);
			JTextField textoSobrenomeAluno = new JTextField();
			textoSobrenomeAluno.setBounds(175, 140, 150, 30);
			painelConteudo.add(textoSobrenomeAluno);

			// CPF
			JLabel alunoCPF = new JLabel("CPF do aluno:");
			alunoCPF.setBounds(175, 190, 150, 20);
			painelConteudo.add(alunoCPF);
			JTextField textoAlunoCPF = new JTextField();
			textoAlunoCPF.setBounds(175, 210, 150, 30);
			painelConteudo.add(textoAlunoCPF);

			// Botão Adicionar
			JButton AdicionarAluno = new JButton("Adicionar");
			AdicionarAluno.setBounds(175, 270, 150, 30);
			painelConteudo.add(AdicionarAluno);

			AdicionarAluno.addActionListener(ev -> {
				String nome = textoNomeAluno.getText();
				String sobrenome = textoSobrenomeAluno.getText();
				String cpf = textoAlunoCPF.getText();

				Aluno aluno = new Aluno(nome, sobrenome, cpf);
				boolean adicionado = turma.adicionarAluno(aluno);

				if (adicionado) {
					JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso!");
					textoNomeAluno.setText("");
					textoSobrenomeAluno.setText("");
					textoAlunoCPF.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Erro: CPF já cadastrado ou turma cheia.", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
				//limpar os campos
				textoNomeAluno.setText("");
				textoSobrenomeAluno.setText("");
				textoAlunoCPF.setText("");
			});

			// Botão Voltar
			JButton botaoVoltar = new JButton("Voltar");
			botaoVoltar.setBounds(175, 320, 150, 30);
			painelConteudo.add(botaoVoltar);

			botaoVoltar.addActionListener(ev -> {
				mostrarMenuPrincipal.run();
			});

			painelConteudo.revalidate();
			painelConteudo.repaint();
		});

		
		// Ação do botão "Remover Aluno"
		botaoRemoverAluno.addActionListener(e -> {
			painelConteudo.removeAll();

			// CPF
			JLabel alunoCPF = new JLabel("CPF do aluno:");
			alunoCPF.setBounds(175, 100, 200, 20);
			painelConteudo.add(alunoCPF);

			JTextField textoAlunoCPF = new JTextField();
			textoAlunoCPF.setBounds(175, 120, 150, 30);
			painelConteudo.add(textoAlunoCPF);

			// Botão Remover
			JButton removerAluno = new JButton("Remover");
			removerAluno.setBounds(175, 180, 150, 30);
			painelConteudo.add(removerAluno);

			removerAluno.addActionListener(ev -> {
				String cpf = textoAlunoCPF.getText().trim();

				if (cpf.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o CPF!", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Cria um Aluno com dados genéricos, só com o CPF
				Aluno aluno = new Aluno("x", "x", cpf);
				boolean removido = turma.removerAluno(aluno);

				if (removido) {
					JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
					textoAlunoCPF.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Aluno não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			});

			// Botão Voltar
			painelConteudo.add(criarBotaoVoltar(mostrarMenuPrincipal, 230));

			painelConteudo.revalidate();
			painelConteudo.repaint();
		});

		// Botão "Adicionar professor"
		botaoNovoProfessor.addActionListener(e -> {
			painelConteudo.removeAll();

			// Nome
			JLabel nomeProfessor = new JLabel("Nome do professor:");
			nomeProfessor.setBounds(175, 50, 150, 20);
			painelConteudo.add(nomeProfessor);
			JTextField textoNomeProfessor = new JTextField();
			textoNomeProfessor.setBounds(175, 70, 150, 30);
			painelConteudo.add(textoNomeProfessor);

			// Sobrenome
			JLabel sobrenomeProfessor = new JLabel("Sobrenome do professor:");
			sobrenomeProfessor.setBounds(175, 120, 180, 20);
			painelConteudo.add(sobrenomeProfessor);
			JTextField textoSobrenomeProfessor = new JTextField();
			textoSobrenomeProfessor.setBounds(175, 140, 150, 30);
			painelConteudo.add(textoSobrenomeProfessor);

			// CPF
			JLabel professorCPF = new JLabel("CPF do professor:");
			professorCPF.setBounds(175, 190, 150, 20);
			painelConteudo.add(professorCPF);
			JTextField textoProfessorCPF = new JTextField();
			textoProfessorCPF.setBounds(175, 210, 150, 30);
			painelConteudo.add(textoProfessorCPF);

			// Botão Adicionar
			JButton adicionarProfessor = new JButton("Adicionar");
			adicionarProfessor.setBounds(175, 270, 150, 30);
			painelConteudo.add(adicionarProfessor);

			adicionarProfessor.addActionListener(ev -> {
				String nome = textoNomeProfessor.getText();
				String sobrenome = textoSobrenomeProfessor.getText();
				String cpf = textoProfessorCPF.getText();

				Professor professor = new Professor(nome, sobrenome, cpf);
				turma.setProfessor(professor);

				JOptionPane.showMessageDialog(null, "Professor adicionado com sucesso!");

				// Limpa os campos
				textoNomeProfessor.setText("");
				textoSobrenomeProfessor.setText("");
				textoProfessorCPF.setText("");
			});

			// Botão Voltar
			painelConteudo.add(criarBotaoVoltar(mostrarMenuPrincipal, 320));

			painelConteudo.revalidate();
			painelConteudo.repaint();
		});

	}

	
	
	
	
	
	private static JButton criarBotaoVoltar(Runnable acao, int y) {
		JButton botao = new JButton("Voltar");
		botao.setBounds(175, y, 150, 30);
		botao.addActionListener(ev -> acao.run());
		return botao;
	}
	
	
	
	
	
	
	
	
	
	
}

	
// 		String name = JOptionPane.showInputDialog("What is your name?");

//		String.format("Welcome, %s, to Java Programming!", name);

//		JOptionPane.showMessageDialog(null, "olá");
		
	