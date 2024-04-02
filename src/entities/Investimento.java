package entities;

import java.util.Scanner;

public class Investimento {
    // Método principal para realizar investimentos
    public static double investir(Scanner scanner, Usuario usuario) {
        System.out.println("\nInvestimentos disponíveis:");
        System.out.println("1 - Tesouro Direto");
        System.out.println("2 - Poupança");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário
        switch (opcao) {
            case 1:
                return investirTesouroDireto(scanner, usuario); // Realiza o investimento em Tesouro Direto
            case 2:
                return investirPoupanca(scanner, usuario); // Realiza o investimento na Poupança
            default:
                System.out.println("Opção inválida.");
                return 0.0; // Retorna 0.0 se a opção for inválida
        }
    }

    // Método para realizar o investimento em Tesouro Direto
    private static double investirTesouroDireto(Scanner scanner, Usuario usuario) {
        System.out.println("Investir em Tesouro Direto:");
        System.out.println("O investimento em Tesouro Direto rende 1% ao mês.");

        // Solicita ao usuário o valor e a quantidade de meses para o investimento
        System.out.print("Digite o valor a ser investido: ");
        double valorInvestido = scanner.nextDouble();
        System.out.print("Digite a quantidade de meses para o investimento: ");
        int meses = scanner.nextInt();

        double valorGanhoJuros = calcularJurosTesouroSelic(valorInvestido, meses); // Calcula o valor ganho com juros

        // Verifica se o usuário possui saldo suficiente para realizar o investimento
        if (valorInvestido > usuario.getSaldo()) {
            System.out.println("Você não possui saldo suficiente.");
            return 0.0;
        }

        usuario.depositar(valorGanhoJuros); // Deposita o valor ganho com juros na conta do usuário

        // Exibe o valor ganho com juros e o novo saldo do usuário
        System.out.printf("Valor ganho com juros após %d meses: R$ %.2f%n", meses, valorGanhoJuros);
        System.out.printf("Novo saldo: R$ %.2f%n", usuario.getSaldo());

        return valorGanhoJuros; // Retorna o valor ganho com juros
    }

    // Método para calcular o valor ganho com juros do Tesouro Direto
    private static double calcularJurosTesouroSelic(double valorInvestido, int meses) {
        double taxaJurosMensal = 0.01;
        double valorGanhoJuros = valorInvestido * taxaJurosMensal * meses;
        return valorGanhoJuros;
    }

    // Método para realizar o investimento na Poupança
    private static double investirPoupanca(Scanner scanner, Usuario usuario) {
        System.out.println("Investir na Poupança:");
        System.out.println("A poupança rende 0,5% ao mês.");

        // Solicita ao usuário o valor e a quantidade de meses para o investimento
        System.out.print("Digite o valor a ser investido: ");
        double valorInvestido = scanner.nextDouble();
        System.out.print("Digite a quantidade de meses para o investimento: ");
        int meses = scanner.nextInt();

        double valorGanhoJuros = calcularJurosPoupanca(valorInvestido, meses); // Calcula o valor ganho com juros

        // Verifica se o usuário possui saldo suficiente para realizar o investimento
        if (valorInvestido > usuario.getSaldo()) {
            System.out.println("Você não possui saldo suficiente.");
            return 0.0;
        }

        usuario.depositar(valorGanhoJuros); // Deposita o valor ganho com juros na conta do usuário

        // Exibe o valor ganho com juros e o novo saldo do usuário
        System.out.printf("Valor ganho com juros após %d meses: R$ %.2f%n", meses, valorGanhoJuros);
        System.out.printf("Novo saldo: R$ %.2f%n", usuario.getSaldo());

        return valorGanhoJuros; // Retorna o valor ganho com juros
    }

    // Método para calcular o valor ganho com juros da Poupança
    private static double calcularJurosPoupanca(double valorInvestido, int meses) {
        double taxaJurosMensal = 0.005;
        double valorGanhoJuros = valorInvestido * taxaJurosMensal * meses;
        return valorGanhoJuros;
    }
}
