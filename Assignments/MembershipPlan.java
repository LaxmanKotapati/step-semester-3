abstract class MembershipPlan {
    abstract double fee();
}

class Monthly extends MembershipPlan {
    double fee() {
        return 1000;
    }
}

class Quarterly extends MembershipPlan {
    double fee() {
        return 1000 * 3 * 0.90;
    }
}

class Annual extends MembershipPlan {
    double fee() {
        return 1000 * 12 * 0.75;
    }
}

class Membership {
    String member;
    String status = "Active";

    Membership(String member, MembershipPlan plan) {
        this.member = member;

        System.out.println("Membership created for " + member);
        System.out.println("Fee: ₹" + plan.fee());
        System.out.println("Status: " + status);
    }

    void checkIn() {
        if (status.equals("Active"))
            System.out.println(member + " checked in successfully.");
        else
            System.out.println("Check-in denied: membership is " + status);
    }

    void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            System.out.println(member + " membership frozen.");
        } else {
            System.out.println("Cannot freeze an " + status + " membership.");
        }
    }

    void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member + " membership unfrozen.");
        } else {
            System.out.println("Cannot unfreeze an " + status + " membership.");
        }
    }

    void expire() {
        status = "Expired";
        System.out.println(member + " membership expired.");
    }
}

class FitZone {
    public static void main(String[] args) {

        Membership a = new Membership("Asha", new Quarterly());

        a.checkIn();

        a.freeze();

        a.checkIn();

        a.unfreeze();

        a.checkIn();

        Membership r = new Membership("Ravi", new Monthly());

        r.expire();

        r.freeze();
    }
}