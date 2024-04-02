package Aplication;

import java.util.Scanner;
import entities.Investimento;
import entities.Usuario;
import entities.Conta;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta = new Conta(); // Cria uma nova conta para gerenciar os usuários

        while (true) { // Loop principal do programa
            System.out.println("\nSeja bem vindo ao Banco:");
            System.out.print("1 - Login \n2 - Criar conta \nEscolha uma opção: ");
            int opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) { // Executa a ação de acordo com a opção escolhida
                case 1:
                    fazerLogin(scanner, conta); // Chama a função para fazer login
                    break;
                case 2:
                    criarNovoLogin(scanner, conta); // Chama a função para criar uma nova conta
                    break;
                default:
                    System.out.println("Opção inválida. Verifique e tente novamente");
            }
        }
    }

    private static void fazerLogin(Scanner scanner, Conta conta) {
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine(); // Lê o nome de usuário
        System.out.print("Senha: ");
        String senha = scanner.nextLine(); // Lê a senha
        Usuario usuarioLogado = conta.fazerLogin(usuario, senha); // Tenta fazer o login com as credenciais fornecidas
        if (usuarioLogado != null) {
            exibirMenuOperacoes(scanner, usuarioLogado, conta); // Se o login for bem-sucedido, exibe o menu de operações
        } else {
            System.out.println("Usuário ou senha incorretos. Verifique e Tente novamente");
        }
    }

    private static void criarNovoLogin(Scanner scanner, Conta conta) {
        System.out.print("Digite o novo nome de usuário: ");
        String novoUsuario = scanner.nextLine(); // Lê o novo nome de usuário
        System.out.print("Digite a nova senha: ");
        String novaSenha = scanner.nextLine(); // Lê a nova senha
        if (conta.adicionarUsuario(novoUsuario, novaSenha)) { // Tenta adicionar o novo usuário
            System.out.println("Sua conta foi criada com sucesso");
        } else {
            System.out.println("Esse Usuário já existe. Escolha outro nome de usuário.");
        }
    }

    private static void exibirMenuOperacoes(Scanner scanner, Usuario usuario, Conta conta) {
        while (true) { // Loop do menu de operações
            System.out.println("\nOperações:");
            System.out.println("1 - Consultar o saldo");
            System.out.println("2 - Depositar dinheiro");
            System.out.println("3 - Sacar dinheiro");
            System.out.println("4 - Transferir dinheiro");
            System.out.println("5 - Investir");
            System.out.println("6 - Sair da conta");
            System.out.println("7 - Encerrar");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt(); // Lê a opção escolhida
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) { // Executa a ação de acordo com a opção escolhida
                case 1:
                    System.out.printf("Saldo atual: R$ %.2f%n", usuario.getSaldo()); // Consulta o saldo do usuário
                    break;
                case 2:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble(); // Lê o valor a ser depositado
                    usuario.depositar(valorDeposito); // Realiza o depósito
                    System.out.printf("Depósito realizado com sucesso. Novo saldo: R$ %.2f%n", usuario.getSaldo());
                    break;
                case 3:
                    System.out.print("Digite o valor que deseja sacar: ");
                    double valorSaque = scanner.nextDouble(); // Lê o valor a ser sacado
                    if (usuario.sacar(valorSaque)){ // Tenta realizar o saque
                        System.out.printf("Saque realizado. Novo saldo: R$ %.2f%n", usuario.getSaldo());
                    }else {
                        System.out.println("Saque não realizado. Saldo insuficiente");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome de usuário para transferência: ");
                    String destinoUsuario = scanner.nextLine(); // Lê o nome de usuário de destino
                    System.out.print("Digite o valor a ser transferido: ");
                    double valorTransferencia = scanner.nextDouble(); // Lê o valor a ser transferido
                    if (conta.transferirDinheiro(usuario, destinoUsuario, valorTransferencia)) { // Tenta transferir o dinheiro
                        System.out.printf("Transferência realizada com sucesso. Novo saldo: R$ %.2f%n", usuario.getSaldo());
                    } else {
                        System.out.println("Transferência não realizada. Saldo insuficiente ou usuário de destino não encontrado.");
                    }
                    break;
                case 5:
                    Investimento.investir(scanner, usuario); // Chama a função para realizar um investimento
                    break;
                case 6:
                    System.out.println("Voce saiu da conta com sucesso!"); // Exibe mensagem de saída da conta
                    return; // Retorna para o menu principal
                case 7:
                    encerrarPrograma(); // Chama a função para encerrar o programa
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void encerrarPrograma() {
        System.out.println("O programa foi encerrado."); // Exibe mensagem de encerramento do programa
        System.exit(0); // Encerra o programa
    }
}
