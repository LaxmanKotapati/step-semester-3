import java.util.*;

class Palindrome {

    // Iterative
    static boolean iterative(String s) {
        for(int i = 0; i < s.length()/2; i++)
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }

    // Recursive
    static boolean recursive(String s, int i, int j) {
        if(i >= j)
            return true;

        if(s.charAt(i) != s.charAt(j))
            return false;

        return recursive(s, i+1, j-1);
    }

    // Array Reversal
    static boolean arrayReverse(String s) {
        char[] a = s.toCharArray();

        for(int i = 0; i < a.length/2; i++) {
            char temp = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = temp;
        }

        return s.equals(new String(a));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println("Iterative: " + iterative(s));
        System.out.println("Recursive: " + recursive(s, 0, s.length()-1));
        System.out.println("Array Reversal: " + arrayReverse(s));
    }
}