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
        do {
            System.out.println("""
                    Bem vindo a concessionaria
                    1-Cadastro
                    2-Login
                    3-Ver veiculos em estoque
                    4-Ver detalhes de um veiculo
                    5-Sair""");
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1 -> cadastro();
                case 2 -> login();
                case 3 -> veiculosEstoque();
                case 4 -> detalhesVeiculos();
                case 5 -> System.exit(0);
            }
        }while (usuarioLogado == null);
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
        do {
            System.out.println("""
                    Bem vindo a concessionaria
                    1-Ver veiculos em estoque
                    2-Ver detalhes de um veiculo
                    3-Ver meus veiculos""");

            if (usuarioLogado instanceof Funcionario) {
                System.out.println("""
                        4-Vender veiculo
                        5-Procurar cliente
                        6-Ver pagamento""");
            }
            if(usuarioLogado instanceof  Gerente){
                System.out.println("""
                        7-Cadastrar Veiculo
                        8-Remover Veículo
                        9-Editar Veículo
                        10-Cadastrar Usuário
                        11-Remover Usuário
                        12-Editar Usuário
                        13-Ver vendedores
                        14-Ver clientes
                        15-Ver pagamentos
                        16-Ver pagamento individual""");
            }
            int escolha = sc.nextInt();
            switch (escolha) {
                case 1 -> veiculosEstoque();
                case 2 -> detalhesVeiculos();
                case 3 -> verVeiculos();
                case 4 -> {if(usuarioLogado instanceof Funcionario) venderVeiculo();}
                case 5 -> {if (usuarioLogado instanceof Funcionario) procurarCliente();}
                case 6 -> {if (usuarioLogado instanceof Funcionario) verPagamento();}
                case 7 -> cadastrarVeiculo();

            }
        }while(usuarioLogado !=null);
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
                System.out.println("Carro:");
                System.out.println(((Carro)veiculo).toString());
            }else if(veiculo instanceof Moto){
                System.out.println("Moto:");
                System.out.println(((Moto)veiculo).toString());
            }else if(veiculo instanceof Caminhao){
                System.out.println("Caminhão:");
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
        Veiculo veiculo = Veiculo.procurarVeiculo(codigo);
        System.out.println("Usuario do cliente: ");
        String cliente = sc.next();
        Usuario usuario = Usuario.procurarUsuario(cliente);
        if(((Funcionario)usuarioLogado).venderVeiculo(veiculo , usuario)){
            System.out.println("Veiculo vendido!");
            ((Funcionario)usuarioLogado).addPagamento(veiculo.getPreco());
        }else{
            System.out.println("Dados incorretos");
        }
    }
    public static void procurarCliente(){
        System.out.print("Usuario: ");
        String usuario = sc.next();
        Usuario user = ((Funcionario)usuarioLogado).procurarCliente(usuario);
        if(user != null){
            System.out.print(user.toString());
        }else{
            System.out.println("Usuario não encontrado");
        }
    }
    public static void verPagamento(){
        System.out.println(((Funcionario)usuarioLogado).getPagamentos());
    }
    public static void cadastrarVeiculo(){
        System.out.println("""
                Qual veiculo deseja adicionar?
                1-Carro
                2-Moto
                3-Caminhão""");
        int escolha = sc.nextInt();
        System.out.print("Modelo: ");
        String modelo = sc.next();
        System.out.print("Ano: ");
        int ano = sc.nextInt();
        System.out.print("Cor: ");
        String cor = sc.next();
        System.out.print("Marca: ");
        String marca = sc.next();
        System.out.print("Quilometragem: ");
        double kms = sc.nextDouble();
        System.out.print("Combustível: ");
        String combustivel = sc.next();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        switch (escolha){
            case 1->{
                System.out.print("Tipo: ");
                String tipo = sc.next();
                System.out.print("Número de portas: ");
                int numPortas = sc.nextInt();
                System.out.print("Cambio: ");
                String cambio = sc.next();
                System.out.println("""
                        Completo?
                        1- Sim
                        2- Não""");
                int completo = sc.nextInt();
                ((Gerente)usuarioLogado).cadastrarVeiculo(new Carro(Veiculo.getVeiculos().size()+1, modelo, ano, cor, marca, kms, combustivel, preco, tipo, numPortas, cambio, (completo == 1) ));
            }
            case 2 ->{
                System.out.println("""
                        Carenagem
                        1- Sim
                        2- Não""");
                int carenagem = sc.nextInt();
                System.out.print("Cilindradas: ");
                int cilindradas = sc.nextInt();
                System.out.print("Estilo: ");
                String estilo = sc.next();
                System.out.print("Partida: ");
                String partida = sc.next();
                ((Gerente)usuarioLogado).cadastrarVeiculo(new Moto(Veiculo.getVeiculos().size()+1, modelo, ano, cor, marca, kms, combustivel, preco, (carenagem == 1), cilindradas, estilo, partida ));
            }
            case 3 ->{
                System.out.print("Carroceria: ");
                String carroceria = sc.next();
                System.out.print("Tração: ");
                String tracao = sc.next();
                System.out.print("Cabine: ");
                String cabine = sc.next();
                ((Gerente)usuarioLogado).cadastrarVeiculo(new Caminhao(Veiculo.getVeiculos().size()+1, modelo, ano, cor, marca, kms, combustivel, preco, carroceria, tracao, cabine ));
            }
        }
        System.out.println("Veiculo cadastrado com sucesso");
    }
    public static void removerVeiculo(){
        System.out.println("Codigo do veículo: ");
        int codigo = sc.nextInt();
        Veiculo veiculo = Veiculo.procurarVeiculo(codigo);
        if(veiculo != null){
            ((Gerente)usuarioLogado).removerVeiculo(veiculo);
            System.out.print("Veiculo removido com sucesso");
            return;
        }
        System.out.println("Veiculo não encontrado");
    }
    
    public static void editarUsuario(){
        System.out.print("Qual o usuário");
        String username = sc.next();
        Usuario usuarioEditado = Usuario.procurarUsuario(username);
        System.out.println("""
                Qual informação deseja aterar
                1 - Nome
                2 - Usuario
                3 - Senha
                4 - Alterar Tudo""");
        int escolha = sc.nextInt();
        switch (escolha){
            case 1 -> {
                System.out.print("Qual o nome ");
                String nomeEditado = sc.next();
            }
        }
        ((Gerente)usuarioLogado).editUsuario(usuarioEditado);
    }
}