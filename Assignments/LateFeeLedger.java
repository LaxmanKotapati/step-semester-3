public class LateFeeLedger {

    static class GymMember {

        private int[] fees = new int[10];
        private int count = 0;

        protected void chargeLateFee(int amount) {
            fees[count++] = amount;
        }

        int[] getLateFeeHistory() {
            int[] copy = new int[count];

            for (int i = 0; i < count; i++)
                copy[i] = fees[i];

            return copy;
        }

        int getTotalLateFees() {
            int total = 0;

            for (int i = 0; i < count; i++)
                total += fees[i];

            return total;
        }
    }

    static class PremiumMember extends GymMember {

        @Override
        protected void chargeLateFee(int amount) {
            super.chargeLateFee(amount / 2);
        }
    }

    public static void main(String[] args) {

        PremiumMember p =
                new PremiumMember();

        p.chargeLateFee(200);

        System.out.println(p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();

        history[0] = 999;

        System.out.println(p.getLateFeeHistory()[0]);
    }
}