package org.example.repositorios;

import org.example.entidades.Album;
import org.example.entidades.Artista;
import org.example.entidades.Musica;
import org.example.infraestrutura.DataBaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicaRep extends RepBaseImp <Musica>{

    AlbumRep albumRep = new AlbumRep();

    public void adicionar(Musica musica, int idAlbum) {

        try {
            // conectando com banco de dados
            Connection conn = DataBaseConfig.getConnection();

            // insert db
            String query = "INSERT INTO CP_MUSICA (TITULO_MUSICA, DURACAO, ID_ALBUM) VALUES (?,?,?)";

            // ajustando os comandos sql
            PreparedStatement stmt = conn.prepareStatement(query);

            // passando os objetos nos lugares das variáveis "?"
            stmt.setString(1, musica.getTitulo());
            stmt.setInt(2, musica.getDuracao());
            stmt.setInt(3, idAlbum);

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
    public List<Musica> listar() {
        ArrayList<Musica> musicas = new ArrayList();


        try {
            Connection conn = DataBaseConfig.getConnection();
            String query = "SELECT * FROM CP_MUSICA ORDER BY ID_MUSICA";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int rsId = rs.getInt("ID_MUSICA");
                String rsTituloMusica = rs.getString("TITULO_MUSICA");
                int rsDuracao = rs.getInt("DURACAO");
                Album rsAlbum = albumRep.listarPorId(rs.getInt("ID_ALBUM"));
                musicas.add(new Musica(rsId, rsTituloMusica, rsDuracao, rsAlbum));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException var10) {
            SQLException e = var10;
            e.printStackTrace();
        }

        return musicas;
    }
}
