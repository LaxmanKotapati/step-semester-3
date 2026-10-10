public class Warehouse {
    public static void main(String[] args) {
        int[][] grid = {
                {4, 9, 2},
                {7, 1, 6},
                {3, 12, 5}
        };

        int total = 0, max = grid[0][0];
        int r = 0, c = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];

                if (grid[i][j] > max) {
                    max = grid[i][j];
                    r = i;
                    c = j;
                }
            }
        }

        System.out.println("Total: " + total);
        System.out.println("Max coordinate: (" + r + ", " + c + ")");
    }
}