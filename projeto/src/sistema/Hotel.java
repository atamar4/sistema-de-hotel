package sistema;

    import java.util.ArrayList;

    public class Hotel {

    private ArrayList<Quarto> quartos;
    private ArrayList<Hospede> hospedes;

    public Hotel() {
        quartos = new ArrayList<>();
        hospedes = new ArrayList<>();

        quartos.add(new Quarto(101, "Solteiro", 120));
        quartos.add(new Quarto(102, "Solteiro", 120));
        quartos.add(new Quarto(201, "Casal", 180));
        quartos.add(new Quarto(202, "Casal", 180));
        quartos.add(new Quarto(301, "Suite", 250));
    }
    
    
    // Retorna null se a reserva foi feita, ou o motivo do erro se a operação for inválida    
    public String fazerReserva(String nome, String cpf, int numeroQuarto, int dias){
        String cpfLimpo = limparCpf(cpf);
        
         if (nome.trim().length() == 0) {
            return "O nome não pode ficar vazio.";
        }
        if (cpfLimpo.length() != 11) {
            return "CPF inválido: informe os 11 números.";
        }
        if (dias < 1) {
            return "A quantidade de dias deve ser pelo menos 1.";
        }
        
        Quarto quarto = buscarQuarto(numeroQuarto);
        if (quarto == null) {
            return "O quarto " + numeroQuarto + " não existe.";
        }
        if (!quarto.reservar()) {
            return "O quarto " + numeroQuarto + " está ocupado.";
        }
 
        //trim serve para remover os espaços em branco do comeco e do fim de um texto
        hospedes.add(new Hospede(nome.trim(), cpfLimpo, quarto, dias));
        return null;
        }
    
    // Procura o hóspede pelo CPF (só os que ainda não fizeram check-out). Retorna null se não achar.
    public Hospede buscarHospede(String cpf) {
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        for (Hospede h : hospedes) {
            if (h.getCpf().equals(cpfLimpo) && !h.isFinalizado()) {
                return h;
            }
        }
        return null;
    }    
    
    public void listarQuartos() {
        for (Quarto q : quartos) {
            q.exibirDados();
        }
    }

    private Quarto buscarQuarto(int numero) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numero) {
                return q;
            }
        }
        return null;
    }


}
