package entities;

import java.util.Scanner;

public class Investimento {
    public static double investir(Scanner scanner, Usuario usuario) {
        System.out.println("\nInvestimentos disponíveis:");
        System.out.println("1 - Tesouro Direto");
        System.out.println("2 - Poupança");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                return investirTesouroDireto(scanner, usuario);
            case 2:
                return investirPoupanca(scanner, usuario);
            default:
                System.out.println("Opção inválida.");
                return 0.0;
        }
    }

    private static double investirTesouroDireto(Scanner scanner, Usuario usuario) {
        System.out.println("Investir em Tesouro Direto:");
        System.out.println("O investimento em Tesouro Direto rende 1% ao mês.");

        System.out.print("Digite o valor a ser investido: ");
        double valorInvestido = scanner.nextDouble();
        System.out.print("Digite a quantidade de meses para o investimento: ");
        int meses = scanner.nextInt();

        double valorGanhoJuros = calcularJurosTesouroSelic(valorInvestido, meses);

        if (valorInvestido > usuario.getSaldo()) {
            System.out.println("Você não possui saldo suficiente.");
            return 0.0;
        }

        usuario.depositar(valorGanhoJuros);

        System.out.printf("Valor ganho com juros após %d meses: R$ %.2f%n", meses, valorGanhoJuros);
        System.out.printf("Novo saldo: R$ %.2f%n", usuario.getSaldo());

        return valorGanhoJuros;
    }

    private static double calcularJurosTesouroSelic(double valorInvestido, int meses) {
        double taxaJurosMensal = 0.01;
        double valorGanhoJuros = valorInvestido * taxaJurosMensal * meses;
        return valorGanhoJuros;
    }

    private static double investirPoupanca(Scanner scanner, Usuario usuario) {
        System.out.println("Investir na Poupança:");
        System.out.println("A poupança rende 0,5% ao mês.");

        System.out.print("Digite o valor a ser investido: ");
        double valorInvestido = scanner.nextDouble();
        System.out.print("Digite a quantidade de meses para o investimento: ");
        int meses = scanner.nextInt();

        double valorGanhoJuros = calcularJurosPoupanca(valorInvestido, meses);

        if (valorInvestido > usuario.getSaldo()) {
            System.out.println("Você não possui saldo suficiente.");
            return 0.0;
        }

        usuario.depositar(valorGanhoJuros);

        System.out.printf("Valor ganho com juros após %d meses: R$ %.2f%n", meses, valorGanhoJuros);
        System.out.printf("Novo saldo: R$ %.2f%n", usuario.getSaldo());

        return valorGanhoJuros;
    }

    private static double calcularJurosPoupanca(double valorInvestido, int meses) {
        double taxaJurosMensal = 0.005;
        double valorGanhoJuros = valorInvestido * taxaJurosMensal * meses;
        return valorGanhoJuros;
    }
}