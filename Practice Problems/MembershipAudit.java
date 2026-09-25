public class MembershipAudit {

    static class LibraryMember {

        static int count = 0;

        final String memberNumber;
        int books;

        LibraryMember(int limit) {
            count++;
            memberNumber = "LIB-" + (100 + count);
        }

        void borrowBook() {
            books++;
        }

        void borrowBook(String genre) {
            System.out.println("Genre: " + genre);
            borrowBook();
        }

        int getBooksBorrowed() {
            return books;
        }

        static boolean isValidRenewalCode(String code) {

            if (code == null || code.length() != 4)
                return false;

            return code.charAt(0) == 'R' &&
                    Character.isDigit(code.charAt(1)) &&
                    Character.isDigit(code.charAt(2)) &&
                    Character.isUpperCase(code.charAt(3));
        }

        static int getMembersEnrolled() {
            return count;
        }
    }

    static class FacultyMember extends LibraryMember {

        String department;

        FacultyMember(int limit, String department) {
            super(limit);
            this.department = department;
        }
    }

    static String processNightlyAudit(LibraryMember[] members) {

        int processed = 0;
        int skipped = 0;
        int faculty = 0;
        int regular = 0;

        for (LibraryMember m : members) {

            if (m == null) {
                skipped++;
                continue;
            }

            processed++;

            if (m instanceof FacultyMember)
                faculty++;
            else
                regular++;
        }

        return processed + " processed | " +
                skipped + " null skipped | " +
                faculty + " faculty | " +
                regular + " regular";
    }

    public static void main(String[] args) {

        LibraryMember m = new LibraryMember(3);

        System.out.println(m.memberNumber);

        System.out.println(
                LibraryMember.isValidRenewalCode("R12A"));

        System.out.println(
                LibraryMember.isValidRenewalCode("R1A"));

        m.borrowBook();
        m.borrowBook("Fiction");

        System.out.println(m.getBooksBorrowed());

        LibraryMember[] list = {
                new FacultyMember(5, "Physics"),
                null,
                new LibraryMember(3)
        };

        System.out.println(processNightlyAudit(list));
    }
}