import java.util.*;

class Traffic {
    static void findLongestStreak(String s) {
        int count = 1, max = 1;
        char ch = s.charAt(0);

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1))
                count++;
            else
                count = 1;

            if(count > max) {
                max = count;
                ch = s.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + ch +
                "' repeated " + max + " times");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        findLongestStreak(s);
    }
}