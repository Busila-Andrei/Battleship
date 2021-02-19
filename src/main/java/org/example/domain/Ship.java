package org.example.domain;

import org.example.utils.ScannerUtils;

public class Ship {


    public static void create(Board board, Player player,String ship, int size){
        boolean test = false;
        int literalsOne=0;
        int numberOne=0;
        int literalsTwo=0;
        int numberTwo=0;
        while (!test) {
            String[] input = ScannerUtils.nextLine().split(" ");
            String[] inputOne = new String[]{input[0].substring(0, 1), input[0].substring(1)};
            String[] inputTwo = new String[]{input[1].substring(0, 1), input[1].substring(1)};

            literalsOne = inputOne[0].charAt(0) - 64;
            numberOne = Integer.parseInt(inputOne[1]);
            literalsTwo = inputTwo[0].charAt(0) - 64;
            numberTwo = Integer.parseInt(inputTwo[1]);



            if (literalsOne >= 1 && literalsTwo <= 10 && literalsOne == literalsTwo && numberOne >= 1 && numberTwo <= 10) {
                if (numberOne > numberTwo) {
                    int aux = numberOne;
                    numberOne = numberTwo;
                    numberTwo = aux;
                }

                test = horizontal(literalsOne,numberOne,literalsTwo,numberTwo,board,size);

            } else if (numberOne >= 1 && numberTwo <= 10 && numberOne == numberTwo && literalsOne >= 1 && literalsTwo <= 10) {
                if (literalsOne > literalsTwo) {
                    int aux = literalsOne;
                    literalsOne = literalsTwo;
                    literalsTwo = aux;
                }

                test = vertical(literalsOne,numberOne,literalsTwo,numberTwo,board,size);

            } else {
                System.out.println("\nError! Wrong ship location! Try again:\n");
                test = false;
            }
        }

        switch (ship){
            case "AIRCRAFT":
                player.setAircraft(literalsOne,numberOne,literalsTwo,numberTwo);
                break;
            case "BATTLESHIP":
                player.setBattleship(literalsOne,numberOne,literalsTwo,numberTwo);
                break;
            case "SUBMARINE":
                player.setSubmarine(literalsOne,numberOne,literalsTwo,numberTwo);
                break;
            case "CRUISER":
                player.setCruiser(literalsOne,numberOne,literalsTwo,numberTwo);
                break;
            case "DESTROYER":
                player.setDestroyer(literalsOne,numberOne,literalsTwo,numberTwo);
                break;
        }

    }

    private static boolean horizontal(int literalsOne, int numberOne, int literalsTwo, int numberTwo, Board board, int size){
        boolean test = true;
        if (numberTwo - numberOne + 1 == size) {
            String[][] map = board.getBoard();
            for (int i = literalsOne - 1; i <= literalsTwo + 1; i++) {
                for (int j = numberOne - 1; j <= numberTwo + 1; j++) {
                    if (map[i][j].equals("O")) {
                        test = false;
                        break;
                    }
                }
            }
            if (test) {
                for (int i = literalsOne; i <= literalsTwo; i++) {
                    for (int j = numberOne; j <= numberTwo; j++) {
                        map[i][j] = "O";
                    }
                }
                board.setBoard(map);
            } else {
                System.out.println("\nError! You placed it too close to another one. Try again:\n");
            }

        } else {
            System.out.println("\nError! Wrong length of the Submarine! Try again:\n");
            test = false;
        }
        return test;
    }

    private static boolean vertical(int literalsOne, int numberOne, int literalsTwo, int numberTwo, Board board, int size){
        boolean test = true;
        if (literalsTwo - literalsOne + 1 == size) {
            String[][] map = board.getBoard();
            for (int i = literalsOne - 1; i <= literalsTwo + 1; i++) {
                for (int j = numberOne - 1; j <= numberTwo + 1; j++) {
                    if (map[i][j].equals("O")) {
                        test = false;
                        break;
                    }
                }
            }
            if (test) {
                for (int i = literalsOne; i <= literalsTwo; i++) {
                    for (int j = numberOne; j <= numberTwo; j++) {
                        map[i][j] = "O";
                    }
                }
                board.setBoard(map);

            } else {
                System.out.println("\nError! You placed it too close to another one. Try again:\n");
            }
        } else {
            System.out.println("\nError! Wrong length of the Submarine! Try again:\n");
            test = false;
        }
        return test;
    }


}
