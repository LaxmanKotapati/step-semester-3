import java.util.*;

class Review {
    static void classifyWordLengths(String s) {
        String[] a = s.split(" ");

        int shortWord = 0, medium = 0, longWord = 0;

        for(String word : a) {
            int n = word.length();

            if(n <= 4)
                shortWord++;
            else if(n <= 8)
                medium++;
            else
                longWord++;
        }

        System.out.println("Short: " + shortWord);
        System.out.println("Medium: " + medium);
        System.out.println("Long: " + longWord);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        classifyWordLengths(s);
    }
}