package Concessionaria.Usuarios;

public class Vendedor extends Funcionario{

    public Vendedor(String nome, String usuario, String senha, double salario, long codigo) {
        super(nome, usuario, senha, salario, codigo, 0.01);
    }
}
