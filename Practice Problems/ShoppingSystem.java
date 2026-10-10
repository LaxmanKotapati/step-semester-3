interface PaymentMethod {
    boolean pay(double amount);
}

class CreditCard implements PaymentMethod {
    public boolean pay(double amount) {
        System.out.println("Payment using Credit Card.");
        return true;
    }
}

class PayPal implements PaymentMethod {
    public boolean pay(double amount) {
        System.out.println("Payment using PayPal.");
        return false;
    }
}

class Order {
    int items = 0;
    String status = "Pending";

    void addItem(int quantity) {
        items += quantity;
    }

    void pay(PaymentMethod method) {

        if (items == 0) {
            System.out.println("Cannot process payment for empty order.");
            return;
        }

        if (method.pay(500)) {
            status = "Paid";
            System.out.println("Payment successful.");
        } else {
            System.out.println("Payment failed.");
        }

        System.out.println("Order status: " + status);
    }
}

class ShoppingSystem {
    public static void main(String[] args) {

        Order order1 = new Order();

        order1.addItem(3);
        order1.pay(new CreditCard());

        Order order2 = new Order();

        order2.pay(new CreditCard());

        Order order3 = new Order();

        order3.addItem(1);
        order3.pay(new PayPal());
    }
}