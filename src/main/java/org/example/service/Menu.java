package org.example.service;

import org.example.domain.Board;
import org.example.domain.Hit;
import org.example.domain.Player;
import org.example.domain.Ship;

import java.io.IOException;

public class Menu {
    private Board boardPlayerOne;
    private Board boardPlayerTwo;
    private final Player playerOne = new Player();
    private final Player playerTwo = new Player();
    private final Board boardShadow = new Board();

    public void logic() {
        boardPlayerOne = new Board();
        boardPlayerTwo = new Board();
        System.out.println("Player 1, place your ships on the game field\n");
        player(boardPlayerOne,playerOne);
        promptEnterKey();
        System.out.println("Player 2, place your ships to the game field\n");
        player(boardPlayerTwo,playerTwo);

        boardShadow.createBoard();
        battle();




    }

    public static void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void player(Board board, Player player){
        board.createBoard();
        board.printBoard();
        System.out.println();

        System.out.print("Enter the coordinates of the Aircraft Carrier (5 cells):\n");
        Ship.create(board,player,"AIRCRAFT", 5);
        board.printBoard();

        System.out.print("Enter the coordinates of the Battleship (4 cells):\n");
        Ship.create(board,player,"BATTLESHIP",4);
        board.printBoard();

        System.out.print("Enter the coordinates of the Submarine (3 cells):\n");
        Ship.create(board,player,"SUBMARINE",3);
        board.printBoard();

        System.out.print("Enter the coordinates of the Cruiser (3 cells):\n");
        Ship.create(board,player,"CRUISER",3);
        board.printBoard();

        System.out.print("Enter the coordinates of the Destroyer (2 cells):\n");
        Ship.create(board,player,"DESTROYER",2);
        board.printBoard();
    }

    public void battle(){
        for (;;){
            promptEnterKey();
            boardShadow.printBoard();
            System.out.println("---------------------");
            boardPlayerOne.printBoard();
            System.out.println("\nPlayer 1, it's your turn:\n");

            if (Hit.execute(boardPlayerTwo, playerTwo)){
                break;
            }
            promptEnterKey();
            boardShadow.printBoard();
            System.out.println("---------------------");
            boardPlayerTwo.printBoard();
            System.out.println("\nPlayer 2, it's your turn:\n");
            if (Hit.execute(boardPlayerOne, playerOne)){
                break;
            }
        }
    }
}
