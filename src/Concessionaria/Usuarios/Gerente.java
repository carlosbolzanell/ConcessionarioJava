package Concessionaria.Usuarios;

import Concessionaria.Veiculos.*;

import java.util.ArrayList;

public class Gerente extends Funcionario{

    public Gerente(String nome, String usuario, String senha, double salario, int codigo) {
        super(nome, usuario, senha, salario, codigo, 0.02);
    }
    public String menu(){
        return super.menu() +
                """
                7-Cadastrar Veiculo
                8-Remover Veículo
                9-Editar Veículo
                10-Alterar Preço
                11-Cadastrar Usuário
                12-Remover Usuário
                13-Editar Usuário
                14-Ver vendedores
                15-Ver clientes
                16-Ver pagamentos
                17-Ver pagamento individual""";
    }

    public void cadastrarVeiculo(Veiculo veiculo){
        veiculo.addVeiculo();
    }
    public void removerVeiculo(Veiculo veiculo){veiculo.removerVeiculo();}
    public void editarVeiculo(Veiculo veiculo){
        int index = Veiculo.getVeiculos().indexOf(veiculo);
        Veiculo.getVeiculos().set(index, veiculo);
    }
    public void cadastrarUsuario(Usuario usuario){
        if(!(usuario instanceof Gerente)){
            usuario.addUsuario();
        }
    }
    public void removerUsuario(Usuario usuario){
        if(!(usuario instanceof Gerente)){
            usuario.removeUsuario();
        }
    }
    public void editarUsuario(Usuario novoUsuario){
        int idUser = novoUsuario.getId();
        Usuario user = Usuario.procurarUsuario(idUser);
        int index = usuarios.indexOf(user);
        usuarios.set(index, novoUsuario);
    }
    public String verVendedores(){
        String vendedores = "";
        for (Usuario vendedor:
             usuarios) {
            if(vendedor instanceof Vendedor){
                vendedores += vendedor.toString() +"\n";
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
                pagamentos.add(funcionario.getNome()+": "+((Vendedor) funcionario).getPagamentos().toString());
            }
        }
        return pagamentos;
    }
    public String verPagamento(Vendedor usuario){
        return usuario.getPagamentos().toString();
    }
}
