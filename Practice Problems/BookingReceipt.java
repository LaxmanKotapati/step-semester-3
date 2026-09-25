import java.util.Arrays;

public class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    BookingReceipt(String id, String[] seats) {
        bookingId = id;
        seatNumbers = seats.clone();
    }

    String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    BookingReceipt withUpdatedSeat(int index, String seat) {
        String[] copy = seatNumbers.clone();
        copy[index] = seat;
        return new BookingReceipt(bookingId, copy);
    }

    static String processNightlySettlement(BookingReceipt[] r) {

        int processed = 0, skipped = 0;
        int group = 0, individual = 0;

        for (BookingReceipt b : r) {

            if (b == null) {
                skipped++;
                continue;
            }

            processed++;

            if (b instanceof GroupBookingReceipt)
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

        BookingReceipt b =
                new BookingReceipt("CH-1001",
                        new String[]{"A1", "A2"});

        String[] seats = b.getSeatNumbers();
        seats[0] = "X";

        System.out.println(b.getSeatNumbers()[0]);

        BookingReceipt updated =
                b.withUpdatedSeat(1, "A3");

        System.out.println(
                Arrays.toString(b.getSeatNumbers()));

        System.out.println(
                Arrays.toString(updated.getSeatNumbers()));

        BookingReceipt[] r = {
                new GroupBookingReceipt(
                        "CH-2002",
                        new String[]{"B1", "B2"}, 2),
                null,
                new BookingReceipt(
                        "CH-3003",
                        new String[]{"C1"})
        };

        System.out.println(processNightlySettlement(r));
    }
}

class GroupBookingReceipt extends BookingReceipt {

    GroupBookingReceipt(String id, String[] seats, int size) {
        super(id, seats);
    }
}