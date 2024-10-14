package org.example.repositorios;

import org.example.entidades.Artista;
import org.example.infraestrutura.DataBaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistaRep extends RepBaseImp<Artista> {
    public List<Artista> buscarPorGenero(String generoMusical) {
        ArrayList<Artista> artistas = new ArrayList();

        try {
            Connection conn = DataBaseConfig.getConnection();
            String query = "SELECT * FROM CP_ARTISTA WHERE UPPER(GENERO_MUSICAL)  LIKE UPPER (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, generoMusical);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int rsId = rs.getInt("ID_ARTISTA");
                String rsNome = rs.getString("NOME");
                String rsGenero = rs.getString("GENERO_MUSICAL");
                artistas.add(new Artista(rsId, rsNome, rsGenero));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException var10) {
            SQLException e = var10;
            e.printStackTrace();
        }

        return artistas;

    }

    @Override
    public void adicionar(Artista artista) {

        try {
            // conectando com banco de dados
            Connection conn = DataBaseConfig.getConnection();

            // insert db
            String query = "INSERT INTO CP_ARTISTA (NOME, GENERO_MUSICAL) VALUES (?,?)";

            // ajustando os comandos sql
            PreparedStatement stmt = conn.prepareStatement(query);

            // passando os objetos nos lugares das variáveis "?"
            stmt.setString(1, artista.getNome());
            stmt.setString(2, artista.getGeneroMusical());

            //
            stmt.executeUpdate();
            stmt.close();
            conn.close();


        } catch (SQLException var5) {
            SQLException e = var5;
            e.printStackTrace();
        }
    }

    @Override
    public List<Artista> listar() {
        ArrayList<Artista> artistas = new ArrayList();

        try {
            Connection conn = DataBaseConfig.getConnection();
            String query = "SELECT * FROM CP_ARTISTA ORDER BY ID_ARTISTA";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int rsId = rs.getInt("ID_ARTISTA");
                String rsNome = rs.getString("NOME");
                String rsGenero = rs.getString("GENERO_MUSICAL");
                artistas.add(new Artista(rsId, rsNome, rsGenero));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException var10) {
            SQLException e = var10;
            e.printStackTrace();
        }

        return artistas;
    }

    public Artista listarPorId(int id) {
        var artistaSalvo = new Artista();

        try {
            Connection conn = DataBaseConfig.getConnection();
            String query = "SELECT * FROM CP_ARTISTA WHERE ID_ARTISTA = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                artistaSalvo.setId(rs.getInt("ID_ARTISTA"));
                artistaSalvo.setNome(rs.getString("NOME"));
                artistaSalvo.setGeneroMusical(rs.getString("GENERO_MUSICAL"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException var10) {
            SQLException e = var10;
            e.printStackTrace();
        }

        return artistaSalvo;
    }
}


