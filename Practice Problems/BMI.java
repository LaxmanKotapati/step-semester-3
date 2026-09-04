import java.util.*;

class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= 10; i++) {
            System.out.print("Height: ");
            double h = sc.nextDouble();

            System.out.print("Weight: ");
            double w = sc.nextDouble();

            double bmi = w / (h * h);

            if(bmi < 18.5)
                System.out.println("Underweight");
            else if(bmi < 25)
                System.out.println("Normal");
            else if(bmi < 30)
                System.out.println("Overweight");
            else
                System.out.println("Obese");
        }
    }
}