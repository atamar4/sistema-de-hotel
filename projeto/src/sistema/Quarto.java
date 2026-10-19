
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

    
    public boolean reservar(){
        if(disponivel){
            disponivel = false;
            return true;
        } else {
            return false;
        }
    }
    
    public void liberar(){
        disponivel = true;
    }
    
    public double calcularEstadia(int dias){
        return valorDiario * dias;
    }
    
    public void exibirDados(){
        String situacao = disponivel ? "Disponivel" : "Ocupado";
        System.out.printf("Quarto %d | %-8s | R$ %.2f | %s%n", numero, tipo, valorDiario, situacao);
    }
    
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }
}
