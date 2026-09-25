public class WeeklyCheckIn {

    static class GymMember {

        static int count = 0;

        final String membershipNumber;
        int feesPaid;

        GymMember(int fee) {
            count++;
            membershipNumber = "GYM-" + (2000 + count);
        }

        void payFee(int amount) {
            feesPaid += amount;
        }

        void payFee(int amount, String mode) {
            System.out.println("Mode: " + mode);
            payFee(amount);
        }

        int getFeesPaid() {
            return feesPaid;
        }

        static boolean isValidReferralCode(String code) {

            if (code == null || code.length() != 4)
                return false;

            return code.charAt(0) == 'G'
                    && Character.isDigit(code.charAt(1))
                    && Character.isDigit(code.charAt(2))
                    && Character.isUpperCase(code.charAt(3));
        }

        static int getMembersEnrolled() {
            return count;
        }
    }

    static class GroupClassMember extends GymMember {

        String className;

        GroupClassMember(int fee, String className) {
            super(fee);
            this.className = className;
        }
    }

    static String processWeeklyCheckIn(GymMember[] members) {

        int processed = 0;
        int skipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember m : members) {

            if (m == null) {
                skipped++;
                continue;
            }

            processed++;

            if (m instanceof GroupClassMember)
                group++;
            else
                individual++;
        }

        return processed + " processed | " +
                skipped + " null skipped | " +
                group + " group | " +
                individual + " individual";
    }

    public static void main(String[] args) {

        GymMember m = new GymMember(1000);

        System.out.println(m.membershipNumber);
        System.out.println(GymMember.getMembersEnrolled());

        System.out.println(
                GymMember.isValidReferralCode("G45B"));

        System.out.println(
                GymMember.isValidReferralCode("G4B"));

        m.payFee(500);
        m.payFee(500, "UPI");

        System.out.println(m.getFeesPaid());

        GymMember[] list = {
                new GroupClassMember(1500, "Zumba"),
                null,
                new GymMember(1000)
        };

        System.out.println(processWeeklyCheckIn(list));
    }
}