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
        quartos.add(new Quarto(301, "Suíte", 250));
    }
    
}
