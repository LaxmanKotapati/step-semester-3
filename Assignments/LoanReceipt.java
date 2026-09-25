import java.util.Arrays;

public class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds.clone();
    }

    String[] getBookIds() {
        return bookIds.clone();
    }

    LoanReceipt withCorrectedBookId(int i, String id) {
        String[] copy = bookIds.clone();
        copy[i] = id;
        return new LoanReceipt(memberId, copy);
    }

    static String processNightlyCirculation(LoanReceipt[] r) {

        int p = 0, n = 0, ref = 0, reg = 0;

        for (LoanReceipt x : r) {

            if (x == null) {
                n++;
            } else {
                p++;

                if (x instanceof ReferenceOnlyLoanReceipt)
                    ref++;
                else
                    reg++;
            }
        }

        return p + " processed | " + n + " null skipped | "
                + ref + " reference-only | " + reg + " regular";
    }

    public static void main(String[] args) {

        LoanReceipt r = new LoanReceipt(
                "LIB-8841",
                new String[]{"BK-100", "BK-101"});

        String[] a = r.getBookIds();
        a[0] = "HACKED";

        System.out.println(r.getBookIds()[0]);

        LoanReceipt x =
                r.withCorrectedBookId(1, "BK-102");

        System.out.println(Arrays.toString(r.getBookIds()));
        System.out.println(Arrays.toString(x.getBookIds()));

        LoanReceipt[] list = {
                new ReferenceOnlyLoanReceipt(
                        "LIB-001",
                        new String[]{"BK-200"},
                        "Reading Room 3"),
                null,
                new LoanReceipt(
                        "LIB-002",
                        new String[]{"BK-201"})
        };

        System.out.println(processNightlyCirculation(list));
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {

    ReferenceOnlyLoanReceipt(
            String id, String[] books, String room) {

        super(id, books);
    }
}