package org.example.entidades;

import org.example.servicos.ValidadorEntidades;

import java.util.ArrayList;
import java.util.List;

public class Artista extends _EntidadeBase{
    private String nome;
    private String generoMusical;
    private List<Album> listaDeAlbum = new ArrayList<>();

    public Artista() {
    }

    public Artista(int id, String nome, String generoMusical) {
        super(id);
        this.nome = nome;
        this.generoMusical = generoMusical;
    }

    public Artista(String nome) {
        this.nome = nome;
    }

    public Artista(int id, String nome) {
        super(id);
        this.nome = nome;
    }

    public Artista(String generoMusical, List<Album> listaDeAlbum) {
        this.generoMusical = generoMusical;
        this.listaDeAlbum = listaDeAlbum;
    }

    public Artista(int id, String generoMusical, List<Album> listaDeAlbum) {
        super(id);
        this.generoMusical = generoMusical;
        this.listaDeAlbum = listaDeAlbum;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(ValidadorEntidades.validarVazio(nome)) {
            this.nome = nome;
        }
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        if(ValidadorEntidades.validarVazio(generoMusical)) {
            this.generoMusical = generoMusical;
        }
    }

    public List<Album> getListaDeAlbum() {
        return listaDeAlbum;
    }

    public void setListaDeAlbum(List<Album> listaDeAlbum) {
        this.listaDeAlbum = listaDeAlbum;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nome='" + nome + '\'' +
                ", generoMusical='" + generoMusical + '\'' +
                ", listaDeAlbum=" + listaDeAlbum +
                '}';
    }
}
