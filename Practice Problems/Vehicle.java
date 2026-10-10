abstract class Vehicle {
    String name;
    boolean rented = false;

    Vehicle(String name) {
        this.name = name;
    }

    abstract double charge(int days);

    void rent() {
        if (rented)
            System.out.println(name + " is currently unavailable.");
        else {
            rented = true;
            System.out.println(name + " rented successfully.");
        }
    }

    void returned() {
        rented = false;
        System.out.println(name + " returned.");
    }
}

class Sedan extends Vehicle {
    Sedan(String name) {
        super(name);
    }

    double charge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {
    SUV(String name) {
        super(name);
    }

    double charge(int days) {
        return days * 80;
    }
}

class VehicleRental {
    public static void main(String[] args) {

        Sedan s = new Sedan("Sedan A");
        SUV suv = new SUV("SUV B");

        s.rent();
        System.out.println("Charge: $" + s.charge(3));

        s.rent();

        s.returned();

        suv.rent();
        System.out.println("Charge: $" + suv.charge(5));
    }
}