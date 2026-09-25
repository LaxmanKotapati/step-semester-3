public class PackageDropOff {

    static abstract class DeliveryNote {

        abstract String confirmDelivery();

        String confirmDelivery(String signature) {
            return confirmDelivery() + ", signed by " + signature;
        }
    }

    static class ParcelNote extends DeliveryNote {

        String trackingId;

        ParcelNote(String id) {
            trackingId = id;
        }

        String confirmDelivery() {
            return "Parcel " + trackingId + " delivered";
        }
    }

    static class LetterNote extends DeliveryNote {

        String trackingId;

        LetterNote(String id) {
            trackingId = id;
        }

        String confirmDelivery() {
            return "Letter " + trackingId + " delivered";
        }
    }

    static void logAll(DeliveryNote[] notes) {

        for (DeliveryNote n : notes)
            System.out.println(n.confirmDelivery());
    }

    public static void main(String[] args) {

        ParcelNote p = new ParcelNote("TRK-1");

        System.out.println(p.confirmDelivery());

        System.out.println(
                p.confirmDelivery("J. Smith"));

        DeliveryNote ref = p;

        logAll(new DeliveryNote[]{
                ref,
                new LetterNote("TRK-2")
        });
    }
}