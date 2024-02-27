package Concessionaria.Usuarios;

import java.util.ArrayList;

public abstract class Funcionario extends Usuario{
    private ArrayList<Float> pagamentos = new ArrayList<>();
    private double salario;
    private long codigo;
    private double comissao;

    public Funcionario(String nome, String usuario, String senha, double salario, long codigo, double comissao) {
        super(nome, usuario, senha);
        this.salario = salario;
        this.codigo = codigo;
        this.comissao = comissao;
    }
    public ArrayList<Float> getPagamentos(){
        return pagamentos;
    }
    public void addPagamento(Float pagamento){
        pagamentos.add(pagamento);
    }
    public Usuario procurarCliente(String usuario){
        return Usuario.procurarUsuario(usuario);
    }
    public boolean venderVeiculo(int codigo, Usuario usuario){
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + 
                "salario: R$" + salario +"\n"+
                "codigo: " + codigo + "\n"+
                "comissao: " + comissao;
    }
}
