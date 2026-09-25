public class SkylineDelivery {

    static abstract class Drone {

        abstract String fly();
    }

    interface Trackable {
        String getLocation();
    }

    static class DeliveryDrone extends Drone
            implements Trackable {

        String id;

        DeliveryDrone(String id) {
            this.id = id;
        }

        String fly() {
            return "Delivery drone flying";
        }

        public String getLocation() {
            return id + " at Sector 4";
        }
    }

    static class ScoutDrone extends Drone {

        String id;

        ScoutDrone(String id) {
            this.id = id;
        }

        String fly() {
            return "Scout drone flying";
        }
    }

    static class GroundRobot implements Trackable {

        String id;

        GroundRobot(String id) {
            this.id = id;
        }

        public String getLocation() {
            return id + " at Sector 4";
        }
    }

    static String getLocationIfTrackable(Object o) {

        if (o instanceof Trackable) {
            Trackable t = (Trackable) o;
            return t.getLocation();
        }

        return "Tracking not available";
    }

    public static void main(String[] args) {

        DeliveryDrone d = new DeliveryDrone("DR-1");
        ScoutDrone s = new ScoutDrone("SC-1");
        GroundRobot g = new GroundRobot("GR-1");

        System.out.println(getLocationIfTrackable(d));
        System.out.println(getLocationIfTrackable(s));
        System.out.println(getLocationIfTrackable(g));
    }
}