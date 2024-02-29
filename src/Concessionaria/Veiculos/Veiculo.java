package Concessionaria.Veiculos;

import java.util.ArrayList;

public abstract class Veiculo {
    private int codigo;
    private String modelo;
    private int ano;
    private String cor;
    private String marca;
    private double quilometragem;
    private String alimentacao;
    private double preco;
    private static final ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Veiculo(int codigo, String modelo, int ano, String cor, String marca, double quilometragem, String alimentacao, double preco) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.marca = marca;
        this.quilometragem = quilometragem;
        this.alimentacao = alimentacao;
        this.preco = preco;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public double getPreco(){
        return this.preco;
    }

    public static void addVeiculo(Veiculo veiculo){
        veiculos.add(veiculo);
    }
    public static void removerVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
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
