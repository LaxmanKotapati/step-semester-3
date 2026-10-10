public class ClassTopper {
    public static void main(String[] args) {
        int[][] marks = {
                {78, 85, 90},
                {88, 92, 79},
                {65, 70, 95}
        };

        int max = -1, topper = 0;

        for (int i = 0; i < marks.length; i++) {
            int total = 0;

            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
            }

            if (total > max) {
                max = total;
                topper = i;
            }
        }

        System.out.println("(" + topper + ", " + max + ")");
    }
}