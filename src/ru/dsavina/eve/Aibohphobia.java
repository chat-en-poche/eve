package ru.dsavina.eve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aibohphobia {

    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {

            System.out.println();
            System.out.print("Пиши, блядь > ");

            String phrase = br.readLine();

            if (phrase.equals("выход")) {
                break;
            }

            for (int i = phrase.length() - 1; i >= 0; i--) {
                System.out.print(phrase.charAt(i));
            }

            String stripped = phrase.toLowerCase().replaceAll("[^a-zа-я0-9]", "");

            boolean palindrome = true;

            for (int i = 0; i < stripped.length() / 2; i++) {
                if (stripped.charAt(i) != stripped.charAt(stripped.length() - 1 - i)) {
                    palindrome = false;
                    break;
                }
            }

            if (palindrome == true) {
                System.out.println(" -- это палиндром.");
            } else {
                System.out.println(" -- это не палиндром.");
            }

        }
    }
}