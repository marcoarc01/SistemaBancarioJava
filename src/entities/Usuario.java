package entities;

public class Usuario {
    private String usuario; // Nome de usuário do usuário
    private String senha; // Senha do usuário
    private double saldo; // Saldo do usuário

    // Construtor da classe para inicializar um novo usuário com nome de usuário, senha e saldo
    public Usuario(String usuario, String senha, double saldo) {
        this.usuario = usuario; // Inicializa o nome de usuário
        this.senha = senha; // Inicializa a senha
        this.saldo = saldo; // Inicializa o saldo
    }

    // Método para obter o nome de usuário
    public String getUsuario() {
        return usuario; // Retorna o nome de usuário
    }

    // Método para obter a senha
    public String getSenha() {
        return senha; // Retorna a senha
    }

    // Método para obter o saldo
    public double getSaldo() {
        return saldo; // Retorna o saldo
    }

    // Método para depositar dinheiro na conta do usuário
    public void depositar(double valor) {
        saldo += valor; // Incrementa o saldo com o valor depositado
    }

    // Método para sacar dinheiro da conta do usuário
    public boolean sacar(double valor){
        if (valor > 0 && saldo >= valor){ // Verifica se o valor é positivo e se há saldo suficiente
            saldo -= valor; // Deduz o valor do saldo
            return true; // Retorna verdadeiro indicando que o saque foi realizado com sucesso
        }
        return false; // Retorna falso indicando que o saque não foi possível
    }

    // Método para transferir dinheiro para outro usuário
    public boolean transferir(Usuario destino, double valor) {
        if (valor > 0 && saldo >= valor) { // Verifica se o valor é positivo e se há saldo suficiente
            saldo -= valor; // Deduz o valor do saldo do usuário atual
            destino.depositar(valor); // Deposita o valor na conta do usuário de destino
            return true; // Retorna verdadeiro indicando que a transferência foi realizada com sucesso
        }
        return false; // Retorna falso indicando que a transferência não foi possível
    }
}
