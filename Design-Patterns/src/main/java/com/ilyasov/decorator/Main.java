package com.ilyasov.decorator;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by damir on 15.11.16.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/File.txt");
        Reader is = new RandomCaseReader(new InputStreamReader(Main.class.getClassLoader().getResourceAsStream("File.txt")));
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
        System.out.println("");
    }
}
