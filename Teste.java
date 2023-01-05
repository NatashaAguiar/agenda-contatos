package class53;

import java.util.Scanner;

public class Teste {

	private static final Scanner scan = null;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Agenda agenda = new Agenda();

		int opcao = 1;

		while (opcao != 3) {
			opcao = ObterOpcaoMenu(scan);
			if (opcao == 1) {
				consultarContato(scan, agenda);
			} else if (opcao == 2) {
				AdicionarContato(scan, agenda);
			}
		}
	}

	public static void AdicionarContato(Scanner scan, Agenda agenda) {
		try {
			System.out.println("Para criar um contato entre com as informações!");
			String nome = leInformacaoString(scan, "Entre com o nome do contato");
			String telefone = leInformacaoString(scan, "Entre com o telefone do contato");
			String email = leInformacaoString(scan, "Entre com o email do contato");

			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setEmail(email);
			contato.setTelefone(telefone);

			System.out.println("Contato a ser criado: ");
			System.out.println(contato);

			agenda.AdicionarContato(contato);
		} catch (AgendaCheiaExeption e) {
			System.out.println(e.getMessage());
			System.out.println("Contatos da agenda");
			System.out.println(agenda);
		}
	}

	public static void consultarContato(Scanner scan, Agenda agenda) {
		String nomeContato = leInformacaoString(scan, "Entre com o nome do contatoa ser pesquisado: ");
		try {
			if (agenda.consultaContatoPorNome(nomeContato) >= 0) {
				System.out.println("Contato existe");
			}
		} catch (ContatoNaoExisteExeption e) {
			System.out.println(e.getMessage());

		}
	}

	public static String leInformacaoString(Scanner scan, String mensagem) {
		System.out.println(mensagem);
		String entrada = scan.nextLine();
		return entrada;
	}

	public static int ObterOpcaoMenu(Scanner scan) {

		boolean entradaValida = false;
		int opcao = 3;
		while (!entradaValida) {
			System.out.println("Digite a opção desejada");
			System.out.println("1: Consultar Contato");
			System.out.println("2: Adicionar Contato");
			System.out.println("3: Sair");
			
			try {
				String entrada = scan.nextLine();
				opcao = Integer.parseInt(entrada);
				
				if (opcao == 1 || opcao == 2 || opcao == 3) {
					entradaValida = true;
				}else {
					throw new Exception("Entrada inválida");
				}
			}
			catch (Exception e) {
				System.out.println("Entrada inválida, digite novamente\n");
			}
		}
		return opcao;

	}

}
