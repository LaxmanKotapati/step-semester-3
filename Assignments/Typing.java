import java.util.*;

class Typing {
    static void checkTypingAccuracy(String original, String typed) {
        int count = 0;
        int first = -1;

        for(int i = 0; i < original.length(); i++) {
            if(original.charAt(i) == typed.charAt(i))
                count++;
            else if(first == -1)
                first = i;
        }

        double accuracy = count * 100.0 / original.length();

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%\n",
                count, original.length(), accuracy);

        if(first == -1)
            System.out.println("No Mismatches");
        else
            System.out.println("First Mismatch at position " + (first + 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String original = sc.nextLine();
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);
    }
}