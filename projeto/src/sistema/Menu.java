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
    
}
