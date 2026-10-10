import java.util.HashMap;

public class PopularOrder {
    public static void main(String[] args) {
        String[] orders = {
                "dosa", "idli", "vada", "dosa",
                "idli", "dosa", "tea"
        };

        HashMap<String, Integer> map = new HashMap<>();

        for (String item : orders) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        String popular = orders[0];
        int max = 0;

        for (String item : orders) {
            if (map.get(item) > max) {
                max = map.get(item);
                popular = item;
            }
        }

        System.out.println("(" + popular + ", " + max + ")");
    }
}