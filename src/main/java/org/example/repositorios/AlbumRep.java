package org.example.repositorios;

import org.example.entidades.Album;
import org.example.entidades.Artista;
import org.example.infraestrutura.DataBaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumRep extends RepBaseImp <Album>{

    ArtistaRep artistaRep = new ArtistaRep();
    public List<Album> buscarPorAno(int anoDeLancamento){
        ArrayList<Album> albuns = new ArrayList();


        try {
            Connection conn = DataBaseConfig.getConnection();
            String query = "SELECT * FROM CP_ALBUM WHERE ANO_LANCAMENTO = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, anoDeLancamento);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int rsId = rs.getInt("ID_ALBUM");
                String rsTituloAlbum = rs.getString("TITULO_ALBUM");
                int rsAnoLanc = rs.getInt("ANO_LANCAMENTO");
                Artista artista = artistaRep.listarPorId(rs.getInt("ID_ARTISTA"));
                albuns.add(new Album(rsId, rsTituloAlbum, rsAnoLanc, artista));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException var10) {
            SQLException e = var10;
            e.printStackTrace();
        }

        return albuns;
    }

    public void adicionar(Album album, int idArtista) {

        try {
            // conectando com banco de dados
            Connection conn = DataBaseConfig.getConnection();

            // insert db
            String query = "INSERT INTO CP_ALBUM (TITULO_ALBUM, ANO_LANCAMENTO, ID_ARTISTA) VALUES (?,?,?)";

            // ajustando os comandos sql
            PreparedStatement stmt = conn.prepareStatement(query);

            // passando os objetos nos lugares das variáveis "?"
            stmt.setString(1, album.getTitulo());
            stmt.setInt(2, album.getAnoDeLancamento());
            stmt.setInt(3, idArtista);

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
    public List<Album> listar() {
        ArrayList<Album> albuns = new ArrayList();


        try {
            Connection conn = DataBaseConfig.getConnection();
            String query = "SELECT * FROM CP_ALBUM ORDER BY ID_ALBUM";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int rsId = rs.getInt("ID_ALBUM");
                String rsTituloAlbum = rs.getString("TITULO_ALBUM");
                int rsAnoLanc = rs.getInt("ANO_LANCAMENTO");
                Artista artista = artistaRep.listarPorId(rs.getInt("ID_ARTISTA"));
                albuns.add(new Album(rsId, rsTituloAlbum, rsAnoLanc, artista));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException var10) {
            SQLException e = var10;
            e.printStackTrace();
        }

        return albuns;
    }

    public Album listarPorId(int id) {
        var albumSalvo = new Album();

        try {
            Connection conn = DataBaseConfig.getConnection();
            String query = "SELECT * FROM CP_ALBUM WHERE ID_ALBUM = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                albumSalvo.setId(rs.getInt("ID_ALBUM"));
                albumSalvo.setTitulo(rs.getString("TITULO_ALBUM"));
                albumSalvo.setAnoDeLancamento(rs.getInt("ANO_LANCAMENTO"));
                albumSalvo.setArtista(artistaRep.listarPorId(rs.getInt("ID_ARTISTA")));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException var10) {
            SQLException e = var10;
            e.printStackTrace();
        }

        return albumSalvo;
    }

}
