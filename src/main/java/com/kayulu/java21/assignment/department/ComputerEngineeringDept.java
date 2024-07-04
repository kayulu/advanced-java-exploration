package com.kayulu.java21.assignment.department;

public final class ComputerEngineeringDept extends Department {
    public void compEng() {
        System.out.println("Custom computer engineering");
    }

    @Override
    public String toString() {
        return "Computer Engineering";
    }
}
