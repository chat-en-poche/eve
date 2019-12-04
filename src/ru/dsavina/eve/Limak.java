package ru.dsavina.eve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Limak {

    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {

            System.out.println();
            System.out.print("Say the alphabet with me, little bear > ");

            String alphabet = "abcdefghijklmnopqrstuvwxyz";

            String check = br.readLine();

            if (check.equals("fuck off")) {
                System.out.println("Go and wash your mouth, young man!");
                break;
            }

            String nude = check.toLowerCase().replaceAll("[^a-z\\s]", "");

            if (check.length() != nude.length()) {
                System.out.println("Mind your language, little bear!");
                continue;
            }

            String stripped = nude.replaceAll("^a-z", "");

            int count = 0;

            if (stripped.length() > alphabet.length()) {
                System.out.println("Mind your spelling, little bear!");
                continue;
                }

            for (int i = 0; i < stripped.length(); i++) {
                if (stripped.charAt(i) == alphabet.charAt(i)) {
                    count++;
                } else {
                    break;
                }
            }

            if (count == alphabet.length()) {
                System.out.println("You've learnt all the letters. Well done, little bear!");
            } else {
                System.out.println("You've learnt " + count + " letters of 26. Try again, little bear!");
            }
        }
    }
}