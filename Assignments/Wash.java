abstract class Wash {
    abstract int duration();
    abstract int charge();
}

class Quick extends Wash {
    int duration() {
        return 30;
    }

    int charge() {
        return 20;
    }
}

class Normal extends Wash {
    int duration() {
        return 45;
    }

    int charge() {
        return 30;
    }
}

class Heavy extends Wash {
    int duration() {
        return 60;
    }

    int charge() {
        return 45;
    }
}

class WashingMachine {
    String name;
    boolean busy = false;

    WashingMachine(String name) {
        this.name = name;
    }

    void start(Wash wash, String student) {
        if (busy) {
            System.out.println(name + " is currently busy.");
        } else {
            busy = true;
            System.out.println(wash.getClass().getSimpleName()
                    + " wash started on " + name + " for " + student);
            System.out.println("Duration: " + wash.duration() + " min");
            System.out.println("Charge: ₹" + wash.charge());
        }
    }

    void complete() {
        busy = false;
        System.out.println(name + " cycle completed.");
        System.out.println(name + " is now free.");
    }
}

class Laundry {
    public static void main(String[] args) {

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        m1.start(new Quick(), "Asha");

        m1.start(new Heavy(), "Ravi");

        m2.start(new Heavy(), "Ravi");

        m1.complete();

        m1.start(new Normal(), "Neha");
    }
}