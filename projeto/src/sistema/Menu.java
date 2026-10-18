package sistema;

import java.util.Scanner;

public class Menu {
    
    private static Scanner scanner = new Scanner(System.in);
    private static Hotel hotel = new Hotel();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("=============================");
            System.out.println("======== AGA PALACE ========");
            System.out.println("   Sistema de Gerenciamento  ");
            System.out.println("=============================");
            System.out.println("1 - Fazer reserva");
            System.out.println("2 - Consultar reserva");
            System.out.println("3 - Check-in");
            System.out.println("4 - Check-out");
            System.out.println("5 - Ver quartos");
            System.out.println("6 - Sair");
            System.out.println("=============================");

            opcao = lerInteiro("Escolha uma opcao: ");

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
                    System.out.println("Encerrando o sistema. Obrigada por utilizar o AGA Palace!");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }
    
    private static void fazerReserva(){
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("             QUARTOS DO AGA PALACE");
        System.out.println("----------------------------------------------");
        
        
        hotel.listarQuartos();
        
        System.out.println("----------------------------------------------");
        System.out.println("                 NOVA RESERVA"                 );
        System.out.println("----------------------------------------------");
        
        System.out.print("\nNome do hospede: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF (11 numeros): ");
        String cpf = scanner.nextLine();
        
        int numeroQuarto = lerInteiro("Numero do quarto: ");
        int dias = lerInteiro("Quantidade de dias: ");

        String erro = hotel.fazerReserva(nome, cpf, numeroQuarto, dias);

        if (erro == null) {
            System.out.println("");
            System.out.println("----------------------------------------------");
            System.out.println("              RESERVA REALIZADA!");
            System.out.println("----------------------------------------------");

            hotel.buscarHospede(cpf).exibirDados();
            System.out.println("");
            
        } else {
            System.out.println("\nNao foi possivel reservar: " + erro);
        }
        System.out.println("");
    }

    private static void consultarReserva() {
        System.out.print("\nCPF do hospede: ");
        Hospede hospede = hotel.buscarHospede(scanner.nextLine());
        
        System.out.println("");

        if (hospede == null) {
            System.out.println("Nenhuma reserva ativa para este CPF.");
        } else {
            System.out.println("----------------------------------------------");
            System.out.println("              DADOS DA RESERVA");
            System.out.println("----------------------------------------------");
            hospede.exibirDados();
            System.out.println("----------------------------------------------");        
        }
    }
        
    
    private static void fazerCheckIn() {
        System.out.print("\nCPF do hospede: ");
        Hospede hospede = hotel.buscarHospede(scanner.nextLine());

        if (hospede == null) {
            System.out.println("Nenhuma reserva ativa para este CPF.");
        } else if (hospede.fazerCheckIn()) {
            System.out.println("Check-in realizado! Bem-vindo(a), " + hospede.getNome() + ".");
        } else {
            System.out.println("Check-in nao permitido. Situacao atual: " + hospede.getSituacao());
        }
        System.out.println("");
    }
    
    // Realizar o check-out
    private static void fazerCheckOut() {
        System.out.print("\nCPF do hospede: ");
        Hospede hospede = hotel.buscarHospede(scanner.nextLine());

        if (hospede == null) {
            System.out.println(
                "Nenhuma reserva ativa para este CPF."
            );
        } else if (hospede.fazerCheckOut()) {
            System.out.println(
                "Check-out realizado com sucesso! Ate logo, "
                + hospede.getNome() + "."
            );
        } else {
            System.out.println(
                "Check-out nao permitido. Situacao atual: "
                + hospede.getSituacao()
            );
        }
        System.out.println("");
    }    
    
     // Repete a pergunta até o usuário digitar um número inteiro
    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Valor invalido. " + mensagem);
        }
   
    
    
        int valor = scanner.nextInt();
        scanner.nextLine(); // consome o ENTER que sobrou
        
        return valor;
    }
    
}
