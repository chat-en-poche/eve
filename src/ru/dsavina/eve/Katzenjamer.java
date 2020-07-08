package ru.dsavina.eve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Katzenjamer {

    public static void main(String[] args) throws IOException {
        final String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = null;
        boolean isItWord = false;

        while (!isItWord) {
            System.out.println();
            System.out.print("Введите слово > ");

            word = br.readLine();
            if (word == null) {
                break;
            }

            if (word.length() < 2) {
                System.out.println("Слово должно состоять минимум из двух букв.");
            } else {
                word = word.toLowerCase();

                isItWord = true;
                for (int i = 0; i < word.length(); i++) {
                    if (alphabet.indexOf(word.charAt(i)) == -1) {
                        isItWord = false;
                        System.out.println("Слово должно содержать только русские буквы.");
                        break;
                    }
                }
            }
        }

        List<String> thesaurus = new ArrayList<>();

        while (isItWord) {
            System.out.println();
            System.out.print("Введите слово, составленное из букв первого слова > ");

            String newWord = br.readLine();
            if (newWord == null) {
                break;
            }

            newWord = newWord.toLowerCase();

            if (newWord.equals("стоп")) {
                break;
            }

            boolean highFive = true;

            if (newWord.equals(word)) {
                System.out.println("Слова должны отличаться.");
                highFive = false;
            } else if (newWord.length() < 2) {
                System.out.println("Слово должно состоять минимум из двух букв.");
                highFive = false;
            } else {
                int[] letters = new int[alphabet.length()];

                for (int i = 0; i < word.length(); i++) {
                    letters[alphabet.indexOf(word.charAt(i))]++;
                }

                for (int i = 0; i < newWord.length(); i++) {
                    if (alphabet.indexOf(newWord.charAt(i)) == -1) {
                        System.out.println("Слово должно содержать только русские буквы.");
                        highFive = false;
                        break;
                    } else if (letters[alphabet.indexOf(newWord.charAt(i))] == 0) {
                        System.out.println("Неверно.");
                        highFive = false;
                        break;
                    } else {
                        letters[alphabet.indexOf(newWord.charAt(i))]--;
                    }
                }
            }

            if (highFive) {
                if (!thesaurus.contains(newWord)) {
                    thesaurus.add(newWord);
                    System.out.println("Вы собрали слов: " + thesaurus.size());
                } else {
                    System.out.println("Вы уже вводили это слово.");
                }
            }
        }
    }
}
