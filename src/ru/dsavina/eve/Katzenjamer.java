package ru.dsavina.eve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Katzenjamer {

    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        System.out.println();
        System.out.print("Введи слово > ");

        String word = br.readLine().toLowerCase();

        int count = 0;

        ArrayList list = new ArrayList();

        String alphabet = "абвгдеёжзиклмнопрстуфхцчшщъыьэюя";

        while (true) {

            System.out.println();
            System.out.print("Введи слово, составленное из букв вот того слова сверху > ");

            String newWord = br.readLine().toLowerCase();

            int[] letters = new int[alphabet.length()];

            for (int i = 0; i < word.length(); i++) {
                letters[alphabet.indexOf(word.charAt(i))]++;
            }

            boolean highFive = true;

            if (newWord.equals(word)) {
                System.out.println("Наебать меня пытаешься?");
            }

            for (int i = 0; i < newWord.length(); i++) {
                if (letters[alphabet.indexOf(newWord.charAt(i))] == 0) {
                    System.out.println("Идиот");
                    highFive = false;
                    break;
                } else {
                    letters[alphabet.indexOf(newWord.charAt(i))]--;
                }
            }

            if (highFive) {
                if (list.indexOf(newWord) == -1) {
                    list.add(newWord);
                    count++;
                    System.out.println("Молодец, ты собрал слов: " + count);
                } else {
                    System.out.println("Наебать меня пытаешься?");
                }
            }
        }
    }
}
