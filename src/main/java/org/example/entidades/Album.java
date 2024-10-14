package org.example.entidades;

import org.example.servicos.ValidadorEntidades;

import java.util.ArrayList;
import java.util.List;

public class Album extends _EntidadeBase{

     private String titulo;
     private int anoDeLancamento;
     private Artista artista;
     private List<Musica> listaDeMusica = new ArrayList<>();

    public Album() {
    }

    public Album(int id, String titulo, int anoDeLancamento, Artista artista) {
        super(id);
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.artista = artista;
    }

    public Album(String titulo, int anoDeLancamento, Artista artista, List<Musica> listaDeMusica) {
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.artista = artista;
        this.listaDeMusica = listaDeMusica;
    }

    public Album(int id, String titulo, int anoDeLancamento, Artista artista, List<Musica> listaDeMusica) {
        super(id);
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.artista = artista;
        this.listaDeMusica = listaDeMusica;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(ValidadorEntidades.validarVazio(titulo)) {
            this.titulo = titulo;
        }
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        if(ValidadorEntidades.validarInt(anoDeLancamento)) {
            this.anoDeLancamento = anoDeLancamento;
        }
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public List<Musica> getListaDeMusica() {
        return listaDeMusica;
    }

    public void setListaDeMusica(List<Musica> listaDeMusica) {
        this.listaDeMusica = listaDeMusica;
    }

    @Override
    public String toString() {
        return "Album{" +
                "titulo='" + titulo + '\'' +
                ", anoDeLancamento=" + anoDeLancamento +
                ", artista=" + artista +
                ", listaDeMusica=" + listaDeMusica +
                '}';
    }
}
