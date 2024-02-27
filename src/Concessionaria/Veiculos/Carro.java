package Concessionaria.Veiculos;

public class Carro extends Veiculo{
    private String tipo;
    private int numeroPortas;
    private String cambio;
    private boolean completo;

    public Carro(int codigo, String modelo, int ano, String cor, String marca, double quilometragem, String alimentacao, double preco, String tipo, int numeroPortas, String cambio, boolean completo) {
        super(codigo, modelo, ano, cor, marca, quilometragem, alimentacao, preco);
        this.tipo = tipo;
        this.numeroPortas = numeroPortas;
        this.cambio = cambio;
        this.completo = completo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public void setCompleto(boolean completo) {
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
