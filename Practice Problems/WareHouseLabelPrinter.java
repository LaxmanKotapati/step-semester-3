public class WarehouseLabelPrinter {

    interface Printable {
        String printLabel();
    }

    static class PackageBox implements Printable {

        String trackingId;

        PackageBox(String id) {
            trackingId = id;
        }

        public String printLabel() {
            return "Package label: " + trackingId;
        }
    }

    static class Invoice implements Printable {

        String invoiceNumber;

        Invoice(String number) {
            invoiceNumber = number;
        }

        public String printLabel() {
            return "Invoice label: " + invoiceNumber;
        }
    }

    static void printAll(Printable[] items) {

        for (Printable x : items)
            System.out.println(x.printLabel());
    }

    public static void main(String[] args) {

        PackageBox p = new PackageBox("TRK-88");
        Invoice i = new Invoice("INV-42");

        System.out.println(p.printLabel());
        System.out.println(i.printLabel());

        printAll(new Printable[]{p, i});
    }
}