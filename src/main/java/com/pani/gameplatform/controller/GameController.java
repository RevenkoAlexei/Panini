package com.pani.gameplatform.controller;

import com.pani.gameplatform.domain.Game;
import com.pani.gameplatform.dto.AddGameDTO;
import com.pani.gameplatform.dto.GameDTO;
import com.pani.gameplatform.service.DataBaseQuerries;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/games-public-library")
public class GameController {

    @GetMapping(path = "/all")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Game> getAllAvailableGames() throws SQLException, ClassNotFoundException {
        return DataBaseQuerries.getAllGames();
    }


    @GetMapping(path = "/game", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Game getSpecficGameByGameId(@RequestParam(value = "game_id") int game_id) {
        return DataBaseQuerries.getGameById(game_id);
    }

    @PostMapping(path = "/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createNewGameInPublicLibrary(@RequestParam(value = "game_id") int game_id,
                                                @RequestParam(value = "game_name") String game_name,
                                                @RequestParam(value = "game_description") String game_description,
                                                @RequestParam(value = "game_creator") String game_creator,
                                                @RequestParam(value = "game_release")String game_release) {
        System.out.println(game_id);
        System.out.println(game_name);
        System.out.println(game_description);
        System.out.println(game_creator);
        System.out.println(game_release);

        DataBaseQuerries.addNewGame(new Game(game_id,game_name,game_description,game_creator,LocalDate.parse(game_release)));
    }


}
