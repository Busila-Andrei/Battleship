package org.example.domain;

import org.example.utils.ScannerUtils;

public class Hit {

    public static boolean execute(Board board, Player player) {
        String[][] map = board.getBoard();

        for (; ; ) {
            String input = ScannerUtils.nextLine();
            String[] inputCord = new String[]{input.substring(0, 1), input.substring(1)};
            int literal = inputCord[0].charAt(0) - 64;
            int number = Integer.parseInt(inputCord[1]);

            if (literal >= 1 && literal <= 10 && number >= 1 && number <= 10) {
                if (map[literal][number].equals("O")) {
                    map[literal][number] = "X";
                    board.setBoard(map);

                    if (verifyHit(map,player,literal,number) ){
                        if (ResultGame.score(board))
                            System.out.println("\nYou sank a ship!\n");
                        else {System.out.println("\nYou sank the last ship. You won. Congratulations!\n");
                            return true;
                        }
                    }else System.out.println("\nYou hit a ship!\n");
                } else if (map[literal][number].equals("~")) {
                    map[literal][number] = "M";
                    board.setBoard(map);
                    System.out.println("\nYou missed!\n");
                }

                break;

            } else {
                System.out.println("\nError! You placed it too close to another one. Try again:\n");
            }
        }
        return false;
    }


    public static boolean verifyHit(String[][] map, Player player, int literal, int number) {
        int[] array;
        boolean test = false;
        int nr = 0;
        array = player.getAircraft();
        for (int i = array[0]; i <= array[2]; i++) {
            for (int j = array[1]; j <= array[3]; j++) {
                if (map[i][j].equals("X"))
                    nr++;
                if (literal == i && number == j) {
                    test = true;
                }
            }
        }

        if (nr == 5 && test){
            return true;
        } else test = false;

        nr = 0;

        array = player.getBattleship();
        for (int i = array[0]; i <= array[2]; i++) {
            for (int j = array[1]; j <= array[3]; j++) {
                if (map[i][j].equals("X"))
                    nr++;
                if (literal == i && number == j) {
                    test = true;
                }
            }
        }

        if (nr == 4 && test){
            return true;
        } else test = false;

        nr = 0;

        array = player.getCruiser();
        for (int i = array[0]; i <= array[2]; i++) {
            for (int j = array[1]; j <= array[3]; j++) {
                if (map[i][j].equals("X"))
                    nr++;
                if (literal == i && number == j) {
                    test = true;
                }
            }
        }

        if (nr == 3 && test){
            return true;
        } else test = false;

        nr = 0;

        array = player.getSubmarine();
        for (int i = array[0]; i <= array[2]; i++) {
            for (int j = array[1]; j <= array[3]; j++) {
                if (map[i][j].equals("X"))
                    nr++;
                if (literal == i && number == j) {
                    test = true;
                }
            }
        }

        if (nr == 3 && test){
            return true;
        } else test = false;

        nr = 0;

        array = player.getDestroyer();
        for (int i = array[0]; i <= array[2]; i++) {
            for (int j = array[1]; j <= array[3]; j++) {
                if (map[i][j].equals("X"))
                    nr++;
                if (literal == i && number == j) {
                    test = true;
                }
            }
        }

        return nr == 2 && test;

    }
}
