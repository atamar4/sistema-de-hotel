
package sistema;

public class Hospede {
  private String nome;
    private String cpf;
    private Quarto quarto;
    private int dias;
    private boolean checkInFeito;
    private boolean checkOutFeito;

    public Hospede(String nome, String cpf, Quarto quarto, int dias) {
        this.nome = nome;
        this.cpf = cpf;
        this.quarto = quarto;
        this.dias = dias;
    }

    // Só faz check-in uma vez
    public boolean fazerCheckIn() {
        if (checkInFeito || checkOutFeito) {
            return false;
        } else {
            checkInFeito = true;
            return true;
        }
    }

    // Só faz check-out depois do check-in. Ao sair, libera o quarto.
    public boolean fazerCheckOut() {
        if (!checkInFeito || checkOutFeito) {
            return false;
        } else {
            checkOutFeito = true;
            quarto.liberar();
            return true;
        }
    }

    public double calcularTotal() {
        return quarto.calcularEstadia(dias);
    }

    public String getSituacao() {
        if (checkOutFeito) {
            return "Finalizada";
        } else if (checkInFeito) {
            return "Hospedado";
        } else {
            return "Aguardando check-in";
        }
    }

    public void exibirDados() {
        System.out.println("Hóspede: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Quarto: " + quarto.getNumero() + " (" + quarto.getTipo() + ")");
        System.out.println("Dias: " + dias);
        System.out.printf("Valor total: R$ %.2f%n", calcularTotal());
        System.out.println("Situação: " + getSituacao());
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isFinalizado() {
        return checkOutFeito;
    }
}
