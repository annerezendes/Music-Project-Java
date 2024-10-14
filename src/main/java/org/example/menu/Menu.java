package org.example.menu;

import java.util.Scanner;


public class Menu {
    Scanner scanner = new Scanner(System.in);

    MenuOperations menuOperations = new MenuOperations();

    int opcao = 0;


    public void exibirMenu(){
        while(opcao !=7){

            System.out.println("\r\n============ MENU ============");
            System.out.println("1. Cadastrar novo artista"); // feito
            System.out.println("2. Cadastar novo álbum"); // feito
            System.out.println("3. Cadastrar nova música"); // ok
            System.out.println("4. Listar todos os artista, álbuns e músicas"); // artista e album feito
            System.out.println("5. Buscar artista por gênero"); // feito
            System.out.println("6. Buscar álbuns por ano"); // feito
            System.out.println("7. Sair da aplicação"); // ok
            System.out.println("Digite uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuOperations.cadastrarArtista();
                    continue;
                case 2:
                    menuOperations.cadastrarAlbum();
                    continue;
                case 3:
                    menuOperations.cadastrarMusica();
                    continue;
                case 4:
                    menuOperations.listar();
                    continue;
                case 5:
                    menuOperations.buscarArtistaPorGenero();
                    continue;
                case 6:
                    menuOperations.buscarAlbunsPorAno();
                    continue;
                case 7:
                    System.out.println("Sistema encerrado...");
                    break;
                default:
                    System.out.println("Opção Inválida");

            }
        }
    }

}

