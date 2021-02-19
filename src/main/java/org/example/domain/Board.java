package org.example.domain;

public class Board {

    String[][] board = new String[12][12];

    public void createBoard(){
        for (int i = 0; i < this.board.length; i++){
            for (int j = 0; j < this.board.length; j++){
                this.board[i][j] = "~";
                if (i==0 && j ==0){
                    this.board[i][j] = " ";
                }else
                if (i == 0 && j < this.board.length-1){
                    this.board[i][j] = String.valueOf(j);
                }else if (j == 0 && i < this.board.length-1){
                    this.board[i][j] = String.valueOf((char)(i+64));
                }else if (j == this.board.length-1 || i == this.board.length-1 ){
                    this.board[i][j] = " ";
                }
            }
        }
    }

    public void printBoard(){
        for (int i = 0; i < this.board.length-1; i++){
            for (int j = 0; j < this.board.length-1; j++){
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }
}
