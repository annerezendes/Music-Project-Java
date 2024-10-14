package org.example.entidades;

import org.example.servicos.ValidadorEntidades;

public class Musica extends _EntidadeBase{

    private String titulo;
    private int duracao;
    private Album album;

    public Musica() {
    }

    public Musica(int id, String titulo, int duracao, Album album) {
        super(id);
        this.titulo = titulo;
        this.duracao = duracao;
        this.album = album;
    }

    public Musica(String titulo, int duracao, Album album) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.album = album;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if(ValidadorEntidades.validarVazio(titulo)) {
            this.titulo = titulo;
        }
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        if(ValidadorEntidades.validarInt(duracao)) {
            this.duracao = duracao;
        }
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "titulo='" + titulo + '\'' +
                ", duracao=" + duracao +
                ", album=" + album +
                '}';
    }
}
