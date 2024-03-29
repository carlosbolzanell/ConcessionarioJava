package Concessionaria.Usuarios;

import Concessionaria.Exceptions.UsuarioExistenteException;
import Concessionaria.Veiculos.Veiculo;

import java.util.ArrayList;

public abstract class Usuario {
    protected static final ArrayList<Usuario> usuarios = new ArrayList<>();
    private final ArrayList<Veiculo> veiculos = new ArrayList<>();
    private final int ID = usuarios.size()+1;
    private String nome;
    private String usuario;
    private String senha;

    public Usuario(String nome, String usuario, String senha){
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
    public static Usuario procurarUsuario(String usuario){
        for (Usuario user:
             usuarios) {
            if(user.usuario.equals(usuario)){
                return user;
            }
        }
        return null;
    }
    public static Usuario procurarUsuario(int id){
        for(Usuario usuario : usuarios){
            if(usuario.getId() == id){
                return usuario;
            }
        }
        return null;
    }
    public static void verificarUsuario(String usuario) throws UsuarioExistenteException {
        for (Usuario user:
                usuarios) {
            if(user.usuario.equals(usuario)){
                throw new UsuarioExistenteException();
            }
        }
    }
    public String menu(){
        return """
                Bem vindo a concessionaria
                1-Ver veiculos em estoque
                2-Ver detalhes de um veiculo
                3-Ver meus veiculos
                """;
    }
    public int getId(){
        return this.ID;
    }

    public void addUsuario(){
        usuarios.add(this);
    } //Não static, por que já existe o usuario

    public void removeUsuario(){
        usuarios.remove(this);
    }

    public void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }
    public void removeVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }
    public static Usuario login(String usuario, String senha){
        for (Usuario user: usuarios) {
            if(user.usuario.equals(usuario) && user.senha.equals(senha)){
                return user;
            }
        }
        return null;
    }

    public ArrayList<Veiculo> getVeiculos(){
        return veiculos;
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString() {
        return "veiculos: " + veiculos + "\n"+
                "nome: " + nome + "\n" +
                "usuario: " + usuario;
    }
}
