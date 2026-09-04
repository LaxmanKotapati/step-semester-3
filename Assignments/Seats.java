import java.util.*;

class Seats {
    static void checkDuplicateSeats(int[] a) {
        boolean found = false;

        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                if(a[i] == a[j]) {
                    System.out.println("Duplicate Seat Number Found: " + a[i]);
                    found = true;
                }
            }
        }

        if(!found)
            System.out.println("No Duplicate Seats Found");
    }

    public static void main(String[] args) {
        int[] a = {101,102,103,102,105};
        checkDuplicateSeats(a);
    }
}