package com.kayulu.java17.assignment;

public final record LecturerRecord(String name, Integer age, Faculty faculty, Department department) {
    public LecturerRecord {
        if(name.isBlank() || age < 0)
            throw new IllegalArgumentException(
                    """
                    Illegal argument passed:
                        "name": %s,
                        "age": %s
                    """.formatted(name, age)
            );
    }

    public boolean hasPhd() {
        String prefix = name.length() >= 3 ? name.toUpperCase().substring(0, 3) : "";
        String suffix = name.length() >= 3 ? name.toUpperCase().substring(name.length() - 3) : "";

        return switch (prefix) {
            case "DR." -> true;
            default -> switch (suffix) {
                case "PHD" -> true;
                default -> false;
            };
        };
    }

    public void whichFaculty() {
        switch (faculty) {
            case EngineeringFaculty eng ->  {
                System.out.println("Faculty of: " + eng);
                eng.engineering();
            }
            case HumanitiesFaculty hum -> {
                System.out.println("Faculty of: " + hum);
                hum.humanities();
            }
            case BusinessFaculty bus -> {
                System.out.println("Faculty of: " + bus);
                bus.business();
            }
            default -> throw new IllegalArgumentException("Invalid Faculty: " + faculty);
        }
    }

    public void whichDept() {

        switch (department) {
            case ComputerEngineeringDpt cmp -> {
                System.out.printf("Dept. of: " + cmp);
                cmp.compEng();
            }
            case SoftwareEngineeringDpt sft -> {
                System.out.println("Dept. of: " + sft);
                sft.swEng();
            }
            case AccountingDpt acc -> {
                System.out.println("Dept. of: " + acc);
                acc.accountingDpt();
            }
            case SocialCareDpt soc -> {
                System.out.println("Dept. of: " + soc);
                soc.socialCare();
            }
            default -> {
                throw new IllegalArgumentException("Invalid Department: " + department);
            }
        }
    }
}
