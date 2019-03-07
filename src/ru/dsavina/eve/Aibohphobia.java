package ru.dsavina.eve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aibohphobia {

    public static void main(String[] args) throws IOException {

        System.out.print("> ");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String phrase = br.readLine();

        for (int i = phrase.length() - 1; i >= 0; i--) {

            System.out.print(phrase.charAt(i));

        }
    }
}