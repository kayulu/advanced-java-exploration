package com.kayulu.java17.assignment;

public abstract sealed class Department permits ComputerEngineeringDpt, SoftwareEngineeringDpt, AccountingDpt, SocialCareDpt {
}

final class ComputerEngineeringDpt extends Department {
    public void compEng() {
        System.out.println("Custom computer engineering");
    }

    @Override
    public String toString() {
        return "Computer Engineering";
    }
}

final class SoftwareEngineeringDpt extends Department {
    public void swEng() {
        System.out.println("Custom software engineering");
    }

    @Override
    public String toString() {
        return "Software Engineering";
    }
}

final class AccountingDpt extends Department {
    public void accountingDpt() {
        System.out.println("Custom accounting");
    }

    @Override
    public String toString() {
        return "Accounting";
    }
}

final class SocialCareDpt extends Department {
    public void socialCare() {
        System.out.println("Custom social care");
    }

    @Override
    public String toString() {
        return "Social Care";
    }
}
