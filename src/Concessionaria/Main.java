package Concessionaria;

import Concessionaria.Usuarios.*;
import Concessionaria.Veiculos.*;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        Usuario.addUsuario(new Cliente("Carlos", "carlos", "123"));
        Usuario.addUsuario(new Vendedor("Victor", "victor", "123", 1200, 12345));
        Usuario.addUsuario(new Gerente("Luana", "luana", "123", 3000, 123));
        Veiculo.addVeiculo(new Carro(1212, "Civic", 2017, "Branco", "Honda", 56.984, "Disel", 79.000, "Sedan", 4, "Automatico",true));
        Veiculo.addVeiculo(new Moto(3030, "CG", 2020, "Vermelho", "Honda", 198.654, "Gasolina", 11.000, false, 125, "Street","Elétrica"));
        Veiculo.addVeiculo(new Caminhao(7373, "FH 540", 2022, "Azul", "Volvo", 161.865, "Disel", 925.000, "Cavalo Mecânico", "6x4", "Leito"));
        menu();
    }
    public static void menu(){
        System.out.println("""
                Bem vindo a concessionaria
                1-Cadastro
                2-Login
                3-Ver veiculos em estoque
                4-Ver detalhes de um veiculo
                5-Sair""");
        int escolha = sc.nextInt();
        switch (escolha){
            case 1 -> cadastro();
            case 2 -> login();
            case 3 -> veiculosEstoque();
            case 4 -> detalhesVeiculos();
            case 5 -> System.exit(0);
        }
    }
    public static void cadastro(){
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Usuario: ");
        String usuario = sc.next();
        System.out.print("Senha: ");
        String senha = sc.next();

        Usuario user = new Cliente(nome, usuario, senha);
        Usuario.addUsuario(user);
    }
    public static void login(){
        do{
            System.out.print("Usuario: ");
            String usuario = sc.next();
            System.out.print("Senha: ");
            String senha = sc.next();
            Usuario user = Usuario.login(usuario, senha);
            if(user != null){
                System.out.println("Usuario logado!");
                usuarioLogado = user;
                menuLogado();
            }else {
                System.out.println("Dados incorretos");
            }

        }while (usuarioLogado == null);
    }
    public static void menuLogado(){
        System.out.println("""
                Bem vindo a concessionaria
                1-Ver veiculos em estoque
                2-Ver detalhes de um veiculo
                3-Ver meus veiculos""");
        int escolha = sc.nextInt();
        switch (escolha){
            case 1 -> veiculosEstoque();
            case 2 -> detalhesVeiculos();
            case 3 -> verVeiculos();
        }
        if(usuarioLogado instanceof Funcionario){
            System.out.println("""
                    4-Vender veiculo
                    5-Procurar cliente
                    6-Ver pagamento""");
            switch (escolha){
                case 4-> venderVeiculo();
                case 5-> procurarCliente();
                case 6-> verPagamento();
            }
        }
    }
    public static void veiculosEstoque(){
        System.out.println(Veiculo.getVeiculos());
    }
    public static void detalhesVeiculos(){
        System.out.print("Codigo do veiculo: ");
        int codigo = sc.nextInt();

        Veiculo veiculo = Veiculo.procurarVeiculo(codigo);
        if(veiculo != null){
            if(veiculo instanceof Carro){
                System.out.println(((Carro)veiculo).toString());
            }else if(veiculo instanceof Moto){
                System.out.println(((Moto)veiculo).toString());
            }else if(veiculo instanceof Caminhao){
                System.out.println(((Caminhao)veiculo).toString());
            }
        }else{
            System.out.println("Veiculo não encontrado");
        }
    }
    public static void verVeiculos(){
        System.out.println(usuarioLogado.getVeiculos().toString());
    }
    public static void venderVeiculo(){
        System.out.print("Codigo do veiculo: ");
        int codigo = sc.nextInt();
        if(Veiculo.procurarVeiculo(codigo) == null){
            System.out.println("Veiculo inexistente");
            return;
        }
        System.out.println("Usuario do cliente: ");
        String cliente = sc.next();

        Usuario usuario = Usuario.procurarUsuario(cliente);
        if(usuario == null){
            System.out.println("Usuario inexistente!");
            return;
        }
        ((Funcionario)usuarioLogado).venderVeiculo(codigo, usuario);
        System.out.println("Veiculo vendido!");
    }
    
}