import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Banco banco = new Banco("Banco Digital Vitor");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Banco!");

        while (true) {
            System.out.println("Escolha uma opcao: ");
            System.out.println("1. Criar conta");
            System.out.println("2. Deletar conta");
            System.out.println("3. Realizar saque");
            System.out.println("4. Realizar transferência");
            System.out.println("5. Realizar depósito");
            System.out.println("6. Listar contas");
            System.out.println("7. Listar valor total no banco");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF");
                    long cpf = scanner.nextLong();
                    scanner.nextLine();
                    Cliente cliente = new Cliente(nome, cpf);
                    System.out.println("Digite 1 para Conta Corrente");
                    System.out.println("Digite 2 para Conta Poupanca");
                    int x = scanner.nextInt();
                    if (x == 1){
                        Conta conta = new ContaCorrente(cliente);
                        banco.addConta(conta);
                    } else if (x == 2) {
                        Conta conta = new ContaPoupanca(cliente);
                        banco.addConta(conta);
                    }
                    else {
                        System.out.println("Opcao invalida.");
                    }
                    break;
                case 2:
                    System.out.println("Digite o numero da conta:");
                    int numeroConta = scanner.nextInt();

                    Conta contaParaDeletar = banco.getConta(numeroConta);
                    if (contaParaDeletar != null) {
                        String nomeCliente = contaParaDeletar.getCliente().getNome();
                        System.out.println("Conta de: " + nomeCliente);

                        System.out.println("Deseja realmente deletar esta conta?");
                        System.out.println("Pressione 1 para confirmar ou 2 para cancelar:");
                        int op = scanner.nextInt();

                        if (op == 1) {
                            banco.removerConta(numeroConta);
                        } else if (op == 2) {
                            System.out.println("Operação cancelada.");
                        } else {
                            System.out.println("Opção inválida.");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o numero da conta");
                    int conta1 = scanner.nextInt();
                    Conta c1 = banco.getConta(conta1);
                    if (c1 != null){
                        System.out.println("Conta de: "+c1.getCliente().getNome());
                        System.out.println("Total disponivel para sacar: R$" + c1.getSaldo());
                        System.out.println("Digite o valor que deseja sacar: ");
                        double valor = scanner.nextDouble();
                        boolean b1 = c1.sacar(valor);
                        if (b1){
                            System.out.println("Saque realizado com sucesso");
                            System.out.println("Saldo atual: R$"+c1.getSaldo());
                        }
                        else {
                            System.out.println("Saldo insuficiente");
                        }
                    }
                    else {
                        System.out.println("Conta não encontrada");
                    }

                    break;
                case 4:
                    System.out.println("Digite o numero da conta");
                    int conta2 = scanner.nextInt();
                    Conta c2 = banco.getConta(conta2);
                    if (c2 != null){
                        System.out.println("Conta de: "+ c2.getCliente().getNome());
                        System.out.println("Digite a conta destino ");
                        int contadestino = scanner.nextInt();
                        if (banco.getConta(contadestino) != null){
                            System.out.println("Conta destino: "+banco.getConta(contadestino).getCliente().getNome());
                            System.out.println("Digite o valor do deposito: ");
                            double valor = scanner.nextDouble();
                            c2.transferir(valor,banco.getConta(contadestino));
                        }
                        else {
                            System.out.println("Conta destino não encontrada");
                        }

                    }
                    else {
                        System.out.println("Conta não encontrada");
                    }

                    break;
                case 5:
                    System.out.println("Digite o numero da conta");
                    int conta3 = scanner.nextInt();

                    Conta c3 = banco.getConta(conta3);
                    if (c3 != null){
                        System.out.println("Conta destino: " + c3.getCliente().getNome());
                        System.out.println("Digite o valor do deposito: ");
                        double valor = scanner.nextDouble();
                        c3.depositar(valor);
                        System.out.println("Valor depositado com sucesso");
                        System.out.println("Saldo atual: R$"+c3.getSaldo());
                    }
                    else {
                        System.out.println("Conta não encontrada");
                    }
                    break;
                case 6:
                    banco.listarContas();

                    break;
                case 7:
                    banco.calcularValorNoBanco();

                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }


    }
}

