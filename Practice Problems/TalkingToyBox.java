public class TalkingToyBox {

    static abstract class Toy {

        static int count = 1000;
        final String toyId;
        String name;

        Toy(String name) {
            this.name = name;
            toyId = "TOY-" + (++count);
        }

        abstract String makeSound();

        String getToyId() {
            return toyId;
        }
    }

    static class ToyCar extends Toy {

        ToyCar(String name) {
            super(name);
        }

        String makeSound() {
            return name + ": Vroom vroom!";
        }
    }

    static class ToyRobot extends Toy {

        ToyRobot(String name) {
            super(name);
        }

        String makeSound() {
            return name + ": Beep boop!";
        }
    }

    public static void main(String[] args) {

        ToyCar c = new ToyCar("Speedster");
        ToyRobot r = new ToyRobot("Bolt");

        System.out.println(c.makeSound());
        System.out.println(r.makeSound());

        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}