
package sistema;

public class Quarto {

    private int numero;
    private String tipo;
    private double valorDiario;
    private boolean disponivel;

    public Quarto(int numero, String tipo, double valorDiario) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiario = valorDiario;
        this.disponivel = true; // todo quarto novo começa livre
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }
}
