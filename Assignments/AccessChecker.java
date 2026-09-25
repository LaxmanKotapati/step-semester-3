public class AccessChecker {

    static String classifyAccess(String m, String c) {

        if (m.equals("public"))
            return "ALLOWED";

        if (m.equals("private"))
            return c.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";

        if (m.equals("default"))
            return c.equals("SAME_CLASS") || c.equals("SAME_PACKAGE")
                    ? "ALLOWED" : "DENIED";

        return c.equals("DIFFERENT_PACKAGE") ? "DENIED" : "ALLOWED";
    }

    static String summarizeByModifier(String[][] a) {

        int pa = 0, pd = 0;
        int da = 0, dd = 0;
        int pra = 0, prd = 0;
        int pua = 0, pud = 0;

        for (String[] x : a) {

            String result = classifyAccess(x[0], x[1]);

            if (x[0].equals("private"))
                if (result.equals("ALLOWED")) pa++; else pd++;

            if (x[0].equals("default"))
                if (result.equals("ALLOWED")) da++; else dd++;

            if (x[0].equals("protected"))
                if (result.equals("ALLOWED")) pra++; else prd++;

            if (x[0].equals("public"))
                if (result.equals("ALLOWED")) pua++; else pud++;
        }

        return "private: " + pa + " allowed / " + pd + " denied | " +
                "default: " + da + " allowed / " + dd + " denied | " +
                "protected: " + pra + " allowed / " + prd + " denied | " +
                "public: " + pua + " allowed / " + pud + " denied";
    }

    public static void main(String[] args) {

        String[][] a = {
                {"private", "SAME_CLASS"},
                {"private", "SAME_PACKAGE"},
                {"default", "SAME_PACKAGE"},
                {"default", "DIFFERENT_PACKAGE"},
                {"protected", "SAME_PACKAGE"},
                {"protected", "SAME_CLASS"},
                {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(summarizeByModifier(a));
    }
}