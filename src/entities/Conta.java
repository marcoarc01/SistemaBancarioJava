package entities;

public class Conta {
    private Usuario[] usuarios; // Array para armazenar os usuários

    public Conta() {
        this.usuarios = new Usuario[0]; // Inicializa o array de usuários com tamanho zero
    }

    // Método para adicionar um novo usuário à conta
    public boolean adicionarUsuario(String usuario, String senha) {
        // Verifica se o usuário já existe na conta
        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(usuario)) {
                return false; // Retorna falso se o usuário já existir
            }
        }
        // Cria um novo usuário e o adiciona ao array de usuários
        Usuario novoUsuario = new Usuario(usuario, senha, 0.0);
        Usuario[] temp = new Usuario[usuarios.length + 1];
        System.arraycopy(usuarios, 0, temp, 0, usuarios.length);
        temp[temp.length - 1] = novoUsuario;
        usuarios = temp;
        return true; // Retorna verdadeiro indicando que o usuário foi adicionado com sucesso
    }

    // Método para fazer login de um usuário
    public Usuario fazerLogin(String usuario, String senha) {
        // Percorre o array de usuários para encontrar o usuário com o nome de usuário e senha correspondentes
        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(usuario) && user.getSenha().equals(senha)) {
                return user; // Retorna o usuário se encontrado
            }
        }
        return null; // Retorna nulo se o usuário não for encontrado
    }

    // Método para transferir dinheiro entre usuários
    public boolean transferirDinheiro(Usuario origem, String destinoUsuario, double valor) {
        // Percorre o array de usuários para encontrar o destinatário da transferência
        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(destinoUsuario)) {
                return origem.transferir(user, valor); // Chama o método transferir do usuário de origem
            }
        }
        return false; // Retorna falso se o destinatário não for encontrado
    }
}
