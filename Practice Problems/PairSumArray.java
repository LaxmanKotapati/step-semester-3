import java.util.HashSet;

public class PairSumArray {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        HashSet<Integer> set = new HashSet<>();
        boolean found = false;

        for (int n : nums) {
            if (set.contains(target - n)) {
                found = true;
                break;
            }
            set.add(n);
        }

        System.out.println(found);
    }
}