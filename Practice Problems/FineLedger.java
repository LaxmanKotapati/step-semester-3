public class FineLedger {

    static class LibraryMember {

        int[] fines = new int[10];
        int count = 0;

        protected void chargeFine(int amount) {
            fines[count++] = amount;
        }

        int[] getFineHistory() {
            int[] copy = new int[count];

            for (int i = 0; i < count; i++)
                copy[i] = fines[i];

            return copy;
        }

        int getTotalFine() {
            int total = 0;

            for (int i = 0; i < count; i++)
                total += fines[i];

            return total;
        }
    }

    static class StudentMember extends LibraryMember {

        @Override
        protected void chargeFine(int amount) {
            super.chargeFine(amount / 2);
        }
    }

    public static void main(String[] args) {

        StudentMember s = new StudentMember();

        s.chargeFine(100);

        System.out.println(s.getTotalFine());

        int[] history = s.getFineHistory();

        history[0] = 999;

        System.out.println(s.getFineHistory()[0]);
    }
}