package com.kayulu.java21.assignment.department;

public final class SocialCareDept extends Department {
    public void socialCare() {
        System.out.println("Custom social care");
    }

    @Override
    public String toString() {
        return "Social Care";
    }
}
