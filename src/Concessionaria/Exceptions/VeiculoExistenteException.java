package Concessionaria.Exceptions;

public class VeiculoExistenteException extends Exception{
    public VeiculoExistenteException(){
        super("O veículo já existe dentro do sistema!");
    }

}
