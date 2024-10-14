package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entidades.Artista;
import org.example.menu.Menu;
import org.example.repositorios.AlbumRep;
import org.example.repositorios.ArtistaRep;
import org.example.repositorios.MusicaRep;

import java.util.Scanner;

public class Main {
    public static MusicaRep musicaRep = new MusicaRep();
    public static AlbumRep albumRep = new AlbumRep();
    public static ArtistaRep artistaRep = new ArtistaRep();
    public static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Sistema iniciando...");
        logger.info("Sistema inicado.");
        Menu menu = new Menu();
        menu.exibirMenu();


    }
}