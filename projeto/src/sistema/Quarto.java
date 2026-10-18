
package sistema;

public class Quarto {

    private int numero;
    private String tipo;
    private double valorDiario;
    private boolean disponivel;

    // Construtor: recebe número, tipo e valor da diária
    public Quarto(int numero, String tipo, double valorDiario) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiario = valorDiario;
        this.disponivel = true; // todo quarto novo começa livre
    }

    // Marca o quarto como ocupado
    // Retorna false se o quarto já estiver ocupado
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
    
    // Mostra os dados do quarto no terminal, com a situação (Disponível ou Ocupado)
    public void exibirDados(){
        String situacao = disponivel ? "Disponivel" : "Ocupado";
        System.out.printf("Quarto %d | %-8s | R$ %.2f | %s%n", numero, tipo, valorDiario, situacao);
    }
    
    // Getters: permitem que outras classes leiam os atributos privados
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }
}
