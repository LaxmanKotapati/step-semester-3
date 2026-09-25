public class MembershipTree {

    static class LibraryMember {

        int books;

        LibraryMember(String id, int limit) {
        }

        void borrowBook() {
            books++;
        }

        int getBooksBorrowed() {
            return books;
        }

        void displayInfo() {
            System.out.println(
                    "General Member | Books Borrowed: " + books);
        }
    }

    static class StudentMember extends LibraryMember {

        String course;

        StudentMember(String id, int limit, String course) {
            super(id, limit);
            this.course = course;
        }

        void displayInfo() {
            System.out.println(
                    "Student Member | Course: " + course +
                            " | Books Borrowed: " + books);
        }
    }

    static class HonorsStudentMember extends StudentMember {

        int bonusLimit;

        HonorsStudentMember(String id, int limit,
                            String course, int bonusLimit) {
            super(id, limit, course);
            this.bonusLimit = bonusLimit;
        }

        void displayInfo() {
            System.out.println(
                    "Honors Student Member | Course: " + course +
                            " | Bonus Limit: " + bonusLimit +
                            " | Books Borrowed: " + books);
        }
    }

    static class FacultyMember extends LibraryMember {

        String department;

        FacultyMember(String id, int limit, String department) {
            super(id, limit);
            this.department = department;
        }

        void displayInfo() {
            System.out.println(
                    "Faculty Member | Department: " + department +
                            " | Books Borrowed: " + books);
        }
    }

    static String classifyGeneration(LibraryMember m) {

        if (m instanceof HonorsStudentMember)
            return "Multilevel descendant (3 generations deep)";

        if (m instanceof FacultyMember)
            return "Hierarchical sibling (independent branch)";

        return "General";
    }

    static int getTotalBooksBorrowed(LibraryMember[] members) {

        int total = 0;

        for (LibraryMember m : members)
            total += m.getBooksBorrowed();

        return total;
    }

    public static void main(String[] args) {

        StudentMember s =
                new StudentMember("STU2", 3, "CSE");

        HonorsStudentMember h =
                new HonorsStudentMember("STU3", 3, "ECE", 2);

        FacultyMember f =
                new FacultyMember("STU4", 5, "Physics");

        s.borrowBook();
        s.borrowBook();

        h.borrowBook();

        f.borrowBook();
        f.borrowBook();
        f.borrowBook();

        h.displayInfo();
        f.displayInfo();

        System.out.println(classifyGeneration(h));
        System.out.println(classifyGeneration(f));

        LibraryMember[] members = {s, h, f};

        System.out.println(getTotalBooksBorrowed(members));
    }
}