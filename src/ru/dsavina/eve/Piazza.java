package ru.dsavina.eve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class Piazza {

    public static void main(String[] args) throws IOException {

        while (true) {

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.println();
            System.out.print("Введи название фигуры > ");

            String shape = br.readLine().toLowerCase();

            if ("прямоугольник".equals(shape)) {

                float length = 0;
                float width = 0;
                boolean lengthNotEntered = true;
                boolean widthNotEntered = true;

                while (lengthNotEntered) {
                    System.out.print("Введи длину > ");
                    String lengthString = br.readLine();

                    try {
                        length = Float.parseFloat(lengthString);
                        lengthNotEntered = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Что-то не то, перевведи ");
                    }
                }

                while (widthNotEntered) {
                    System.out.print("Введи ширину > ");
                    String widthString = br.readLine();

                    try {
                        width = Float.parseFloat(widthString);
                        widthNotEntered = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Что-то не то, перевведи ");
                    }
                }

                float piazza = length * width;

                System.out.println();
                System.out.println("Площадь равна: " + piazza);

            } else if ("круг".equals(shape)) {

                float radius = 0;
                float diameter = 0;
                float circumference = 0;
                boolean cannotCalculate = true;

                while (cannotCalculate) {
                    System.out.print("Ты знаешь радиус? (да / нет) > ");
                    String whatAboutRadius = br.readLine();

                    if ("да".equals(whatAboutRadius)) {
                        System.out.print("Введи радиус > ");
                        String radiusString = br.readLine();

                        try {
                            radius = Float.parseFloat(radiusString);
                            cannotCalculate = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Что-то не то, перевведи ");
                        }

                    } else if ("нет".equals(whatAboutRadius)) {
                        System.out.print("Ты знаешь диаметр? (y / n > ");
                        String whatAboutDiameter = br.readLine();

                        if ("да".equals(whatAboutDiameter)) {
                            System.out.print("Введи диаметр > ");
                            String diameterString = br.readLine();

                            try {
                                diameter = Float.parseFloat(diameterString);
                                cannotCalculate = false;
                                radius = diameter / 2;
                            } catch (NumberFormatException e) {
                                System.out.println("Что-то не то, перевведи ");
                            }

                        } else if ("нет".equals(whatAboutDiameter)) {
                            System.out.print("Ты знаешь длину окружности? (y / n > ");
                            String whatAboutCircumference = br.readLine();

                            if ("да".equals(whatAboutCircumference)) {
                                System.out.print("Введи длину окружности > ");
                                String circumferenceString = br.readLine();

                                try {
                                    circumference = Float.parseFloat(circumferenceString);
                                    cannotCalculate = false;
                                    radius = (float) (circumference / (2 * Math.PI));
                                } catch (NumberFormatException e) {
                                    System.out.println("Что-то не то, перевведи ");
                                }
                            } else if ("нет".equals(whatAboutCircumference)) {
                                System.out.println();
                                System.out.print("Не могу помочь :(");
                            }
                        }
                    }

                    float piazza = radius * radius * Math.round(Math.PI * 1000) / 1000;

                    System.out.println();
                    System.out.println("Площадь равна: " + piazza);
                }

            } else if ("трапеция".equals(shape)) {

                float littleBase = 0;
                float largeBase = 0;
                float height = 0;
                boolean littleBaseNotEntered = true;
                boolean largeBaseNotEntered = true;
                boolean hightNotEntered = true;

                while (littleBaseNotEntered) {
                    System.out.print("Введи основание > ");
                    String littleBaseString = br.readLine();

                    try {
                        littleBase = Float.parseFloat(littleBaseString);
                        littleBaseNotEntered = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Что-то не то, перевведи ");
                    }
                }

                while (largeBaseNotEntered) {
                    System.out.print("Введи другое основание > ");
                    String largeBaseString = br.readLine();

                    try {
                        largeBase = Float.parseFloat(largeBaseString);
                        largeBaseNotEntered = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Что-то не то, перевведи ");
                    }
                }

                while (hightNotEntered) {
                    System.out.print("Введи высоту > ");
                    String heightString = br.readLine();

                    try {
                        height = Float.parseFloat(heightString);
                        hightNotEntered = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Что-то не то, перевведи ");
                    }
                }

                float piazza = ((littleBase + largeBase) / 2) * height;

                System.out.println();
                System.out.println("Площадь равна: " + piazza);

            } else if ("треугольник".equals(shape)) {

                float a = 0;
                float b = 0;
                float c = 0;
                boolean aNotEntered = true;
                boolean bNotEntered = true;
                boolean cNotEntered = true;

                while (aNotEntered) {
                    System.out.print("Введи сторону a > ");
                    String aString = br.readLine();

                    try {
                        a = Float.parseFloat(aString);
                        aNotEntered = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Что-то не то, перевведи ");
                    }
                }

                while (bNotEntered) {
                    System.out.print("Введи сторону b > ");
                    String bString = br.readLine();

                    try {
                        b = Float.parseFloat(bString);
                        bNotEntered = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Что-то не то, перевведи ");
                    }
                }

                while (cNotEntered) {
                    System.out.print("Введи сторону c > ");
                    String cString = br.readLine();

                    try {
                        c = Float.parseFloat(cString);
                        cNotEntered = false;
                    } catch (NumberFormatException e) {
                        System.out.println("Что-то не то, перевведи ");
                    }
                }

                if (a != b && b != c && a < b + c && a > (Math.abs(b - c))) {

                    float p = ((float)1 / 2 * (a + b + c));
                    float piazza = (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
                    System.out.println();
                    System.out.println("Площадь равна: " + piazza);

                } else {
                    System.out.println("Это не треугольник");
                }

            } else {
                System.out.println("Не поддерживается");
            }
        }
    }
}
