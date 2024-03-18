package Concessionaria.Exceptions;

public class VeiculoNaoEncontradoException extends Exception{
    public VeiculoNaoEncontradoException (){
        super("O veiculo não foi encontrado");
    }
}
