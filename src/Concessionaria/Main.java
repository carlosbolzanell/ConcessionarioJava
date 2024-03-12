package Concessionaria;

import Concessionaria.Usuarios.*;
import Concessionaria.Veiculos.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        Usuario carlos = new Cliente("Carlos", "carlos", "123");
        Usuario victor = new Vendedor("Victor", "victor", "123", 1200, 12345);
        Usuario luana = new Gerente("Luana", "luana", "123", 3000, 123);
        Veiculo carro = new Carro("Civic", 2017, "Branco", "Honda", 56.984, "Disel", 79000, "Sedan", 4, "Automatico",true);
        Veiculo moto = new Moto("CG", 2020, "Vermelho", "Honda", 198.654, "Gasolina", 11000, false, 125, "Street","Elétrica");
        Veiculo caminhao = new Caminhao("FH 540", 2022, "Azul", "Volvo", 161.865, "Disel", 925000, "Cavalo Mecânico", "6x4", "Leito");
        carlos.addUsuario();
        victor.addUsuario();
        luana.addUsuario();
        carro.addVeiculo();
        moto.addVeiculo();
        caminhao.addVeiculo();
        menu();
    }
    public static String input(String texto){
        System.out.print(texto);
        return sc.next();
    }
    public static int inputInt(String texto){
        System.out.print(texto);
        return sc.nextInt();
    }
    public static double inputDouble(String texto){
        System.out.print(texto);
        return sc.nextDouble();
    }
    public static Veiculo procuraVeiculo(){
        int codigo = inputInt("Codigo do veiculo: ");
        return Veiculo.procurarVeiculo(codigo);
    }
    public static Usuario procuraUsuario(){
        String usuario = input("Usuario: ");
        return Usuario.procurarUsuario(usuario);
    }
    public static ArrayList<String> infoVeiculo(){
        ArrayList<String> infos = new ArrayList<>();
        String modelo = input("Modelo: ");
        infos.add(modelo);
        int ano = inputInt("Ano: ");
        infos.add(String.valueOf(ano));
        String cor = input("Cor: ");
        infos.add(cor);
        String marca = input("Marca: ");
        infos.add(marca);
        double kms = inputDouble("Quilometragem: ");
        infos.add(String.valueOf(kms));
        String combustivel = input("Combustível");
        infos.add(combustivel);
        double preco = inputDouble("Preço: ");
        infos.add(String.valueOf(preco));
        return infos;
    }
    public static ArrayList<String> infoCarro(){
        ArrayList<String> infos = new ArrayList<>();
        String tipo = input("Tipo: ");
        infos.add(tipo);
        int numPortas = inputInt("Numero de portas: ");
        infos.add(String.valueOf(numPortas));
        String cambio = input("Cambio: ");
        infos.add(cambio);
        int completo = inputInt("Completo?\n1-Sim\n2-Não");
        infos.add(String.valueOf(completo));
        return infos;
    }
    public static ArrayList<String> infoMoto(){
        ArrayList<String> infos = new ArrayList<>();
        int carenagem = inputInt("Carenagem?\n1-Sim\n2-Não");
        infos.add(String.valueOf(carenagem));
        int cilindradas = inputInt("Cilindradas: ");
        infos.add(String.valueOf(cilindradas));
        String estilo = input("Estilo: ");
        infos.add(estilo);
        String partida = input("Partida: ");
        infos.add(partida);
        return infos;
    }
    public static ArrayList<String> infoCaminhao(){
        ArrayList<String> infos = new ArrayList<>();
        String carroceria = input("Carroceria: ");
        infos.add(carroceria);
        String tracao = input("Tração: ");
        infos.add(tracao);
        String cabine = input("Cabine: ");
        infos.add(cabine);
        return infos;
    }
    public static String[] infoCliente(){
        String[] infos = new String[3];
        String nome = input("Nome: ");
        infos[0] = nome;
        Usuario newUser = null;
        String usuario = "";
        do {
            usuario = input("Usuario: ");
            newUser = Usuario.procurarUsuario(usuario);
            if (newUser != null) {
                System.out.println("Usuario já existe!");
            }
        }while(newUser != null);
        infos[1] = usuario;
        String senha = input("Senha: ");
        infos[2] = senha;
        return infos;
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
        String[] infos = infoCliente();
        Usuario user = new Cliente(infos[0], infos[1], infos[2]);
        user.addUsuario();
    }
    public static void login(){
        String usuario = input("Usuario: ");
        String senha = input("Senha: ");
        Usuario user = Usuario.login(usuario, senha);
        if(user != null){
            System.out.println("Usuario logado!");
            usuarioLogado = user;
            menuLogado();
        }else {
            System.out.println("Dados incorretos");
        }
    }
    public static void menuLogado(){
        do {
            usuarioLogado.menu();
            System.out.println("0-logout");
            int escolha = sc.nextInt();
            switch (escolha) {
                case 0 -> logout();
                case 1 -> veiculosEstoque();
                case 2 -> detalhesVeiculos();
                case 3 -> verVeiculos();
                case 4 -> {if(usuarioLogado instanceof Funcionario) venderVeiculo();}
                case 5 -> {if (usuarioLogado instanceof Funcionario) procurarCliente();}
                case 6 -> {if (usuarioLogado instanceof Funcionario) verPagamento();}
                case 7 -> {if (usuarioLogado instanceof  Gerente) cadastrarVeiculo();}
                case 8 -> {if (usuarioLogado instanceof  Gerente) removerVeiculo();}
                case 9 -> {if (usuarioLogado instanceof  Gerente) editarVeiculo();}
                case 10 -> {if (usuarioLogado instanceof  Gerente) alterarPreco();}
                case 11 -> {if (usuarioLogado instanceof  Gerente) cadastrarUsuario();}
                case 12 -> {if (usuarioLogado instanceof  Gerente) removerUsuario();}
                case 13 -> {if (usuarioLogado instanceof  Gerente) editarUsuario();}
                case 14 -> {if (usuarioLogado instanceof  Gerente) verVendedores();}
                case 15 -> {if (usuarioLogado instanceof  Gerente) verClientes();}
                case 16 -> {if (usuarioLogado instanceof  Gerente) verPagamentoVendedores();}
                case 17 -> {if (usuarioLogado instanceof  Gerente) verPagamentoVendedor();}
            }
        }while(usuarioLogado !=null);
    }
    public static void logout(){
        usuarioLogado = null;
    }
    public static void veiculosEstoque(){
        System.out.println(Veiculo.getVeiculos());
    }
    public static void detalhesVeiculos(){
        Veiculo veiculo = procuraVeiculo();
        if(veiculo != null){
            if(veiculo instanceof Carro){
                System.out.println("Carro:");
                System.out.println(veiculo);
            }else if(veiculo instanceof Moto){
                System.out.println("Moto:");
                System.out.println(veiculo);
            }else if(veiculo instanceof Caminhao){
                System.out.println("Caminhão:");
                System.out.println(veiculo);
            }
        }else{
            System.out.println("Veiculo não encontrado");
        }
    }
    public static void verVeiculos(){
        System.out.println(usuarioLogado.getVeiculos().toString());
    }
    public static void venderVeiculo(){
        Veiculo veiculo = procuraVeiculo();
        String cliente = input("Usuario do cliente: ");
        Usuario usuario = Usuario.procurarUsuario(cliente);
        if(((Funcionario)usuarioLogado).venderVeiculo(veiculo , usuario)){
            System.out.println("Veiculo vendido!");
            veiculo.removerVeiculo();
        }else{
            System.out.println("Dados incorretos");
        }
    }
    public static void procurarCliente(){
        Usuario user = procuraUsuario();
        if(user != null){
            System.out.print(user);
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
        ArrayList<String> infos = infoVeiculo();
        ArrayList<String> infosEspecificas;
        switch (escolha){
            case 1->{
                inserirCarro(infos);
            }
            case 2 ->{
                inserirMoto(infos);
            }
            case 3 ->{
                inserirCaminhao(infos);
            }
        }
        System.out.println("Veiculo cadastrado com sucesso");
    }
    public static void removerVeiculo(){
        Veiculo veiculo = procuraVeiculo();
        if(veiculo != null){
            ((Gerente)usuarioLogado).removerVeiculo(veiculo);
            System.out.print("Veiculo removido com sucesso");
            return;
        }
        System.out.println("Veiculo não encontrado");
    }
    public static void alterarPreco(){
        Veiculo veiculoEditado = procuraVeiculo();
        if(veiculoEditado != null){
            double novoPreco = inputDouble("Novo Preço: ");
            veiculoEditado.setPreco(novoPreco);
            System.out.println("Preço editado com sucesso!");
            return;
        }
        System.out.println("Veiculo não encontrado!");
    }

    public static void editarVeiculo(){
        Veiculo veiculoEditar = procuraVeiculo();
        if(veiculoEditar != null){
            ArrayList<String> infos = infoVeiculo();
            if(veiculoEditar instanceof Carro){
                inserirCarro(infos);
            }else if(veiculoEditar instanceof Moto){
                inserirMoto(infos);
            }else{
                inserirCaminhao(infos);
            }
            System.out.println("Veiculo ediatado com sucesso!");
        }
    }

    private static void inserirCarro(ArrayList<String> infos) {
        ArrayList<String> infosEspecificas = infoCarro();
        ((Gerente)usuarioLogado).cadastrarVeiculo(new Carro(infos.get(0), Integer.parseInt(infos.get(1)), infos.get(2), infos.get(3), Double.parseDouble(infos.get(4)), infos.get(5), Double.parseDouble(infos.get(6)), infosEspecificas.get(0), Integer.parseInt(infosEspecificas.get(1)), infosEspecificas.get(2), (Integer.parseInt(infosEspecificas.get(3))==1) ));
    }

    private static void inserirMoto(ArrayList<String> infos) {
        ArrayList<String> infosEspecificas = infoMoto();
        ((Gerente)usuarioLogado).cadastrarVeiculo(new Moto(infos.get(0), Integer.parseInt(infos.get(1)), infos.get(2), infos.get(3), Double.parseDouble(infos.get(4)), infos.get(5), Double.parseDouble(infos.get(6)), (Integer.parseInt(infosEspecificas.get(0)) == 1), Integer.parseInt(infosEspecificas.get(1)), infosEspecificas.get(2), infosEspecificas.get(3) ));
    }

    private static void inserirCaminhao(ArrayList<String> infos) {
        ArrayList<String> infosEspecificas = infoCaminhao();
        ((Gerente)usuarioLogado).cadastrarVeiculo(new Caminhao(infos.get(0), Integer.parseInt(infos.get(1)), infos.get(2), infos.get(3), Double.parseDouble(infos.get(4)), infos.get(5), Double.parseDouble(infos.get(6)), infosEspecificas.get(0), infosEspecificas.get(1), infosEspecificas.get(2) ));
    }

    public static void cadastrarUsuario(){;
        int escolha = inputInt("""
                1-Cliente
                2-Vendedor""");
        String[] infos = infoCliente();
        Usuario novoUsuario = null;
        switch (escolha){
            case 1 -> novoUsuario = new Cliente(infos[0], infos[1], infos[2]);
            case 2 ->{
                double salario = inputDouble("Salário: ");
                int codigo = inputInt("Código: ");
                novoUsuario = new Vendedor(infos[0], infos[1], infos[2], salario, codigo);
            }
        }
        ((Gerente) usuarioLogado).cadastrarUsuario(novoUsuario);
        System.out.println("Usuario cadastrado com sucesso!");

    }
    public static void removerUsuario(){
        Usuario user = procuraUsuario();
        if(user != null) {
            ((Gerente) usuarioLogado).removerUsuario(user);
            System.out.println("Usuario removido!");
            return;
        }
        System.out.println("Usuario inexistente");
    }
    public static void editarUsuario(){
        Usuario usuarioEditado = procuraUsuario();
        String[] infos = infoCliente();
        if(usuarioEditado instanceof Vendedor){
            double salario = inputDouble("Salário: ");
            ((Gerente)usuarioLogado).editarUsuario(new Vendedor(infos[0], infos[1], infos[2], salario, ((Funcionario)usuarioEditado).getCodigo()));
            System.out.println("Vendedor editado com sucesso");
            return;
        }
        ((Gerente)usuarioLogado).editarUsuario(new Cliente(infos[0], infos[1], infos[2]));
        System.out.println("Cliente editado com sucesso!");
    }
    public static void verVendedores(){
        System.out.println(((Gerente)usuarioLogado).verVendedores());
    }
    public static void verClientes(){
        System.out.println(((Gerente)usuarioLogado).verClientes());
    }
    public static void verPagamentoVendedores(){
        System.out.println(((Gerente)usuarioLogado).verPagamentos());
    }
    public static void verPagamentoVendedor(){
        Usuario vendedor = procuraUsuario();
        if(vendedor == null){
            System.out.println("Vendedor não encontrado");
            return;
        }else if(!(vendedor instanceof Vendedor)){
            System.out.println("Usuario não é um vendedor");
            return;
        }
        System.out.println(((Gerente)usuarioLogado).verPagamento((Vendedor)vendedor));
    }
}