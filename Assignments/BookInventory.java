public class BookInventory {

    private int total;
    private int available;

    BookInventory(int total) {
        this.total = total;
        available = total;
    }

    void checkOut() {
        if (available > 0)
            available--;
    }

    void checkIn() {
        if (available < total)
            available++;
    }

    int getCopiesAvailable() {
        return available;
    }

    public static void main(String[] args) {

        BookInventory b = new BookInventory(3);

        b.checkOut();
        b.checkOut();
        b.checkOut();
        b.checkOut();

        System.out.println(b.getCopiesAvailable());

        b.checkIn();
        b.checkIn();
        b.checkIn();
        b.checkIn();

        System.out.println(b.getCopiesAvailable());
    }
}