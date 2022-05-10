package com.pani.gameplatform.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Game {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id_game;

    private String name;

    private String description;

    private String game_creator;

    private LocalDate release_date;

    public Game(String name, String description, String game_creator, LocalDate release_date) {
        this.name = name;
        this.description = description;
        this.game_creator = game_creator;
        this.release_date = release_date;
    }

    public Game(int id_game, String name, String description, String game_creator, LocalDate release_date) {
        this.id_game = id_game;
        this.name = name;
        this.description = description;
        this.game_creator = game_creator;
        this.release_date = release_date;
    }

    public int getId_game() {
        return id_game;
    }

    public void setId_game(int id_game) {
        this.id_game = id_game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGame_creator() {
        return game_creator;
    }

    public void setGame_creator(String game_creator) {
        this.game_creator = game_creator;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }
}
