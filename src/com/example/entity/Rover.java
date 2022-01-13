package com.example.entity;

public class Rover {
    private Coordinate coordinate;
    private Cardinal cardinal;

    public Rover(Coordinate coordinate, Cardinal cardinal) {
        this.coordinate = coordinate;
        this.cardinal = cardinal;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Cardinal getCardinal() {
        return cardinal;
    }

    public void setCardinal(Cardinal cardinal) {
        this.cardinal = cardinal;
    }

    public void move(Letter letter) {
        if (letter.equals(Letter.L)) {
            if (cardinal.equals(Cardinal.N) || cardinal.equals(Cardinal.S)) {
                cardinal = Cardinal.W;
            } else if (cardinal.equals(Cardinal.W) || cardinal.equals(Cardinal.E)) {
                cardinal = Cardinal.N;
            } else {
                System.out.println("No sens!");
            }
        } else if (letter.equals(Letter.R)) {
            if (cardinal.equals(Cardinal.N) || cardinal.equals(Cardinal.S)) {
                cardinal = Cardinal.E;
            } else if (cardinal.equals(Cardinal.W) || cardinal.equals(Cardinal.E)) {
                cardinal = Cardinal.S;
            } else {
                System.out.println("No sens!");
            }
        } else if (letter.equals(Letter.M)) {
            if (cardinal.equals(Cardinal.N)) {
                coordinate.setY(coordinate.getY() + 1);
            } else if (cardinal.equals(Cardinal.S)) {
                coordinate.setY(coordinate.getY() - 1);
            } else if (cardinal.equals(Cardinal.E)) {
                coordinate.setX(coordinate.getX() + 1);
            } else if (cardinal.equals(Cardinal.W)) {
                coordinate.setX(coordinate.getX() - 1);
            }
        }
    }

    @Override
    public String toString() {
        return coordinate.getX() + " " + coordinate.getY() + " " +  cardinal.toString();
    }
}
