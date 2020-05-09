package ru.dsavina.eve;

public class Cell {

    boolean wall = false;

    boolean traces = false;

    @Override
    public String toString() {
        if (wall) {
            return "X";
        } else {
            return "0";
        }
    }
}
