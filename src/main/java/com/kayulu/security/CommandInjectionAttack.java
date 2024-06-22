package com.kayulu.security;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
Farm
├── Animals
│   ├── Cattle
│   │   ├── Breeds
│   │   │   ├── Angus.txt
│   │   │   └── Hereford.txt
│   └── Sheep
│       ├── Breeds
│       │   └── Suffolk.txt
├── HR
│   ├── Staff
│   │   ├── Disciplined
│   │   │   └── Joe Bloggs.txt
│   │   ├── Joe Bloggs.txt
│   │   └── Mary Bloggs.txt
 */

public class CommandInjectionAttack {
    public static void commandInjection(){
        Console console = System.console();
        System.out.print("Enter directory: ");
        String dirToView = console.readLine();  // if user types: ..
        Path p = Paths.get("c:/Farm/Animals/" + dirToView); // all txt-files relative to c:/Farm will be output
        try(Stream<Path> s = Files.walk(p)){
            s.filter(path -> path.toString().endsWith(".txt"))
                    .forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void commandInjectionWhitelist(){
        Console console = System.console();
        System.out.print("Enter directory: ");
        String dirToView = console.readLine();
        // use a whitelist to ensure only valid directories are allowed
        if(dirToView.equals("Cattle") || dirToView.equals("Sheep")){
            Path p = Paths.get("c:/Farm/Animals/" + dirToView);
            try(Stream<Path> s = Files.walk(p)){
                s.filter(path -> path.toString().endsWith(".txt"))
                        .forEach(System.out::println);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else{
            System.err.println("Invalid directory entered: "+dirToView);
        }
    }

    public static void main(String[] args) {
        commandInjection();
        //         commandInjectionWhitelist();
    }

}
