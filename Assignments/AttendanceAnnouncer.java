public class AttendanceAnnouncer {

    static class GymMember {

        int sessions;

        GymMember(String id, int fee) {
        }

        void displayInfo() {
            System.out.print("Standard | Sessions: " + sessions);
        }
    }

    static class PremiumMember extends GymMember {

        String trainer;

        PremiumMember(String id, int fee, String trainer) {
            super(id, fee);
            this.trainer = trainer;
        }

        void displayInfo() {
            System.out.print("Premium | Trainer: " +
                    trainer + " | Sessions: " + sessions);
        }
    }

    static String batchPrint(GymMember[] members) {

        StringBuilder result = new StringBuilder();

        for (GymMember m : members) {

            m.displayInfo();

            if (m instanceof PremiumMember) {
                PremiumMember p = (PremiumMember) m;

                result.append("[Trainer via downcast: ")
                        .append(p.trainer)
                        .append("]");
            }

            result.append(" | ");
        }

        return result.toString();
    }

    public static void main(String[] args) {

        GymMember[] members = {
                new GymMember("MEM6", 1000),
                new PremiumMember("MEM7", 2000, "Coach Riya")
        };

        System.out.println(batchPrint(members));
    }
}