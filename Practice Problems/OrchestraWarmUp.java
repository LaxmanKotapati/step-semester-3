public class OrchestraWarmUp {

    static abstract class Instrument {

        abstract String play();
    }

    static class StringInstrument extends Instrument {

        String play() {
            return "Strumming the strings";
        }
    }

    static class Violin extends StringInstrument {

        String play() {
            return super.play() +
                    ", with a bow drawn across four strings";
        }
    }

    public static void main(String[] args) {

        StringInstrument s = new StringInstrument();
        Violin v = new Violin();

        System.out.println(s.play());
        System.out.println(v.play());
    }
}