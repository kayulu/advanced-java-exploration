package com.kayulu.java21.assignment.faculty;

public final class BusinessFaculty extends Faculty {
    public void business() {
        System.out.println("We teach accountancy, law, economics etc...");
    }

    @Override
    public String toString() {
        return "Business";
    }
}
