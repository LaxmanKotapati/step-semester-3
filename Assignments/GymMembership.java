public class GymMembership {

    static class GymMember {
        String memberId;
        int monthlyFee;
        int sessions;

        GymMember(String id, int fee) {
            if (id == null || id.trim().length() < 4)
                throw new IllegalArgumentException();

            memberId = id;
            monthlyFee = fee;
        }

        void attendSession() {
            sessions++;
        }

        int getSessionsAttended() {
            return sessions;
        }
    }

    static class PremiumMember extends GymMember {
        String trainerName;

        PremiumMember(String id, int fee, String trainer) {
            super(id, fee);
            trainerName = trainer;
        }
    }

    static String signUpBatch(String[] ids, int fee) {
        int signed = 0, rejected = 0;

        for (String id : ids) {
            try {
                new GymMember(id, fee);
                signed++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signed + " | Rejected: " + rejected;
    }

    public static void main(String[] args) {

        PremiumMember p =
                new PremiumMember("MEM01", 2000, "Coach Riya");

        p.attendSession();
        p.attendSession();

        System.out.println(p.getSessionsAttended());

        String[] ids = {"MEM1", "GM1", "MEM2", " ", "MEM3"};

        System.out.println(signUpBatch(ids, 1000));
    }
}