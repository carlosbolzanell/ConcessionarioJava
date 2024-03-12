package Concessionaria.Veiculos;

import java.util.ArrayList;

public abstract class Veiculo {
    private final int codigo = veiculos.size()+1;
    private String modelo;
    private int ano;
    private String cor;
    private String marca;
    private double quilometragem;
    private String alimentacao;
    private double preco;
    private static final ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Veiculo(String modelo, int ano, String cor, String marca, double quilometragem, String alimentacao, double preco) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.marca = marca;
        this.quilometragem = quilometragem;
        this.alimentacao = alimentacao;
        this.preco = preco;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public double getPreco(){
        return this.preco;
    }

    public void addVeiculo(){
        veiculos.add(this);
    }
    public void removerVeiculo(){
        veiculos.remove(this);
    }
    public static Veiculo procurarVeiculo(int codigo){
        for (Veiculo veiculo:
             veiculos) {
            if(veiculo.codigo == codigo){
                return  veiculo;
            }
        }
        return null;
    }
    public static ArrayList<Veiculo> getVeiculos(){
        return veiculos;
    }

    @Override
    public String toString() {
        return "codigo: " + codigo + "\n"+
                "modelo: " + modelo + "\n" +
                "ano: " + ano + "\n"+
                "cor: " + cor + "\n" +
                "marca: " + marca + "\n" +
                "quilometragem: " + quilometragem +"\n"+
                "alimentacao: " + alimentacao + "\n" +
                "preco: R$" + preco;
    }
}
