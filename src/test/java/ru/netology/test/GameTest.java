package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    public Game game;
    Player player1 = new Player(1, "Петя", 2);
    Player player2 = new Player(2, "Вася", 3);
    Player player3 = new Player(3, "Миша", 2);

    public GameTest() {
        game = new Game();
    }

    @Test
    void registered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Collection expected = Arrays.asList(player1, player2, player3);
        Collection actual = game.getPlayers();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findByName() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Player expected = player2;
        Player actual = game.findByName("Вася");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void RoundFirstPlayerWins() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        int expected = 2;
        int actual = game.round("Вася", "Петя");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void RoundSecondPlayerWins() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        int expected = 0;
        int actual = game.round("Петя", "Вася");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void RoundNobodyWins() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        int expected = 1;
        int actual = game.round("Петя", "Миша");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void NoRegisterFirstPlayer() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, ()->game.round("Митя","Вася"));
    }
    @Test
    void NoRegisterSecondPlayer1() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, ()->game.round("Миша","Женя"));
    }
}

