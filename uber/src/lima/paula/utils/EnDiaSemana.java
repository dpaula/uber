package lima.paula.utils;

public enum EnDiaSemana {

	SEGUNDA(1, "Segunda"), TERCA(2, "Terça"), QUARTA(3, "Quarta"), QUINTA(4, "Quinta"), SEXTA(5, "Sexta"), SABADO(6,
			"Sábado"), DOMINGO(7, "Domingo");

	int valor;
	String nome;

	private EnDiaSemana(int valor, String nome) {
		this.valor = valor;
		this.nome = nome;
	}

	public int getValor() {
		return this.valor;
	}

	public String getNome() {
		return this.nome;
	}
}
