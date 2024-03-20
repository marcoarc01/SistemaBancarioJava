package entities;

public class Conta {
    private Usuario[] usuarios;

    public Conta() {
        this.usuarios = new Usuario[0];
    }

    public boolean adicionarUsuario(String usuario, String senha) {
        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(usuario)) {
                return false;
            }
        }
        Usuario novoUsuario = new Usuario(usuario, senha, 0.0);
        Usuario[] temp = new Usuario[usuarios.length + 1];
        System.arraycopy(usuarios, 0, temp, 0, usuarios.length);
        temp[temp.length - 1] = novoUsuario;
        usuarios = temp;
        return true;
    }

    public Usuario fazerLogin(String usuario, String senha) {
        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(usuario) && user.getSenha().equals(senha)) {
                return user;
            }
        }
        return null;
    }

    public boolean transferirDinheiro(Usuario origem, String destinoUsuario, double valor) {
        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(destinoUsuario)) {
                return origem.transferir(user, valor);
            }
        }
        return false;
    }
}
