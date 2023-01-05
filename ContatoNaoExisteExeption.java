package class53;

public class ContatoNaoExisteExeption extends Exception {

	private String nomeContato;

	public ContatoNaoExisteExeption(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	@Override
	public String getMessage() {

		return "Contato " + nomeContato + "Não Exite na Agenda!";
	}
}
