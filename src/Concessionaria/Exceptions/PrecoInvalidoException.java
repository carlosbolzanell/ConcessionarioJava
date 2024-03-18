package Concessionaria.Exceptions;

public class PrecoInvalidoException extends Exception{
    public PrecoInvalidoException(){
        super("O preço é inválido!");
    }
}
