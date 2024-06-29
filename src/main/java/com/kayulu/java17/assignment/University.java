package com.kayulu.java17.assignment;

public class University {
    public static void main(String[] args) {
        // force exception on Lecturer record
//        LecturerRecord errorLecturer =
//                new LecturerRecord("", 34, new EngineeringFaculty(), new ComputerEngineeringDpt());

//        LecturerRecord errorLecturer =
//                new LecturerRecord("Joe Bloggs", -3, new EngineeringFaculty(), new ComputerEngineeringDpt());

        LecturerRecord jane = new LecturerRecord("Jane Bloggs", 24, new EngineeringFaculty(), new SoftwareEngineeringDpt());
        System.out.println(jane);

        outputRecordDetails(jane);

        jane.whichFaculty();

        jane.whichDept();

        System.out.println(jane.hasPhd());

        LecturerRecord anne = new LecturerRecord("Dr. Anne Bloggs", 35, new BusinessFaculty(), new AccountingDpt());
        System.out.println(anne);
        outputPhd(anne);

        LecturerRecord joe = new LecturerRecord("Joe Bloggs PhD", 54, new HumanitiesFaculty(), new SocialCareDpt());
        System.out.println(joe);
        outputPhd(joe);
    }

    public static void outputRecordDetails(LecturerRecord lect) {
        String output = """
                Name is %s
                Age is %s
                Faculty is %s
                Department is %s
                """.formatted(lect.name(), lect.age(), lect.faculty(), lect.department());

        System.out.println(output);
    }

    public static void outputPhd(LecturerRecord lecturer) {
        String anneHasPhD = lecturer.hasPhd() ? lecturer.name() + " has a PhD" : lecturer.name() + " does not have a PhD";
        System.out.println(anneHasPhD);
    }
}
