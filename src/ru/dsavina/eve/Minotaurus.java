package ru.dsavina.eve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Minotaurus {

    public static void main(String[] args) throws IOException {

        byte dimension = 0;
        boolean dimensionNotEntered = true;

        int row = 0;
        int column = 0;

        List<int[]> route = new ArrayList<>();

        boolean exitFound = false;

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (dimensionNotEntered) {
            System.out.println();
            System.out.print("Введи размер > ");

            String dimensionString = br.readLine();

            try {
                dimension = Byte.parseByte(dimensionString);
                dimensionNotEntered = false;
            } catch (NumberFormatException e) {
                System.out.println("Это не число ");
            }
        }

        Cell[][] grid = new Cell[dimension][dimension];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                grid[i][j] = new Cell();

                grid[i][j].wall = (byte) Math.round(Math.random()) == 1; // стена тру, если округленное рандомное число равно единице

                System.out.print(grid[i][j].toString());
            }
            System.out.println();
        }

        while (column < dimension) {

            if (grid[row][column].wall) {
                column++;

            } else {

                while (row != dimension - 1) {

                    if (row != dimension - 1 && !grid[row + 1][column].wall && !grid[row + 1][column].traces) {
                        grid[row][column].traces = true;
                        route.add(new int[]{row, column});
                        row++;
                        System.out.println("Иду вниз...");

                    } else if (column != 0 && !grid[row][column - 1].wall && !grid[row][column - 1].traces) {
                        grid[row][column].traces = true;
                        route.add(new int[]{row, column});
                        column--;
                        System.out.println("Иду влево...");

                    } else if (column != dimension - 1 && !grid[row][column + 1].wall && !grid[row][column + 1].traces) {
                        grid[row][column].traces = true;
                        route.add(new int[]{row, column});
                        column++;
                        System.out.println("Иду вправо...");

                    } else if (row != 0 && !grid[row - 1][column].wall && !grid[row - 1][column].traces) {
                        grid[row][column].traces = true;
                        route.add(new int[]{row, column});
                        row--;
                        System.out.println("Иду вверх...");

                    } else {
                        grid[row][column].traces = true;

                        if (route.size() != 0) {
                            row = route.get(route.size() - 1)[0];
                            column = route.get(route.size() - 1)[1];
                            route.remove(route.size() - 1);
                            System.out.println("Возвращаюсь...");

                        } else {
                            break;
                        }
                    }

                    if (row == dimension - 1) {
                        exitFound = true;
                        System.out.println("Выход из лабиринта есть.");
                        break;
                    }
                }

                column++;
            }
        }

        row = 0;
        column = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j].traces = false;
            }
        }

        while (!exitFound) {

            while (row < dimension) {

                if (grid[row][column].wall) {
                    row++;

                } else {

                    while (column != dimension - 1) {

                        if (column != dimension - 1 && !grid[row][column + 1].wall && !grid[row][column + 1].traces) {
                            grid[row][column].traces = true;
                            route.add(new int[]{row, column});
                            column++;
                            System.out.println("Иду вправо...");

                        } else if (row != dimension - 1 && !grid[row + 1][column].wall && !grid[row + 1][column].traces) {
                            grid[row][column].traces = true;
                            route.add(new int[]{row, column});
                            row++;
                            System.out.println("Иду вниз...");

                        } else if (row != 0 && !grid[row - 1][column].wall && !grid[row - 1][column].traces) {
                            grid[row][column].traces = true;
                            route.add(new int[]{row, column});
                            row--;
                            System.out.println("Иду вверх...");

                        } else if (column != 0 && !grid[row][column - 1].wall && !grid[row][column - 1].traces) {
                            grid[row][column].traces = true;
                            route.add(new int[]{row, column});
                            column--;
                            System.out.println("Иду влево...");

                        } else {

                            grid[row][column].traces = true;

                            if (route.size() != 0) {
                                row = route.get(route.size() - 1)[0];
                                column = route.get(route.size() - 1)[1];
                                route.remove(route.size() - 1);
                                System.out.println("Возвращаюсь...");

                            } else {
                                break;
                            }
                        }

                        if (column == dimension - 1) {
                            exitFound = true;
                            System.out.println("Выход из лабиринта есть.");
                            break;
                        } else {
                            System.out.println("Выхода из лабиринта нет.");
                        }
                    }

                    row++;
                }
            }
        }
    }
}