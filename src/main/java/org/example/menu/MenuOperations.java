package org.example.menu;

import org.example.entidades.Album;
import org.example.entidades.Artista;
import org.example.entidades.Musica;

import java.util.List;
import java.util.Scanner;

import static org.example.Main.*;

public class MenuOperations {
    Scanner scanner = new Scanner(System.in);
    public void cadastrarArtista() {
        var artista = new Artista();
        System.out.println("Digite o nome do Artista: ");
        var nomeArtista = scanner.nextLine();
        artista.setNome(nomeArtista);
        System.out.println("Digite o gênero musical do artista");
        var generoArtista = scanner.nextLine();
        artista.setGeneroMusical(generoArtista);
        artistaRep.adicionar(artista);
        logger.info("Artista cadastrado.");
    }

    public void cadastrarAlbum(){
        var album = new Album();
        var confirmacao = false;
        System.out.println("Digite o título do Álbum: ");
        var tituloAlbum = scanner.nextLine();
        album.setTitulo(tituloAlbum);

        System.out.println("Digite o ano de lançamento do Álbum: ");
        var anoAlbum = scanner.nextInt();
        scanner.nextLine();
        album.setAnoDeLancamento(anoAlbum);

        var idArtista = 0;
        while (!confirmacao){
            System.out.println("Digite o ID do Artista: ");
            idArtista = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Artista: " + artistaRep.listarPorId(idArtista));
            System.out.println("Confirmar artista do álbum? S/N");
            var opcaoArtista = scanner.nextLine();
            if(opcaoArtista.equalsIgnoreCase("s")){
                confirmacao = true;
            } else if (opcaoArtista.equalsIgnoreCase("n")) {
            } else{
                System.out.println("Opção Inválida!");
            }
        }
        albumRep.adicionar(album, idArtista);
        logger.info("Álbum cadastrado.");

    }

    public void cadastrarMusica(){
        var confirmacao = false;
        var idAlbum = 0;

        var musica = new Musica();
        System.out.println("Digite o título da música: ");
        var tituloMusica = scanner.nextLine();
        musica.setTitulo(tituloMusica);

        System.out.println("Digite o tempo de duração da música em segundos: ");
        var tempoMusica = scanner.nextInt();
        scanner.nextLine();
        musica.setDuracao(tempoMusica);

        while (!confirmacao){
            System.out.println("Digite o ID do Album: ");
            idAlbum = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Album: " + albumRep.listarPorId(idAlbum));
            System.out.println("Confirmar album da música? S/N");
            var opcaoAlbum = scanner.nextLine();
            if(opcaoAlbum.equalsIgnoreCase("s")){
                confirmacao = true;
            } else if (opcaoAlbum.equalsIgnoreCase("n")) {
            } else{
                System.out.println("Opção Inválida!");
            }
        }

        musicaRep.adicionar(musica, idAlbum);
        logger.info("Música cadastrada!");

    }

    public void listar(){
       List<Artista> artistaList = artistaRep.listar();
       List<Album> albumList = albumRep.listar();
       List<Musica> musicaList = musicaRep.listar();

        System.out.println("-------Artistas-------");
       for(Artista artista: artistaList){
           System.out.println("\nNome: " + artista.getNome());
           System.out.println("Gênero Musical: " + artista.getGeneroMusical());
       }
        System.out.println("\r\n--------Albuns--------");
       for(Album album: albumList){
           System.out.println("\nTítulo: " + album.getTitulo());
           System.out.println("Ano de lançamento: " + album.getAnoDeLancamento());
           System.out.println("Artista: " + album.getArtista().getNome());
       }
        System.out.println("\r\n--------Músicas--------");
        for(Musica musica: musicaList){
            System.out.println("\nTítulo: " + musica.getTitulo());
            System.out.println("Duração: " + musica.getDuracao() + " segundos");
            System.out.println("Album: " + musica.getAlbum().getTitulo());
            System.out.println("Artista: " + musica.getAlbum().getArtista().getNome());
        }

    }

    public void buscarArtistaPorGenero(){
        System.out.println("Digite o gênero: ");
        var genero = scanner.nextLine();
        System.out.println(artistaRep.buscarPorGenero(genero));
        logger.info("Busca por gênero concluída.");
    }

    public void buscarAlbunsPorAno(){
        System.out.println("Digite o ano do álbum: ");
        var ano = scanner.nextInt();
        scanner.nextLine();
        List<Album> albumsList = albumRep.buscarPorAno(ano);
        if(albumsList.isEmpty()){
            System.out.println("Não existem albuns cadastrados nesse ano.");
        } else {
            for (Album album : albumsList) {
                System.out.println("\nTítulo: " + album.getTitulo());
                System.out.println("Ano de lançamento: " + album.getAnoDeLancamento());
                System.out.println("Artista: " + album.getArtista().getNome());
            }
        }
        logger.info("Busca por ano concluída.");
    }
}
