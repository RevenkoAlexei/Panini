package com.pani.gameplatform.service;

import com.pani.gameplatform.domain.Game;
import com.pani.gameplatform.dto.GameDTO;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseQuerries {

    public static List<Game> getAllGames() throws SQLException, ClassNotFoundException {
        List<Game> games = new ArrayList<>();
        try {
            Connection conn = mysqlDataSource().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM GAME");

            while (rs.next()) {
                games.add(new Game(rs.getInt("ID_GAME"),
                        rs.getString("NAME"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("GAME_CREATOR"),
                        rs.getDate("RELEASE_DATE").toLocalDate()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }


    public static Game getGameById(int id) {
        try {
            List<Game> games = new ArrayList<>();

            Connection conn = mysqlDataSource().getConnection();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM GAME WHERE ID_GAME=4";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println(rs.toString());
            while (rs.next()) {
                games.add(new Game(rs.getInt("ID_GAME"),
                        rs.getString("NAME"),
                        rs.getString("DESCRIPTION"),
                        rs.getString("GAME_CREATOR"),
                        rs.getDate("RELEASE_DATE").toLocalDate()));
            }
            return games.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");

        return dataSource;
    }

    public static void addNewGame(Game game) {
        try {
            Connection conn = mysqlDataSource().getConnection();
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO GAME VALUES ("
                    + game.getId_game() + ",'"
                    + game.getName() + "','"
                    + game.getDescription() + "','"
                    + game.getGame_creator() + "','"
                    + game.getRelease_date() + "')";
           stmt.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
