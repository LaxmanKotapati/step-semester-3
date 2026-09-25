public class LibraryMembership {

    static class LibraryMember {

        String memberId;
        int borrowLimit;
        int booksBorrowed;

        LibraryMember(String id, int limit) {
            if (id == null || id.trim().length() < 4)
                throw new IllegalArgumentException();

            memberId = id;
            borrowLimit = limit;
        }

        void borrowBook() {
            if (booksBorrowed < borrowLimit)
                booksBorrowed++;
        }

        int getBooksBorrowed() {
            return booksBorrowed;
        }
    }

    static class StudentMember extends LibraryMember {

        String course;

        StudentMember(String id, int limit, String course) {
            super(id, limit);
            this.course = course;
        }
    }

    static String enrollBatch(String[] ids, int limit) {

        int enrolled = 0;
        int rejected = 0;

        for (String id : ids) {
            try {
                new LibraryMember(id, limit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled +
                " | Rejected: " + rejected;
    }

    public static void main(String[] args) {

        StudentMember s =
                new StudentMember("STU10", 3, "CSE");

        s.borrowBook();
        s.borrowBook();

        System.out.println(s.getBooksBorrowed());

        String[] ids = {"STU1", "LB1", "STU2", " ", "STU3"};

        System.out.println(enrollBatch(ids, 3));
    }
}