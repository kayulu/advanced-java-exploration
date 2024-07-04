import com.kayulu.java21.assignment.LecturerRecord;
import com.kayulu.java21.assignment.department.AccountingDept;
import com.kayulu.java21.assignment.department.Department;
import com.kayulu.java21.assignment.department.SocialCareDept;
import com.kayulu.java21.assignment.department.SoftwareEngineeringDept;
import com.kayulu.java21.assignment.faculty.BusinessFaculty;
import com.kayulu.java21.assignment.faculty.EngineeringFaculty;
import com.kayulu.java21.assignment.faculty.Faculty;
import com.kayulu.java21.assignment.faculty.HumanitiesFaculty;

import java.util.*;

void main() {
    seqColl();
    seqSet();
    seqMap();

    LecturerRecord mike = new LecturerRecord("Mike Bloggs", 44, new EngineeringFaculty(), new SoftwareEngineeringDept());
    LecturerRecord alan = new LecturerRecord("Alan Austin", 64, new BusinessFaculty(), new AccountingDept());
    LecturerRecord lisa = new LecturerRecord("Lisa Bloggs", 65, new HumanitiesFaculty(), new SocialCareDept());

    recordPatterns(mike);
    recordPatterns(alan);
    recordPatterns(lisa);
}

void seqColl() {
    SequencedCollection<LecturerRecord> seq = new ArrayList<>();

    Faculty faculty = new EngineeringFaculty();
    Department department = new SoftwareEngineeringDept();
    LecturerRecord jane = new LecturerRecord("Jane Bloggs", 24, faculty, department);
    LecturerRecord anne = new LecturerRecord("Dr. Anne Bloggs", 35, faculty, department);
    LecturerRecord joe = new LecturerRecord("Joe Bloggs PhD", 54, faculty,department);

    seq.addFirst(jane);
    seq.addFirst(anne);
    seq.addLast(joe);

    System.out.println("--- seqColl()");

    System.out.println(seq);

    System.out.println("getFirst(): " + seq.getFirst());
    System.out.println("getLast(): " + seq.getLast());
    System.out.println("removeLast(): " + seq.removeLast());

    System.out.println(seq);

    System.out.println("Forwards...");
    for(LecturerRecord lr : seq)
        System.out.println(lr);

    System.out.println("Backwards...");
    for(LecturerRecord lr : seq.reversed())
        System.out.println(lr);
}

void seqSet() {
    SequencedSet<LecturerRecord> seq = new LinkedHashSet<>();

    Faculty faculty = new EngineeringFaculty();
    Department department = new SoftwareEngineeringDept();
    LecturerRecord jane = new LecturerRecord("Jane Austin", 24, faculty, department);
    LecturerRecord charlotte = new LecturerRecord("Dr. Charlotte Bronte", 35, faculty, department);
    LecturerRecord anne = new LecturerRecord("Anne Bronte PhD", 54, faculty, department);

    seq.addFirst(jane);
    seq.addFirst(jane);
    seq.addFirst(jane);         // Jane
    seq.addFirst(charlotte);    // Charlotte Jane
    seq.addLast(jane);
    seq.addLast(anne);          // Charlotte Jane Anne

    System.out.println("--- seqSet()");
    System.out.println(seq);

    System.out.println("getFirs(): " + seq.getFirst());
    System.out.println("getLast(): " + seq.getLast());
    System.out.println("removeFirst(): " + seq.removeFirst());

    System.out.println(seq);

    System.out.println("Forwards...");
    for(LecturerRecord lr : seq)
        System.out.println(lr);

    System.out.println("Backwards...");
    for(LecturerRecord lr : seq.reversed())
        System.out.println(lr);

}

void seqMap() {
    SequencedMap<LecturerRecord, String> map = new LinkedHashMap<>();

    Department department = new SocialCareDept();
    Faculty faculty = new HumanitiesFaculty();
    LecturerRecord king = new LecturerRecord("King Lear", 88, faculty, department);
    LecturerRecord goneril = new LecturerRecord("Goneril", 55, faculty, department);
    LecturerRecord regan = new LecturerRecord("Regan", 50, faculty, department);
    LecturerRecord cordelia = new LecturerRecord("Cordelia", 45, faculty, department);

    map.putFirst(goneril, "Eldest");
    map.putFirst(regan, "Middle");
    map.putLast(cordelia, "Youngest");
    map.putLast(king, "Father");

    System.out.println("--- seqMap()");
    System.out.println(map);

    System.out.println("firstEntry(): " + map.firstEntry());
    System.out.println("lastEntry(): " + map.lastEntry());
    System.out.println("pollLastEntry(): " + map.pollLastEntry());

    System.out.println(map);

    System.out.println("Forwards...");
    for(Map.Entry<LecturerRecord, String> entry : map.entrySet()) {
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());
    }

    System.out.println("Backwards...");
    for(Map.Entry<LecturerRecord, String> entry : map.reversed().entrySet()) {
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());
    }
}

void recordPatterns(Object obj) {
    System.out.println(
            switch (obj) {
                // using Record Pattern
                case LecturerRecord(String name, Integer age, Faculty faculty, Department department)
                        when age >= 64 : yield """
                        name: %s
                        age: %s
                        faculty: %s
                        department: %s
                        """.formatted(name, age, faculty, department);
                case null, default: yield "";
            }
    );
}
