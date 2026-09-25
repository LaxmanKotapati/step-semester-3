public class AccessChecker {

    static String classifyAccess(String m, String c) {
        if (m.equals("public"))
            return "ALLOWED";

        if (m.equals("private"))
            return c.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";

        if (m.equals("default"))
            return c.equals("SAME_CLASS") || c.equals("SAME_PACKAGE")
                    ? "ALLOWED" : "DENIED";

        if (m.equals("protected"))
            return c.equals("DIFFERENT_PACKAGE") ? "DENIED" : "ALLOWED";

        return "DENIED";
    }

    static String summarizeBatch(String[][] a) {
        int x = 0, y = 0;

        for (String[] i : a) {
            if (classifyAccess(i[0], i[1]).equals("ALLOWED"))
                x++;
            else
                y++;
        }

        return "Allowed: " + x + " | Denied: " + y;
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));

        String[][] a = {
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(summarizeBatch(a));
    }
}