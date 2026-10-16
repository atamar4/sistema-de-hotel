package sistema;

import java.util.Scanner;

public class Menu {
    
    private static Scanner scanner = new Scanner(System.in);
    private static Hotel hotel = new Hotel();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("===== HOTEL =====");
            System.out.println("1 - Fazer reserva");
            System.out.println("2 - Consultar reserva");
            System.out.println("3 - Check-in");
            System.out.println("4 - Check-out");
            System.out.println("5 - Ver quartos");
            System.out.println("6 - Sair");
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    fazerReserva();
                    break;
                case 2:
                    consultarReserva();
                    break;
                case 3:
                    fazerCheckIn();
                    break;
                case 4:
                    fazerCheckOut();
                    break;
                case 5:
                    System.out.println();
                    hotel.listarQuartos();
                    break;
                case 6:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }
    
    private static void fazerReserva(){
        System.out.println();
        hotel.listarQuartos();
        
        System.out.print("\nNome do hóspede: ");
        String nome = scanner.nextLine();
        System.out.print("CPF (11 números): ");
        String cpf = scanner.nextLine();
        int numeroQuarto = lerInteiro("Número do quarto: ");
        int dias = lerInteiro("Quantidade de dias: ");

        String erro = hotel.fazerReserva(nome, cpf, numeroQuarto, dias);

        if (erro == null) {
            System.out.println("\nReserva realizada!");
            hotel.buscarHospede(cpf).exibirDados();
        } else {
            System.out.println("\nNão foi possível reservar: " + erro);
        }
    }

    private static void consultarReserva() {
        System.out.print("\nCPF do hóspede: ");
        Hospede hospede = hotel.buscarHospede(scanner.nextLine());

        if (hospede == null) {
            System.out.println("Nenhuma reserva ativa para este CPF.");
        } else {
            hospede.exibirDados();
        }
    }
        
    
    private static void fazerCheckIn() {
        System.out.print("\nCPF do hóspede: ");
        Hospede hospede = hotel.buscarHospede(scanner.nextLine());

        if (hospede == null) {
            System.out.println("Nenhuma reserva ativa para este CPF.");
        } else if (hospede.fazerCheckIn()) {
            System.out.println("Check-in realizado! Bem-vindo(a), " + hospede.getNome() + ".");
        } else {
            System.out.println("Check-in não permitido. Situação atual: " + hospede.getSituacao());
        }
    }
       
    }
    
}
