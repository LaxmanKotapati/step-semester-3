public class GymMembershipTiers {

    static class GymMember {
        int sessions;

        GymMember(String id, int fee) {
        }

        void attendSession() {
            sessions++;
        }

        int getSessionsAttended() {
            return sessions;
        }

        void displayInfo() {
            System.out.println("Standard Member | Sessions: " + sessions);
        }
    }

    static class PremiumMember extends GymMember {
        String trainer;

        PremiumMember(String id, int fee, String trainer) {
            super(id, fee);
            this.trainer = trainer;
        }

        void displayInfo() {
            System.out.println("Premium Member | Trainer: " +
                    trainer + " | Sessions: " + sessions);
        }
    }

    static class EliteMember extends PremiumMember {
        String locker;

        EliteMember(String id, int fee, String trainer, String locker) {
            super(id, fee, trainer);
            this.locker = locker;
        }

        void displayInfo() {
            System.out.println("Elite Member | Trainer: " +
                    trainer + " | Locker: " + locker +
                    " | Sessions: " + sessions);
        }
    }

    static class GroupClassMember extends GymMember {
        String className;

        GroupClassMember(String id, int fee, String className) {
            super(id, fee);
            this.className = className;
        }

        void displayInfo() {
            System.out.println("Group Class Member | Class: " +
                    className + " | Sessions: " + sessions);
        }
    }

    static String classifyGeneration(GymMember m) {
        if (m instanceof EliteMember)
            return "Multilevel descendant (3 generations deep)";

        if (m instanceof GroupClassMember)
            return "Hierarchical sibling (independent branch)";

        return "Standard";
    }

    static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;

        for (GymMember m : members)
            total += m.getSessionsAttended();

        return total;
    }

    public static void main(String[] args) {

        PremiumMember p =
                new PremiumMember("MEM2", 2000, "Coach Riya");

        EliteMember e =
                new EliteMember("MEM3", 3000,
                        "Coach Arjun", "L12");

        GroupClassMember g =
                new GroupClassMember("MEM4", 1500, "Zumba");

        p.attendSession();
        p.attendSession();
        p.attendSession();

        e.attendSession();
        e.attendSession();

        g.attendSession();
        g.attendSession();
        g.attendSession();
        g.attendSession();

        e.displayInfo();
        g.displayInfo();

        System.out.println(classifyGeneration(e));
        System.out.println(classifyGeneration(g));

        GymMember[] list = {p, e, g};

        System.out.println(getTotalSessionsAttended(list));
    }
}