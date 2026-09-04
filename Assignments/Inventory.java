import java.util.*;

class Inventory {
    static void analyzeInventory(int[] a, int[] b) {
        int sumA = 0, sumB = 0;
        int max = a[0], section = 1, index = 0;

        for(int i = 0; i < a.length; i++) {
            sumA += a[i];
            sumB += b[i];

            if(a[i] > max) {
                max = a[i];
                section = 1;
                index = i;
            }

            if(b[i] > max) {
                max = b[i];
                section = 2;
                index = i;
            }
        }

        System.out.println("Section A Total: " + sumA);
        System.out.println("Section B Total: " + sumB);

        if(sumA == sumB)
            System.out.println("Status: Balanced");
        else
            System.out.println("Status: Not Balanced");

        System.out.println("Highest Quantity: " + max +
                " Section " + section + ", Item " + (index + 1));
    }

    public static void main(String[] args) {
        int[] a = {20,15,30};
        int[] b = {25,10,30};

        analyzeInventory(a,b);
    }
}