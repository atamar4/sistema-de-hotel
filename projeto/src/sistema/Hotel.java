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
    
    
    // Retorna null se a reserva foi feita, ou o motivo do erro se a operaçao for invalida    
    public String fazerReserva(String nome, String cpf, int numeroQuarto, int dias){
        
        String cpfLimpo = limparCpf(cpf);
        
         if (nome.trim().length() == 0) {
            return "O nome nao pode ficar vazio.";
        }
        if (cpfLimpo.length() != 11) {
            return "CPF invalido: informe os 11 numeros.";
        }
        if (dias < 1) {
            return "A quantidade de dias deve ser pelo menos 1.";
        }
        
        // Verifica se o CPF já possui uma reserva ativa
        Hospede hospedeExistente = buscarHospede(cpfLimpo);

        if (hospedeExistente != null) {
            return "Este CPF ja possui uma reserva ativa no quarto "
                    + hospedeExistente.getQuarto().getNumero()
                    + ". Nao e possivel fazer outra reserva.";
        }
        
        Quarto quarto = buscarQuarto(numeroQuarto);
        
        if (quarto == null) {
            return "O quarto " + numeroQuarto + " nao existe.";
        }
        if (!quarto.reservar()) {
            return "O quarto " + numeroQuarto + " esta ocupado.";
        }
        
        hospedes.add(new Hospede(
        nome.trim(), cpfLimpo, quarto, dias
        ));

        return null;
    }
    
    // Procura o hospede pelo CPF (só os que ainda nao fizeram check-out). Retorna null se nao achar.
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

    // Mantem somente os numeros do CPF
    private String limparCpf(String cpf) {
        String resultado = "";

        for (int i = 0; i < cpf.length(); i++) {
            char c = cpf.charAt(i);

            if (c >= '0' && c <= '9') {
                resultado = resultado + c;
            }
        }

        return resultado;
    }
}
