abstract class Room {
    int number;
    boolean booked = false;

    Room(int number) {
        this.number = number;
    }

    abstract double price(int days);
}

class StandardRoom extends Room {
    StandardRoom(int number) {
        super(number);
    }

    double price(int days) {
        return days * 100;
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(int number) {
        super(number);
    }

    double price(int days) {
        return days * 200;
    }
}

class Hotel {
    public static void main(String[] args) {

        StandardRoom room = new StandardRoom(101);

        if (!room.booked) {
            room.booked = true;
            System.out.println("Room 101 booked.");
            System.out.println("Price: $" + room.price(4));
        } else {
            System.out.println("Room is not available.");
        }

        if (room.booked)
            System.out.println("Room 101 is not available.");

        room.booked = false;
        System.out.println("Reservation cancelled.");

        DeluxeRoom deluxe = new DeluxeRoom(201);

        if (!deluxe.booked) {
            deluxe.booked = true;
            System.out.println("Deluxe Room 201 booked.");
            System.out.println("Price: $" + deluxe.price(2));
        }
    }
}