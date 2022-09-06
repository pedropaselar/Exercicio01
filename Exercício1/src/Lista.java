
public class Lista<T> {
	private No inicio;
	private No fim;
	int tamanho;

	public void inserir(String cpf, String nome, Double saldo) {
		if(pesquisar(cpf) == null) {
		No aux = new No(cpf, nome, saldo);
		if (tamanho == 0) {
			fim = aux;
		} else {
			inicio.esq = aux;
			aux.dir = inicio;
		}
		inicio = aux;
		tamanho++;
		}
		else {
			System.out.println("CPF ja possui uma conta");
		}
	}

	public void inserirFim(String cpf, String nome, Double saldo) {
		No aux = new No(cpf, nome, saldo);
		if (tamanho == 0) {
			inicio = aux;
		} else {
			fim.dir = aux;
			aux.esq = fim;
		}
		fim = aux;
		tamanho++;
	}


	public No pesquisar(String cpf) {
		No aux = inicio;
		while (aux != null) {
			if (aux.cpf.equalsIgnoreCase(cpf)) {
				break;
			}
			aux = aux.dir;
		}
		return aux;
	}
	
	public No EncerrarConta(String cpf) {
		No aux = inicio;
		
		if(tamanho == 1) {
			inicio = null;
			tamanho --;
		} else {
		
			while (aux != null) {
			if (aux.cpf.equalsIgnoreCase(cpf)) {
				aux.dir.esq = aux.esq;
				aux.esq.dir = aux.dir;
			}
			aux = aux.dir;
			tamanho --;
		}
	}
		return aux;
	}
	
	public No Imprimir() {
		No aux = inicio;
		while (aux != null) {
			System.out.println("Nome: " + aux.nome + " - CPF: " + aux.cpf + " - Saldo: " + aux.saldo);
			aux = aux.dir;
		}
		return aux;
	}

	public void Sacar(String cpf, Double saldo) {
		No aux = pesquisar(cpf);
		if(aux != null && aux.saldo > saldo) {
		aux.saldo += saldo;
		}else
		{
			System.out.println("Saldo insuficiente");
		}


	}
	
	public void Depositar(String cpf, Double saldo) {
		No aux = pesquisar(cpf);
		if(aux != null && saldo > 0) {
		aux.saldo += saldo;
		}


	}

}
