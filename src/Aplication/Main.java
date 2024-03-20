package Aplication;

import java.util.Scanner;

import entities.Investimento;
import entities.Usuario;
import entities.Conta;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta = new Conta();

        while (true) {
            System.out.println("\nSeja bem vindo ao Banco:");
            System.out.print("1 - Login \n2 - Criar conta \nEscolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    fazerLogin(scanner, conta);
                    break;
                case 2:
                    criarNovoLogin(scanner, conta);
                    break;
                default:
                    System.out.println("Opção inválida. Verifique e tente novamente");
            }
        }
    }

    private static void fazerLogin(Scanner scanner, Conta conta) {
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        Usuario usuarioLogado = conta.fazerLogin(usuario, senha);
        if (usuarioLogado != null) {
            exibirMenuOperacoes(scanner, usuarioLogado, conta);
        } else {
            System.out.println("Usuário ou senha incorretos. Verifique e Tente novamente");
        }
    }

    private static void criarNovoLogin(Scanner scanner, Conta conta) {
        System.out.print("Digite o novo nome de usuário: ");
        String novoUsuario = scanner.nextLine();
        System.out.print("Digite a nova senha: ");
        String novaSenha = scanner.nextLine();
        if (conta.adicionarUsuario(novoUsuario, novaSenha)) {
            System.out.println("Sua conta foi criada com sucesso");
        } else {
            System.out.println("Esse Usuário já existe. Escolha outro nome de usuário.");
        }
    }

    private static void exibirMenuOperacoes(Scanner scanner, Usuario usuario, Conta conta) {
        while (true) {
            System.out.println("\nOperações:");
            System.out.println("1 - Consultar o saldo");
            System.out.println("2 - Depositar dinheiro");
            System.out.println("3 - Sacar dinheiro");
            System.out.println("4 - Transferir dinheiro");
            System.out.println("5 - Investir");
            System.out.println("6 - Sair da conta");
            System.out.println("7 - Encerrar");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.printf("Saldo atual: R$ %.2f%n", usuario.getSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    usuario.depositar(valorDeposito);
                    System.out.printf("Depósito realizado com sucesso. Novo saldo: R$ %.2f%n", usuario.getSaldo());
                    break;
                case 3:
                    System.out.print("Digite o valor que deseja sacar: ");
                    double valorSaque = scanner.nextDouble();
                    if (usuario.sacar(valorSaque)){
                        System.out.printf("Saque realizado. Novo saldo: R$ %.2f%n", usuario.getSaldo());
                    }else {
                        System.out.println("Saque não realizado. Saldo insuficiente");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome de usuário para transferência: ");
                    String destinoUsuario = scanner.nextLine();
                    System.out.print("Digite o valor a ser transferido: ");
                    double valorTransferencia = scanner.nextDouble();
                    if (conta.transferirDinheiro(usuario, destinoUsuario, valorTransferencia)) {
                        System.out.printf("Transferência realizada com sucesso. Novo saldo: R$ %.2f%n", usuario.getSaldo());
                    } else {
                        System.out.println("Transferência não realizada. Saldo insuficiente ou usuário de destino não encontrado.");
                    }
                    break;
                case 5:
                    Investimento.investir(scanner, usuario);
                    break;
                case 6:
                    System.out.println("Voce saiu da conta com sucesso!");
                    return;
                case 7:
                    encerrarPrograma();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    private static void encerrarPrograma() {
        System.out.println("O programa foi encerrado.");
        System.exit(0);
    }
}