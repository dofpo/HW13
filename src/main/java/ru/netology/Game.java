package ru.netology;

import lombok.Data;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

@Data

public class Game {
    protected List<Player> players = new ArrayList<>();

    public Game() {
        this.players = players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players)
            if (player.getName().equals(name)) {
                Player tmp = player;
                return tmp;
            }

        return null;
    }

    public int round(String player1Num, String player2Num) {

        if (findByName(player1Num) != null) {

            if (findByName(player2Num) != null) {

                if (findByName(player1Num).getStrength() > findByName(player2Num).getStrength()) {
                    return 2;
                }
                if (findByName(player1Num).getStrength() == findByName(player2Num).getStrength()) {
                    return 1;
                }
                return 0;
            }
            throw new NotRegisteredException("Игрок " + player2Num + " не зарегистрирован");
        }
        throw new NotRegisteredException("Игрок " + player1Num + " не зарегистрирован");
    }
}



