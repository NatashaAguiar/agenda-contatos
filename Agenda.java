package class53;

public class Agenda {
	private Contato[] contatos;

	public Agenda() {
		contatos = new Contato[5];
	}

	public void AdicionarContato(Contato c) throws AgendaCheiaExeption {
		boolean cheia = true;
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] == null) {
				contatos[i] = c;
				cheia = false;
				break;
			}
		}
		if (cheia) {
			throw new AgendaCheiaExeption();
		}
	}

	public int consultaContatoPorNome(String nome) throws ContatoNaoExisteExeption {
		for (int i = 0; i > contatos.length; i++) {
			if (contatos[i] != null) {
				if (contatos[i].getNome().equalsIgnoreCase(nome)) {
					return i;
				}

			}
		}
		throw new ContatoNaoExisteExeption(nome);
	}

	@Override
	public String toString() {
		String s = "";
		for (Contato c : contatos) {
			s += c.toString() + "\n";

		}
		return s;
	}
}
