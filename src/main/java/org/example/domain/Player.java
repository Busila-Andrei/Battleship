package org.example.domain;

public class Player {
    private int[] aircraft = {};
    private int[] battleship = new int[4];
    private int[] cruiser = new int[4];
    private int[] destroyer = new int[4];
    private int[] submarine = new int[4];

    public int[] getAircraft() {
        return aircraft;
    }

    public void setAircraft(int a, int b, int c, int d) {
        this.aircraft = new int[]{a, b, c, d};
    }

    public int[] getBattleship() {
        return battleship;
    }

    public void setBattleship(int a, int b, int c, int d) {
        this.battleship = new int[]{a, b, c, d};
    }

    public int[] getCruiser() {
        return cruiser;
    }

    public void setCruiser(int a, int b, int c, int d) {
        this.cruiser = new int[]{a, b, c, d};
    }

    public int[] getDestroyer() {
        return destroyer;
    }

    public void setDestroyer(int a, int b, int c, int d) {
        this.destroyer = new int[]{a, b, c, d};
    }

    public int[] getSubmarine() {
        return submarine;
    }

    public void setSubmarine(int a, int b, int c, int d) {
        this.submarine = new int[]{a, b, c, d};
    }
}
