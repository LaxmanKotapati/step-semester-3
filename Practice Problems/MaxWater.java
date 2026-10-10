public class MaxWater {
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int left = 0, right = heights.length - 1;
        int max = 0;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int area = height * (right - left);

            if (area > max)
                max = area;

            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        System.out.println(max);
    }
}