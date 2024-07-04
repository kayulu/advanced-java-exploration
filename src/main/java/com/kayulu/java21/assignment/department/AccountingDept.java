package com.kayulu.java21.assignment.department;

public final class AccountingDept extends Department {
    public void accounting() {
        System.out.println("Custom accounting");
    }

    @Override
    public String toString() {
        return "Accounting";
    }
}
