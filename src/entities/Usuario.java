package entities;

public class Usuario {
    private String usuario;
    private String senha;
    private double saldo;

    public Usuario(String usuario, String senha, double saldo) {
        this.usuario = usuario;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor){
        if (valor > 0 && saldo >= valor){
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Usuario destino, double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}