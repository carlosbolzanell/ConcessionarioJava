package Concessionaria.Veiculos;

public class Carro extends Veiculo{
    private String tipo;
    private int numeroPortas;
    private String cambio;
    private boolean completo;

    public Carro(String placa,String modelo, int ano, String cor, String marca, double quilometragem, String alimentacao, double preco, String tipo, int numeroPortas, String cambio, boolean completo) {
        super(placa, modelo, ano, cor, marca, quilometragem, alimentacao, preco);
        this.tipo = tipo;
        this.numeroPortas = numeroPortas;
        this.cambio = cambio;
        this.completo = completo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "tipo: " + tipo + "\n" +
                "numeroPortas=" + numeroPortas + "\n"+
                "cambio='" + cambio + "\n" +
                "completo=" + completo;
    }
}
