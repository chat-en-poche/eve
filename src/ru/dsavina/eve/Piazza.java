package ru.dsavina.eve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Piazza {

    public static void main(String[] args) throws IOException {

        while (true) {

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.println();
            System.out.print("Название фигуры > ");

            String shape = br.readLine().toLowerCase();

            if ("треугольник".equals(shape) || "круг".equals(shape)) {

                System.out.print("Попробуй через пару дней, мальчик.");

            } else if ("прямоугольник".equals(shape)) {

                boolean notEnteredLength = true;

                float length = 0;

                float width = 0;

                while (notEnteredLength == true) {

                    System.out.println();
                    System.out.print("Введи длину > ");
                    String lengthString = br.readLine();

                    try {
                        length = Float.parseFloat(lengthString);
                        notEnteredLength = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Говно ввёл, перевведи ");
                    }
                }

                boolean notEnteredWidth = true;

                while (notEnteredWidth == true) {

                    System.out.println();
                    System.out.print("Введи ширину > ");
                    String widthString = br.readLine();

                    try {
                        width = Float.parseFloat(widthString);
                        notEnteredWidth = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Говно ввёл, перевведи ");
                    }

                }

                float piazza = length * width;

                System.out.println();
                System.out.print("Площадь равна: " + piazza);

            } else {
                break;
            }
        }
    }
}
