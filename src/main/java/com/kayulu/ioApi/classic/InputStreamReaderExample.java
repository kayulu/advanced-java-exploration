package com.kayulu.ioApi.classic;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class InputStreamReaderExample {
    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader reader = new BufferedReader(isr)) {

            System.out.println("Enter text: ");
            String input = reader.readLine();
            System.out.println("You entered: " + input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
