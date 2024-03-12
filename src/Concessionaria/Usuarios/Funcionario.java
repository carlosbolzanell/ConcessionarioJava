package Concessionaria.Usuarios;

import Concessionaria.Veiculos.Veiculo;

import java.util.ArrayList;

public abstract class Funcionario extends Usuario{
    private ArrayList<String> pagamentos = new ArrayList<>();
    private double salario;
    private int codigo;
    private double comissao;

    public Funcionario(String nome, String usuario, String senha, double salario, int codigo, double comissao) {
        super(nome, usuario, senha);
        this.salario = salario;
        this.codigo = codigo;
        this.comissao = comissao;
    }
    public String menu(){
        return super.menu() + "\n" +
                """
                   4-Vender veiculo
                   5-Procurar cliente
                   6-Ver pagamento
                """;
    }
    public ArrayList<String> getPagamentos(){
        return pagamentos;
    }
    public void addPagamento(double pagamento){
        double pagamentoComissao = pagamento * this.comissao;
        pagamentos.add("R$ "+pagamentoComissao);
    }
    public Usuario procurarCliente(String usuario){
        return Usuario.procurarUsuario(usuario);
    }
    public boolean venderVeiculo(Veiculo veiculo, Usuario usuario){
        if(veiculo == null){
            return false;
        }
        if(usuario == null){
            return false;
        }
        usuario.addVeiculo(veiculo);
        this.addPagamento(veiculo.getPreco());
        return true;
    }
    public int getCodigo(){
        return this.codigo;
    }

    @Override
    public String toString() {
        return super.toString() + 
                "salario: R$" + salario +"\n"+
                "codigo: " + codigo + "\n"+
                "comissao: " + comissao;
    }
}
