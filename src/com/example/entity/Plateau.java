package com.example.entity;

public class Plateau {
    private Coordinate upperRight;
    private Coordinate lowerLeft;

    public Plateau(Coordinate upperRight) {
        this.upperRight = upperRight;
        this.lowerLeft = new Coordinate(0, 0);
    }

    public Coordinate getUpperRight() {
        return upperRight;
    }

    public void setUpperRight(Coordinate upperRight) {
        this.upperRight = upperRight;
    }

    public Coordinate getLowerLeft() {
        return lowerLeft;
    }

    public void setLowerLeft(Coordinate lowerLeft) {
        this.lowerLeft = lowerLeft;
    }
}
