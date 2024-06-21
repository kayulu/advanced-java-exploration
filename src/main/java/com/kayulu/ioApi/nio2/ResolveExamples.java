package com.kayulu.ioApi.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

// Note: resolve means concatenate
public class ResolveExamples {
    public static void main(String[] args) {
        Path absolute = Paths.get("C:\\Development\\intelliJ-workspace\\advanced-java-exploration");
        Path relative = Path.of("nio2");
        Path file     = Path.of("name.txt");

        System.out.println("absolute.resolve(relative): " +
                absolute.resolve(relative)); // C:\Development\intelliJ-workspace\advanced-java-exploration\nio2
        System.out.println("absolute.resolve(file): " +
                absolute.resolve(file)); // C:\Development\intelliJ-workspace\advanced-java-exploration\name.txt
        System.out.println("relative.resolve(file): " + // nio2\name.txt
                relative.resolve(file)); // nio2\name.txt

        // trying to resolve an absolute path within anything just returns the absolute path
        System.out.println("relative.resolve(absolute): "+
                relative.resolve(absolute)); // C:\Development\intelliJ-workspace\advanced-java-exploration
        System.out.println("file.resolve(absolute): "+
                file.resolve(absolute)); // C:\Development\intelliJ-workspace\advanced-java-exploration
        System.out.println("absolute.resolve(absolute): "+
                absolute.resolve(absolute)); // C:\Development\intelliJ-workspace\advanced-java-exploration

        // interesting...
        Path p1  = Path.of("dir");      // this is actually a file
        Path p2  = Path.of("sk.txt");   // this is actually a directory
        System.out.println("dir.resolve(sk.txt): "+
                p1.resolve(p2));// dir\sk.txt
        System.out.println("sk.txt.resolve(dir): "+     // sk.txt could be a directory (it is) and
                p2.resolve(p1));// sk.txt\dir           // dir could be a file (it is)
    }

}
