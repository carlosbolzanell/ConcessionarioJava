package Concessionaria.Usuarios;

import Concessionaria.Veiculos.*;

import java.util.ArrayList;

public class Gerente extends Funcionario{

    public Gerente(String nome, String usuario, String senha, double salario, int codigo) {
        super(nome, usuario, senha, salario, codigo, 0.02);
    }

    public void cadastrarVeiculo(Veiculo veiculo){
        Veiculo.addVeiculo(veiculo);
    }
    public void removerVeiculo(Veiculo veiculo){
        Veiculo.removerVeiculo(veiculo);
    }
    public void editarVeiculo(Veiculo veiculo){
        int index = Veiculo.getVeiculos().indexOf(veiculo);
        Veiculo.getVeiculos().set(index, veiculo);
    }
    public void cadastrarUsuario(Usuario usuario){
        if(!(usuario instanceof Gerente)){
            Usuario.addUsuario(usuario);
        }
    }
    public void removerUsuario(Usuario usuario){
        if(!(usuario instanceof Gerente)){
            Usuario.removeUsuario(usuario);
        }
    }
    public void editUsuario(Usuario usuario){
        int index = usuarios.indexOf(usuario);
        usuarios.set(index, usuario);
    }
    public String verVendedores(){
        String vendedores = "";
        for (Usuario vendedor:
             usuarios) {
            if(vendedor instanceof Vendedor){
                vendedores += vendedor.toString();
            }
        }
        return vendedores;
    }

    public String verClientes(){
        String clientes = "";
        for (Usuario cliente:
                usuarios) {
            if(cliente instanceof Vendedor){
                clientes += cliente.toString();
            }
        }
        return clientes;
    }
    public ArrayList<String> verPagamentos(){
        ArrayList<String> pagamentos = new ArrayList<>();
        for (Usuario funcionario:
             usuarios) {
            if(funcionario instanceof Vendedor){
                pagamentos.add(((Vendedor) funcionario).getPagamentos().toString());
            }
        }
        return pagamentos;
    }
    public String verPagamento(Vendedor usuario){
        return usuario.getPagamentos().toString();
    }
}
