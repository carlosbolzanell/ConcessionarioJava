package Concessionaria.Veiculos;

public class Moto extends Veiculo{
    private boolean carenagem;
    private int cilindrada;
    private String estlo;
    private String partida;

    public Moto(int codigo, String modelo, int ano, String cor, String marca, double quilometragem, String alimentacao, double preco, boolean carenagem, int cilindrada, String estlo, String partida) {
        super(codigo, modelo, ano, cor, marca, quilometragem, alimentacao, preco);
        this.carenagem = carenagem;
        this.cilindrada = cilindrada;
        this.estlo = estlo;
        this.partida = partida;
    }

    public void setCarenagem(boolean carenagem) {
        this.carenagem = carenagem;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setEstlo(String estlo) {
        this.estlo = estlo;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    @Override
    public String toString() {
        return super.toString() +
                "carenagem: " + carenagem + "\n" +
                "cilindrada: " + cilindrada +"\n"+
                "estlo: " + estlo + "\n" +
                "partida: " + partida;
    }
}
