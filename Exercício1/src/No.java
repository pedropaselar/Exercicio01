
public class No {
	No esq;
	String cpf;
	String nome;
	Double saldo;
	No dir;

	public No(String cpf, String nome, Double saldo) {
		this.cpf = cpf;
		this.nome = nome;
		this.saldo = saldo;
	}
}