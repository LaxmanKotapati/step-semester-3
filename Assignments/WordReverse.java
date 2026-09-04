import java.util.Scanner;

class WordReverse {
    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            result += sb.reverse();

            if (i < words.length - 1)
                result += " ";
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        System.out.println(reverseEachWord(sentence));
    }
}