package Concessionaria.Usuarios;

import Concessionaria.Veiculos.Veiculo;

import java.util.ArrayList;

public abstract class Usuario {
    protected static final ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Veiculo> veiculos = new ArrayList<>();
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

    public static void addUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public static void removeUsuario(Usuario usuario){
        usuarios.remove(usuario);
    }

    public void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }
    public void removeVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }
    public static Usuario login(String usuario, String senha){
        for (Usuario user:
             usuarios) {
            if(user.usuario.equals(usuario) && user.senha.equals(senha)){
                return user;
            }
        }
        return null;
    }

    public ArrayList<Veiculo> getVeiculos(){
        return veiculos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "veiculos: " + veiculos + "\n"+
                "nome: " + nome + "\n" +
                "usuario: " + usuario;
    }
}
