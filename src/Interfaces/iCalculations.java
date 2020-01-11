package Interfaces;

public interface iCalculations {
    double ToRad(double degrees);
    double ToDegrees(double radians);
    double ToBearing(double radians);
    double DegreeBearing(double lat1, double lon1, double lat2, double lon2);
//    boolean isDistanceEnough(float height, float Tilt,double distanceBtw );
    boolean isServed(int azimut, int direction, int raznos);

    String getDate(int month);
}
