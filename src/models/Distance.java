package models;

public class Distance {
    private String name;
    private double longitude;
    private double latitude;


    public Distance(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Distance(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // return distance between this location and that location
    // measured in statute miles
//    public double distanceTo(Distance that) {
//        double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
//        double to_get_metrs = 1.609344 * 1000;
//        double lat1 = Math.toRadians(this.latitude);
//        double lon1 = Math.toRadians(this.longitude);
//        double lat2 = Math.toRadians(that.latitude);
//        double lon2 = Math.toRadians(that.longitude);
//
//        // great circle distance in radians, using law of cosines formula
//        double angle = Math.acos(Math.sin(lat1) * Math.sin(lat2)
//                + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
//
//        // each degree on a great circle of Earth is 60 nautical miles
//        double nauticalMiles = 60 * Math.toDegrees(angle);
//        double distance = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles * to_get_metrs;
//        return distance;
//    }

    // return string representation of this point
    public String toString() {
        return name + " (" + latitude + ", " + longitude + ")";
    }
}
