public class ReferenceDeskAccess {

    static String classifyAccess(String m, String c) {

        if (m.equals("public"))
            return "ALLOWED";

        if (m.equals("private"))
            return c.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";

        if (m.equals("default"))
            return c.equals("SAME_CLASS") ||
                    c.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";

        if (c.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"))
            return "ALLOWED";

        return "DENIED";
    }

    static String firstDeniedAttempt(String[][] a) {

        for (int i = 0; i < a.length; i++) {

            if (classifyAccess(a[i][0], a[i][1]).equals("DENIED"))
                return a[i][0] + " via " + a[i][1]
                        + " (attempt #" + (i + 1) + ")";
        }

        return "None Denied";
    }

    public static void main(String[] args) {

        String[][] a = {
                {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
                {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(firstDeniedAttempt(a));
    }
}