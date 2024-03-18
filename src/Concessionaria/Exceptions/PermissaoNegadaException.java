package Concessionaria.Exceptions;

public class PermissaoNegadaException extends  RuntimeException{
    public PermissaoNegadaException(){
        super("Desculpe, mas você não tem as permissões necessárias para essa ação!");
    }
}
