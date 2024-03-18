package Concessionaria.Exceptions;

public class UsuarioExistenteException extends Exception{
    public UsuarioExistenteException(){
        super("O usuário já existe!");
    }
}
