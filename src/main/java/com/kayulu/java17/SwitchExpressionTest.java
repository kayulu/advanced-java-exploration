package com.kayulu.java17;

enum Direction {NORTH, SOUTH, WEST, EAST}

public class SwitchExpressionTest {
    public static void main(String[] args) {
        System.out.println(getDirectionString(Direction.SOUTH));
    }

    private static String getDirectionString(Direction d) {
//        return switch (d) {
//            case NORTH -> "NORTH";
//            case SOUTH -> "SOUTH";
//            case WEST -> "WEST";
//            case EAST -> "EAST";
//        };

        // using yield
        return switch (d) {
            case NORTH: yield "NORTH";
            case SOUTH: yield "SOUTH";
            case WEST: yield "WEST";
            case EAST: yield "EAST";
        };
    }


}
