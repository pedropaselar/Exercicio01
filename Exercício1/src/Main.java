
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		int opcao = 0;
		String cpf, nome;
		Lista correntista = new Lista<Correntista>();
		do {
			
			opcao = 0;
			String x = gerarMenu();

			if (x.equals("")) {

			} else if (x.length() > 1) {
				System.out.println("Apenas 1 digito!");

			} else if (x.matches("^[0-9]*$")) {
				opcao = Integer.parseInt(x);

			} else {
				System.out.println("Apenas Números são válidos!");
			}
			if (opcao < 1 || opcao > 6) {
				System.out.println("Opção inválida !");

			} else {

				switch (opcao) {
				case 1:

					nome = JOptionPane.showInputDialog("Informe seu nome");
					cpf = JOptionPane.showInputDialog("Informe seu CPF");
					correntista.inserir(cpf, nome, 0.00);
					

					break;

				case 2:
					cpf = JOptionPane.showInputDialog("Informe seu CPF");
					
					if (correntista.pesquisar(cpf) != null) {
						String saldo = JOptionPane.showInputDialog("Informe o valor de saque");
						correntista.Sacar(cpf, (Double.parseDouble(saldo) * -1));
					} else {
						System.out.println("Correntista não encontrado");
					}
					break;

				case 3:
					cpf = JOptionPane.showInputDialog("Informe seu CPF");
					if (correntista.pesquisar(cpf) != null) {
						String saldo = JOptionPane.showInputDialog("Informe o valor de deposito");
						correntista.Depositar(cpf, (Double.parseDouble(saldo) ));
					} else {
						System.out.println("Correntista não encontrado");
					}
					break;

				case 4:
					correntista.Imprimir();
					break;

				case 5:
					cpf = JOptionPane.showInputDialog("Informe seu CPF");
					correntista.EncerrarConta(cpf);

					break;

				}
			}
		} while (opcao != 6);

	}

	public static String gerarMenu() {
		return JOptionPane.showInputDialog("Escolha uma opcao: \n "
				+ "1. Abrir Conta \n"
				+ "2. Realizar Saque\n"
				+ "3. Realizar Deposito\n"
				+ "4. Relatorio de contas\n"
				+ "5. Encerrar Conta\n"
				+ "6. Encerrar Aplicacao");
	}
}
