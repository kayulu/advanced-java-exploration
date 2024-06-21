package com.kayulu.ioApi.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathOperations {
    public static void main(String[] args) {
        pathInfo(Paths.get("C:\\Development\\intelliJ-workspace\\advanced-java-exploration\\pom.xml"));
//        pathInfo(Path.of("abc\\def\\ghi\\jkl"));
    }
    public static void pathInfo(Path path){
        System.out.println("toString: " + path);
        System.out.println("getNameCount: " + path.getNameCount());

        for(int i = 0; i < path.getNameCount(); i++){
            // getName(0): Users   => root is NOT a name element (see Path.of("/").getName(0); on line 22)
            System.out.println("getName(" + i + "): " + path.getName(i));
        }

        System.out.println("getFileName: " + path.getFileName());   // pom.xml
        System.out.println("getParent: " + path.getParent());       // C:\Development\intelliJ-workspace\advanced-java-exploration
        System.out.println("getRoot: " + path.getRoot());           // C:\
//        System.out.println("exception: " + Path.of("/").getName(0)); // java.lang.IllegalArgumentException

        System.out.println("subpath(0,3): "+path.subpath(0, 3));    // Development\intelliJ-workspace\advanced-java-exploration
        System.out.println("subpath(1,4): "+path.subpath(1, 4));    // intelliJ-workspace\advanced-java-exploration
        System.out.println("subpath(2,3): "+path.subpath(2, 3));    // advanced-java-exploration

        System.out.println("isAbsolute: "+path.isAbsolute());       // true
    }
}

