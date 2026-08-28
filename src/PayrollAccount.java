import java.util.Scanner;

public class PayrollAccount {

    private double basicSalary;
    private double bonus;

    PayrollAccount(double basicSalary) {

        if (basicSalary < 0) {
            System.out.println("Invalid basic salary");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        bonus = 0;
    }

    void creditBonus(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid bonus");
        } else {
            bonus = bonus + amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    void deductTax(double percent) {

        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage");
        } else {
            basicSalary = basicSalary - (basicSalary * percent / 100);
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double salary = sc.nextDouble();
        double bonus = sc.nextDouble();
        double tax = sc.nextDouble();

        PayrollAccount account = new PayrollAccount(salary);

        account.creditBonus(bonus);
        account.deductTax(tax);

        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}