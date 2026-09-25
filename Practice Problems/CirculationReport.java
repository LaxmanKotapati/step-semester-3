public class CirculationReport {

    static class LibraryMember {

        int books;

        LibraryMember(String id, int limit) {
        }

        void displayInfo() {
            System.out.print(
                    "General | Books: " + books);
        }
    }

    static class StudentMember extends LibraryMember {

        String course;

        StudentMember(String id, int limit, String course) {
            super(id, limit);
            this.course = course;
        }

        void displayInfo() {
            System.out.print(
                    "Student | Course: " + course +
                            " | Books: " + books);
        }
    }

    static String batchPrint(LibraryMember[] members) {

        StringBuilder result = new StringBuilder();

        for (LibraryMember m : members) {

            m.displayInfo();

            if (m instanceof StudentMember) {
                StudentMember s = (StudentMember) m;
                result.append(" [Course via downcast: ")
                        .append(s.course)
                        .append("]");
            }

            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        LibraryMember[] members = {
                new LibraryMember("LB5", 3),
                new StudentMember("STU6", 3, "ECE")
        };

        System.out.println(batchPrint(members));
    }
}