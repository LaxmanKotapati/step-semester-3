abstract class Seat {
    String number;
    boolean booked = false;

    Seat(String number) {
        this.number = number;
    }

    abstract int price();
}

class Regular extends Seat {
    Regular(String number) {
        super(number);
    }

    int price() {
        return 150;
    }
}

class Premium extends Seat {
    Premium(String number) {
        super(number);
    }

    int price() {
        return 250;
    }
}

class Recliner extends Seat {
    Recliner(String number) {
        super(number);
    }

    int price() {
        return 400;
    }
}

class Booking {
    String customer;
    int count = 0;
    int total = 0;

    Booking(String customer) {
        this.customer = customer;
    }

    void addSeat(Seat seat) {

        if (count == 6) {
            System.out.println("Maximum 6 seats allowed.");
            return;
        }

        if (seat.booked) {
            System.out.println("Seat " + seat.number
                    + " is already booked.");
            return;
        }

        seat.booked = true;
        count++;
        total += seat.price();

        System.out.println("Seat " + seat.number + " booked.");
    }

    void showTotal() {
        System.out.println("Booking confirmed for " + customer);
        System.out.println("Total: ₹" + total);
    }

    void cancel(Seat s1, Seat s2, Seat s3) {
        s1.booked = false;
        s2.booked = false;
        s3.booked = false;

        System.out.println("Booking cancelled.");
        System.out.println("Seats released.");
    }
}

class TicketCounter {
    public static void main(String[] args) {

        Regular a1 = new Regular("A1");
        Regular a2 = new Regular("A2");
        Premium f5 = new Premium("F5");
        Recliner r1 = new Recliner("R1");

        Booking b1 = new Booking("Asha");

        b1.addSeat(a1);
        b1.addSeat(a2);
        b1.addSeat(f5);

        b1.showTotal();

        Booking b2 = new Booking("Ravi");

        b2.addSeat(a2);
        b2.addSeat(r1);

        b2.showTotal();

        b1.cancel(a1, a2, f5);

        Booking b3 = new Booking("Neha");

        b3.addSeat(a2);
        b3.showTotal();
    }
}