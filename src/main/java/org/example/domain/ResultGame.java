package org.example.domain;

public class ResultGame {

    public static boolean score(Board board){
        String[][] map = board.getBoard();
        for (int i = 1; i < map.length-1;i++){
            for (int j = 1; j < map.length-1; j++){
                if (map[i][j].equals("O"))
                    return true;
            }
        }
        return false;
    }

}
